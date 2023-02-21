# RestfulSpring
This Repo uses DTO-Pattern, Rest api,Spring Web Service,Spring Data,Sprng Jpa,Hibernate
In this Example I used DTO Pattern between Presentation Layer and Business Layer.
Used Database  : PostgreSQL

I used package-system. control to project or how to use/do ?
When We want to use CRUD operations we dont want to use directly our model Class so We created the DTO object. Because we  dont want to show  to user all infos about entity.
We want to secure some info fields like password,email,another things.
Business Layer and Persistence Layer interat with Entity Object 
Some annotations here I want to talk about @Repository @Service @RestController,@Entity
@Repository it says to us that class interact with database with SQL Querys (JpaRepository facilitates to us ).
@Service it says to us that is service class.When we build a program .It creates a object of this class.
@RestController Controller says to us what is our endpoint what is our directions inside of API (It includes best practices thats important) 
Rest Controller works with JSON and XML Object it facilitates to us .We can send to server our Objects and get it.
@Entity class says to us that class is a table in our database .

![image](https://user-images.githubusercontent.com/57002551/219337794-69976fdc-50be-4921-9370-881c1d3d5ba9.png)

What is DTO Pattern 
Above I said what is it but I want to talk about Spring IOC Container and Dependency Injection and another important Annotations.



![image](https://user-images.githubusercontent.com/57002551/219340081-f495be76-3062-4f8a-a97c-a575196fe302.png)
here We can say When we run a program Service annotations creates a instance of service class and ıt stores inside of Spring IOC Container
When we  call it inside of another class We can use @Autowired annotations it shows to us that is dependency Injection Spring Ioc container calls automatically tht object to here
inside of Controller class from Service class.



![image](https://user-images.githubusercontent.com/57002551/219340713-2f0a0f40-b165-4d09-b9dd-336325f4b554.png)


Here We can see Component and Bean anonotations
They basically create an instance and it sends to Spring Ioc container .And Whenever we want to use ,We can use easily @Bean annotations is based method .We can call it anywhere from our Program and use it.

okey lets build up the puzzle!
When We use DTO pattern We must use ModelMapper it maps to for example User -> UserDTO that is a bean we can do it.


I used here Monolithic Architecture .But I know many companies uses usually Microservices Architectures It depends on the complex of project or any aspects.
What is Monolithic Architecture
Just One Database
A Server ->Load balancer regulates the Processes maybe some requests are so much ıt can regulate.
