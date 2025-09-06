# CST339 - Milestone 2 - 
# Lindsey DeDecker
### September 3, 2025



## 3DeDeck
An asthetically pleasing online storefront for 3D printed items within 3 categories - Fun, Practical and collectibles.  3DeDeck's website will be full functional with login capabilities, inventory changing capabilities, a chopping cart and order history. 

## Video Cast Link
https://youtu.be/FMxqbhnWTBQ    

## Tasks Completed
- Main Appplication
    - Home page is operation and has a look that fits the store.
    - There is a menu bar that becomes more expansive when a user logs in. 
    - Style is well developed and fits the theme and vision for the storefront.
    - Login and register features are present on home page of the storefront. 
    - Spring MVC waws used for development.
    - Title '3DeDeck' is in for store.  Logo is in the works and for now is the name of the store

- Registration Mode
    - A user can register on the loaded home page.
    - users are required to provide faist and last name, password, username, email and phone number. 
    - Spring MVC is used.
    - All data entered must be valid before registering.
    - Upon registering, the user is prompted to login.

- Login Mode
    - user must login with valid username and password.
    - Spring MVC is used.
    - Upon logging in, the user is brought to the main product page of the store front. 

## Technical Approach
- Spring security for login authorization.
- Thyme and html to create a sharp and distinct design that will attract customers to the webpage.
- Custom login/registration forms  and the  ability to toggle between the two.

## Arcitecture Overview
3DeDeck's application follows MVC architecture pattern using the Spring Boot framework along with Thymeleaf.  

## Technology Stack
- Spring Boot for backend framework
- Thymeleaf for template design
- HTML, CSS and JavaScript
- Maven
- Java

## Known Issues
- I need to focus on tightening up the error calls for registration and login.  It is only hald working
- Getting the design and implementation fo the products up and running.
- Decide if I want to create an actual logo or stick with 3DEDECK in purple as the logo

## Risk 
- Security 
    - I need to work next week to really get the security for logging in and registering working correctly. 
- Database
    - There is no hook up or set up ready for a database.  This will all have to be added in independently. 

## Installation and Configuration
- Using the latest version of Java
- Runnign the main applicaiton within local host


## High-Level Features and Functionality
- User Registration and Login
- Prodcut Browsing
    - Sort (price, alphabetical)
    - By Category
    - Search
- Product Detail Page
- Admin-only product management

## User Interface Flow Diagram
User will first see the home page with a toggle between login and registration.  If the user successfully logs in, they will see the product page.  If the login is unsuccessful, they will  be prompted to tyr again.  If the users attempts to register unsuccessfully, they will be prompted to try agian.  If they are successful, they will be prompted to login. 

```mermaid
flowchart TD
A[Home] --> B{Login} & C{Register}
B --> |Yes| D[Product Page]
B --> |No - Try again| A
C --> |Yes| B
C --> |no - Try again| C
```

## Sitemap

![3DeDeck Sitemap](./sitemap.png)

## Planning 

This project is solo.  Below is my plan for each week as it works with my schedule.  Wednesday I do not work and the weekend will be the most time I am able to commit to the projects.
|Day|Plan|
|--|--|
|Mondays|Answer DQ question|
|Tuesday|**|
|Wednesday|Finish Activity & Start Milestone|
|Thursday|Discussion, Look at Milestone|
|Friday|**|
|Saturday|Work on Milestone, Discussion|
|Sunday|Finish up Milestone, Discussion|

## Resources

- https://docs.mermaidchart.com/blog/posts/easier-diagram-editing-with-code-snippets

- https://www.w3schools.com/howto/howto_css_login_form.asp

- https://www.youtube.com/watch?v=Jh40uRabHcI   

- https://docs.mermaidchart.com/mermaid-oss/syntax/flowchart.html#document
