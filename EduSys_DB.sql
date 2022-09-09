USE master
GO
DROP DATABASE IF EXISTS EDUSYS
GO 
CREATE DATABASE EDUSYS
GO
USE EDUSYS
GO
CREATE TABLE NhanVien(
	MaNV VARCHAR(20) PRIMARY KEY,
	MatKhau VARCHAR(50) NOT NULL,
	HoTen NVARCHAR(50) NOT NULL,
	VaiTro BIT DEFAULT 0,
	TrangThai BIT DEFAULT 0

)
CREATE TABLE KhoaHoc(
	MaKH INT IDENTITY(1,1) PRIMARY KEY,
	MaCD VARCHAR(5) NOT NULL,
	HocPhi FLOAT NOT NULL, 
	ThoiLuong INT NOT NULL,
	NgayKG DATE NOT NULL,
	GhiChu NVARCHAR(255),
	MaNV VARCHAR(20) NOT NULL,
	NgayTao DATE NOT NULL
)
CREATE TABLE ChuyenDe(
	MaCD VARCHAR(5) PRIMARY KEY,
	TenCD NVARCHAR(50) NOT NULL, 
	HocPhi FLOAT NOT NULL, 
	ThoiLuong INT NOT NULL,
	Hinh NVARCHAR(50) NOT NULL,
	MoTa NVARCHAR(255) NOT NULL,
)
CREATE TABLE NguoiHoc(
	MaNH VARCHAR(7) PRIMARY KEY,
	HoTen NVARCHAR(50) NOT NULL, 
	GioiTinh BIT DEFAULT 1 , 
	NgaySinh DATE NOT NULL,
	DienThoai VARCHAR(11) NOT NULL, 
	Email VARCHAR(100) NOT NULL,
	GhiChu NVARCHAR(255),
	MaNV VARCHAR(20) NOT NULL,
	NgayDK DATE NOT NULL
)
CREATE TABLE HocVien(
	MaHV INT IDENTITY(1,1) PRIMARY KEY,
	MaNH VARCHAR(7) NOT NULL,
	MaKH INT NOT NULL,
	Diem FLOAT DEFAULT -1 
)
GO

ALTER TABLE KhoaHoc ADD CONSTRAINT FK_KhoaHoc_ChuyenDe FOREIGN KEY (MaCD) REFERENCES ChuyenDe(MaCD) ON UPDATE CASCADE ON DELETE CASCADE
ALTER TABLE KhoaHoc ADD CONSTRAINT FK_KhoaHoc_NhanVien FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON UPDATE CASCADE ON DELETE NO ACTION
ALTER TABLE NguoiHoc ADD CONSTRAINT FK_NguoiHoc_NhanVien FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON UPDATE CASCADE ON DELETE NO ACTION
ALTER TABLE HocVien ADD CONSTRAINT FK_HocVien_NguoiHoc FOREIGN KEY (MaNH) REFERENCES NguoiHoc(MaNH) ON UPDATE CASCADE ON DELETE NO ACTION
ALTER TABLE HocVien ADD CONSTRAINT FK_HocVien_KhoaHoc FOREIGN KEY (MaKH) REFERENCES KhoaHoc(MaKH) ON DELETE CASCADE
-- Field with Identity not updated
GO
--
CREATE PROC SP_BANGDIEM 
@MAKH INT
AS
BEGIN
SELECT NguoiHoc.MaNH,NguoiHoc.HoTen,HocVien.Diem FROM NguoiHoc JOIN HocVien ON HocVien.MaNH = NguoiHoc.MaNH
WHERE HocVien.MaKH = @MAKH
ORDER BY HocVien.Diem DESC
END
GO
--
CREATE PROC SP_LUONGNGUOIHOC
AS
BEGIN
SELECT YEAR(NgayDK) AS 'NAM',COUNT(*) AS SOLUONG , MIN(NgayDK) AS DAUTIEN , MAX(NgayDK) AS CUOICUNG FROM NguoiHoc 
GROUP BY YEAR(NgayDK)
END
GO
--

CREATE PROC SP_DIEMCHUYENDE
AS
BEGIN
SELECT TenCD , COUNT(MaHV) AS SOHV , MIN(Diem) AS THAPNHAT , AVG(Diem) AS TRUNGBINH , MAX(Diem) AS CAONHAT 
FROM KhoaHoc JOIN HocVien ON KhoaHoc.MaKH = HocVien.MaKH JOIN ChuyenDe ON KhoaHoc.MaCD = ChuyenDe.MaCD
GROUP BY TenCD
END
GO
--

