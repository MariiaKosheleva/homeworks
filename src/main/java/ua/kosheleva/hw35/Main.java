package ua.kosheleva.hw35;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                1. Login to the account:
                    POST/api/authorization
                    {
                        "user": "newAuthorId",
                        "password": "newAuthorName"
                     }
                2. Watch all books:
                    GET/api/books
                3. Filter books by the name:
                    GET/api/books?name={name}
                4. Filter books by the year:
                    GET/api/books?year={year}
                5. Filter books by the name and the year:
                    GET/api/books?name={name}&year={year}
                6. Sort books by the year (2 variants)
                    GET/api/books?sort=+year
                    GET/api/books?sort=-year
                7. Watch all authors:
                    GET/api/authors
                8. Watch the certain author:
                    GET/api/authors/{id}
                9. Watch books of the certain author:
                    GET/api/authors/{id}/books
                10. Watch certain book of the certain author:
                     GET/api/authors/{id}/books/{id}
                11. Create a new book:
                     POST/api/books
                     {
                        "id": "newBookId",
                        "name": "newBookName",
                        "author": "newAuthor",
                        "year": "newYearValue"
                     }
                12. Add book to the certain author:
                     POST/api/authors/{id}/books
                     {
                        "id": "newBookId",
                        "name": "newBookName",
                        "author": "newAuthor",
                        "year": "newYearValue"
                     }
                13. Update the certain author:
                     PUT/api/authors/{id}
                     {
                        "id": "newAuthorId",
                        "name": "newAuthorName"
                     }
                14. Delete the certain book:
                     DELETE/api/books/{id}
                15. Create many books:
                     POST/api/books
                     {
                        "id": "newBookId-1", "newBookId-2", "newBookId-3",
                        "name": "newBookName-1", "newBookName-2", "newBookName-3",
                        "author": "newAuthor-1", "newAuthor-2", "newAuthor-3",
                        "year": "newYearValue-1", "newYearValue-2", "newYearValue-3"
                     }""");
    }
}