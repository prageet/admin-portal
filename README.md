## API's Documentation

Register User
-------------

`Request URL:` http://localhost:8080/admin-portal/users/signup

`Request Method:` POST

`Request Payload:`
{"email":"surothiya.prageet@gmail.com","password":"1qaz","firstName":"prageet","lastName":"surothiya","role":"admin"}

`Response:`
{
    "id": 1,
    "firstName": "prageet",
    "lastName": "surothiya",
    "email": "surothiya.prageet@gmail.com",
    "password": "$2a$10$.VNJ4TcdK5RB/5jlCrY5LeDFKLcl.ecL2S.XgfkO8LJmnhtTOJXta",
    "role": "admin",
    "orders": null,
    "creationDate": 1535912042246,
    "lastModifiedDate": 1535912042246
}

-----
Login
-----

`Request URL:` http://localhost:8080/admin-portal/token/generate-token

`Request Method:` POST

`Request Payload:`
{"email":"surothiya.prageet@gmail.com","password":"1qaz"}

`Response:`
{"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXJvdGhpeWEucHJhZ2VldEBnbWFpbC5jb20iLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImlhdCI6MTUzNTkxMjc5NiwiZXhwIjoxNTM1OTMwNzk2fQ.t3QnzlZryIM9WRCr8VIePnXbny4Rhz27XTIMNjXk9aA"}

-----------------
Create A Category
-----------------

`Request URL:` http://localhost:8080/admin-portal/categories

`Request Method:` POST

`Request Header: ` 
Content-Type: application/json
Accept: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXJvdGhpeWEucHJhZ2VldEBnbWFpbC5jb20iLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImlhdCI6MTUzNTkxMjc5NiwiZXhwIjoxNTM1OTMwNzk2fQ.t3QnzlZryIM9WRCr8VIePnXbny4Rhz27XTIMNjXk9aA

`Request Payload:`
{"name":"Starter(Veg)","description":"Vegetarian starters","imagePath":"E:\\prageet\\workspace\\java\\projects\\screenshots","isActive":"true"}

`Response:`
{"id":1,"name":"Starter(Veg)","description":"Vegetarian starters","imagePath":"E:\\prageet\\workspace\\java\\projects\\screenshots","isActive":true,"dishes":null,"creationDate":1535913464163,"lastModifiedDate":1535913464163}

-------------
Create Dish
-------------

`Request URL:` http://localhost:8080/admin-portal/dishes

`Request Method:` POST

`Request Header: ` 
Content-Type: application/json
Accept: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXJvdGhpeWEucHJhZ2VldEBnbWFpbC5jb20iLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImlhdCI6MTUzNTkxMjc5NiwiZXhwIjoxNTM1OTMwNzk2fQ.t3QnzlZryIM9WRCr8VIePnXbny4Rhz27XTIMNjXk9aA

`Request Payload:`
{"categoryId":"1","name":"paneer tikka","description":"paneer tikka","price":"140","isActive":"true"}

`Response:`
{"id":1,"name":"paneer tikka","description":"paneer tikka","imagePath":null,"price":140,"isActive":true,"categoryId":1,"orders":null,"creationDate":1535914186081,"lastModifiedDate":1535914186081}


-----------
Edit Dish
-----------

`Request URL:` http://localhost:8080/admin-portal/dishes/<dishId>

`Request Method:` PUT

`Request Header: ` 
Content-Type: application/json
Accept: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXJvdGhpeWEucHJhZ2VldEBnbWFpbC5jb20iLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImlhdCI6MTUzNTkxMjc5NiwiZXhwIjoxNTM1OTMwNzk2fQ.t3QnzlZryIM9WRCr8VIePnXbny4Rhz27XTIMNjXk9aA

`Request Payload:`
{"id":<dishId>,"name":"veg sheekh kabab","description":"veg sheekh kabab","imagePath":null,"price":"120","isActive":true,"categoryId":"1","orders":[],"creationDate":1535914428853,"lastModifiedDate":1535914428853}

`Response:`
{"id":3,"name":"veg sheekh kabab","description":"veg sheekh kabab","imagePath":null,"price":120,"isActive":true,"categoryId":1,"orders":[],"creationDate":1535914428853,"lastModifiedDate":1535914689991}

