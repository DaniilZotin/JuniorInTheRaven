
<br />
<div align="center">
  <a href="https://theraven.tech/#contact-us">
    <img src="company-img/new-logo-2-.png" alt="Logo" width="300" height="80">
  </a>

  <h3 align="center" >The project to get job at TheRaven</h3>

  <p align="center">
    Here you can see description about the program😉
    <br />
    
  </p>
</div>









## Introduction 
Hello, my name is Daniil, I really want to work in your company as a developer, I specializing in Java and Java EE design 
and development for one year, have experience in 
creating new projects and supporting existing ones. I know that the competition is very strong, so I am making maximum efforts.

### VinWolves the best )


## About the project 

A system for working with users that has the following endpoints:
1. $\color{#E3C678}{{POST}}$  /api/customers - Create customer
2. $\color{#55AE5B}{{GET}}$ /api/customers - Read all customers
3. $\color{#55AE5B}{{GET}}$ /api/customers/{id} - Read customer
4. $\color{#706CD4}{{PUT}}$ /api/customers/{id} - Update customer
5. $\color{#FF0000}{{DELETE}}$ /api/customers/{id} - Delete customer



## Build with
* [![Spring][Spring]][Spring-url]
* [![Java][Java]][Java-url]
* [![MySQL][MySQL]][MySQL-url]


## Preview
### Create customer  
![image](https://github.com/DaniilZotin/JuniorInTheRaven/assets/85665335/e0a5b1d7-d516-4ffb-a208-6f02c1ea448e)
### Get customers
![image](https://github.com/DaniilZotin/JuniorInTheRaven/assets/85665335/cad6953c-946a-4113-9a4a-6498d0edbc20)

### Get customer 
![image](https://github.com/DaniilZotin/JuniorInTheRaven/assets/85665335/e9608476-2e7f-44d4-846f-1b330272e099)

### Update customer
I implemented the following logic: The user cannot change the id because it can lead to data inconsistency. 
Therefore, the id in the url must match the id in the json          
![image](https://github.com/DaniilZotin/JuniorInTheRaven/assets/85665335/22dc1ef4-7432-4188-916f-ab29a27a0087)

### Delete customer
![image](https://github.com/DaniilZotin/JuniorInTheRaven/assets/85665335/a6d46be3-405e-4a5b-b502-d83032e69912)


## DB
```sh
create database clientDB;
use clientDB;


CREATE TABLE IF NOT EXISTS customers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    created BIGINT NOT NULL,
    updated BIGINT NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    is_active BOOLEAN NOT NULL
);


INSERT INTO customers (created, updated, full_name, email, phone, is_active)
VALUES
    (UNIX_TIMESTAMP(NOW() - INTERVAL 1 DAY), UNIX_TIMESTAMP(), 'John Doe', 'john.doe@example.com', '+380501234567', true),
    (UNIX_TIMESTAMP(NOW() - INTERVAL 2 DAY), UNIX_TIMESTAMP(), 'Jane Smith', 'jane.smith@example.com', '+380961638509', true),
    (UNIX_TIMESTAMP(NOW() - INTERVAL 3 DAY), UNIX_TIMESTAMP(), 'Bob Johnson', 'bob.johnson@example.com', '+380992094351', false),
    (UNIX_TIMESTAMP(NOW() - INTERVAL 4 DAY), UNIX_TIMESTAMP(), 'Alice Williams', 'alice.williams@example.com', '+380960039598', true),
    (UNIX_TIMESTAMP(NOW() - INTERVAL 5 DAY), UNIX_TIMESTAMP(), 'Charlie Brown', 'charlie.brown@example.com', '+380988230569', true);

select * from customers;
```




### Instalation 
1. Clone the repo
   ```sh
     https://github.com/DaniilZotin/JuniorInTheRaven.git
   ```
2. Change DB      
   ![image](https://github.com/DaniilZotin/JuniorInTheRaven/assets/85665335/10b0b078-1762-4bbd-bda0-b58e67dced90)
3. Insert data 
8. Build project
   








[Spring]: https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io/projects/spring-framework

[MySQL]: https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white
[MySQL-url]: https://spring.io/projects/spring-framework

[Java]: https://img.shields.io/badge/Java-E02027?style=for-the-badge&logo=jameson&logoColor=white
[Java-url]: https://spring.io/projects/spring-framework

