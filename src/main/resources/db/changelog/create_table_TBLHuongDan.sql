--liquibase formatted sql
--changeset author_liquibase:202304200857_create_table_schools
CREATE TABLE IF NOT EXISTS `tblhuongdan`(
Masv bigint primary key,
Madt varchar(10),
Magv bigint,
KetQua decimal(5,2),
foreign key (Madt) references tbldetai(Madt),
foreign key (Magv) references tblgiangvien(Magv));

INSERT INTO tblhuongdan VALUES
(1,'Dt01',13,8),
(2,'Dt03',14,0),
(3,'Dt03',12,10),
(5,'Dt04',14,7),
(6,'Dt01',13,Null),
(7,'Dt04',11,10),
(8,'Dt03',15,6);