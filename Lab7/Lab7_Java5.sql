USE lab7_java5;

-- 🧱 Bảng danh mục
CREATE TABLE Category (
    id INT PRIMARY KEY,
    name NVARCHAR(100)
);

-- 🔗 Bảng liên kết danh mục - sản phẩm
CREATE TABLE Category_Product (
    ctid INT NOT NULL,
    pdid INT NOT NULL,
    PRIMARY KEY (ctid, pdid),
    FOREIGN KEY (ctid) REFERENCES Category(id),
    FOREIGN KEY (pdid) REFERENCES Product(id)
);

-- 📋 Dữ liệu Category
INSERT INTO Category (id, name) VALUES
(101, N'Đồ uống & Cà phê'),
(102, N'Bánh kẹo & Đồ ngọt'),
(103, N'Sữa & Sản phẩm từ sữa'),
(104, N'Gia vị & Đường muối'),
(105, N'Ngũ cốc & Bánh mì'),
(106, N'Sản phẩm từ mật ong & siro'),
(107, N'Thực phẩm tự nhiên & hữu cơ');

-- 🔗 Dữ liệu bảng liên kết Category_Product
INSERT INTO Category_Product (ctid, pdid) VALUES
-- Category 101: Đồ uống & Cà phê
(101, 1001), (101, 1006), (101, 1010), (101, 1027), (101, 1044),
(101, 1068), (101, 1072), (101, 1077), (101, 1087), (101, 1096),
(101, 1011), (101, 1013), (101, 1014), (101, 1071),

-- Category 102: Bánh kẹo & Đồ ngọt
(102, 1002), (102, 1015), (102, 1029), (102, 1035), (102, 1055),
(102, 1078), (102, 1091), (102, 1100), (102, 1071), (102, 1081),
(102, 1019), (102, 1021), (102, 1024), (102, 1031), (102, 1073),

-- Category 103: Sữa & Sản phẩm từ sữa
(103, 1007), (103, 1005), (103, 1033), (103, 1066), (103, 1097),
(103, 1034), (103, 1026), (103, 1035), (103, 1020), (103, 1060),
(103, 1032), (103, 1037), (103, 1038), (103, 1040),

-- Category 104: Gia vị & Đường muối
(104, 1017), (104, 1016), (104, 1086), (104, 1024), (104, 1064),
(104, 1082), (104, 1093), (104, 1022), (104, 1095), (104, 1025),
(104, 1042), (104, 1043), (104, 1046),

-- Category 105: Ngũ cốc & Bánh mì
(105, 1010), (105, 1041), (105, 1061), (105, 1035), (105, 1023),
(105, 1030), (105, 1050), (105, 1080), (105, 1099), (105, 1074),
(105, 1049), (105, 1051), (105, 1052),

-- Category 106: Sản phẩm từ mật ong & siro
(106, 1008), (106, 1022), (106, 1045), (106, 1073), (106, 1084),
(106, 1083), (106, 1092), (106, 1094), (106, 1090), (106, 1047),
(106, 1054), (106, 1057), (106, 1058), (106, 1059), (106, 1076),

-- Category 107: Thực phẩm tự nhiên & hữu cơ
(107, 1003), (107, 1004), (107, 1009), (107, 1012), (107, 1018),
(107, 1028), (107, 1036), (107, 1048), (107, 1056), (107, 1067),
(107, 1061), (107, 1062), (107, 1063), (107, 1064), (107, 1065),
(107, 1069);

-- 📊 Thống kê tồn kho theo loại
SELECT 
    c.name AS category_name,
    SUM(p.price) AS total_price,
    COUNT(p.id) AS total_products
FROM 
    Category c
    JOIN Category_Product cp ON c.id = cp.ctid
    JOIN Product p ON cp.pdid = p.id
GROUP BY 
    c.name
ORDER BY 
    total_price DESC;