-------------
Delete Dish
-------------

`Request URL:` http://localhost:8080/admin-portal/dishes/<dishId>

`Request Method:` DELETE

`Request Header: ` 
Content-Type: application/json
Accept: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXJvdGhpeWEucHJhZ2VldEBnbWFpbC5jb20iLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImlhdCI6MTUzNTkxMjc5NiwiZXhwIjoxNTM1OTMwNzk2fQ.t3QnzlZryIM9WRCr8VIePnXbny4Rhz27XTIMNjXk9aA

`Response:`
{"id":3,"name":"veg sheekh kabab","description":"veg sheekh kabab","imagePath":null,"price":120,"isActive":true,"categoryId":1,"orders":[],"creationDate":1535914428853,"lastModifiedDate":1535914689991}

TODO: "isActive":true should be set to false on deletion.

------------
Create Order  --- STEP 1
------------

`Request URL:` http://localhost:8080/admin-portal/orders

`Request Method:` POST

`Request Header: ` 
Content-Type: application/json
Accept: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXJvdGhpeWEucHJhZ2VldEBnbWFpbC5jb20iLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImlhdCI6MTUzNTkxMjc5NiwiZXhwIjoxNTM1OTMwNzk2fQ.t3QnzlZryIM9WRCr8VIePnXbny4Rhz27XTIMNjXk9aA

`Request Payload:`
{"totalPrice": 250,"userId":2,"status":"true"}

`Response:`
{
    "id": 1,
    "totalPrice": 250,
    "userId": 2,
    "status": "ordered",
    "creationDate": 1535915630242,
    "lastModifiedDate": 1535915630242,
    "orderDetails": null
}

--------
STEP--2
--------

`Request URL:` http://localhost:8080/admin-portal/orderDetails

`Request Method:` POST

`Request Header: ` 
Content-Type: application/json
Accept: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXJvdGhpeWEucHJhZ2VldEBnbWFpbC5jb20iLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImlhdCI6MTUzNTkxMjc5NiwiZXhwIjoxNTM1OTMwNzk2fQ.t3QnzlZryIM9WRCr8VIePnXbny4Rhz27XTIMNjXk9aA

`Request Payload:`
[
	{"dishId": 1, "dishName":"paneer tikka","quantity":1, "price": 140,"orderId":1},
	{"dishId": 2, "dishName":"hara bhara kabab","quantity":1, "price": 110,"orderId":1}
]

`Response:`
[
    {
        "id": 1,
        "dishId": 1,
        "dishName": "paneer tikka",
        "quantity": 1,
        "price": 140,
        "orderId": 1
    },
    {
        "id": 2,
        "dishId": 2,
        "dishName": "hara bhara kabab",
        "quantity": 1,
        "price": 110,
        "orderId": 1
    }
]

----------
View Order
----------

`Request URL:` http://localhost:8080/admin-portal/orders/<dishId>

`Request Method:` GET

`Request Header: ` 
Content-Type: application/json
Accept: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXJvdGhpeWEucHJhZ2VldEBnbWFpbC5jb20iLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImlhdCI6MTUzNTkxMjc5NiwiZXhwIjoxNTM1OTMwNzk2fQ.t3QnzlZryIM9WRCr8VIePnXbny4Rhz27XTIMNjXk9aA

`Response:`
{"id":1,"totalPrice":250,"userId":2,"status":"order received","creationDate":1535915630242,"lastModifiedDate":1535916723588,"orderDetails":[{"id":1,"dishId":1,"dishName":"paneer tikka","quantity":1,"price":140,"orderId":1},{"id":2,"dishId":2,"dishName":"hara bhara kabab","quantity":1,"price":110,"orderId":1}]}

------------
Update Order
------------

`Request URL:` http://localhost:8080/admin-portal/orders/<orderId>

`Request Method:` PUT

