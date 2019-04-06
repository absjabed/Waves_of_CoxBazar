-- phpMyAdmin SQL Dump
-- version 4.0.10.14
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Jun 02, 2017 at 01:49 PM
-- Server version: 5.6.36-82.0-log
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `wavesofc_all_info_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `hotel_info_tbl`
--

CREATE TABLE IF NOT EXISTS `hotel_info_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(150) DEFAULT '-',
  `hotel_logo_name` varchar(150) DEFAULT '-',
  `hotel_img1_name` varchar(150) DEFAULT '-',
  `hotel_img2_name` varchar(150) DEFAULT '-',
  `hotel_img3_name` varchar(150) DEFAULT '-',
  `hotel_img4_name` varchar(150) DEFAULT '-',
  `hotel_img5_name` varchar(150) DEFAULT '-',
  `hotel_booking_link` varchar(500) DEFAULT '-',
  `hotel_email` varchar(500) DEFAULT '-',
  `hotel_phone_number` varchar(150) DEFAULT '-',
  `hotel_destination` varchar(500) DEFAULT '-',
  `special_suit` varchar(150) DEFAULT '-',
  `internet` varchar(150) DEFAULT '-',
  `parking` varchar(150) DEFAULT '-',
  `pets` varchar(150) DEFAULT '-',
  `shops` varchar(150) DEFAULT '-',
  `business_facility` varchar(150) DEFAULT '-',
  `swiming_pool` varchar(150) DEFAULT '-',
  `food_drink` varchar(150) DEFAULT '-',
  `transport` varchar(150) DEFAULT '-',
  `reception_service` varchar(150) DEFAULT '-',
  `cleaning_service` varchar(150) DEFAULT '-',
  `miscellaneous` varchar(150) DEFAULT '-',
  `status` varchar(10) DEFAULT '1',
  `any` varchar(10) DEFAULT '-',
  PRIMARY KEY (`id`),
  UNIQUE KEY `hotel_id` (`id`),
  UNIQUE KEY `hotel_id_2` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `hotel_info_tbl`
--

