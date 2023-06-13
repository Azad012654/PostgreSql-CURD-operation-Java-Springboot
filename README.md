# PostgreSql-CURD-operation-Java-Springboot


API Endpoits :-

1. Get Details of all the students Entries in DB(GET) = http://localhost:8080/api/v1/student/get-students
2. Create new Student entry in DB(POST)= http://localhost:8080/api/v1/student/save-student
3. Get Details of Single Student using Email Address  (GET) = http://localhost:8080/api/v1/student/get-student/<email address>
4. Delete a Student using ID#(DELETE) = http://localhost:8080/api/v1/student/<id>
5. Update user info using ID# (PUT) = http://localhost:8080/api/v1/student/update/<id>
  
Steps to Run the project.
  1. Install PostGreSql start postgresql using pgadmin4.exe and create a database called Student.
  2. Open the project on Springboot and change the configuration from application.properties and set the localhost ,port number, username and password for DB.
  3. Run the project and use the endpoints given above to perform the operations.
