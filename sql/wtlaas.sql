-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 22 jul 2024 om 14:07
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
(1, 'SQL for Dummies', 'Book', 1, 'Book about SQL for dummies.', 'Yes');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