`Request Header: ` 
Content-Type: application/json
Accept: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXJvdGhpeWEucHJhZ2VldEBnbWFpbC5jb20iLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImlhdCI6MTUzNTkxMjc5NiwiZXhwIjoxNTM1OTMwNzk2fQ.t3QnzlZryIM9WRCr8VIePnXbny4Rhz27XTIMNjXk9aA

`Request Payload:`
{"id":<orderId>,"totalPrice":610,"userId":2,"status":"delivered","creationDate":1535916856867,"lastModifiedDate":1535917035785,"orderDetails":[{"id":3,"dishId":1,"dishName":"paneer tikka","quantity":1,"price":140,"orderId":2},{"id":4,"dishId":5,"dishName":"tandoori murg","quantity":1,"price":270,"orderId":2},{"id":5,"dishId":6,"dishName":"mix veg","quantity":1,"price":200,"orderId":2}]}

`Response:`
{"id":2,"totalPrice":610,"userId":2,"status":"delivered","creationDate":1535916856867,"lastModifiedDate":1535917530360,"orderDetails":[{"id":3,"dishId":1,"dishName":"paneer tikka","quantity":1,"price":140,"orderId":2},{"id":4,"dishId":5,"dishName":"tandoori murg","quantity":1,"price":270,"orderId":2},{"id":5,"dishId":6,"dishName":"mix veg","quantity":1,"price":200,"orderId":2}]}

---------------
List All Orders
---------------

`Request URL:` http://localhost:8080/admin-portal/orders

`Request Method:` GET

`Request Header: ` 
Content-Type: application/json
Accept: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXJvdGhpeWEucHJhZ2VldEBnbWFpbC5jb20iLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImlhdCI6MTUzNTkxMjc5NiwiZXhwIjoxNTM1OTMwNzk2fQ.t3QnzlZryIM9WRCr8VIePnXbny4Rhz27XTIMNjXk9aA

`Response:`

[
    {
        "id": 1,
        "totalPrice": 250,
        "userId": 2,
        "status": "order received",
        "creationDate": 1535915630242,
        "lastModifiedDate": 1535916723588,
        "orderDetails": [
            {
                "id": 1,
                "dishId": 1,
                "dishName": "paneer tikka",
                "quantity": 1,
                "price": 140,
                "orderId": 1
            },
            {
                "id": 2,
                "dishId": 2,
                "dishName": "hara bhara kabab",
                "quantity": 1,
                "price": 110,
                "orderId": 1
            }
        ]
    },
    {
        "id": 2,
        "totalPrice": 610,
        "userId": 2,
        "status": "delivered",
        "creationDate": 1535916856867,
        "lastModifiedDate": 1535917530360,
        "orderDetails": [
            {
                "id": 3,
                "dishId": 1,
                "dishName": "paneer tikka",
                "quantity": 1,
                "price": 140,
                "orderId": 2
            },
            {
                "id": 4,
                "dishId": 5,
                "dishName": "tandoori murg",
                "quantity": 1,
                "price": 270,
                "orderId": 2
            },
            {
                "id": 5,
                "dishId": 6,
                "dishName": "mix veg",
                "quantity": 1,
                "price": 200,
                "orderId": 2
            }
        ]
    }
]

----------------
Recently Ordered
----------------

`Request URL:` http://localhost:8080/admin-portal/dishes/search/ordered/recently

`Request Method:` GET

`Request Header: ` 
Content-Type: application/json
Accept: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXJvdGhpeWEucHJhZ2VldEBnbWFpbC5jb20iLCJzY29wZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImlhdCI6MTUzNTkxMjc5NiwiZXhwIjoxNTM1OTMwNzk2fQ.t3QnzlZryIM9WRCr8VIePnXbny4Rhz27XTIMNjXk9aA

`Response:`

[
    {
        "id": 3,
        "dishId": 1,
        "dishName": "paneer tikka",
        "quantity": 1,
        "price": 140,
        "orderId": 2
    },
    {
        "id": 4,
        "dishId": 5,
        "dishName": "tandoori murg",
        "quantity": 1,
        "price": 270,
        "orderId": 2
    },
    {
        "id": 5,
        "dishId": 6,
        "dishName": "mix veg",
        "quantity": 1,
        "price": 200,
        "orderId": 2
    }
]