CREATE PROC SP_DOANHTHU
@YEAR INT
AS
BEGIN
SELECT TENCD,COUNT(DISTINCT KhoaHoc.MaKH) AS SOKH , COUNT(HocVien.MaHV) AS SOHV , SUM(KhoaHoc.HocPhi) AS DOANHTHU,MIN(KhoaHoc.HocPhi) AS THAPNHAT ,
MAX(KhoaHoc.HocPhi) AS CAONHAT , AVG(KhoaHoc.HocPhi) AS TRUNGBINH
FROM KhoaHoc JOIN HocVien ON KhoaHoc.MaKH = HocVien.MaKH JOIN ChuyenDe ON ChuyenDe.MaCD = KhoaHoc.MaCD
WHERE YEAR(NgayKG) = @YEAR
GROUP BY TenCD
END
GO

-- Insert into table NhanVien
INSERT INTO NhanVien(MaNV,HoTen,MatKhau,VaiTro) VALUES ('NVS0001',N'Trần Văn An','antvmnvs0001',0)
INSERT INTO NhanVien(MaNV,HoTen,MatKhau,VaiTro) VALUES ('NVS0002',N'Nguyễn Trung Biên','bienntmnvs0002',1)
INSERT INTO NhanVien(MaNV,HoTen,MatKhau,VaiTro) VALUES ('NVS0003',N'Lê Ngọc Chí','chilnmnvs0003',0)
select * from NhanVien
-- 
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('JAVA1',N'Lập trình JAVA 1 Core',250.0,90,'java1.jpg','')
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('JAVA2',N'Lập trình JAVA 2 Core',250.0,90,'java2.jpg','')
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('JAVA3',N'Lập trình JAVA 3 Swing',300.0,100,'java3.jpg','')
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('JAVA4',N'Lập trình JAVA 4 JSP & Servlet ',350.0,120,'java4.jpg','')
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('JAVA5',N'Lập trình JAVA 5 Spring MVC ',400.0,150,'java5.jpg','')
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('RDB01',N'Cơ sở dữ liệu',250.0,100,'database.jpg','')
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('RDB03',N'Cơ sở dữ liệu với Hibernate',300.0,150,'managerDB.jpg','')
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('RDB02',N'Hệ quản trị cơ sở dữ liệu',250.0,100,'hibernate.jpg','')
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('NET01',N'Lập trình C# 1 Core',250.0,90,'cs1.png','')
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('NET02',N'Lập trình C# 2 Core',250.0,90,'cs2.png','')
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('NET03',N'Lập trình C# 3 WinForm',300.0,100,'cs3.jpg','')
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('NET04',N'Lập trình C# 4 MS.NET',350.0,130,'cs4.png','')
INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES ('NET05',N'Lập trình C# 5 MS.NET MVC',400.0,150,'cs5.jpg','')
GO
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('JAVA1','NVS0001',250.0,90,'2/10/2022','1/10/2022',N'Ca 1 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('JAVA1','NVS0003',250.0,90,'2/11/2022','1/10/2022',N'Ca 2 : 2- 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('JAVA1','NVS0001',250.0,90,'2/12/2022','1/10/2022',N'Ca 3 : 3 - 5 - 7');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('JAVA2','NVS0002',250.0,90,'2/8/2022','1/10/2022',N'Ca 3 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('JAVA2','NVS0003',250.0,90,'2/9/2022','1/10/2022',N'Ca 2 : 3 - 5 - 7');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('JAVA3','NVS0002',300.0,100,'2/8/2022','1/10/2022',N'Ca 3 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('JAVA4','NVS0002',350.0,120,'2/11/2022','1/10/2022',N'Ca 1 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('JAVA4','NVS0002',350.0,120,'2/10/2022','1/10/2022',N'Ca 3 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('JAVA5','NVS0001',400.0,150,'2/1/2022','1/10/2022',N'Ca 3 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('NET01','NVS0001',250.0,90,'2/1/2022','1/10/2022',N'Ca 3 : 3 - 5 - 7');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('NET02','NVS0003',250.0,90,'2/5/2022','1/10/2022',N'Ca 3 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('NET02','NVS0001',250.0,90,'2/10/2022','1/10/2022',N'Ca 3 : 3 - 5 - 7');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('NET03','NVS0003',300.0,100,'2/12/2022','1/10/2022',N'Ca 3 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('NET03','NVS0003',300.0,100,'2/11/2022','1/10/2022',N'Ca 2 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('NET04','NVS0002',350.0,130,'2/5/2022','1/10/2022',N'Ca 3 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('NET04','NVS0003',350.0,130,'2/6/2022','1/10/2022',N'Ca 2 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('NET04','NVS0001',350.0,130,'2/7/2022','1/10/2022',N'Ca 1 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('NET05','NVS0001',400.0,150,'2/5/2022','1/10/2022',N'Ca 3 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('NET05','NVS0002',400.0,150,'2/10/2022','1/10/2022',N'Ca 2 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('RDB01','NVS0003',250.0,100,'2/5/2022','1/10/2022',N'Ca 1 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('RDB01','NVS0003',250.0,100,'2/4/2022','1/10/2022',N'Ca 2 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('RDB01','NVS0001',250.0,100,'2/6/2022','1/10/2022',N'Ca 3 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('RDB02','NVS0001',250.0,100,'2/4/2022','1/10/2022',N'Ca 3 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('RDB02','NVS0003',250.0,100,'2/5/2022','1/10/2022',N'Ca 3 : 3 - 5 - 7');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('RDB03','NVS0001',300.0,150,'2/10/2022','1/10/2022',N'Ca 1 : 3 - 5 - 7');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('RDB03','NVS0003',300.0,150,'2/11/2022','1/10/2022',N'Ca 1 : 2 - 4 - 6');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('RDB03','NVS0001',300.0,150,'2/12/2022','1/10/2022',N'Ca 3 : 3 - 5 - 7');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('RDB03','NVS0001',300.0,150,'2/9/2022','1/10/2022',N'Ca 2 : 3 - 5 - 7');
INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES ('RDB03','NVS0003',300.0,150,'2/8/2022','1/10/2022',N'Ca 3 : 2 - 4 - 6');
GO
INSERT INTO NguoiHoc(MaNH,HoTen,DienThoai,Email,GioiTinh,MaNV,NgaySinh,NgayDK,GhiChu) VALUES ('NH00001',N'Trần Văn An','0343344950','antv@gmail.com',1,'NVS0001','2/22/2002','2/1/2022','')
INSERT INTO NguoiHoc(MaNH,HoTen,DienThoai,Email,GioiTinh,MaNV,NgaySinh,NgayDK,GhiChu) VALUES ('NH00002',N'Nguyễn Ngọc Bình','0343343260','binhnn@gmail.com',1,'NVS0001','4/19/2002','2/5/2022','')
INSERT INTO NguoiHoc(MaNH,HoTen,DienThoai,Email,GioiTinh,MaNV,NgaySinh,NgayDK,GhiChu) VALUES ('NH00003',N'Lê Minh Chiến','0343384240','chienlm@gmail.com',1,'NVS0003','10/17/2002','2/5/2022','')
INSERT INTO NguoiHoc(MaNH,HoTen,DienThoai,Email,GioiTinh,MaNV,NgaySinh,NgayDK,GhiChu) VALUES ('NH00004',N'Trần Ngọc Dương','0343572349','duongtn@gmail.com',1,'NVS0002','8/29/2002','2/3/2022','')
INSERT INTO NguoiHoc(MaNH,HoTen,DienThoai,Email,GioiTinh,MaNV,NgaySinh,NgayDK,GhiChu) VALUES ('NH00004',N'Lê Thị Ngọc Yến','0343121204','yebltn@gmail.com',0,'NVS0003','2/9/2002','2/2/2022','')
INSERT INTO NguoiHoc(MaNH,HoTen,DienThoai,Email,GioiTinh,MaNV,NgaySinh,NgayDK,GhiChu) VALUES ('NH00005',N'Nguyễn Ngọc Vân','0346597533','vannn@gmail.com',0,'NVS0001','8/10/2002','2/2/2022','')
GO
INSERT INTO HocVien(MaKH,MaNH,Diem) VALUES (1,'NH00001',7);
INSERT INTO HocVien(MaKH,MaNH,Diem) VALUES (1,'NH00002',5);
INSERT INTO HocVien(MaKH,MaNH,Diem) VALUES (1,'NH00003',8.5);
INSERT INTO HocVien(MaKH,MaNH,Diem) VALUES (1,'NH00004',9.0);
INSERT INTO HocVien(MaKH,MaNH,Diem) VALUES (2,'NH00001',7.2);
INSERT INTO HocVien(MaKH,MaNH,Diem) VALUES (2,'NH00004',5.7);
INSERT INTO HocVien(MaKH,MaNH,Diem) VALUES (5,'NH00004',5.7);

