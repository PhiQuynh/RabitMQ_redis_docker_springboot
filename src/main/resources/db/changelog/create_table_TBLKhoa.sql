--liquibase formatted sql
--changeset author_liquibase:202304200857_create_table_schools
CREATE TABLE IF NOT EXISTS `tblkhoa`
(
    Makhoa varchar(10) primary key,
    Tenkhoa varchar(30),
    Dienthoai varchar(10)
 );

INSERT INTO tblkhoa VALUES
('Geo','Dia ly va QLTN',3855413),
('Math','Toan',3855411),
('Bio','Cong nghe Sinh hoc',3855412);