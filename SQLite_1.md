# Android Sqlite 
	* IDE 
	* SQL 
		* Show Table
		* Create table 
		* Describe Table
		* Select
		* Insert 
		* Update 
		* Delete 
		* Pagination 		
	* JOIN 
	* Group By 
	* Create Table IF NOT EXISTS
	* Full Sql Script
	
## IDE 
	Tool IDE Db Browse for Sqlite
	
## SQL
### Show table 
	select name from sqlite_master;
	
### Create Table 
	* department :
		CREATE TABLE `department` (
			`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
			`name_department`	TEXT,
			`address_department`	TEXT,
			`note`	TEXT
		);

	* employee : 
		CREATE TABLE `employee` (
			`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
			`name`	TEXT,
			`address`	TEXT,
			`salary`	NUMERIC,
			`department_id`	INTEGER,
			FOREIGN KEY(`department_id`) REFERENCES `department`(`id`) on update set null
		);
	
	
### Describe Table 
	PRAGMA table_info(employee);
	PRAGMA table_info(department);
	
### SELECT
	select * from department;
	select * from employee;
	
### Insert 
	* Department table : 
		insert into department (name_department, address_department) values ('IT Departmnet', 'lampung tengah');
		insert into department (name_department, address_department) values ('Finance', 'lampung barat');
		insert into department (name_department, address_department) values ('Sales Marketing', 'lampung utara');
		insert into department (name_department, address_department) values ('Humas', 'lampung selatan');
		
	* Employee table : 
		insert into employee (name, address, salary, department_id) values ('masyda arrizaqu', 'seputih banyak', 50000.0, 13);
		insert into employee (name, address, salary, department_id) values ('NIta bahar', 'jakarta utara', 23000.0, 14);
		insert into employee (name, address, salary, department_id) values ('Agung Budiyono', 'jakarta barat', 40000.0, 14);
		insert into employee (name, address, salary, department_id) values ('Indah suci', 'tangerang', 23400.0, 15);
	
### Update
	update department
	set name_department = 'lampung tengah'
	where department.id = 1;

### Delete 
	delete from department where department.id = 1;
	
### Pagination 
	select * from department limit 0, 3;
	
## JOIN Table 
	select 
	  emp.name as full_name,
	  emp.salary as salary,
	  emp.address as address,
	  department.name_department as deptname
	from employee emp
	join department department
	on 
	emp.department_id = department.id 

## Group By 
	select 
	  department.name_department,
	  avg(employee.salary),
	  department.name_department as deptname,
	  count(*) people
	from employee
	join department
	on 
	employee.department_id = department.id 
	group by employee.department_id

##	Create table IF NOT EXISTS 
	create table if not exists contoh (
		id integer primary key,
		name text,
		address text 
	)
	
## Full Sql Script
	-- show tables
	select name from sqlite_master;
	
	-- crete table department
	CREATE TABLE `department` (
		`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
		`name_department`	TEXT,
		`address_department`	TEXT,
		`note`	TEXT
	);

	-- create table employee 
	CREATE TABLE `employee` (
		`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
		`name`	TEXT,
		`address`	TEXT,
		`salary`	NUMERIC,
		`department_id`	INTEGER,
		FOREIGN KEY(`department_id`) REFERENCES `department`(`id`) on update set null
	);

	-- select the table
	select * from department;
	select * from employee;

	-- describe table
	PRAGMA table_info(department);
	pragma table_info(employee);

	-- insert table department
	insert into department (name_department, address_department) values ('IT Departmnet', 'lampung tengah');
	insert into department (name_department, address_department) values ('Finance', 'lampung barat');
	insert into department (name_department, address_department) values ('Sales Marketing', 'lampung utara');
	insert into department (name_department, address_department) values ('Humas', 'lampung selatan');

	-- insert table employee 
	insert into employee (name, address, salary, department_id) values ('masyda arrizaqu', 'seputih banyak', 50000.0, 13);
	insert into employee (name, address, salary, department_id) values ('NIta bahar', 'jakarta utara', 23000.0, 14);
	insert into employee (name, address, salary, department_id) values ('Agung Budiyono', 'jakarta barat', 40000.0, 14);
	insert into employee (name, address, salary, department_id) values ('Indah suci', 'tangerang', 23400.0, 15);

	-- update 
	update department
	set name_department = 'lampung tengah'
	where department.id = 1;

	-- delete
	delete from department;
	delete from department where department.id = 1;

	-- pagination 
	select * from department limit 0, 2;

	-- join
	select 
	  emp.name as full_name,
	  emp.salary as salary,
	  emp.address as address,
	  department.name_department as deptname
	from employee emp
	join department department
	on 
	emp.department_id = department.id 

	-- Group Function 
	select count(*), max(salary), sum(salary), avg(salary) from employee;

	-- group by 
	select 
	  department.name_department,
	  avg(employee.salary),
	  department.name_department as deptname,
	  count(*) people
	from employee
	join department
	on 
	employee.department_id = department.id 
	group by employee.department_id

	-- drop table
	drop table employee;
	drop table department;
