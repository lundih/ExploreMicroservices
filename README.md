### Microservices with Spring Boot
A simple project in Spring Boot to demonstrate microservices. The project is to explore the basic ideas in the microservice architecture. It does not strictly follow best practices. It does not use any external data sources.<br><br>
Three microservices are available:<br>
<ul>
<li>Movie (receives a movie ID and returns details about the movie)</li>
<li>Rating (receives a user ID and returns ratings of movies by the user)*</li>
<li>Movie catalogue (uses the movie and ratings microservices to get a catalogue of user rated movies)</li>
</ul><br>
Service discovery is used to enable the microservcies to find each other. Eureka server facilitates service discovery amongst the microservices<br>
*For this project, the user ID received  by the rating service is not actually used in the service itself.<br><br>

<b>They may be called microservices, but they're doing us a big service.</b>
