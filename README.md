Golf Club Server
================

This is the server-side Spring Boot application for Golf Club Membership and Tournament Management. 
It provides a REST API for managing members, tournaments, and assigning members to tournaments.

------------------------
📋 Features
------------------------

- Add and retrieve members
- Add and retrieve tournaments
- Add members to tournaments
- Search members by:
  - Name
  - Membership type (duration)
  - Phone number
  - Membership start date
- Search tournaments by:
  - Start date
  - Location
- Retrieve all members in a tournament

------------------------
🔧 How to Run (Without Docker)
------------------------

1. Create a MySQL database named: golf_club_db

2. Update the file at:
   src/main/resources/application.properties

   With your MySQL credentials:

   spring.datasource.url=jdbc:mysql://localhost:3306/golf_club_db  
   spring.datasource.username=your_mysql_username  
   spring.datasource.password=your_mysql_password  
   spring.jpa.hibernate.ddl-auto=update  
   spring.jpa.show-sql=true  
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

3. Run the server with the following commands:

   mvn clean install  
   java -jar target/golf-club-api-1.0.0.jar

------------------------
🐳 How to Run with Docker
------------------------

1. Make sure Docker is installed and running.

2. Build the Docker image:

   docker build -t golf-club-server .

3. Run the Docker container:

   docker run -p 8080:8080 golf-club-server

Your app will be available at: http://localhost:8080

------------------------
✅ Sample API Endpoints
------------------------

MEMBERS:
- GET     /api/members
- POST    /api/members
- GET     /api/members/{id}
- DELETE  /api/members/{id}
- GET     /api/members/search/name?name=alice
- GET     /api/members/search/phone?phone=987-654-3210
- GET     /api/members/search/startDate?date=2024-06-01
- GET     /api/members/search/duration?months=12

TOURNAMENTS:
- GET     /api/tournaments
- POST    /api/tournaments
- GET     /api/tournaments/{id}
- DELETE  /api/tournaments/{id}
- GET     /api/tournaments/search/startDate?date=2024-07-01
- GET     /api/tournaments/search/location?location=newyork
- PUT     /api/tournaments/{tournamentId}/add-member/{memberId}
- GET     /api/tournaments/{tournamentId}/members

------------------------
📁 Project Structure
------------------------

- entity/      → JPA entities (Member, Tournament)
- repository/  → Spring Data JPA repositories
- services/    → Business logic
- controller/  → REST endpoints
- GolfClubApplication.java → Main Spring Boot class
- Dockerfile   → Docker configuration

------------------------
📦 Tech Stack
------------------------

- Java 21
- Spring Boot 3.2.2
- Spring Data JPA
- MySQL
- Maven
- Docker
