-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 23 jul 2024 om 09:15
-- Serverversie: 10.4.32-MariaDB
-- PHP-versie: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wtlaas`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `teachingmaterial`
--

CREATE TABLE `teachingmaterial` (
  `id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `format` varchar(128) NOT NULL,
  `amount` int(11) NOT NULL,
  `description` text NOT NULL,
  `available` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Gegevens worden geëxporteerd voor tabel `teachingmaterial`
--

INSERT INTO `teachingmaterial` (`id`, `name`, `format`, `amount`, `description`, `available`) VALUES
(1, 'Scrum for Dummies', 'book', 1, '', 'True'),
(2, 'SQL Pocket Guide', 'book', 2, '', 'True'),
(3, 'The Data Warehouse Toolkit', 'book', 1, '', 'True'),
(4, 'The Data Warehouse ETL Toolkit', 'book', 1, '', 'True'),
(5, 'BABOK', 'book', 2, '', 'True'),
(6, 'Business Analysis', 'book', 1, '', 'True'),
(7, 'The Pragmatic Programmer', 'book', 1, '', 'True'),
(8, 'Querying Data with Transact-SQL', 'book', 2, '', 'True'),
(9, 'Oracle Certified Professional Java SE 11 Developer', 'book', 1, '', 'True'),
(10, 'Handboek ISO 27001 Controls 2022', 'book', 1, '', 'True'),
(11, 'MTA EXAM: HTML5 Application Development Fundamentals', 'book', 2, '', 'True'),
(12, 'Kick-off.pdf', 'slidedeck', 1, '', 'True'),
(13, 'Agile en Scrum.pdf', 'slidedeck', 1, '', 'True'),
(14, 'IT Bootcamp - Security Training - Niek Derksen - 15-07-2024', 'slidedeck', 1, '', 'True'),
(15, 'Training Introductie SDLC - Niek Derksen.pdf', 'slidedeck', 1, '', 'True'),
(16, 'WT Traineeship Bootcamp Fundamnt Training - IT in een notendop - Niek Derksen.pdf', 'slidedeck', 1, '', 'True'),
(17, 'WT Lesprogramma IT-bootcamp.pdf', 'pdf_file', 1, '', 'True'),
(18, 'De Scrumguide', 'weblink', 1, '', 'True'),
(19, 'Design Patterns', 'weblink', 1, '', 'True'),
(20, 'Agile Product Ownership in a Nutshell', 'video', 1, '', 'True'),
(21, 'SAFe Explained in Five Minutes', 'video', 1, '', 'True'),
(22, 'Large Scaled Scrum: Spotify Model', 'video', 1, '', 'True'),
(23, 'Changes to computer thinking - Stephen Fry explains cloud computing', 'video', 1, '', 'True'),
(24, 'Microsoft Azure Fundamentals Certification Course (AZ-900) - Pass the exam in 3 hours!', 'video', 1, '', 'True'),
(25, 'SQLzoo', 'online_tutorial', 1, '', 'True'),
(26, 'SQLTutorial', 'online_tutorial', 1, '', 'True'),
(27, 'Webinar Low-code met Mendix - 16-04-20', 'webinar', 1, '', 'True'),
(28, 'IT for beginners', 'udemy_course', 1, '', 'True'),
(29, 'Learn Scrum, understand the Agile principles + prepare for your Agile/Scrum Master Certification in 2024', 'udemy_course', 1, '', 'True'),
(30, 'Introduction to Computer Networks for Non-Techies', 'udemy_course', 1, '', 'True'),
(31, 'Cloud Computing Fundamentals', 'udemy_course', 1, '', 'True'),
(32, 'Relational Database Design', 'udemy_course', 1, '', 'True'),
(33, 'SQL for Beginners: Learn SQL using MySQL and Database Design', 'udemy_course', 1, '', 'True'),
(34, 'The Complete SQL Bootcamp: Go from Zero to Hero', 'udemy_course', 1, '', 'True'),
(35, 'UML and Object-Oriented Design Foundations', 'udemy_course', 1, '', 'True'),
(36, 'SOLID Principles: Introducing Software Architecture & Design', 'udemy_course', 1, '', 'True'),
(37, 'Fundamentals of backend Engineering', 'udemy_course', 1, '', 'True'),
(38, 'Java for Absolute Beginners', 'udemy_course', 1, '', 'True'),
(39, '50 Projects in 50 Days - HTML CSS & JavaScript', 'udemy_course', 1, '', 'True'),
(40, 'The Complete Python Bootcamp From Zero to Hero in Python', 'udemy_course', 1, '', 'True'),
(41, 'C# Basics for Beginners: Learn C# Fundamentals by Coding', 'udemy_course', 1, '', 'True'),
(42, 'Mendix: Low-code application Development Course', 'udemy_course', 1, '', 'True'),
(43, 'OutSystems Reactive for Beginners', 'udemy_course', 1, '', 'True'),
(44, 'Information Security Management Fundamentals for Non-Techies', 'udemy_course', 1, '', 'True'),
(45, 'SQL Fundamentals', 'reader', 1, '', 'True'),
(46, 'Het BADSOC-model', 'reader', 1, '', 'True'),
(47, 'Training Presentatietechnieken', 'reader', 1, '', 'True');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `userfeedback`
--

CREATE TABLE `userfeedback` (
  `feedbackId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `teachingMaterialId` int(11) NOT NULL,
  `feedback` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `gender` varchar(128) NOT NULL,
  `phoneNumber` varchar(128) NOT NULL,
  `address` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Gegevens worden geëxporteerd voor tabel `users`
--

INSERT INTO `users` (`id`, `name`, `dateOfBirth`, `gender`, `phoneNumber`, `address`, `email`, `username`, `password`) VALUES
(1, 'admin', '2024-07-01', 'male', '112', 'Kuiperbergweg 50a', 'admin@workingtalent.nl', 'admin', 'admin');

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `teachingmaterial`
--
ALTER TABLE `teachingmaterial`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `userfeedback`
--
ALTER TABLE `userfeedback`
  ADD PRIMARY KEY (`feedbackId`),
  ADD UNIQUE KEY `userId` (`userId`),
  ADD UNIQUE KEY `teachingMaterialId` (`teachingMaterialId`);

--
-- Indexen voor tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `teachingmaterial`
--
ALTER TABLE `teachingmaterial`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT voor een tabel `userfeedback`
--
ALTER TABLE `userfeedback`
  MODIFY `feedbackId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `userfeedback`
--
ALTER TABLE `userfeedback`
  ADD CONSTRAINT `userfeedback_ibfk_1` FOREIGN KEY (`teachingMaterialId`) REFERENCES `teachingmaterial` (`id`),
  ADD CONSTRAINT `userfeedback_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
