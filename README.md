# Student_system_springboot
This is the backend part of a student course system, where students can enroll or cancel enrollement in class.
The backend is written in springboot framework.

Return all avalible courses:
GET: localhost:8080/api/v1/course/

Return all the courses, that the student is enrolled in:
GET: localhost:8080/api/v1/course/

Return the course with id:
GET: localhost:8080/api/v1/course/{id}

Return the course with name:
GET: localhost:8080/api/v1/course/name/{name}

Create new course:
POST: localhost:8080/api/v1/course/

Delete course:
POST: localhost:8080/api/v1/course/{id}

Update course:
PUT: localhost:8080/api/v1/course/{id}

Enroll in course:
PUT: localhost:8080/api/v1/course/{id}/enroll

Cancel enrollement in course:
PUT: localhost:8080/api/v1/course/{id}/cancel_enroll


You can sumbit requests with postman or you can use a frontend I did for this project in angular, which you can find on url: https://github.com/jurankar/StudentSystemAngular
