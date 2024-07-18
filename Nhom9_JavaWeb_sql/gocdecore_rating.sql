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
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating` (
  `rating_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `light_id` int DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `user_phone` int DEFAULT NULL,
  `vote` int DEFAULT NULL,
  `rating_description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`rating_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,98,31,'Nguyễn Linh',982768674,3,'Sản phẩm khá đẹp, tuy nhiên so vối mình thì giá cả có hơi cao'),(3,23,45,'Hanh Nguyen',890938671,2,'Sản phẩm bị hư hỏng trong quá trình vận chuyển'),(4,21,3,'TrisNguyen',848792874,1,'Sản phẩm bị lỗi 1 số chỗ. Giá cao mà so với chất lượng khiến mình thật thất vọng'),(5,43,24,'Nguyễn Bảo Bình',472859937,3,'Cũng được.'),(6,45,2,'Hoàng Ngọc Bảo',246862964,5,'Mình mua đèn đợt sale mà đẹp quá trời luôn, chồng mình cứ khen mãi, đáng mua nhé cả nhà.'),(7,543,6,'Mộc Lê',847262937,4,'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'),(8,324,43,'An Nguyễn',247297523,4,'Giá cả có hơi nhỉnh chút với mặt bằng nhưng đẹp thật.'),(9,24,2,'Thế Anh',936472527,3,'cho 3 sao vì giá khá cao, nhưng công nhận 1 điều đèn khá hợp vibe với gian phòng của mình'),(10,23,41,'Việt Hà Bùi',942864254,5,'yehhh, trời ơi là trời, đèn đẹp hết xảy luôn. Mình sẽ mua thêm vài cái nữa.'),(11,5,23,'Linh Đức',924582548,3,'Đèn cũng tạm được, giá hơi cao'),(12,98,11,'Nguyễn Thị Anh',937452874,3,'Đèn đẹp, mình mua săn sale giá rẻ mà dùng được 1 tháng đã cháy bóng, lạ ghê'),(13,45,3,'Đào Thế Duy',974628548,2,'Đèn bị xước. Chắc do quá trình vận chuyển, mong cửa hàng có cách giải quyế'),(14,2,22,'Minh Trần',386946896,4,'Đèn đẹp'),(15,65,16,'Lê Bình',385646078,5,'Đèn rất đẹp, tôi rất thích'),(16,47,9,'Nguyễn Bảo Ngọc',399648697,3,'Mong chờ lắm, nhưng có vẻ đèn không như kì vọng của tôi'),(17,77201,40,'four',981468671,3,'Mình đã mua hầng và mẹ mình khen lắm!!!'),(18,655147,4,'Hòa',123450867,4,'Tuyệt quá shop ơi!!!'),(19,107705,43,'Nguyễn Mỹ Hạnh',98146632,3,'Sản phẩm nhà GoscDecor tôi rất ưng ý về mẫu mã và cả chất lượng nữa'),(20,766173,10,'Hanh Nguyen',981468671,4,'Đèn rất tuyệt!'),(21,928514,27,'Hanh Nguyen',981468671,5,'Đèn rất tuyệt!'),(22,214140,3,'four',981468671,4,'ưqdqw'),(23,121616,38,'Hanh Nguyen',981468671,4,'Đèn rất đẹp, rất sang trọng và phù hợp với nhu cầu của mình.'),(24,782703,3,'Mung',1234567890,5,'Tuyệt lắm shop ạ!'),(25,825272,2,'Mung',981468671,4,'Đèn rất đẹp, sang trọng và xứng với giá tiền!!! Tôi sẽ mua thêm'),(26,439687,6,'Mung',981468671,4,'Đèn rất đẹp!!!');
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-28  1:44:54
