-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2018 at 12:15 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `b25`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userID` int(4) NOT NULL,
  `userName` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userID`, `userName`, `password`, `status`) VALUES
(1101, 'MohaimenNoor', 'mohaimen', 'Admin'),
(1102, 'JamiJoy', 'jamijoy', 'Admin'),
(1103, 'EstiakAhmed', 'estiak', 'Admin'),
(1104, 'SamiraSobhan', 'samira', 'Admin'),
(1105, 'ArmaanChaklader', 'armaan', 'Admin'),
(2212, 'SajidRafi', 'rafi', 'Seller'),
(2243, 'FoysalNitu', 'nitu', 'Seller'),
(3001, 'fahim', 'fahim', 'Customer'),
(3002, 'adnan', 'adnan', 'Customer'),
(3006, 'emad', 'emadharun', 'Customer'),
(3343, 'MajnuMia', 'majnu', 'Customer'),
(3333, 'customer1', 'customer1', 'Customer'),
(1111, 'admin1', 'admin1', 'Admin'),
(2222, 'seller1', 'seller1', 'Seller'),
(7822, 'bob', 'bob', 'Seller'),
(7415, 'seller2', 'seller2', 'Seller');

-- --------------------------------------------------------

--
-- Table structure for table `order_table`
--

CREATE TABLE `order_table` (
  `orderNo` int(8) NOT NULL,
  `userID` int(4) NOT NULL,
  `pID` int(4) NOT NULL,
  `pQuantity` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_table`
--

INSERT INTO `order_table` (`orderNo`, `userID`, `pID`, `pQuantity`) VALUES
(34369167, 3006, 2006, 1),
(49791584, 3006, 4003, 1);

-- --------------------------------------------------------

--
-- Table structure for table `product_details`
--

CREATE TABLE `product_details` (
  `pID` int(4) NOT NULL,
  `pName` varchar(40) NOT NULL,
  `pQuantity` int(3) NOT NULL,
  `pPrice` double(7,2) NOT NULL,
  `pCategory` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_details`
--

INSERT INTO `product_details` (`pID`, `pName`, `pQuantity`, `pPrice`, `pCategory`) VALUES
(1002, 'Pran Mango Jam (500g)', 25, 120.00, 'beverage'),
(1003, 'Orange Jam', 10, 80.00, 'beverage'),
(1004, 'Pran Chocolate Juice', 37, 20.00, 'beverage'),
(1005, 'Pran Froto Juice', 20, 15.00, 'beverage'),
(1006, 'frutika Mango Juice ', 20, 15.00, 'beverage'),
(1007, 'Nescafe Coffee 500g', 20, 10.00, 'beverage'),
(1008, 'Arong Milk 1kg', 20, 55.00, 'beverage'),
(1009, 'Ispahani Mirjapur Tea Pack 50 pcs', 34, 110.00, 'beverage'),
(1010, '7up 1L', 15, 65.00, 'beverage'),
(1011, 'Coca Cola (1L)', 61, 2.00, 'beverage'),
(2001, 'Fullcopi', 25, 40.00, 'vegetable'),
(2002, 'Alu', 40, 18.00, 'vegetable'),
(2003, 'Sim', 10, 70.00, 'vegetable'),
(2004, 'Begun', 10, 40.00, 'vegetable'),
(2005, 'Borboti', 6, 80.00, 'vegetable'),
(2006, 'Motor', 4, 90.00, 'vegetable'),
(2007, 'Dherosh', 10, 47.00, 'vegetable'),
(2008, 'Potol', 13, 56.00, 'vegetable'),
(2009, 'Korolla', 20, 38.00, 'vegetable'),
(2010, 'Tomato', 20, 78.00, 'vegetable'),
(3001, 'Detol Soup', 15, 50.00, 'groceries'),
(3002, 'Maggi Noodles 8 Piece', 7, 65.00, 'groceries'),
(3003, 'Ahmed Baking Powder', 20, 35.00, 'groceries'),
(3004, 'Pran Sauce', 12, 95.00, 'groceries'),
(3005, 'Tir Moyda 1 Kg', 25, 60.00, 'groceries'),
(3006, 'Tir Ata 1Kg', 7, 70.00, 'groceries'),
(3007, 'Moshuri Dal', 15, 57.00, 'groceries'),
(3008, 'Ada', 10, 120.00, 'groceries'),
(3009, 'Rosun', 0, 150.00, 'groceries'),
(3010, 'Peyaj', 15, 40.00, 'groceries'),
(4001, 'katol fish', 1, 400.00, 'fish'),
(4002, 'Bowal fish', 2, 300.00, 'fish'),
(4003, 'Rui fish', 5, 200.00, 'fish'),
(4004, 'Ilish fish', 2, 900.00, 'fish'),
(4005, 'Tengra fish', 9, 130.00, 'fish'),
(4006, 'Rup chada fish', 6, 980.00, 'fish'),
(4007, 'Ayil fsh', 8, 380.00, 'fish'),
(4008, 'koral fish', 4, 490.00, 'fish'),
(4009, 'Chingri fish', 20, 400.00, 'fish'),
(4010, 'Telapia fish', 8, 120.00, 'fish'),
(5001, 'Shopon Soyabin Oil', 82, 120.00, 'oil'),
(5002, 'Rupchada Soyabin Oil', 30, 119.00, 'oil'),
(5003, 'Bashundhara Soyabin Oil', 34, 115.95, 'oil'),
(5004, 'Radhuni Khati Soyabin Oil', 24, 125.65, 'oil'),
(5005, 'Jester Olive Oil', 19, 1500.00, 'oil'),
(5006, 'Parasuite Coconut Oil', 231, 70.13, 'oil'),
(5007, 'Jaccabi Custurd Oil', 45, 800.00, 'oil'),
(5008, 'Sunflower Olive Oil', 122, 1600.82, 'oil'),
(5009, 'Rohomot Kalijira Oil', 233, 55.00, 'oil'),
(5010, 'Amond Custurd Oil', 22, 600.00, 'oil'),
(6001, 'Maxpro 5 mg', 109, 70.00, 'medicine'),
(6002, 'Napa 0.5 mg', 72, 20.00, 'medicine'),
(6003, 'Napa Extra', 14, 25.00, 'medicine'),
(6004, 'Napa Extend', 21, 30.00, 'medicine'),
(6005, 'Ace', 64, 15.00, 'medicine'),
(6006, 'Fexil 0.5 mg', 56, 65.00, 'medicine'),
(6007, 'Seclo 20 mg', 20, 50.50, 'medicine'),
(6008, 'Revetrol 100 mg', 50, 105.00, 'medicine'),
(6009, 'Alatrol 5 mg', 70, 12.00, 'medicine'),
(6010, 'Tip tin 10 mg', 38, 10.00, 'medicine');

-- --------------------------------------------------------

--
-- Table structure for table `user_accounts`
--

CREATE TABLE `user_accounts` (
  `userID` int(4) NOT NULL,
  `userName` varchar(30) NOT NULL,
  `name` varchar(60) NOT NULL,
  `password` varchar(30) NOT NULL,
  `balance` double(10,2) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `phone` int(11) NOT NULL,
  `address` text NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_accounts`
--

INSERT INTO `user_accounts` (`userID`, `userName`, `name`, `password`, `balance`, `gender`, `phone`, `address`, `status`) VALUES
(1101, 'MohaimenNoor', 'Mohaimen Bin Noor', 'mohaimen', 100000.00, 'Male', 1234567891, 'Road : 06,\r\nBuilding : 10,\r\nBashundhara R/A, Dhaka.', 'Admin'),
(1102, 'JamiJoy', 'Abdullah Al Jmai Joy', 'jamijoy', 3800.00, 'Male', 1779611966, 'Road : 02,\r\nBuilding : 248,\r\nBashundhara R/A, Dhaka.', 'Admin'),
(1103, 'EstiakAhmed', 'Md Estiak Ahmed', 'estiak', 48950.00, 'Male', 1766461990, '35/F/5/3, Road no: 2,\r Shyamoli, Dhaka.', 'Admin'),
(1104, 'SamiraSobhan', 'Samira Sobhan', 'samira', 49800.00, 'Female', 1742237347, 'Stuff Quarter,\r\nBuet Campus, Shahabag,\r\nDhaka.', 'Admin'),
(1105, 'ArmaanChaklader', 'Armaan Hossain Sanjeed Chaklader', 'armaan', 50000.00, 'Male', 1785973940, 'Taltola, Agargaon,\r\nShyamoli, Dhaka.', 'Admin'),
(1111, 'admin1', 'admin1', 'admin1', 9400.00, 'male', 1473690258, '17/C, Road: 3, Banani, Dhaka', 'Admin'),
(2212, 'SajidRafi', 'Al Sajid Rafi', 'rafi', 10000.00, 'Others', 1521435677, 'Road : 02,\r\nBuilding : 246,\r\nBashundhara R/A, Dhaka.', 'Seller'),
(2222, 'seller1', 'seller1', 'seller1', 5000.00, 'male', 1691234789, '14/3, Iqbal Road, Mohammadpur, Dhaka', 'Seller'),
(2243, 'FoysalNitu', 'Foysal Ahmed Nitu', 'nitu', 10000.00, 'Others', 1855570816, 'Mohakhali DOHS,\r\nMohakhali, Dhaka.\r\n', 'Seller'),
(3001, 'fahim', 'fahim ahmed', 'fahim', 3000.00, 'male', 1715913448, 'shamoli, dhaka', 'Customer'),
(3002, 'adnan', 'adnan Harun', 'adnan', 2810.00, 'male', 1740764336, '35/F, Shamoli, Dhaka', 'Customer'),
(3006, 'emad', 'Emad Harun', '0507622528', 3000.00, 'male', 1748523741, '35/F/5/3,\r Road no: 02, \r Shamoli,\r dhaka:1207', 'Customer'),
(3333, 'customer1', 'customer1', 'customer1', 2000.00, 'male', 1470258369, '15/A, \r Road no: 02, \r Gulsan: 02, \r Dhaka', 'Customer'),
(3343, 'MajnuMia', 'Mister Majnu Mia', 'majnu', 1500.00, 'Male', 1523111767, 'Kuril Chaurasta,\r\nDhaka, Bangladesh.', 'Customer'),
(7415, 'seller2', 'seller2', 'seller2', 0.00, 'male', 1715913444, 'Kuratoli, Bisshoroad, Dhaka', 'Seller'),
(7822, 'bob', 'BobTheBuilder', 'bob', 0.00, 'male', 1766461990, 'quarry', 'Seller');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `order_table`
--
ALTER TABLE `order_table`
  ADD PRIMARY KEY (`orderNo`);

--
-- Indexes for table `product_details`
--
ALTER TABLE `product_details`
  ADD PRIMARY KEY (`pID`);

--
-- Indexes for table `user_accounts`
--
ALTER TABLE `user_accounts`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `userName` (`userName`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
