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
-- Table structure for table `light`
--

DROP TABLE IF EXISTS `light`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `light` (
  `light_id` int NOT NULL AUTO_INCREMENT,
  `light_name` varchar(200) NOT NULL,
  `light_price` int NOT NULL,
  `light_material` varchar(200) DEFAULT NULL,
  `light_color` varchar(100) DEFAULT NULL,
  `light_size` varchar(100) NOT NULL,
  `light_state` varchar(100) NOT NULL,
  `light_img` text,
  `category_id` int DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `sales_count` int DEFAULT NULL,
  `light_revenue` double GENERATED ALWAYS AS ((`light_price` * `sales_count`)) VIRTUAL,
  `light_percen` int DEFAULT NULL,
  `light_pricelegal` int GENERATED ALWAYS AS (((`light_price` / (100 - `light_percen`)) * 100)) STORED,
  PRIMARY KEY (`light_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `light_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `light`
--

LOCK TABLES `light` WRITE;
/*!40000 ALTER TABLE `light` DISABLE KEYS */;
INSERT INTO `light` (`light_id`, `light_name`, `light_price`, `light_material`, `light_color`, `light_size`, `light_state`, `light_img`, `category_id`, `rating`, `sales_count`, `light_percen`) VALUES (1,'Đèn sàn phòng khách kiểu dáng uốn lượn',1725000,'Nhôm, Sillicon, Thép không gỉ','Màu đen','28x133cm','Còn hàng','1_1',1,5,233,0),(2,'Đèn sàn phòng ngủ hai đầu sáng tạo',1398000,'Acrylic, Thép không gỉ','Màu đen','23*165cm','Còn hàng','1_2',1,4,44,10),(3,'Đèn sàn trang trí phòng khách sáng tạo kiểu Ý',15943000,'Thép không gỉ','Màu trắng, Màu cam đất','22*165cm','Còn hàng','1_3',1,3,55,0),(4,'Đèn sàn vòng cung sang trọng hiện đại',3549000,'Acrylic, Thép không gỉ','Màu nâu, Màu trắng','28*165cm','Còn hàng','1_4',1,5,65,10),(5,'Đèn sàn trang trí nghệ thuật nữ thần nhảy múa',20748000,'Nhựa, Thuỷ tinh','Màu trắng','78*179cm','Còn hàng','1_5',1,5,62,0),(6,'Đèn sàn thép không gỉ phòng khách tối giản',11013000,'Thép không gỉ, Vải chịu nhiệt','Màu bạc','35x170cm','Còn hàng','1_6',1,4,763,0),(7,'Đèn sàn xếp ly thân lượn sóng sáng tạo',983000,'Thép không gỉ','Màu trắng, Màu vàng, Màu xanh','25*155cm','Còn hàng','1_7',1,3,735,0),(8,'Đèn sàn decor phòng khách bằng vải Wabi-sabi',5855000,'Thép cao cấp, Vải chịu nhiệt','Màu trắng','40x160cm, 40x110cm','Còn hàng','1_8',1,3,85,0),(9,'Đèn cây đứng trang trí góc sofa sáng tạo',5415000,'Thép cao cấp, Vải chịu nhiệt','Màu trắng, Màu vàng','30x113cm, 30x143cm, 30x173cm','Còn hàng','1_9',1,3,385,0),(10,'Đèn cây đứng trang trí góc sofa ba chân độc đáo',6880000,'Thép không gỉ','Màu trắng','60x150cm','Còn hàng','1_10',1,5,85,0),(11,'Đèn sàn hoa sen trang trí phong cảnh lãng mạn',2600000,'Nhựa PC, Sắt nghệ thuật','Màu trắng, Màu xanh','25x180cm','Còn hàng','1_11',1,4,836,0),(12,'Đèn sàn kiểu Mỹ điều chỉnh chiều cao tiện lợi',4387000,'Thép cao cấp, Vải chịu nhiệt','Màu vàng','40x150cm','Còn hàng','1_12',1,3,634,0),(13,'Đèn thả bằng gỗ phong cách Wabi-sabi độc đáo',2315000,'Đồng thau, Gỗ','Màu gỗ nhạt, Màu gỗ óc chó','43x28cm','Còn hàng','2_1',2,2,265,0),(14,'Đèn thả trần bằng đá hình tròn 2 lớp độc đáo',2160000,'Acrylic, Đá tự nhiên','Màu đen','43x28cm','Còn hàng','2_2',2,4,265,15),(15,'Đèn chùm pha lê nhà hàng đàn bướm bay lượn',25990000,'Pha lê, Thép không gỉ','Màu trắng','120x80cm, 80x80cm','Còn hàng','2_3',2,5,251,0),(16,'Đèn thả trần bằng giấy đám mây bồng bềnh',1290000,'Sắt, Giấy nghệ thuật','Màu trắng','43*28cm, 50*40cm','Còn hàng','2_4',2,3,245,0),(17,'Đèn thả trần hình nón dây gai dệt thủ công',4240000,'Sắt nghệ thuật, Dây gai','Màu nâu óc chó','43*28cm, 50*40cm','Còn hàng','2_5',2,2,53,0),(18,'Đèn thả thủy tinh phòng ăn hiện đại sang trọng',2175000,'Gỗ, Thép cao cấp, Thủy tinh cao cấp','Màu trắng','30*20cm, 30*25cm','Còn hàng','2_6',2,3,645,0),(19,'Đèn lồng mây tre thả trần hình cá mộc mạc',9479000,'Sợi mây tre','Màu óc chó','30*100cm, 30*120cm, 45*200cm','Còn hàng','2_7',2,3,452,0),(20,'Đèn thả trần decor kiểu dáng tảng đá ấn tượng',5220000,'Nhựa tổng hợp cao cấp','Màu đen, Màu đồng đỏ, Màu trắng, Màu xám đậm ','30*20cm, 30*25cm','Còn hàng','2_8',2,4,65,0),(21,'Đèn thả bàn ăn hiện đại Bắc Âu',873000,'Acrylic','Màu đen, Màu trắng','30*20cm, 30*25cm','Còn hàng','2_9',2,5,64,15),(22,'Đèn thả trần sắt nghệ thuật kiểu dáng tinh tế',1150000,'Sắt nghệ thuật, Vải chịu nhiệt','Màu đen, Màu trắng','33x48cm','Còn hàng','2_10',2,3,87,0),(23,'Đèn lồng vải phong cách Wabi-sabi bình dị',2230000,'Thép cao cấp, Vải chịu nhiệt','Màu đen, Màu trắng','33x48cm','Còn hàng','2_11',2,4,254,0),(24,'Đèn thả trần mây tre decor nhà hàng nghệ thuật',840000,'Sợi mây tre','Màu nâu, Màu gỗ nhạt','30*100cm, 30*120cm, 45*200cm','Còn hàng','2_12',2,5,159,0),(25,'Đèn bàn vải hoa trang trí phòng kiểu retro',1400000,'Sắt nghệ thuật, Vải chịu nhiệt','Đa màu, Màu trắng','380x455mm, 400x450mm','Còn hàng','3_1',3,3,535,0),(26,'Đèn để bàn bằng gỗ robot sáng tạo',798000,'Gỗ sồi, Vải cotton, Vải lanh','Màu be, Màu trắng','22*44cm','Còn hàng','3_2',3,3,154,20),(27,'Đèn để bàn đầu giường ngủ hiện đại tối giản',1490000,'Sắt nghệ thuật, Vải chịu nhiệt','Màu be','30×53.5cm','Còn hàng','3_3',3,4,626,0),(28,'Đèn bàn lông vũ decor sang trọng hiện đại',973000,'Gốm sứ, Thép cao cấp','Màu hồng, Màu trắng','30*37cm','Còn hàng','3_4',3,5,543,30),(29,'Đèn để bàn bằng đồng thuỷ tinh độc đáo',1092000,'Đồng, Thuỷ tinh','Màu đồng, MÀu trắng','30*37cm','Còn hàng','3_5',3,4,64,0),(30,'Đèn bàn xi măng đầu giường ngủ sáng tạo',2939000,'Cement (xi măng), Composite, Vải lanh','Màu trắng, Màu xám','38.5x72cm','Còn hàng','3_6',3,3,345,25),(31,'Đèn để bàn mây tre đan phong cách Zen bình dị',760000,'Tre cao cấp','Màu be','20x23cm, 23x30cm, 23x38cm','Còn hàng','3_7',3,3,56,0),(32,'Đèn bàn bằng đồng retro kiểu Pháp',2950000,'Đồng thau, Thuỷ tinh','Màu trắng','30x48cm','Còn hàng','3_8',3,5,652,0),(33,'Đèn bàn thân xoắn nghệ thuật bằng đồng',2490000,'Đá cẩm thạch, Đồng thau','Màu đen','17x31cm','Còn hàng','3_9',3,4,566,0),(34,'Đèn để bàn bằng đồng nhánh cây nghệ thuật',4790000,'Đồng thau, Vải lanh','Màu vàng','30x55cm','Còn hàng','3_10',3,5,647,0),(35,'Đèn bàn phòng ngủ bằng đồng gốm cổ điển',3300000,'Đồng thau, Gốm sứ, Vải chịu nhiệt','Màu trắng, Màu xanh','40*65cm','Còn hàng','3_11',3,4,462,0),(36,'Đèn bàn trang trí bằng gốm sứ',1480000,'Gốm sứ, Thép không gỉ, Vải chịu nhiệt','Màu be, Màu hồng, Màu trắng','30*46cm, 35*52cm','Còn hàng','3_12',3,3,647,40),(37,'Đèn tường xi măng chiếu sáng ngoại thất',2820000,'Cement (xi măng)','Màu trắng, Màu xám','24×6.5cm, 38x7cm','Còn hàng','4_1',4,5,76,5),(38,'Đèn tường công tắc kéo Minimalist mộc mạc',460000,'Gỗ, Thép cao cấp, Thuỷ tinh','Màu trắng, Màu xám','24×6.5cm, 38x7cm','Còn hàng','4_2',4,4,73,0),(39,'Đèn tường phòng khách hình giọt nước độc đáo',570000,'Nhựa PE','Màu trắng','22.5x30cm, 9.5x24cm','Còn hàng','4_3',4,3,46,0),(40,'Đèn gắn tường thủy tinh đui gỗ Wabi-sabi',870000,'Gỗ, Thép cao cấp, Thuỷ tinh','Màu gỗ nhạt, Màu gỗ óc chó','24×6.5cm, 38x7cm','Còn hàng','4_4',4,4,244,0),(41,'Đèn tường gỗ trang trí hành lang độc đáo',1730000,'Gỗ, Sắt nghệ thuật, Dây gai','Màu nâu','13x18cm, 13x20cm','Còn hàng','4_5',4,5,544,0),(42,'Đèn tường năng lượng mặt trời decor sân vườn',2300000,'Acrylic, Nhôm','Màu đen','24.9×33.2.cm','Còn hàng','4_6',4,3,522,5),(43,'Đèn gắn tường cổ điển Địa Trung Hải tối giản',765000,'Thép cao cấp, Vải chịu nhiệt','Màu đen, Màu trắng','14x34cm','Còn hàng','4_7',4,3,546,0),(44,'Đèn tường ngoài trời trang trí lối đi kiểu Mỹ',2980000,'Nhôm, Thuỷ tinh','Màu đen, Màu đồng Bronze, Màu nâu ','33x58cm','Còn hàng','4_8',4,4,645,0),(45,'Đèn tường hình cô gái nghệ thuật sáng tạo',1260000,'Acrylic, Sắt nghệ thuật','Màu trắng','28.5*60cm','Còn hàng','4_9',4,5,652,15),(46,'Đèn tường trong suốt trang trí mái hiên',3590000,'Acrylic, Nhôm','Màu đen, Màu nâu, Màu vàng','26.5×7.5×34.5cm','Còn hàng','4_10',4,3,646,10),(47,'Đèn tường năng lượng mặt trời chiếu sáng lối đi',980000,'Acrylic, Nhôm','Màu đen','24x14cm','Còn hàng','4_11',4,4,341,5),(48,'Đèn tường hình tròn chạm khắc tinh tế',1350000,'Nhựa ABS','Màu trắng','24x14cm','Còn hàng','4_12',4,5,245,0),(91,'four',122434,'Titaniumfake','Màu bạc','12*132cm','còn hàng','1_3',NULL,NULL,NULL,10);
/*!40000 ALTER TABLE `light` ENABLE KEYS */;
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
