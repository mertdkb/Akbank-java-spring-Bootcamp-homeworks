# Akbank-java-spring-bootcamp-homeworks
This repository contains all projects done during Akbank java-spring bootcamp

---
## Country Api

This project, is an RestAPI that proceeds Counties(`name` ve `president`) GET, POST, PUT and DELETE request. You can make API request via API test tools.( Postman or cURL):
- `GET api/v1.0/countries`: Gets all countries.
  
- `GET api/v1.0/countries/{id}`: Gets country by id.
  
- `POST api/v1.0/countries`: Saves new country.
  
- `PUT api/v1.0/countries/{id}`: Updates country president name.

- `DELETE api/v1.0/countries/{id}`: Deletes country.


---
## House service
This project is a plain Java project that utilizes the factory design pattern to create houses (`Apartment`, `Villa`, and `Summer house`) and provides functionality to print, filter based on room count and list of all types of houses.

Features of the Project:

 - Houses are created using the factory design pattern.
 - The project allows the creation of different types of houses, including Apartment, Villa, and Summer house.
 - All types of houses can be printed to the console for display.
 - The houses can be listed and filtered based on room and living room count.
 - The project is implemented using the Java programming language and designed as a simple console application.
 - By using this project, you can perform basic operations such as creating, listing, and filtering houses of different types.
 - The factory design pattern allows for extensibility to accommodate additional types of houses that may be added in the future.
---
## E-COMMERCE SERVICE
This project, is an API that proceeds **Users, Products and Comments** (`GET, POST, PUT` and `DELETE`) request.
## Endpoints
 You can make API request via API test tools.( Postman or cURL):
**User**

- `[POST] api/v1.0/users`: Saves user. 
- `[GET] api/v1.0/users`: Gets user by username.
- `[GET] api/v1.0/users/all`: Gets all users.
- `[GET] api/v1.0/users/{id}`: Gets user by id.
- `[PUT] api/v1.0/users/{id}`: Updates user data.
- `[DELETE] api/v1.0/users`: Deletes user with username and phone number.

**Product**

- `[POST] api/v1.0/products`: Saves product. 
- `[GET] api/v1.0/products`: Gets all products.
- `[GET] api/v1.0/products/{id}`: Gets product by id.
- `[PUT] api/v1.0/products/{id}`: Updates product data.
- `[DELETE] api/v1.0/products/{id}`: Deletes product by id.

**Comment**

- `[POST] api/v1.0/comments`: Saves comment. 
- `[GET] api/v1.0/comments/user/{userid}/all`: Gets all comments of user.
- `[GET] api/v1.0/comments/product/{productid}/all`: Gets all comments of product.
- `[DELETE] api/v1.0/comments/{id}`: Deletes comment.

### Custom Exceptions
- `UserDataNotPairingException` : if username and phone number are not pairing for signed user throws this exception
- `ThereIsNoCommentOnUserException` : if user has no comments throws this exception
- `ThereIsNoCommentOnProductException` : if product has no comment throws this exception


****

If you have any questions or feedback regarding the project, please feel free to reach out to me. You can contact me through the following:

`Email:` dikbykmert@gmail.com

`Twitter:` @mertdkb
