## Run application
Run the `main` method from `Lec78Application` class.

or 

- Open terminal in project's root directory
- `mvn spring-boot:run`

## View application in browser
The application has these pages:
 - http://localhost:8080/login
 - http://localhost:8080/hello
 - http://localhost:8080/users

Without authentication, you have no access to **/hello** and **/users**
(you will be redirected to **/login**).

Use these credentials to authenticate:

|       | username | password |
|:-----:|:--------:|:--------:|
|   1   |   roma   |   123    |
|   2   |   dru    |  123456  |
|   3   |   dmtr   |   1234   |
|   4   |  al.ex   |  12345   |
|   5   |   mike   |  123456  |

After authentication, you have no access to **/login** until you logout.

After logout, you have no access to **/hello** and **/users**.
