
# Spring Boot & Hello SQL

1. http://start.spring.io/
   1. docs/screenshots/ shows the options I choose
1. `./gradlew bootRun` works
1. http://localhost:8080 goes to the HAL Browser
1. http://localhost:8080/h2-console goes to the H2 database console; just click login.
   1. Copy from http://www.w3schools.com/sql/sql_create_table.asp (which has a nice try it yourself feature!)
~~~~~
CREATE TABLE Persons
(
PersonID int,
LastName varchar(255),
FirstName varchar(255),
Address varchar(255),
City varchar(255)
);
~~~~~
  1. Then insert a row...
~~~~~
insert into persons values (1,'Payne','Matt','72nd & Dodge','Omaha');
~~~~~
  1. Then see what is there...
~~~~~
select * from persons;
~~~~~  
1. Notice that http://localhost:8080/member?id=42 works because of MemberController
1. Also notice that one can enter member into the HAL browser's search box.  Since I am not yet, doing things properly (still just faffing about half assed learning) it's not HAL compliant.



## Background
1. http://www.sohamkamani.com/blog/2016/07/07/a-beginners-guide-to-sql/
