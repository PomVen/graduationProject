create table student(
stu_seq integer primary key not null,
stu_code varchar(20),
stu_name varchar(200),
stu_gender varchar(1),
stu_age varchar (3),
stu_class_num varchar (20),
stu_password varchar (200)
);

create table graduation_theme(
theme_seq integer primary key not null,
theme_title varchar(200),
theme_introduction varchar(2000),
theme_teacher varchar(50)
);

create table teacher(
teacher_seq integer primary key not null,
teacher_name varchar(200),
teacher_id varchar(2000),
teacher_age varchar(3),
teacher_gender varchar(1),
teacher_phone varchar(1),
teacher_major varchar(1),
teacher_address varchar(1),
teacher_email varchar(1),
);

