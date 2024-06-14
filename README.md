# To Do List (Bookshelf) - Backend Project

## Summary
The to-do list will have three models, User, Book and Bookshelf. A user can create personalised bookshelves (lists) tailored to a specific theme. For example,  “Holiday Reads”, “Textbook’s for next year”, “Sorting my life together” which could be a collection of self-help books. Within these bookshelves are book objects (to-do) that the user can add, update, remove and provide details. Such as title, author, genre…

This system allows the user access to their bookshelves and associated books. It would include fields or attributes to indicate the status of each book (e.g., whether it's been read, is currently being read, or is intended for future reading) and potentially a priority level. Users could then categorise their books accordingly, helping them track their reading progress and prioritise their reading list effectively.

## Trello Board
https://trello.com/b/NlJeK8qk/backend-project

## Tech Stack

- **Java**
- **Spring Boot**
- **PostgreSQL**

### How to run this API locally

1. **Install PostgreSQL**
   - Via Homebrew:
     ```sh
     brew install postgresql
     ```
   - Or via [Postgres.app](https://postgresapp.com)
  
2. **Create a database**
   ```sh
   createdb bookify_db

3. **Fork repository**
   To your computer and run main() in BookifyApplication

4. **Postico**
   You may wish to visualise the database in Postico once the database is created.

5. **Postman**
   Create models/ services / repositories.
   You may wish to visualise the endpoints in Postman using the JSON segments.


## API Designs

## ERDs
![image](https://github.com/ornerykiwi/Bookify/assets/111086837/f6afba0d-52b6-4d69-a14d-8fa227ff3706)



## UML
![image](https://github.com/ornerykiwi/Bookify/assets/111086837/cd0486f8-c0fb-4c59-8efc-7a3b82102477)

  
## MVP Key Functionality

### Models:
- Book: Represents a book with properties such as title, author, ISBN, publication year, genre, and rating.
- Bookshelf: Represents a user's bookshelf, which contains a list of books.
- User: Represents a user who owns the bookshelf and can add many books to their bookshelf, as a list. Users can have multiple bookshelves.

### Bookshelf

| Endpoints        | URLs           | Description  |
| :-------------: |:-------------:| :-----:|
| GET      | localhost:8080/users/{id}| Retrieve user’s associated bookshelves |
| SHOW   | localhost:8080/bookshelves/{id} |  Retrieve a specific bookshelf |
| CREATE/POST | localhost:8080/bookshelves| Create a new bookshelf |
|PATCH | localhost:8080/bookshelves/{id} | Add book to existing bookshelf|
| UPDATE/PATCH | localhost:8080/bookshelves/{id} | Update the name of a specific bookshelf |
|DELETE |localhost:8080/bookshelves/{id}|Delete bookshelf by bookshelf_id (this will be mapped by the value = “bookshelves_id”)|
|DELETE |localhost:8080/bookshelves/{id}/books/{id}|Delete specific book from a bookshelf|

### Book

| Endpoints        | URLs           | Description  |
| :-------------: |:-------------:| :-----:|
| INDEX/GET/ | localhost:8080/books | Get all books in all the collections (this could be something in the extension as a family plan) |
| SHOW | localhost:8080/books/{id} | Retrieve a specific book by its ID |
| INDEX | localhost:8080/books | Retrieve all books |
| ~~UPDATE/PUT~~ | ~~localhost:8080/books/{id}~~ | ~~Update the details of a specific book~~ |
|DELETE|localhost:8080/books/{id}| Delete a specific book |


### User

| Endpoints        | URLs           | Description  |
| :-------------: |:-------------:| :-----:|
| GET | localhost:8080/users | Retrieve users|
| GET| localhost:8080/users/{id}| Get user by id |
|PUT | localhost:8080/users/{id} | Update the details of a specific user|
|POST|localhost:8080/users | Create a new user |
|DELETE|localhost:8080/users/{id}| Delete a specific user |

### UsersBooks
| Endpoints        | URLs           | Description  |
| :-------------: |:-------------:| :-----:|
| GET | localhost:8080/users-books | Retrieve usersbooks|
| GET| localhost:8080/users-books/{id}| Get usersbooks by id |
| GET| localhost:8080/users-books/{id}| Get a specific users usersbooks |
| UPDATE/PATCH | localhost:8080/books/{id} | Update reading status |
