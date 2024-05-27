**Hibernate Basic Project**

Overview

This Java project demonstrates the basic usage of Hibernate to map Java classes to database tables. The project uses Maven for dependency management and includes two primary entities: Employee and Address, which are related and persisted in a MySQL database.

System Requirements

Java JDK 17 or newer
Maven 3.6 or newer
MySQL Server 8.0 or newer

Configuration

The database configuration is set in hibernate.cfg.xml. Ensure that MySQL is running and the credentials provided in the configuration file match those of your MySQL instance.

Dependencies

MySQL Connector/J
Hibernate ORM
These dependencies are managed through Maven, as specified in the pom.xml file.

Notes

The project is configured to show SQL output in the console for educational purposes.
The Hibernate configuration is set to update the database schema automatically.