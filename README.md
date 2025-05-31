# Shopping Cart API (Spring Boot + PostgreSQL)

This is a simple shopping cart REST API developed in **Java** using **Spring Boot**, **Spring Data JPA**, and **PostgreSQL**.  
It allows you to manage a product catalog and perform basic CRUD operations (Create, Read, Update, Delete) via HTTP.

---

##  Main Class

The entry point of the application is located in:

src/main/java/com/ohoud/cart/shopping_cart/App.java 
It contains the `main()` method that launches the Spring Boot application.

---

## Sample Product Data

Upon startup, the application loads 12 products automatically using `DataLoader.java`.

---

## How to Test the API using Postman

Make sure your application is running at:" http://localhost:8080 "

### Add a Product

POST /products  
json
{
  "name": "Milk",
  "description": "Fresh full-fat milk",
  "price": 2.5,
  "taxRate": 0.05,
  "quantity": 100
}

### Get All Products

GET /products
Returns a list of all available products.

### Get Product by ID

GET /products/{id}

Like: GET /products/3

### Update Product

PUT/products/{id}

json
{
  "name": "Updated Milk",
  "description": "Low-fat milk",
  "price": 2.8,
  "taxRate": 0.07,
  "quantity": 80
}

###  Delete Product

DELETE /products/{id}

Like: DELETE /products/5

###   Search Products by Name

GET /products/search?name=milk

Returns all products whose name contains the word "milk" (case-insensitive).

 With best regards,
 Ohoud Alghamdi
