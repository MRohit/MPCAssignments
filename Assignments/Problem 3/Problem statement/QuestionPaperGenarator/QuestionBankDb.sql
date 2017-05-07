
drop database if exists questiondb;

create database questiondb;

use  questiondb;


--
-- Table structure for table `questionBank`
--

DROP TABLE IF EXISTS `questionBank`;

CREATE TABLE `questionBank` (
  `SrNo` int(3) PRIMARY KEY,
  `Question` varchar(100) DEFAULT NULL,
  `optionA` varchar(50) DEFAULT NULL,
  `optionB` varchar(50) DEFAULT NULL,
  `optionC` varchar(80) DEFAULT NULL,
  `OptionD` varchar(50) DEFAULT NULL,
  `CorrectAns` varchar(10) DEFAULT NULL,
  `Category` varchar(15) DEFAULT NULL,
  `Complexity` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Dumping data for table `questionBank`
--


INSERT INTO `questionBank` VALUES 
(1,'What is the satellite of the earth called?','sun','moon','mars','saturn','B','Geography','Simple'),
(2,'Which city is the capital of Maharashtra?','Pune','Nashik','Nagpur','Mumbai','D','History','Complex'),
(3,'When did the state of Gujrat come into existence?','1May 1961','1May 1960','1May 1965','1May 1970','B','History','Medium'),
(4,'In which state did Shivaji Maharaj establish the Swaraj?','Gujrat','Bihar','Maharashtra','Keral','C','History','Simple'),
(5,'Who was the king who ruled over Bijapur?','Nijamshah','Deshmukhs','Mugal Badshaha','Adilshah','D','History','Complex'),
(6,'Which period did Leonardo Da Vinci belong to?','Renaissance','Ancient','Modern','Medieval','A','GK','Simple'),
(7,'Name Sant Dnyaneshwar\'s sister.','Muktabai','Geetabai','Saibai','Jijabai','A','History','Complex'),
(8,'Which book did Dnyaneshwar write?','Geeta','Dasbodh','Leelachritra','Dnyaneshwari','D','GK','Medium'),
(9,'Who wrote Dasbodh?','Tukaram','Namdeo','Sopandeo','Sant Ramdas','D','History','Medium'),
(10,'Where was Gandhiji born?','Mumbai','Porbandar','Johannesberg','Baroda','B','History','Simple'),
(11,'What was the first name of the teacher of Shivaji Maharaj?','Vithoji','Dattoji','Dadoji','Balaji','C','History','Simple'),
(12,'What was the name of the state established by Bajirao\'s grandson?','Uttar Pradesh','Banda','Kanda','Pune','B','History','Medium'),
(13,'In which language did Dnyaneshwar write his book?','Hindi','Sanskrit','Marathi','Urdu','C','History','Simple'),
(14,'The water that gets stored under the ground is called------?','ground water','pond','reservoir','lake','A','Science','Complex'),
(15,'In the following, which is the hill-station in Sahyandri mountain?','Pal','Mahabaleshwar','Chikhaldara','Toranmal','B','Geography','Simple'),
(16,'From June to September, in which direction the mansoon winds blow over Maharashtra?','south-east','north-west','south-west','north-east','C','Geography','Medium'),
(17,'Which city in Maharashtra receives the highest rainfall?','Chikhaldara','Toranmal','Gadchiroli','Amboli','D','Geography','Simple'),
(18,'Which is the highest peak in Maharashtra?','Mahabaleshwar','Salher','Pachgani','Kalsubai','D','Geography','Complex'),
(19,'Which is the state tree of Maharashtra?','Banyan','Mango','Peepul','Jackfruit','B','GK','Medium'),
(20,'Which is the State animal of Maharashtra?','tiger','porcupine','shekaroo','fox','C','GK','Complex'),
(21,'India\'s first satellite is named after','Aryabhatta','Bhaskara II','Bhaskara I','Albert Einstein','A','GK','Simple'),
(22,'Galileo was an Italian astronomer who','developed the telescope','discovered four satellites of Jupiter','discovered that the movement of pendulum produces a regular time measurement','All of the above','D','GK','Simple'),
(23,'How many red blood cells does the bone marrow produce every second?','5 million','7 million','10 million','12 million','C','GK','Simple'),
(24,'How many red blood cells does the bone marrow produce every second?','5 million','7 million','10 million','12 million','C','Science','Medium'),
(25,'How many Layers of skin are there in human body?','5','7','10','12','B','Science','Medium'),
(26,'How many sence organs do we have?','5 ','7 ','10 ','12','A','Science','Simple'),
(27,'Thinking part of human body is called_____','head','brain','mind','eyes','B','Science','Simple');
