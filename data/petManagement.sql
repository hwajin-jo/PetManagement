create database petManage;
use petmanage;

create table petMember(
	memberID int auto_increment not null,
    memberName varchar(20) not null,
    memberSpecies varchar(20) not null,
    hostName varchar(20) not null,
    hostPhoneNum varchar(20) not null,
    visitReason varchar(30) not null,
    primary key (memberID)
);

create table Examination(
	examID int auto_increment not null,
    memberID int not null,
    memberName varchar(20),
    examContent varchar(50),
    examCost varchar(20),
    foreign key (memberID) references petMember(memberID),
    primary key (examID)
);

create table petReservation(
	reservationID int auto_increment not null,
    memberID int not null,
    memberName varchar(20),
    nextReserve datetime,
    foreign key (memberID) references petMember(memberID),
    primary key (reservationID)
);

create table managerLogin(
	managerID varchar(30) not null,
    managerPWD varchar(30) not null,
    primary key(managerID)
);

drop table examination;
drop table petmember;
drop table petreservation;
drop table managerlogin;

select * from petmember;
select * from examination;
select * from petreservation;
select * from managerLogin;

-- insert test
insert into petmember values(null,'초코','dog','홍길동','01012345678','예방접종');
insert into petmember values(null,'두부','dog','김자바','01087654321','예방접종');

insert into examination values(null,001,'초코','소화장애','35000');
insert into examination values(null,002,'두부','감기','12000');

insert into petreservation values(null,001,'초코','2022-07-10 13:30:00');
insert into petreservation values(null,002,'두부','2022-07-10 14:30:00');

insert into managerlogin values('manager1','1234');