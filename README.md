# My Producivity App (Backend)

This project is the backend API service for My Productivity App project.  This project is built with Maven, Java, Spring Boot and MySQL.  Visit the source repository for the frontend for a description, backstory, and user interface on this project.

<details closed>
<summary>
<h2>Feature Specification</h2>
</summary>

Create and manage projects and tasks.
Dashboard
- Task
Projects have can be viewed in 3 ways
- Table View
- Calendar View
- Board View (i.e. Kabana board)

</details>

<details open>
<summary>
<h2>Project Folder Structure</h2>
</summary>

```
├── backend
│   ├── .mvn
│   │    └── wrapper
│   │        └──
│   ├── .vscode
│   │    └── settings.json # VS Code settings


│   ├── index.css # Global styles.
│   ├── index.tsx # Used for DOM rendering only.
│   ├── react-app-env.d.ts # .
│   ├── reportWebVitals.ts # .
│   ├── setupTests.ts # .
│   └── types.ts # Typescript types definitions for the project.
├── .gitignore # Files ignored by Git.
├── README.md # This file.
├── package.json # npm package manager file.
├── package-lock.json # Contains the dependencies used in the project.
├── postcss-config.json # .
├── tailwind.config.js # Tailwind CSS configuration file.
└── tsconfig.json # Typescript configuration file.
```
</details>

<details closed>
<summary>
<h2>API Documentation</h2>
</summary>

[Link to OpenAPI definition]()

</details>


<details open>
<summary>
<h2>Known Issues</h2>
</summary>

TBD

</details>

<details open>
<summary>
<h2>Future Todos</h2>
</summary>

</details>

<details open>
<summary>
<h2>Resources</h2>
</summary>

<details closed>
<summary>
<h4>Backend (Spring Boot, Java, PostgreSQL, AWS, ...)</h4>
</summary>

* [The Complete Java Development Bootcamp (Udemy)](https://www.udemy.com/course/the-complete-java-development-bootcamp/).  This course was great in helping me learn the basics of Java within a week.

* [The Complete Spring Boot Development Bootcamp (Udemy)](https://www.udemy.com/course/the-complete-java-development-bootcamp/).  This course was great in helping me learn the basics of Spring Boot within a week.

* [Spring Boot in Practice (Amazon)](https://www.amazon.com/Spring-Boot-Practice-Somnath-Musib-ebook/dp/B0B3YD1PGD?ref_=ast_author_mpb)

* [Difference Between java.util.Date and java.sql.Date in Java](https://javarevisited.blogspot.com/2012/04/difference-between-javautildate-and.html)

* [Repository not extending JpaRepository](https://stackoverflow.com/questions/55756272/repository-not-extending-jparepository)

* [VS Code message: org.springframework.stereotype.Repository. Unnecessary `@Repository`vscode-spring-boot(JAVA_REPOSITORY) (Stackoverflow)](https://stackoverflow.com/questions/69909613/why-spring-data-jpa-unnecessary-repository)

* [Storing tags in MySQL database (Quora)](https://www.quora.com/What-is-the-best-and-easy-way-to-store-tags-in-MySQL-database)

* [A Simple Tagging Implementation with JPA (Baeldung)](https://www.baeldung.com/jpa-tagging)

* [An Advanced Tagging Implementation with JPA (Baeldung)](https://www.baeldung.com/jpa-tagging-advanced)

* [Error calling `jakarta.validation.Validation#buildDefaultValidatorFactory` (Stackoverflow)](https://stackoverflow.com/questions/74788826/error-calling-jakarta-validation-validationbuilddefaultvalidatorfactory)


* [@RequiredArgsConstructor and @NoArgsConstructor annotation errors - Duplicate method Project() in type Project (Stackoverflow)](https://stackoverflow.com/questions/60163928/error-duplicate-method-enquiryform-in-type-enquiryform-for-allargsconstruct)

* [Hibernate: "Field 'id' doesn't have a default value"](https://stackoverflow.com/questions/804514/hibernate-field-id-doesnt-have-a-default-value)

* [MySQL Disable Foreign Key Checks](https://www.mysqltutorial.org/mysql-disable-foreign-key-checks/).  I made a schema change and could not drop a table due to a foreign key.  After running the SQL command `SET foreign_key_checks = 0;`, I could drop the table.

* [Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver' [duplicate] (Stackoverflow)](https://stackoverflow.com/questions/52032739/loading-class-com-mysql-jdbc-driver-this-is-deprecated-the-new-driver-class)
I was getting the message: `Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.`  I resolved it by changing the application.properties from `spring.datasource.driver-class-name=com.mysql.jdbc.Driver` to `spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`.

* [Spring h2 database error when trying to save (Stackoverflow)](https://stackoverflow.com/questions/57502956/spring-h2-database-error-when-trying-to-save)
I was getting the error message: `java.lang.NullPointerException: Cannot invoke "com.stevehanstudio.productivity.service.ProjectService.createProject(com.stevehanstudio.productivity.entity.Project)" because "this.projectService" is null`.  The person that posted Stackoverflow he resolved his issue by adding `@autowired` to the controller.  In my case I resolved it by adding `@AllArgsConstructor` to the service.


</details>

</details>




