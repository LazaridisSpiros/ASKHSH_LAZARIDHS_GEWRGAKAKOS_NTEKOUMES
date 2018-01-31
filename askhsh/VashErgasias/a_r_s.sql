-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 31, 2018 at 11:01 PM
-- Server version: 5.7.21-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `a_r_s`
--

-- --------------------------------------------------------

--
-- Table structure for table `aircraft`
--

CREATE TABLE `aircraft` (
  `aircraftTypeID` varchar(10) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `bseats` int(2) DEFAULT NULL,
  `xseats` int(3) DEFAULT NULL,
  `eseats` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aircraft`
--

INSERT INTO `aircraft` (`aircraftTypeID`, `description`, `bseats`, `xseats`, `eseats`) VALUES
('JA075', 'JAVA AIRBUS 075', 0, 50, 110),
('JA085', 'JAVA AIRBUS 085', 30, 75, 110),
('JA090', 'JAVA AIRBUS 090', 30, 150, 200),
('JA092', 'JAVA AIRBUS 092', 40, 80, 0),
('JA191', 'JAVA AIRBUS 191', 75, 200, 200),
('JA192', 'JAVA AIRBUS 192', 75, 200, 0),
('JA253', 'JAVA AIRBUS 253', 80, 80, 80),
('JA273', 'JAVA AIRBUS 273', 80, 55, 100),
('JA331', 'JAVA AIRBUS 331', 0, 0, 250),
('JA332', 'JAVA AIRBUS 332', 0, 0, 250),
('JA491', 'JAVA AIRBUS 491', 30, 150, 200),
('JA927', 'JAVA AIRBUS 927', 60, 75, 80),
('JA928', 'JAVA AIRBUS 928', 60, 130, 130),
('JA930', 'JAVA AIRBUS 930', 80, 150, 200),
('JA991', 'JAVA AIRBUS 991', 80, 0, 120),
('JA992', 'JAVA AIRBUS 992', 0, 100, 120);

-- --------------------------------------------------------

--
-- Table structure for table `dailycollections`
--

CREATE TABLE `dailycollections` (
  `pnrno` varchar(8) DEFAULT NULL,
  `trandate` date DEFAULT NULL,
  `trantype` varchar(15) DEFAULT NULL,
  `amount` decimal(9,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `flights`
--

CREATE TABLE `flights` (
  `flightno` varchar(6) NOT NULL,
  `deptime` varchar(5) DEFAULT NULL,
  `arrtime` varchar(5) DEFAULT NULL,
  `aircrafttypeID` varchar(6) DEFAULT NULL,
  `sectorID` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flights`
--

INSERT INTO `flights` (`flightno`, `deptime`, `arrtime`, `aircrafttypeID`, `sectorID`) VALUES
('FJA11', '18:00', NULL, 'JA075', 'ad-ko'),
('FJA12', '08:30', NULL, 'JA927', 'dl-ko'),
('FJA16', NULL, NULL, NULL, 'dl-ch'),
('FJA19', '17:55', NULL, 'JA991', 'dl-ad'),
('FJA22', NULL, NULL, NULL, 'ko-mu'),
('FJA23', '00:30', NULL, 'JA930', 'ko-ad'),
('FJA24', '21:40', NULL, 'JA991', 'ko-ad'),
('FJA26', NULL, NULL, NULL, 'ch-mu'),
('FJA27', NULL, NULL, NULL, 'ko-mu'),
('FJA31', '08:00', NULL, 'JA090', 'ad-dl'),
('FJA33', '15:00', NULL, 'JA192', 'ko-mu'),
('FJA40', '08:00', NULL, 'JA090', 'ad-dl'),
('FJA42', '07:35', NULL, 'JA332', 'dl-ko'),
('FJA43', NULL, NULL, NULL, 'dl-mu'),
('FJA45', NULL, NULL, NULL, 'dl-mu'),
('FJA47', NULL, NULL, NULL, 'mu-ch'),
('FJA55', '13:15', NULL, 'JA191', 'ko-dl'),
('FJA58', '20:00', NULL, 'JA253', 'ko-dl'),
('FJA67', '09:00', NULL, 'JA491', 'dl-ko'),
('FJA71', NULL, NULL, NULL, 'dl-mu'),
('FJA78', '21:30', NULL, 'JA273', 'dl-ad'),
('FJA81', NULL, NULL, NULL, 'dl-ad'),
('FJA87', '10:00', NULL, 'JA092', 'ad-dl'),
('FJA88', NULL, NULL, NULL, 'dl-ad'),
('FJA91', '00:25', NULL, 'JA330', 'dl-ko'),
('FJA95', NULL, NULL, NULL, 'dl-ad'),
('FJA98', '13:00', NULL, 'JA085', 'ad-ko'),
('FJA99', '12:30', NULL, 'JA992', 'ko-ad');

-- --------------------------------------------------------

--
-- Table structure for table `passengers`
--

CREATE TABLE `passengers` (
  `pnrno` varchar(8) NOT NULL,
  `flightno` varchar(5) DEFAULT NULL,
  `traveldate` date DEFAULT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `class` varchar(15) DEFAULT NULL,
  `mealpref` varchar(15) DEFAULT NULL,
  `noa` int(2) DEFAULT '1',
  `noc` int(2) NOT NULL DEFAULT '0',
  `status` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `scheduledflights`
--

CREATE TABLE `scheduledflights` (
  `scheduleID` varchar(5) NOT NULL,
  `flightno` varchar(5) DEFAULT NULL,
  `flightdate` date DEFAULT NULL,
  `bcsavailable` int(2) DEFAULT NULL,
  `xcsavailable` int(3) DEFAULT NULL,
  `ecsavailable` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `scheduledflights`
--

INSERT INTO `scheduledflights` (`scheduleID`, `flightno`, `flightdate`, `bcsavailable`, `xcsavailable`, `ecsavailable`) VALUES
('00001', 'FJA11', '2016-01-18', 0, 50, 110),
('00002', 'FJA12', '2016-01-18', 60, 75, 80),
('00003', 'FJA24', '2016-01-18', 80, 150, 200),
('00004', 'FJA19', '2016-01-18', 80, 0, 120),
('00005', 'FJA31', '2016-01-18', 30, 150, 200),
('00006', 'FJA33', '2016-01-18', 75, 200, 0),
('00007', 'FJA40', '2016-01-18', 30, 150, 200),
('00008', 'FJA42', '2016-01-18', 0, 0, 250),
('00009', 'FJA55', '2016-01-18', 75, 200, 200),
('00010', 'FJA58', '2016-01-18', 80, 80, 80),
('00011', 'FJA67', '2016-01-18', 30, 150, 200),
('00012', 'FJA78', '2016-01-18', 80, 55, 100),
('00013', 'FJA87', '2016-01-18', 40, 80, 0),
('00014', 'FJA91', '2016-01-18', 0, 0, 250),
('00015', 'FJA98', '2016-01-18', 30, 75, 110),
('00016', 'FJA99', '2016-01-18', 0, 100, 120);

-- --------------------------------------------------------

--
-- Table structure for table `sector`
--

CREATE TABLE `sector` (
  `sectorID` varchar(5) NOT NULL,
  `source` varchar(25) DEFAULT NULL,
  `destination` varchar(25) NOT NULL,
  `weekday1` varchar(4) DEFAULT NULL,
  `weekday2` varchar(4) DEFAULT NULL,
  `weekday3` varchar(4) DEFAULT NULL,
  `bfare` decimal(8,2) DEFAULT '0.00',
  `xfare` decimal(8,2) DEFAULT '0.00',
  `efare` decimal(8,2) DEFAULT '0.00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sector`
--

INSERT INTO `sector` (`sectorID`, `source`, `destination`, `weekday1`, `weekday2`, `weekday3`, `bfare`, `xfare`, `efare`) VALUES
('ad-ch', 'Athens', 'Thesaloniki', 'WED', 'MON', 'NULL', '9565.00', '7500.00', '0.00'),
('ad-dl', 'Athens', 'Giannena', 'TUE', 'TUE', 'THR', '6330.00', '0.00', '5664.00'),
('ad-ko', 'Athens', 'Kalamaria', 'MON', 'TUE', 'WED', '4290.00', '3560.00', '2563.00'),
('ad-mu', 'Athens', 'Mani', 'SUN', 'SAT', 'NULL', '0.00', '5700.00', '4500.00'),
('ch-ad', 'Thesaloniki', 'LamiaDomoko', 'FRI', 'SAT', 'NULL', '8500.00', '6500.00', '4500.00'),
('ch-dl', 'Thesaloniki', 'LamiaDomoko', 'FRI', 'WED', 'MON', '10253.00', '8954.00', '6789.00'),
('ch-ko', 'Thesaloniki', 'Mani', 'THR', 'TUE', 'SAT', '12500.00', '9800.00', '6555.00'),
('ch-kr', 'Thesaloniki', 'Athens', 'SAT', 'FRI', 'SUN', '5600.00', '4400.00', '3200.00'),
('ch-mu', 'Thesaloniki', 'Mani', 'MON', 'TUE', 'WED', '15500.00', '11550.00', '9540.00'),
('dl-ad', 'Giannena', 'Thesaloniki', 'TUE', 'WED', 'THR', '0.00', '7500.00', '4660.00'),
('dl-ch', 'Giannena', 'Mani', 'FRI', 'MON', 'WED', '0.00', '8990.00', '6450.00'),
('dl-ko', 'Giannena', 'Thesaloniki', 'SUN', 'TUE', 'WED', '11800.00', '9900.00', '5630.00'),
('dl-mu', 'Giannena', 'Thesaloniki', 'TUE', 'SAT', 'NULL', '5800.00', '4200.00', '3200.00'),
('go-ko', 'Iraklio', 'Giannena', 'MON', 'NULL', 'NULL', '10000.00', '8700.00', '0.00'),
('ko-ad', 'Kalamaria', 'LamiaDomoko', 'SUN', 'MON', 'MON', '8600.00', '0.00', '5750.00'),
('ko-ch', 'Kalamaria', 'Giannena', 'TUE', 'MON', 'WED', '9450.00', '0.00', '6450.00'),
('ko-dl', 'Kalamaria', 'Iraklio', 'MON', 'TUE', 'NULL', '15550.00', '12300.00', '8600.00'),
('ko-go', 'Kalamaria', 'Iraklio', 'WED', 'NULL', 'NULL', '12000.00', '10000.00', '0.00'),
('ko-mu', 'Kalamaria', 'Mani', 'TUE', 'SAT', 'FRI', '12500.00', '11000.00', '10000.00'),
('kr-ch', 'Kalamaria', 'Mani', 'WED', 'THR', 'NULL', '6000.00', '5000.00', '4000.00'),
('mu-ad', 'Mani', 'LamiaDomoko', 'THR', 'FRI', 'SAT', '6262.00', '5120.00', '0.00'),
('mu-ch', 'LamiaDomoko', 'Iraklio', 'FRI', 'SAT', 'SUN', '7990.00', '6375.00', '4550.00'),
('mu-dl', 'LamiaDomoko', 'Athens', 'SAT', 'TUE', 'THR', '16000.00', '12500.00', '10500.00'),
('mu-ko', 'LamiaDomoko', 'Athens', 'SUN', 'SAT', 'FRI', '0.00', '0.00', '6800.00');

-- --------------------------------------------------------

--
-- Table structure for table `user_profile`
--

CREATE TABLE `user_profile` (
  `userid` int(10) NOT NULL,
  `firstname` text NOT NULL,
  `lastname` text NOT NULL,
  `contactno` bigint(10) NOT NULL,
  `dob` date NOT NULL,
  `address` text NOT NULL,
  `city` text NOT NULL,
  `state` text NOT NULL,
  `country` text NOT NULL,
  `emailid` text NOT NULL,
  `password` text NOT NULL,
  `usertype` text NOT NULL,
  `username` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_profile`
--

INSERT INTO `user_profile` (`userid`, `firstname`, `lastname`, `contactno`, `dob`, `address`, `city`, `state`, `country`, `emailid`, `password`, `usertype`, `username`) VALUES
(1, 'Euterpi', 'Xalimourda', 2107483647, '1977-08-05', 'Tzitzifias 22', 'Katafugio', 'Zvounia', 'Greece', 'papadia22@gmail.com', 'admin', 'ADMIN', 'admin'),
(2, 'Emanouil', 'Mpasilaris', 6456998235, '1992-07-27', 'Prionokordelas 12', 'Kilkis', 'Patlia', 'Greece', 'emanouil_sexokounelos@gmail.com', 'manager', 'MANAGER', 'manager1'),
(3, 'Oisofagos', 'Larigkios', 6452633200, '1992-03-25', 'GavGav 3Alfa', 'Kastelorizo', 'Kouroumplia', 'Greece', 'gloupgloup@yahoo.co.in', 'manager', 'MANAGER', 'manager2'),
(4, 'Tasos', 'Protaprilias', 6656923534, '1980-07-07', 'Podovolitou 32misi', 'Vrusoula', 'Gournokoumaso', 'Greece', 'leo_psemata1980@yahoo.com', 'operator', 'OPERATOR', 'operator1'),
(5, 'Nikos', 'Korompos', 6632126377, '1983-10-25', 'Karotserh 12', 'Eratinh', 'Akaitsamalois', 'Greece', 'einai_kinito@yahoo.com', 'operator', 'OPERATOR', 'operator2'),
(6, 'Efi', 'Thodi', 6953382350, '1982-10-17', 'Kaprolaxanou 6', 'Amorani', 'Houston', 'Greece', 'kontoulalemonia1982@yahoo.co.in.', 'operator', 'OPERATOR', 'operator3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aircraft`
--
ALTER TABLE `aircraft`
  ADD PRIMARY KEY (`aircraftTypeID`);

--
-- Indexes for table `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`flightno`);

--
-- Indexes for table `passengers`
--
ALTER TABLE `passengers`
  ADD PRIMARY KEY (`pnrno`);

--
-- Indexes for table `scheduledflights`
--
ALTER TABLE `scheduledflights`
  ADD PRIMARY KEY (`scheduleID`);

--
-- Indexes for table `sector`
--
ALTER TABLE `sector`
  ADD PRIMARY KEY (`sectorID`);

--
-- Indexes for table `user_profile`
--
ALTER TABLE `user_profile`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_profile`
--
ALTER TABLE `user_profile`
  MODIFY `userid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
