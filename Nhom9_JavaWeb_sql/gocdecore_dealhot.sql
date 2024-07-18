CREATE DATABASE  IF NOT EXISTS `gocdecore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gocdecore`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: gocdecore
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dealhot`
--

DROP TABLE IF EXISTS `dealhot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dealhot` (
  `light_id` int NOT NULL AUTO_INCREMENT,
  `light_name` varchar(200) NOT NULL,
  `light_price` int NOT NULL,
  `light_pricelegal` int NOT NULL,
  `light_percen` int NOT NULL,
  `light_material` varchar(200) DEFAULT NULL,
  `light_color` varchar(100) DEFAULT NULL,
  `light_size` varchar(100) NOT NULL,
  `light_state` varchar(100) NOT NULL,
  `light_img` text,
  PRIMARY KEY (`light_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dealhot`
--

LOCK TABLES `dealhot` WRITE;
/*!40000 ALTER TABLE `dealhot` DISABLE KEYS */;
INSERT INTO `dealhot` VALUES (32,'Đèn sàn hoa sen trang trí phong cảnh lãng mạn',2600000,2900000,5,'Nhựa PC, Sắt nghệ thuật','Màu trắng, Màu xanh','25x180','còn hàng','3_1'),(33,'Đèn sàn kiểu Mỹ điều chỉnh chiều cao tiện lợi				',4387000,4987000,15,'Thép cao cấp, Vải chịu nhiệt','Màu vàng	','40x150','còn hàng','3_3'),(34,'Đèn thả bằng gỗ phong cách Wabi-sabi độc đáo				',2315000,2615000,25,'Đồng thau, Gỗ','Màu gỗ nhạt, Màu gỗ óc chó','43x28','còn hàng','2_1	'),(35,'Đèn thả trần bằng đá hình tròn 2 lớp độc đáo					',2160000,2260000,5,'Acrylic, Đá tự nhiên','Màu đen','43x28','còn hàng','2_2	'),(36,'Đèn chùm pha lê nhà hàng đàn bướm bay lượn',25990000,35990000,30,'Pha lê, Thép không gỉ','Màu trắng','120x80','còn hàng','2_3	'),(37,'Đèn sàn phòng khách kiểu dáng uốn lượn',1725000,1785000,5,'Nhôm, Sillicon, Thép không gỉ			','Màu đen','28x133','còn hàng','1_1	'),(38,'Đèn sàn phòng ngủ hai đầu sáng tạo			',1398000,1598000,15,'Acrylic, Thép không gỉ','Màu đen','23*166','còn hàng','1_2	'),(39,'Đèn sàn trang trí phòng khách sáng tạo kiểu Ý					',15943000,16243000,5,'Thép không gỉ	','Màu trắng, Màu cam đất','22*165','còn hàng','1_3	'),(40,'Đèn sàn vòng cung sang trọng hiện đại				',3549000,3949000,30,'Acrylic, Thép không gỉ','Màu nâu, Màu trắng','28*165','còn hàng','1_4	'),(41,'Đèn sàn trang trí nghệ thuật nữ thần nhảy múa				',20748000,29748000,10,'Nhựa, Thuỷ tinh','Màu trắng','78*179','còn hàng','1_5	'),(42,'Đèn sàn xếp ly thân lượn sóng sáng tạo',983000,1083000,15,'Thép không gỉ			','Màu trắng, Màu vàng, Màu xanh','25*155','còn hàng','1_7	'),(43,'Đèn sàn decor phòng khách bằng vải Wabi-sabi			',5855000,6055000,25,'Thép cao cấp, Vải chịu nhiệt','Màu trắng','40x160','còn hàng','1_8	'),(44,'Đèn cây đứng trang trí góc sofa sáng tạo					',5415000,5915000,5,'Thép cao cấp, Vải chịu nhiệt','Màu trắng, Màu vàng','30x113','còn hàng','1_9	'),(45,'Đèn chùm pha lê nhà hàng đàn bướm bay lượn						',25990000,29990000,10,'Pha lê, Thép không gỉ','Màu trắng','120x80','Còn hàng','2_3');
/*!40000 ALTER TABLE `dealhot` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-28  1:44:55
