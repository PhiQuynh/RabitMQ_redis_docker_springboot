--liquibase formatted sql
--changeset author_liquibase:202304200857_create_table_schools
CREATE TABLE IF NOT EXISTS `tblsinhvien`(
Masv bigint primary key AUTO_INCREMENT,
Hotensv varchar(40),
Namsinh varchar(30),
Quequan varchar(30),
Makhoa varchar(10),
FOREIGN KEY (Makhoa) REFERENCES tblkhoa(Makhoa));

INSERT INTO tblsinhvien VALUES
(1,'Le Van Son','1990','Nghe An','Bio'),
(2,'Nguyen Thi Mai','1990','Thanh Hoa','Geo'),
(3,'Bui Xuan Duc','1992','Ha Noi','Math'),
(4,'Nguyen Van Tung',null,'Ha Tinh','Bio'),
(5,'Le Khanh Linh','1989','Ha Nam','Bio'),
(6,'Tran Khac Trong','1991','Thanh Hoa','Geo'),
(7,'Le Thi Van',null,'null','Math'),
(8,'Hoang Van Duc','1992','Nghe An','Bio');

