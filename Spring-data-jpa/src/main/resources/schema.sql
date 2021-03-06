CREATE TABLE `USER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `CREATED_TIME` datetime NOT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `USER_TYPE` varchar(45) NOT NULL,
  `DOB` date NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_NAME_UNIQUE` (`USER_NAME`)
);

create table if not exists employee
(
    id                 bigint auto_increment
        primary key,
    created_by         varchar(100) null,
    created_date       datetime(6)  null,
    last_modified_by   varchar(100) null,
    last_modified_date datetime(6)  null,
    address            varchar(255) null,
    email              varchar(255) null,
    first_name         varchar(255) not null,
    last_name          varchar(255) not null,
    phone              varchar(255) null
);



create table if not exists project
(
    id                 bigint auto_increment
        primary key,
    created_by         varchar(100) null,
    created_date       datetime(6)  null,
    last_modified_by   varchar(100) null,
    last_modified_date datetime(6)  null,
    budget             double       null,
    location           varchar(255) not null,
    name               varchar(255) not null,
    type               varchar(255) null
);


create table if not exists employee_project
(
    employee_id bigint not null,
    project_id  bigint not null,
    primary key (employee_id, project_id),
    constraint FK4yddvnm7283a40plkcti66wv9
        foreign key (project_id) references project (id),
    constraint FKb25s5hgggo6k4au4sye7teb3a
        foreign key (employee_id) references employee (id)
);


drop view if exists employee_project_view;
create view employee_project_view as
select distinct employee_id,
       first_name,
       last_name,
       project_id,
       name     as project_name,
       location as project_location,
       budget   as project_budget
from employee,
     employee_project,
     project
where employee.id = employee_project.employee_id
  and employee_project.project_id = project.id;





INSERT INTO employee (id, first_name, last_name, email, address, phone)
VALUES (1,  'John',  'Doe', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone)
VALUES (2,  'Jack',  'Reacher', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone)
VALUES (3,  'John',  'Reese', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone)
VALUES (4,  'Steve',  'Rogers', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone)
VALUES (5,  'Tony',  'Stark', null, null, null);
INSERT INTO employee (id, first_name, last_name, email, address, phone)
VALUES (6,  'Mark',  'Modaha', null, null, null);

INSERT INTO project (id, name, budget, location, type)
VALUES (1,  'HR Management System', 1000,  'DC',  'Internal');
INSERT INTO project (id, name, budget, location, type)
VALUES (2,  'Timesheet Managerment', 1000,  'NYC',  'Contract');
INSERT INTO project (id, name, budget, location, type)
VALUES (3,  'Online Reservation', 1000,  'LA',  'Contract');
INSERT INTO project (id, name, budget, location, type)
VALUES (4,  'Employee Portal', 1000,  'Chicago',  'Internal');
INSERT INTO project (id, name, budget, location, type)
VALUES (5,  'PayCheck System', 1000,  'Chicago',  'Internal');
INSERT INTO project (id, name, budget, location, type)
VALUES (6,  '401K System', 1000,  'Chicago',  'Internal');


INSERT INTO employee_project (employee_id, project_id)
VALUES (1, 1);
INSERT INTO employee_project (employee_id, project_id)
VALUES (1, 2);
INSERT INTO employee_project (employee_id, project_id)
VALUES (1, 3);
INSERT INTO employee_project (employee_id, project_id)
VALUES (1, 4);
INSERT INTO employee_project (employee_id, project_id)
VALUES (1, 5);
INSERT INTO employee_project (employee_id, project_id)
VALUES (1, 6);
INSERT INTO employee_project (employee_id, project_id)
VALUES (2, 1);
INSERT INTO employee_project (employee_id, project_id)
VALUES (2, 2);
INSERT INTO employee_project (employee_id, project_id)
VALUES (2, 3);
INSERT INTO employee_project (employee_id, project_id)
VALUES (2, 4);
INSERT INTO employee_project (employee_id, project_id)
VALUES (2, 5);
INSERT INTO employee_project (employee_id, project_id)
VALUES (2, 6);
INSERT INTO employee_project (employee_id, project_id)
VALUES (3, 1);
INSERT INTO employee_project (employee_id, project_id)
VALUES (3, 2);
INSERT INTO employee_project (employee_id, project_id)
VALUES (3, 3);
INSERT INTO employee_project (employee_id, project_id)
VALUES (3, 4);
INSERT INTO employee_project (employee_id, project_id)
VALUES (3, 5);
INSERT INTO employee_project (employee_id, project_id)
VALUES (3, 6);
INSERT INTO employee_project (employee_id, project_id)
VALUES (4, 1);
INSERT INTO employee_project (employee_id, project_id)
VALUES (4, 2);
INSERT INTO employee_project (employee_id, project_id)
VALUES (4, 3);
INSERT INTO employee_project (employee_id, project_id)
VALUES (4, 4);
INSERT INTO employee_project (employee_id, project_id)
VALUES (4, 5);
INSERT INTO employee_project (employee_id, project_id)
VALUES (4, 6);
INSERT INTO employee_project (employee_id, project_id)
VALUES (5, 1);
INSERT INTO employee_project (employee_id, project_id)
VALUES (5, 2);
INSERT INTO employee_project (employee_id, project_id)
VALUES (5, 3);
INSERT INTO employee_project (employee_id, project_id)
VALUES (5, 4);
INSERT INTO employee_project (employee_id, project_id)
VALUES (5, 5);
INSERT INTO employee_project (employee_id, project_id)
VALUES (5, 6);
INSERT INTO employee_project (employee_id, project_id)
VALUES (6, 1);
INSERT INTO employee_project (employee_id, project_id)
VALUES (6, 2);
INSERT INTO employee_project (employee_id, project_id)
VALUES (6, 3);
INSERT INTO employee_project (employee_id, project_id)
VALUES (6, 4);
INSERT INTO employee_project (employee_id, project_id)
VALUES (6, 5);
INSERT INTO employee_project (employee_id, project_id)
VALUES (6, 6);

