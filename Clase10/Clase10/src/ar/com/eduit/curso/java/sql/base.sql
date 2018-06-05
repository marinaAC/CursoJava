drop database if exists colegio;
create database colegio;
use colegio;
create table cursos(
    idCurso     int auto_increment primary key,
    titulo      varchar(20) not null,
    profesor    varchar(20) not null,
    dia         varchar(20) not null
                check(dia in('lunes','martes','miércoles','jueves','viernes')),
    turno       varchar(20) not null
                check(turno in('mañana','tarde','noche'))
);
create table alumnos(
    idAlumno    int auto_increment primary key,
    nombre      varchar(20) not null,
    apellido    varchar(20) not null,
    edad        int         not null    check(edad>=18 and edad<=120),
    idCurso     int
);
alter table alumnos add constraint FK_alumnos_cursos
foreign key(idCurso)
references cursos(idCurso)
on delete set null;


