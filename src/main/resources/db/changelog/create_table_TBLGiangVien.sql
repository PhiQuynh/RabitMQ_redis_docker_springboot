--liquibase formatted sql
--changeset author_liquibase:202304200857_create_table_schools
CREATE TABLE IF NOT EXISTS `tblgiangvien`(
Magv bigint primary key,
Hotengv varchar(30),
Luong decimal(5,2),
Makhoa varchar(10),
FOREIGN KEY (Makhoa) REFERENCES tblkhoa(Makhoa));

INSERT INTO tblgiangvien VALUES
(11,'Thanh Binh',700,'Geo'),
(12,'Thu Huong',500,'Math'),
(13,'Chu Vinh',650,'Geo'),
(14,'Le Thi Ly',500,'Bio'),
(15,'Tran Son',900,'Math');
