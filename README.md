```

--create

create table students(
    student_id serial primary key ,
    student_name varchar(100) NOT NULL ,
    email varchar(100) ,
    phone_number varchar(100)
);



create  table student_course(
    id serial primary key ,
    student_id int references  students(student_id) ON DELETE CASCADE,
    course_id int references courses(course_id) ON DELETE CASCADE

);



create table  instructors(
    instructor_id serial primary key ,
    instructor_name varchar(100) not null ,
    email varchar(100)
);


create  table courses(
    course_id serial primary key ,
    course_name varchar(100) not null ,
    description varchar(200)  ,
    instructor_id INT REFERENCES instructors(instructor_id) ON DELETE CASCADE
);

update instructors set email = 'Lyna@gmail.com' where  instructor_id =2;
```
