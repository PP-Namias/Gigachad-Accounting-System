-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2024 at 08:10 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gigachadaccountingsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `question` varchar(50) NOT NULL,
  `answer` varchar(40) NOT NULL,
  `date` date NOT NULL,
  `update_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `email`, `username`, `password`, `question`, `answer`, `date`, `update_date`) VALUES
(1, 'pp.namias@gmail.com', 'PP Namias', 'admin', 'What is your favorite color?', 'Pink', '2024-08-20', '2024-08-20'),
(2, 'marky@gmail.com', 'Marky', 'admin123', 'What is your most favorite sport?', 'backetBall', '2024-08-20', '2024-08-20'),
(3, 'aya.ay@gmail.com', 'Aya Ay', 'admin123', 'What is the name of your pet?', 'Bunny', '2024-08-20', '2024-08-20'),
(4, 'maki@gmail.com', 'Maki', 'admin123', 'What is the name of your pet?', 'chuwawa', '2024-08-20', '2024-08-20'),
(5, 'Junfrance@gmail.com', 'Junfrance', 'admin123', 'What is your favorite food?', 'Ado', '2024-08-20', '2024-08-20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