INSERT INTO `hotel_info_tbl` (`id`, `hotel_name`, `hotel_logo_name`, `hotel_img1_name`, `hotel_img2_name`, `hotel_img3_name`, `hotel_img4_name`, `hotel_img5_name`, `hotel_booking_link`, `hotel_email`, `hotel_phone_number`, `hotel_destination`, `special_suit`, `internet`, `parking`, `pets`, `shops`, `business_facility`, `swiming_pool`, `food_drink`, `transport`, `reception_service`, `cleaning_service`, `miscellaneous`, `status`, `any`) VALUES
(1, 'Long Beach Hotel Ltd.', 'http://wavesofcoxsbazar.com/images/hotel_images/longbeachlogo.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/longbeachimg1.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/longbeachimg2.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/longbeachimg3.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/longbeachimg4.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/longbeachimg5.jpg', 'http://www.longbeachhotelbd.com/coxsbazar', 'sales@longbeachhotelbd.com, reservation@longbeachhotelbd.com', 'Hotline:01730338907-8,+8809666772266,01730338905,01730338907', '14 Kalatoli, Hotel Motel Zone, Cox''s  Bazar, 3.6 Km 10min Distance by Car/CNG', 'Special Suite available here.', 'Free Internet Service, WiFi available.', 'Vehicle Parking available for guests.', 'No pets are allowed here.', 'Various shops are available here.', 'Business Facilities available.', 'Swimming pool available for hotel gusts.', 'Wide ranges of food & drinks available.', 'Transportation facility available here.', '24/7 Reception Service available.', 'Internal Cleaning Service available.', 'Many other amusement and entertainment arrangements available. ', '1', '-'),
(2, 'Hotel Shaibal', 'http://wavesofcoxsbazar.com/images/hotel_images/hotelshaiballogo.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/hotelshaibalimg1.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/hotelshaibalimg2.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/hotelshaibalimg3.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/hotelshaibalimg4.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/hotelshaibalimg5.jpg', 'http://www.parjatan.portal.gov.bd/', 'hotalshaibal@ymail.com\r\n', '0341-63274', '1 km of airport & 1.5 km of center (approximatly)', 'Special Suite available here.', 'Free Wi-Fi internet available here.', 'Vast & secure parking place.', 'No pets are allowed here.', 'No relative information found.', 'No relative information found.', 'Swimming pool available for hotel gusts.', 'Wide ranges of food & drinks available.', 'Transportation facility available here.', '24/7 Reception Service available.', 'Internal Cleaning Service available.', 'Exclusive beach, vast pond, cano boat etc.', '1', '-'),
(3, 'Ocean Paradise Hotel & Resort', 'http://wavesofcoxsbazar.com/images/hotel_images/oceanparadiselogo.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/oceanparadiseimg1.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/oceanparadiseimg2.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/oceanparadiseimg3.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/oceanparadiseimg4.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/oceanparadiseimg5.jpg', 'http://oceanparadisehotel.com', 'reservation@oceanparadisehotel.com\r\n', '0001938 846 761-5', '28-29 Hotel Motel zone, Kolatoli, Cox''s Bazar, 01 kilometer from center', 'Special Suite Available here.', 'Broadband connection in room,\r\nWi-Fi in public areas', 'Free vehicle parking available.', 'Pets are not allowed here.', 'Under construction', 'Business Facilities available.', 'Swimming pool available for hotel gusts.', 'Wide ranges of food & drinks available.', 'Payable Transportation facility available here.', 'Reception Service available.', 'Internal Cleaning Service available.(PAYABLE)', 'Many other amusement and entertainment arrangements available. (PAYABLE)', '1', NULL),
(4, 'Hotel Cox Today', 'http://wavesofcoxsbazar.com/images/hotel_images/coxtodaylogo.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/coxtodayimg1.JPG', 'http://wavesofcoxsbazar.com/images/hotel_images/coxtodayimg2.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/coxtodayimg3.JPG', 'http://wavesofcoxsbazar.com/images/hotel_images/coxtodayimg4.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/coxtodayimg5.jpg', 'http://hotelthecoxtoday.com', 'reservation@hotelthecoxtoday.com, info@hotelthecoxtoday.com', '+88-017 555 98 449, +88-017 555 98 450', 'Situated in Cox''s Bazar main town.', 'Special Suite Available here.', 'Free Wi-Fi internet available here.', 'Car parking available.', 'No pets are allowed here.', 'Various shops are available here.', 'Business Facilities available.', 'Swimming pool available for hotel gusts.', 'Wide ranges of food & drinks available.', 'Transportation facility available here.', '24/7 Reception Service available.', 'Internal Cleaning Service available.', 'Many other amusement and entertainment arrangements available. ', '1', NULL),
(5, 'NEESHORGO HOTEL & RESORT LTD.', 'http://wavesofcoxsbazar.com/images/hotel_images/neeshorgologo.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/neeshorgoimg1.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/neeshorgoimg2.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/neeshorgoimg3.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/neeshorgoimg4.jpg', 'http://wavesofcoxsbazar.com/images/hotel_images/neeshorgoimg5.jpg', '', 'neeshorgo@mail.com', '0341 64927,\r\n01617 83 44 00,\r\n01617 83 44 01', 'MARINE DRIVE ROAD, KOLATOLI, Cox''s Bazar-4701,5 KM FROM THE COX''S BAZAR AIRPORT', 'Special Suite Available here.', 'Free Wi-Fi internet available here.', 'Free vehicle parking available.', 'Pets are not allowed here.', 'Various shops are available here.', 'Business Facilities available.', 'Swimming pool available for hotel gusts.', 'Wide ranges of food & drinks available.', 'Transportation facility available here.', 'Reception Service available.', 'Internal Cleaning Service available.', 'Many other amusement and entertainment arrangements available. ', '1', '-'),
(6, 'Allegro Holiday Suits', '-', '-', '-', '-', '-', '-', '-', 'Allegro@gmail.com', '98765456987', 'Coxs Bazar, 2.4 km from centre', 'Special Suite Available here.', 'Free WiFi available', 'Free Private Parking', 'No pets are allowed here.', 'Shops, mini-market', 'Business Center facility available ', 'Swimming pool is not available here.', 'Restaurant, Room Service, Breakfast in the room. ', 'Transportation facility available here.', '24-hour front desk, Tour desk, Ticket Service', 'Laundry', 'Non-Smoking rooms, Sound proof room.', '1', '-');

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_tbl`
--

CREATE TABLE IF NOT EXISTS `restaurant_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resturent_name` varchar(150) NOT NULL,
  `image_link` varchar(250) NOT NULL,
  `restaurant_email` varchar(50) NOT NULL,
  `restaurant_phone` varchar(50) NOT NULL,
  `web_address` varchar(150) NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `transport_services_tbl`
--

CREATE TABLE IF NOT EXISTS `transport_services_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transport_name` varchar(150) NOT NULL,
  `destination` varchar(150) NOT NULL,
  `contact_person` varchar(50) NOT NULL,
  `phone_no` varchar(50) NOT NULL,
  `transport_type` varchar(50) NOT NULL,
  `image_link` varchar(150) NOT NULL,
  `web_link` varchar(150) NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Tuak_members_tbl`
--

CREATE TABLE IF NOT EXISTS `Tuak_members_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(250) COLLATE utf16_unicode_ci NOT NULL DEFAULT 'টুয়াক নামঃ',
  `owner_name` varchar(250) COLLATE utf16_unicode_ci NOT NULL DEFAULT 'মালিকের নামঃ',
  `owner_mobile` varchar(50) COLLATE utf16_unicode_ci NOT NULL DEFAULT 'মোবাইল নংঃ',
  `status` varchar(10) COLLATE utf16_unicode_ci NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `users_tbl`
--

CREATE TABLE IF NOT EXISTS `users_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `user_type` varchar(50) NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user_complain`
--

CREATE TABLE IF NOT EXISTS `user_complain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `complain_type` varchar(20) NOT NULL DEFAULT '-',
  `user_name` varchar(50) NOT NULL DEFAULT '-',
  `user_email` varchar(50) NOT NULL DEFAULT '-',
  `user_phone` varchar(25) NOT NULL DEFAULT '-',
  `complain_description` varchar(200) NOT NULL DEFAULT '-',
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `user_complain`
--

INSERT INTO `user_complain` (`id`, `complain_type`, `user_name`, `user_email`, `user_phone`, `complain_description`, `datetime`, `status`) VALUES
(1, 'Suggestion', 'jabed', 'jbd@mail.com', '01927363928', '', '2017-05-29 07:16:42', '1'),
(3, 'Complain', 'sazzad', 'sazzad@mail.com', '09764', '', '2017-05-29 07:33:37', '1'),
(4, 'Bug', 'parvez', 'parvez@mail.com', '01839363946', 'qwerty qwerty qwerty', '2017-05-29 07:46:27', '1'),
(5, 'Bug', 'parvez', 'parvez@mail.com', '01839363946', 'qwerty qwerty qwerty', '2017-05-29 07:48:01', '1');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
