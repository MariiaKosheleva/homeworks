create table if not exists unigroup
(
    id varchar(255) primary key,
    name varchar(255)
);

create table if not exists undergraduate
(
    id varchar(255) primary key,
    firstname varchar(255),
    lastname varchar(255),
    age integer,
    dateofadmission date,
    unigroup_id varchar(255)
);

create table if not exists subject
(
    id varchar(255) primary key,
    name varchar(255),
    teacher_id varchar(255)
);

create table if not exists teacher
(
    id varchar(255) primary key,
    firstname varchar(255),
    lastname varchar(255),
    age integer,
    subject_id varchar(255)
);

create table if not exists mark
(
    id varchar(255) primary key,
    value integer,
    subject_id varchar(255),
    undergraduate_id varchar(255)
);