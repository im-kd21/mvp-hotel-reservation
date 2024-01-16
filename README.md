# Hotel Reservation System

## Overview

This project is a hotel reservation system built using Spring Boot, MySQL, and JPA.

## Prerequisites

- Java JDK 11 or later
- MySQL database server
- Maven

## Database Configuration

1. Ensure a MySQL database named "hotel_reservation" exists or you can configure application.properties file accordingly.
2. Hibernate will automatically create the "reservations" table. I have used JPA annotations @Entity for that. Kindly refer the entity package.

## Running the Application

1. Build the project using Maven:
   
   "mvn clean install -DskipTests" "or mvn clean install"

Run the application:

    mvn spring-boot:run
    
The application will start on port 9002.

### API Endpoints

--> Base URL: 
## http://localhost:9002/v1/hotel-reservation

Available Endpoints:

# GET "/<user_id>" 

# POST "/add" 

createReservation endpoint


input json 

{
  "userEmail": "dev.faang@gmail.com",
  "city": "Chandigarh",
  "locality": "Sector 43",
  "hotelName": "Lalit Grand",
  "noOfRooms": 2,
  "noOfPersons": 3,
  "fromDate": "16-01-2024",  // Date in "dd-MM-yyyy" format, as specified
  "toDate": "20-01-2024",  // Date in "dd-MM-yyyy" format
  "roomType": "Deluxe"-
}

# DELETE "/remove" 

cancelReservation endpoint

it takes requestParam "userId" as input

Thanks
