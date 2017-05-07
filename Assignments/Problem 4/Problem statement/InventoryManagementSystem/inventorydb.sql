create database inventorydb;

use inventorydb;

--
-- Table structure for table `cheese_tbl`
--

DROP TABLE IF EXISTS `cheese_tbl`;

CREATE TABLE `cheese_tbl` (
  `id` int(10) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `mfg_date` date DEFAULT NULL,
  `UseBeforeInMonths` int(3) DEFAULT NULL,
  `cheeseType` varchar(20) DEFAULT NULL,
  `protein` float DEFAULT NULL,
  `vitaminB1` float DEFAULT NULL,
  `fat` float DEFAULT NULL
) 

INSERT INTO `cheese_tbl` VALUES 
(1001,'Mozzarella Cheese - Best for Pizza Preparation',200,200,'2014-01-09',12,'Mozzarella',30,0.57,0.33),
(1002,'Goat Cheese Low calories -Easy Spread',300,300,'2014-01-10',3,'Easy_Spread',0.33,33.99,0.57),
(1003,'Cottage Cheese High Protine and Energy',400,400,'2014-05-28',6,'Cottage',0.33,20.2,0.57);


--
-- Table structure for table `milk_tbl`
--

DROP TABLE IF EXISTS `milk_tbl`;

CREATE TABLE `milk_tbl` (
  `id` int(10) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `mfg_date` date DEFAULT NULL,
  `useBeforeInMonths` int(11) DEFAULT NULL,
  `fatRate` float DEFAULT NULL,
  `milkType` varchar(20) DEFAULT NULL  
) 


INSERT INTO `milk_tbl` VALUES 
(1005,'Low fat high protein cow milk',500,12.35,'2014-04-28',6,2,'CowMilk'),
(1004,'High fat buffalo milk',500,14.25,'2014-04-25',6,8,'BuffaloMilk'),
(1006,'Low fat separated buffalo milk',500,13.3,'2013-09-12',6,4,'BuffaloMilk');

--
-- Table structure for table `wheat_tbl`
--

DROP TABLE IF EXISTS `wheat_tbl`;

CREATE TABLE `wheat_tbl` (
  `id` int(10) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `mfg_date` date DEFAULT NULL,
  `useBeforeInMonths` int(11) DEFAULT NULL,
  `wheatType` varchar(20) DEFAULT NULL 
)

INSERT INTO `wheat_tbl` VALUES 
(1007,'Special Wheat from Punjab',1,32,'2014-01-20',24,'Punjab1002'),
(1008,'Cookies Special Wheat from field ',5,120,'2013-08-02',30,'NI2002'),
(1009,'Organic Products Wheat',5,130,'2013-09-04',28,'Khapali'),
(1010,'Lokwan -Mararastra Special Wheat ',1,25,'2013-10-13',36,'Locwan33');

