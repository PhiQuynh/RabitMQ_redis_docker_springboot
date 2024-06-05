--liquibase formatted sql
--changeset author_liquibase:202304200857_create_table_schools
CREATE TABLE IF NOT EXISTS `tbldetai`(
Madt varchar(10) primary key,
Tendt varchar(30),
Kinhphi bigint,
Noithuctap varchar(30));

INSERT INTO tbldetai VALUES
('Dt01','GIS',100,'Nghe An'),
('Dt02','ARC GIS',500,'Nam Dinh'),
('Dt03','Spatial DB',100, 'Ha Tinh'),
('Dt04','MAP',300,'Quang Binh' );
