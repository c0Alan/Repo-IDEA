postgresql:
db.driver=org.postgresql.Driver
db.url=jdbc:postgresql://192.168.147.129:5432/sd
db.username=postgres
db.password=123abe
DBMS:PostgreSQL

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>${postgresql.version}</version>
</dependency>

<dependency>
    <groupId>com.googlecode.log4jdbc</groupId>
    <artifactId>log4jdbc</artifactId>
    <version>${log4jdbc.version}</version>
</dependency>

mysql:
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>${mysql.version}</version>
</dependency>
DBMS: MySQL

DBMS:
SYBASE
DB2
ORACLE
ACCESS
Visual Foxpro
MS SQL Server
Informix


