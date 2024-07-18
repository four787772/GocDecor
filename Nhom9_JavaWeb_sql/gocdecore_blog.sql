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
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `blog_id` int NOT NULL AUTO_INCREMENT,
  `blog_title` varchar(1000) NOT NULL,
  `blog_description` varchar(14000) NOT NULL,
  `blog_img` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (1,'Hướng dẫn chi tiết cách lắp đặt đèn LED ngoài trời ','Việc lắp đặt đèn LED ngoài trời không chỉ mang lại ánh sáng cần thiết mà còn tạo điểm nhấn thẩm mỹ cho không gian sống của bạn. Tuy nhiên, để đèn hoạt động hiệu quả và bền lâu, cần có một quy trình lắp đặt chính xác và an toàn.Tiết kiệm chi phí điện','blog1'),(2,'Các loại đèn ngoài trời lý tưởng cho khu vườn của bạn','Đèn ngoài trời, đúng như tên gọi, dành cho không gian bên ngoài. Chức năng chính của hệ thống chiếu sáng ngoài trời là cung cấp ánh sáng cho các khu vực bên ngoài bên ngoài như sân, lối đi, vườn, sân và mặt  ','blog2'),(3,'Bí quyết chọn đèn led phòng khách độc đáo và ấn tượng','Nguyên tắc bố trí đèn led phòng khách thông minh. Dưới đây là những nguyên tắc quan trọng giúp bạn lựa chọn và bố tr','blog3'),(4,'Đèn chiếu sáng cho lối đi từ cổng vào nhà','Ba quy tắc chiếu sáng hiệu quả cho lối đi từ cổng vào nhà. Ánh sáng là một trong những yếu tố quan trọng trong việc tôn lên vẻ đẹp của ngôi nhà. Tuy nhiên, không phải ai cũng biết cách bố trí ánh sáng như thế nào để đạt được hiệu quả thẩm mỹ cao nhất. Do vậy, blog nội thất Flexhouse VN sẽ chia sẻ với bạn ba nguyên tắc vàng để thiết kế chiếu sáng cho lối đi từ cổng vào nhà. Sự liên kết tổng thể','blog4'),(5,'9 cách chọn đèn trang trí bàn ăn cho mái ấm của bạn','Bài viết này sẽ đưa ra cho bạn một số trường hợp sử dụng đèn trang trí bàn ăn để mang đến cho bạn một không gian thư giãn, ấm cúng và sum vầy bên gia đình hay các cuộc hội họp bè bạn, đồng nghiệp thêm phần trang trọng, vui tươi, thoải mái.','blog5'),(6,'Bí kíp thiết kế phòng chơi game tại nhà “chất” như game thủ chuyên nghiệp','Không phải ai cũng sở hữu một phòng giải trí rộng rãi được thiết kế riêng cho nhu cầu thư giãn. Nhưng điều đó không có nghĩa là bạn không thể biến ước mơ thành hiện thực. Bí quyết nằm ở việc khéo léo tận dụng không gian sẵn có, dù đó là một phòng nhỏ, một góc phòng khách hay thậm chí chỉ là một phần của phòng làm v','blog6'),(7,'Mẹo sử dụng tấm tiêu âm trang trí cho mọi không gian nội thất','Tấm tiêu âm trang trí thường ứng dụng nhiều trong thiết kế nội thất nhà ở. Tuy nhiên, mỗi một khu vực chức năng trong phòng khách. Đối với những không gian cần sự yên tĩnh để nghỉ ngơi hoặc tập trung cao độ như phòng ngủ và phòng làm việc tại nhà, bạn có thể cân nhắc sử dụng','blog7');
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
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
