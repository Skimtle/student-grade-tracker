-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2026 at 02:16 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_tracker_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `admin_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`admin_id`, `username`, `password`, `full_name`, `created_at`) VALUES
(1, 'adminone', 'admingaming', 'Andrew Andrew', '2026-04-27 04:23:28'),
(67, 'adminsixseven', 'password', 'Pearl Jam', '2026-05-07 12:49:17');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_faculty`
--

CREATE TABLE `tbl_faculty` (
  `faculty_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_faculty`
--

INSERT INTO `tbl_faculty` (`faculty_id`, `username`, `password`, `full_name`, `created_at`) VALUES
(1, 'andrew', 'admin123', 'Andrew Valencia', '2026-04-17 01:24:50'),
(3, 'jc', '123', 'jillian carl', '2026-05-07 03:49:48'),
(4, 'youtube', '123', 'ebido', '2026-05-07 04:36:03'),
(5, 'teacher', '123', 'teacher', '2026-05-07 04:48:05');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_grades`
--

CREATE TABLE `tbl_grades` (
  `grade_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `grade` decimal(5,2) NOT NULL,
  `date_recorded` timestamp NOT NULL DEFAULT current_timestamp(),
  `faculty_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_grades`
--

INSERT INTO `tbl_grades` (`grade_id`, `student_id`, `subject_id`, `grade`, `date_recorded`, `faculty_id`) VALUES
(1, 3, 2, 99.00, '2026-05-09 07:04:00', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_programs`
--

CREATE TABLE `tbl_programs` (
  `program_id` int(11) NOT NULL,
  `program_code` varchar(20) NOT NULL,
  `program_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_programs`
--

INSERT INTO `tbl_programs` (`program_id`, `program_code`, `program_name`) VALUES
(1, 'BSCS', 'Computer Science'),
(3, 'BSN', 'Nursing');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_students`
--

CREATE TABLE `tbl_students` (
  `student_id` int(11) NOT NULL,
  `student_number` varchar(20) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `year_level` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `program_id` int(11) DEFAULT NULL,
  `faculty_id` int(11) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_students`
--

INSERT INTO `tbl_students` (`student_id`, `student_number`, `first_name`, `last_name`, `year_level`, `created_at`, `program_id`, `faculty_id`, `admin_id`) VALUES
(3, '2026-1054', 'Ricardo', 'Milos', 2, '2026-05-05 12:44:22', 1, 1, NULL),
(4, '2026-7170', 'Andrew', 'Valencia', 1, '2026-05-05 12:45:16', 1, 1, NULL),
(5, '2026-8587', 'Jillian Carl', 'Pascasio', 1, '2026-05-06 01:54:13', 1, 1, NULL),
(11, '2026-3722', 'andrew', 'esguerra', 1, '2026-05-07 04:03:14', 1, 3, NULL),
(16, '2026-8398', 'test', 'tester', 1, '2026-05-07 04:35:10', 1, 3, NULL),
(18, '2026-2364', 'jay', 'de luna', 4, '2026-05-07 04:37:19', 1, 4, NULL),
(19, '2026-9213', 'jhustine', 'llarves', 4, '2026-05-07 04:47:20', 1, 1, NULL),
(20, '2026-6960', 'Lhanz', 'Xavier', 1, '2026-05-07 05:03:40', 1, 3, NULL),
(21, '2026-3080', 'mathew', 'del rosario', 2, '2026-05-07 05:19:34', 1, 1, NULL),
(22, '2026-3271', 'Andrew', 'Valencia', 4, '2026-05-07 05:29:46', 1, 1, NULL),
(23, '2026-9356', 'Emillio', 'Perez', 1, '2026-05-07 05:38:49', 1, 1, NULL),
(24, '2026-1490', 'Cravennn', 'de castro', 3, '2026-05-07 12:48:21', 1, 4, NULL),
(26, '2026-7685', 'Jose', 'Rizal', 2, '2026-05-07 13:49:10', 1, NULL, 67),
(27, '2026-3964', 'Richelle', 'Sabando', 2, '2026-05-07 13:49:46', 1, 3, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_subjects`
--

CREATE TABLE `tbl_subjects` (
  `subject_id` int(11) NOT NULL,
  `subject_code` varchar(20) NOT NULL,
  `subject_name` varchar(100) NOT NULL,
  `faculty_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_subjects`
--

INSERT INTO `tbl_subjects` (`subject_id`, `subject_code`, `subject_name`, `faculty_id`) VALUES
(2, 'CSC122L', 'Information Management 1 (LAB)', 3),
(3, 'GEC07', 'Science, Technology, and Society', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `tbl_faculty`
--
ALTER TABLE `tbl_faculty`
  ADD PRIMARY KEY (`faculty_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `tbl_grades`
--
ALTER TABLE `tbl_grades`
  ADD PRIMARY KEY (`grade_id`),
  ADD UNIQUE KEY `unique_student_subject` (`student_id`,`subject_id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `faculty_id` (`faculty_id`);

--
-- Indexes for table `tbl_programs`
--
ALTER TABLE `tbl_programs`
  ADD PRIMARY KEY (`program_id`),
  ADD UNIQUE KEY `program_code` (`program_code`);

--
-- Indexes for table `tbl_students`
--
ALTER TABLE `tbl_students`
  ADD PRIMARY KEY (`student_id`),
  ADD UNIQUE KEY `student_number` (`student_number`),
  ADD KEY `faculty_id` (`faculty_id`),
  ADD KEY `program_id` (`program_id`),
  ADD KEY `fk_admin` (`admin_id`);

--
-- Indexes for table `tbl_subjects`
--
ALTER TABLE `tbl_subjects`
  ADD PRIMARY KEY (`subject_id`),
  ADD UNIQUE KEY `subject_code` (`subject_code`),
  ADD KEY `faculty_id` (`faculty_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT for table `tbl_faculty`
--
ALTER TABLE `tbl_faculty`
  MODIFY `faculty_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_grades`
--
ALTER TABLE `tbl_grades`
  MODIFY `grade_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_programs`
--
ALTER TABLE `tbl_programs`
  MODIFY `program_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_students`
--
ALTER TABLE `tbl_students`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `tbl_subjects`
--
ALTER TABLE `tbl_subjects`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_grades`
--
ALTER TABLE `tbl_grades`
  ADD CONSTRAINT `tbl_grades_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `tbl_subjects` (`subject_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `tbl_grades_ibfk_3` FOREIGN KEY (`faculty_id`) REFERENCES `tbl_faculty` (`faculty_id`),
  ADD CONSTRAINT `tbl_grades_ibfk_4` FOREIGN KEY (`faculty_id`) REFERENCES `tbl_faculty` (`faculty_id`),
  ADD CONSTRAINT `tbl_grades_ibfk_5` FOREIGN KEY (`faculty_id`) REFERENCES `tbl_faculty` (`faculty_id`);

--
-- Constraints for table `tbl_students`
--
ALTER TABLE `tbl_students`
  ADD CONSTRAINT `fk_admin` FOREIGN KEY (`admin_id`) REFERENCES `tbl_admin` (`admin_id`),
  ADD CONSTRAINT `tbl_students_ibfk_1` FOREIGN KEY (`faculty_id`) REFERENCES `tbl_faculty` (`faculty_id`),
  ADD CONSTRAINT `tbl_students_ibfk_2` FOREIGN KEY (`program_id`) REFERENCES `tbl_programs` (`program_id`);

--
-- Constraints for table `tbl_subjects`
--
ALTER TABLE `tbl_subjects`
  ADD CONSTRAINT `tbl_subjects_ibfk_1` FOREIGN KEY (`faculty_id`) REFERENCES `tbl_faculty` (`faculty_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
