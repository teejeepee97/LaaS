-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Gegenereerd op: 23 jul 2024 om 11:22
-- Serverversie: 5.7.39
-- PHP-versie: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `LaaS`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Books`
--

CREATE TABLE `Books` (
  `bookId` int(11) NOT NULL,
  `physicalContentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `ContentDatabase`
--

CREATE TABLE `ContentDatabase` (
  `contentId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `contentDescription` text NOT NULL,
  `contentSubject` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Course`
--

CREATE TABLE `Course` (
  `courseId` int(11) NOT NULL,
  `courseName` varchar(128) NOT NULL,
  `description` varchar(128) NOT NULL,
  `learningPathId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Feedback`
--

CREATE TABLE `Feedback` (
  `feedbackId` int(11) NOT NULL,
  `feedbackRating` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `LearningPaths`
--

CREATE TABLE `LearningPaths` (
  `learningPathId` int(11) NOT NULL,
  `learningPathName` varchar(128) NOT NULL,
  `userId` int(11) NOT NULL,
  `trainerId` int(11) NOT NULL,
  `traineeId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Onlinecontent`
--

CREATE TABLE `Onlinecontent` (
  `onlineContentId` int(11) NOT NULL,
  `contentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `PhysicalContent`
--

CREATE TABLE `PhysicalContent` (
  `physicalContentId` int(11) NOT NULL,
  `contentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Presentations`
--

CREATE TABLE `Presentations` (
  `presentationId` int(11) NOT NULL,
  `onlineContentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Readers`
--

CREATE TABLE `Readers` (
  `readerId` int(11) NOT NULL,
  `physicalContentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Texts`
--

CREATE TABLE `Texts` (
  `textId` int(11) NOT NULL,
  `onlineContentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Trainee`
--

CREATE TABLE `Trainee` (
  `traineeId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `learningPathEnrollment` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Trainer`
--

CREATE TABLE `Trainer` (
  `trainerId` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Tutorials`
--

CREATE TABLE `Tutorials` (
  `tutorialId` int(11) NOT NULL,
  `onlineContentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `UdemyCourses`
--

CREATE TABLE `UdemyCourses` (
  `udemyId` int(11) NOT NULL,
  `onlineContentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `User`
--

CREATE TABLE `User` (
  `userId` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Videos`
--

CREATE TABLE `Videos` (
  `videoId` int(11) NOT NULL,
  `onlineContentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `Weblinks`
--

CREATE TABLE `Weblinks` (
  `webLinkid` int(11) NOT NULL,
  `onlineContentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `Books`
--
ALTER TABLE `Books`
  ADD PRIMARY KEY (`bookId`),
  ADD UNIQUE KEY `physicalContentId` (`physicalContentId`);

--
-- Indexen voor tabel `ContentDatabase`
--
ALTER TABLE `ContentDatabase`
  ADD PRIMARY KEY (`contentId`),
  ADD KEY `fk_contentDatabase_courseId` (`courseId`);

--
-- Indexen voor tabel `Course`
--
ALTER TABLE `Course`
  ADD PRIMARY KEY (`courseId`),
  ADD UNIQUE KEY `learningPathId` (`learningPathId`),
  ADD KEY `learningPathId_2` (`learningPathId`),
  ADD KEY `learningPathId_3` (`learningPathId`);

--
-- Indexen voor tabel `Feedback`
--
ALTER TABLE `Feedback`
  ADD PRIMARY KEY (`feedbackId`),
  ADD UNIQUE KEY `userId` (`userId`);

--
-- Indexen voor tabel `LearningPaths`
--
ALTER TABLE `LearningPaths`
  ADD PRIMARY KEY (`learningPathId`),
  ADD UNIQUE KEY `userId` (`userId`),
  ADD UNIQUE KEY `trainerId` (`trainerId`),
  ADD UNIQUE KEY `traineeId` (`traineeId`);

--
-- Indexen voor tabel `Onlinecontent`
--
ALTER TABLE `Onlinecontent`
  ADD PRIMARY KEY (`onlineContentId`),
  ADD KEY `fk_onlinecontent_contentId` (`contentId`);

--
-- Indexen voor tabel `PhysicalContent`
--
ALTER TABLE `PhysicalContent`
  ADD PRIMARY KEY (`physicalContentId`),
  ADD UNIQUE KEY `contentId` (`contentId`);

--
-- Indexen voor tabel `Presentations`
--
ALTER TABLE `Presentations`
  ADD PRIMARY KEY (`presentationId`),
  ADD KEY `fk_presentations_onlineContentId` (`onlineContentId`);

--
-- Indexen voor tabel `Readers`
--
ALTER TABLE `Readers`
  ADD PRIMARY KEY (`readerId`),
  ADD UNIQUE KEY `physicalContentId` (`physicalContentId`);

--
-- Indexen voor tabel `Texts`
--
ALTER TABLE `Texts`
  ADD PRIMARY KEY (`textId`),
  ADD KEY `fk_texts_onlineContentId` (`onlineContentId`);

--
-- Indexen voor tabel `Trainee`
--
ALTER TABLE `Trainee`
  ADD PRIMARY KEY (`traineeId`),
  ADD UNIQUE KEY `userid` (`userId`);

--
-- Indexen voor tabel `Trainer`
--
ALTER TABLE `Trainer`
  ADD PRIMARY KEY (`trainerId`),
  ADD UNIQUE KEY `userid` (`userId`);

--
-- Indexen voor tabel `Tutorials`
--
ALTER TABLE `Tutorials`
  ADD PRIMARY KEY (`tutorialId`),
  ADD KEY `fk_tutorials_onlineContentId` (`onlineContentId`);

--
-- Indexen voor tabel `UdemyCourses`
--
ALTER TABLE `UdemyCourses`
  ADD PRIMARY KEY (`udemyId`),
  ADD KEY `fk_udemyCourses_onlineContentId` (`onlineContentId`);

--
-- Indexen voor tabel `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`userId`);

--
-- Indexen voor tabel `Videos`
--
ALTER TABLE `Videos`
  ADD PRIMARY KEY (`videoId`),
  ADD KEY `fk_videos_onlineContentId` (`onlineContentId`);

--
-- Indexen voor tabel `Weblinks`
--
ALTER TABLE `Weblinks`
  ADD PRIMARY KEY (`webLinkid`),
  ADD KEY `fk_weblinks_onlineContentId` (`onlineContentId`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `Books`
--
ALTER TABLE `Books`
  MODIFY `bookId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `ContentDatabase`
--
ALTER TABLE `ContentDatabase`
  MODIFY `contentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `Course`
--
ALTER TABLE `Course`
  MODIFY `courseId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `Feedback`
--
ALTER TABLE `Feedback`
  MODIFY `feedbackId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `LearningPaths`
--
ALTER TABLE `LearningPaths`
  MODIFY `learningPathId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `Onlinecontent`
--
ALTER TABLE `Onlinecontent`
  MODIFY `onlineContentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `PhysicalContent`
--
ALTER TABLE `PhysicalContent`
  MODIFY `physicalContentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `Presentations`
--
ALTER TABLE `Presentations`
  MODIFY `presentationId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `Readers`
--
ALTER TABLE `Readers`
  MODIFY `readerId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `Texts`
--
ALTER TABLE `Texts`
  MODIFY `textId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `Trainee`
--
ALTER TABLE `Trainee`
  MODIFY `traineeId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `Trainer`
--
ALTER TABLE `Trainer`
  MODIFY `trainerId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `Tutorials`
--
ALTER TABLE `Tutorials`
  MODIFY `tutorialId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `UdemyCourses`
--
ALTER TABLE `UdemyCourses`
  MODIFY `udemyId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `User`
--
ALTER TABLE `User`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `Videos`
--
ALTER TABLE `Videos`
  MODIFY `videoId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `Weblinks`
--
ALTER TABLE `Weblinks`
  MODIFY `webLinkid` int(11) NOT NULL AUTO_INCREMENT;

--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `ContentDatabase`
--
ALTER TABLE `ContentDatabase`
  ADD CONSTRAINT `fk_contentDatabase_courseId` FOREIGN KEY (`courseId`) REFERENCES `Course` (`courseId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `Course`
--
ALTER TABLE `Course`
  ADD CONSTRAINT `fk_course_learningPathId` FOREIGN KEY (`learningPathId`) REFERENCES `LearningPaths` (`learningPathId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `Feedback`
--
ALTER TABLE `Feedback`
  ADD CONSTRAINT `fk_feedback_userId` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `LearningPaths`
--
ALTER TABLE `LearningPaths`
  ADD CONSTRAINT `fk_learningPaths_traineeId` FOREIGN KEY (`traineeId`) REFERENCES `Trainee` (`traineeId`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_learningPaths_trainerId` FOREIGN KEY (`trainerId`) REFERENCES `Trainer` (`trainerId`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_learningPaths_userId` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `Onlinecontent`
--
ALTER TABLE `Onlinecontent`
  ADD CONSTRAINT `fk_onlinecontent_contentId` FOREIGN KEY (`contentId`) REFERENCES `ContentDatabase` (`contentId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `PhysicalContent`
--
ALTER TABLE `PhysicalContent`
  ADD CONSTRAINT `fk_physicalContent_contentId` FOREIGN KEY (`contentId`) REFERENCES `ContentDatabase` (`contentId`) ON UPDATE CASCADE,
  ADD CONSTRAINT `physicalcontent_ibfk_1` FOREIGN KEY (`physicalContentId`) REFERENCES `Books` (`physicalContentId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `Presentations`
--
ALTER TABLE `Presentations`
  ADD CONSTRAINT `fk_presentations_onlineContentId` FOREIGN KEY (`onlineContentId`) REFERENCES `Onlinecontent` (`onlineContentId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `Readers`
--
ALTER TABLE `Readers`
  ADD CONSTRAINT `fk_readers_physicalContentId` FOREIGN KEY (`physicalContentId`) REFERENCES `PhysicalContent` (`physicalContentId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `Texts`
--
ALTER TABLE `Texts`
  ADD CONSTRAINT `fk_texts_onlineContentId` FOREIGN KEY (`onlineContentId`) REFERENCES `Onlinecontent` (`onlineContentId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `Trainee`
--
ALTER TABLE `Trainee`
  ADD CONSTRAINT `fk_trainee_userId` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `Trainer`
--
ALTER TABLE `Trainer`
  ADD CONSTRAINT `fk_trainer_userId` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `Tutorials`
--
ALTER TABLE `Tutorials`
  ADD CONSTRAINT `fk_tutorials_onlineContentId` FOREIGN KEY (`onlineContentId`) REFERENCES `Onlinecontent` (`onlineContentId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `UdemyCourses`
--
ALTER TABLE `UdemyCourses`
  ADD CONSTRAINT `fk_udemyCourses_onlineContentId` FOREIGN KEY (`onlineContentId`) REFERENCES `Onlinecontent` (`onlineContentId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `Videos`
--
ALTER TABLE `Videos`
  ADD CONSTRAINT `fk_videos_onlineContentId` FOREIGN KEY (`onlineContentId`) REFERENCES `Onlinecontent` (`onlineContentId`) ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `Weblinks`
--
ALTER TABLE `Weblinks`
  ADD CONSTRAINT `fk_weblinks_onlineContentId` FOREIGN KEY (`onlineContentId`) REFERENCES `Onlinecontent` (`onlineContentId`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
