
CREATE DATABASE Student;

USE Student;

CREATE TABLE IF NOT EXISTS `thisinh` (
  `soBaoDanh` varchar(10) NOT NULL PRIMARY KEY,
  `hoTen` varchar(50) NOT NULL,
  `dienThoai` varchar(50) NOT NULL,
  `diemLyThuyet` float NOT NULL,
  `diemThucHanh` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `thisinh` (`soBaoDanh`, `hoTen`, `dienThoai`, `diemLyThuyet`, `diemThucHanh`) VALUES
('b140', 'toan', '45615789', 4.2, 1.5),
('B150', 'lynhattam', '123456789', 10, 9),
('B160', 'phanbuiphuongnhi', '987654456', 8, 6.9),
('b170', 'tinh tran', '0122554789', 7.1, 8.1);


