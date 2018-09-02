package com.prageet.adminportal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(CustomGenericException.class)
	public ResponseEntity<CustomGenericException> handleCustomException(CustomGenericException ex) {

		CustomGenericException cex = new CustomGenericException();
		cex.setErrCode(ex.getErrCode());
		cex.setErrMsg(ex.getErrMsg());
		System.out.println("Inside custom exception handler"+ ex.getErrMsg());
		return new ResponseEntity<CustomGenericException>(cex, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        System.out.println(req.getRequestURL());
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "Sorry, we couldn't find what you are looking for." + ex.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        System.out.println("Inside generic exception handler");
        return mav;
    }
}