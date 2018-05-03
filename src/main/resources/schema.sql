/*create table employee
(
   id int(10) not null AUTO_INCREMENT,
   name varchar(255) not null,
   designation varchar(255) not null,
   age int(10) not null,
   primary key(id)
);


create table address
(
   id int(10) not null AUTO_INCREMENT,
   street varchar(255) not null,
   city varchar(255) not null,
   state varchar(255) not null,
   country varchar(255) not null,
   primary key(id),
   FOREIGN KEY (employee) REFERENCES employee(id)
   
);*/