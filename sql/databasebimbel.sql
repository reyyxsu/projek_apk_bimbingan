-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 30, 2024 at 04:05 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `databasebimbel`
--

-- --------------------------------------------------------

--
-- Table structure for table `biaya_bimbel_pendaftar`
--

CREATE TABLE `biaya_bimbel_pendaftar` (
  `id` varchar(20) NOT NULL,
  `nama_pendaftar` varchar(100) DEFAULT NULL,
  `lama_bimbingan` varchar(50) DEFAULT NULL,
  `biaya_bimbingan` varchar(50) DEFAULT NULL,
  `cicilan_biaya` varchar(50) DEFAULT NULL,
  `biaya_akhir` varchar(50) DEFAULT NULL,
  `tanggal_pendaftaran` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `biaya_bimbel_pendaftar`
--

INSERT INTO `biaya_bimbel_pendaftar` (`id`, `nama_pendaftar`, `lama_bimbingan`, `biaya_bimbingan`, `cicilan_biaya`, `biaya_akhir`, `tanggal_pendaftaran`) VALUES
('ID001', 'Atallah Carlen Syafaat', '4 Bulan', '400000', '200000', '200000', 'Monday, 09 September 2024 11:18:10'),
('ID002', 'Ariyal Zarhan Ikhlas Haryanto', '4 Bulan', '400000', '400000', 'LUNAS', 'Monday, 09 September 2024 11:18:17'),
('ID003', 'Bryllent Arciellio Lim', '4 Bulan', '400000', '150000', '250000', 'Monday, 09 September 2024 11:18:22'),
('ID004', 'Faleniko Mubintoro', '3 Bulan', '300000', '300000', 'LUNAS', 'Monday, 09 September 2024 11:18:28'),
('ID005', 'Damar Wijayanto', '5 Bulan', '500000', '400000', '100000', 'Monday, 09 September 2024 11:17:50'),
('ID006', 'Muhammad Abril Firdaus', '2 Bulan', '200000', '200000', 'LUNAS', 'Monday, 09 September 2024 11:18:37'),
('ID007', 'Marthin Yehezkiel Rante Lobo', '5 Bulan', '500000', '100000', '400000', 'Monday, 09 September 2024 11:18:46'),
('ID008', 'Stevan Rendyanata', '5 Bulan', '500000', '500000', 'LUNAS', 'Monday, 09 September 2024 11:18:55'),
('ID009', 'Muhammad Fatur Imaniaji', '4 Bulan', '400000', '400000', 'LUNAS', 'Monday, 09 September 2024 11:19:01'),
('ID010', 'Muhammad Soviyan', '6 Bulan', '600000', '150000', '450000', 'Monday, 09 September 2024 11:19:06'),
('ID011', 'Alfi Zahra Quratu\' Aini', '4 Bulan', '400000', '350000', '50000', 'Monday, 09 September 2024 11:19:14');

-- --------------------------------------------------------

--
-- Table structure for table `biodata_pendaftar`
--

CREATE TABLE `biodata_pendaftar` (
  `id` varchar(10) NOT NULL,
  `nama_pendaftar` varchar(100) DEFAULT NULL,
  `alamat` varchar(150) DEFAULT NULL,
  `tempat_tanggal_lahir` varchar(100) DEFAULT NULL,
  `agama` varchar(30) DEFAULT NULL,
  `jenis_kelamin` varchar(20) DEFAULT NULL,
  `asal_sekolah` varchar(50) DEFAULT NULL,
  `kelas` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telepon` varchar(20) DEFAULT NULL,
  `tanggal_pendaftaran` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `biodata_pendaftar`
--

INSERT INTO `biodata_pendaftar` (`id`, `nama_pendaftar`, `alamat`, `tempat_tanggal_lahir`, `agama`, `jenis_kelamin`, `asal_sekolah`, `kelas`, `email`, `telepon`, `tanggal_pendaftaran`) VALUES
('ID001', 'Atallah Carlen Syafaat', 'Perumahan Villa Mas Indah', 'Bekasi, 18 Oktober 2006', 'Islam', 'Laki - Laki', 'SMK Negeri 5 Kota Bekasi', '12', 'rylzrhn06@gmail.com', '08212345678', 'Sunday, 08 September 2024 00:27:55'),
('ID002', 'Ariyal Zarhan Ikhlas Haryanto', 'Perumahan Pesona Anggrek', 'Makassar, 25 November 2006', 'Islam', 'Laki - Laki', 'SMK Negeri 5 Kota Bekasi', '12', 'rylzrhn06@gmail.com', '082112071288', 'Sunday, 08 September 2024 00:30:52'),
('ID003', 'Bryllent Arciellio Lim', 'Perumahan Wisma Asri', 'Bekasi, 15 Juli 2007', 'Islam', 'Laki - Laki', 'SMK Negeri 5 Kota Bekasi', '12', 'cainisman@yahoo.com', '082176542098', 'Sunday, 08 September 2024 00:31:57'),
('ID004', 'Faleniko Mubintoro', 'Perumahan Danau Duta', 'Bekasi, 19 Desember 2006', 'Islam', 'Laki - Laki', 'SMK Negeri 5 Kota Bekasi', '12', 'cainiskikir@haha.com', '0898654245678', 'Sunday, 08 September 2024 00:33:54'),
('ID005', 'Damar Wijayanto', 'Perumahan Villa Gading Harapan', 'Bekasi, 18 Juli 2007', 'Kristen', 'Laki - Laki', 'SMK Negeri 5 Kota Bekasi', '12', 'damarwijayanto@gmail.com', '087423081545', 'Sunday, 08 September 2024 00:34:49'),
('ID006', 'Muhammad Abril Firdaus', 'Perumahan Suropati Gabus', 'Bekasi, 14 Agustus 2008', 'Islam', 'Laki - Laki', 'SMK Negeri 5 Kota Bekasi', '12', 'abrilgabusman@hok.com', '08271469862', 'Sunday, 08 September 2024 00:36:16'),
('ID007', 'Marthin Yehezkiel Rante Lobo', 'Perumahan Villa Indah Permai', 'Bekasi, 25 Desember 2006', 'Kristen', 'Laki - Laki', 'SMK Negeri 5 Kota Bekasi', '12', 'marthinrantelobo@gmail.com', '0891253749703', 'Sunday, 08 September 2024 00:37:18'),
('ID008', 'Stevan Rendyanata', 'Perumahan Perwira Sari', 'Bekasi, 6 Oktober 2006', 'Islam', 'Laki - Laki', 'SMK Negeri 5 Kota Bekasi', '12', 'stevanrendy@yahoo.com', '08212345687', 'Sunday, 08 September 2024 00:42:36'),
('ID009', 'Muhammad Fatur Imaniaji', 'Perumahan Pondok Ungu Permai Sektor V', 'Madura, 16 Mei 2007', 'Islam', 'Laki - Laki', 'SMK Negeri 5 Kota Bekasi', '12', 'faturimaniaji@gmail.com', '0872634569123', 'Sunday, 08 September 2024 00:44:23'),
('ID010', 'Muhammad Soviyan', 'Perumahan Arab Teroris', 'Pakistan, 19 Agustus 1969', 'Islam', 'Laki - Laki', 'SMK Negeri 5 Kota Bekasi', '12', 'iamterorishaha@yahoo.com', '0823938969', 'Sunday, 08 September 2024 00:45:54'),
('ID011', 'Alfi Zahra Quratu\' Aini', 'Perumahan Villa Mas Indah', 'Bandar Lampung, 9 Oktober 1969', 'Islam', 'Laki - Laki', 'SMK Negeri 5 Kota Bekasi', '12', 'alfizahra@gmail.com', '0821234567', 'Monday, 09 September 2024 08:20:38');

-- --------------------------------------------------------

--
-- Table structure for table `biodata_pengajar`
--

CREATE TABLE `biodata_pengajar` (
  `pid` varchar(10) NOT NULL,
  `nama_pengajar` varchar(100) DEFAULT NULL,
  `tempat_tanggal_lahir_pengajar` varchar(100) DEFAULT NULL,
  `agama_pengajar` varchar(100) DEFAULT NULL,
  `jenis_kelamin_pengajar` varchar(100) DEFAULT NULL,
  `alamat_pengajar` varchar(100) DEFAULT NULL,
  `no_telepon_pengajar` varchar(100) DEFAULT NULL,
  `universitas_pengajar` varchar(100) DEFAULT NULL,
  `jurusan_universitas` varchar(100) DEFAULT NULL,
  `lulusan_pengajar` varchar(100) DEFAULT NULL,
  `tanggal_pendaftaran` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `biodata_pengajar`
--

INSERT INTO `biodata_pengajar` (`pid`, `nama_pengajar`, `tempat_tanggal_lahir_pengajar`, `agama_pengajar`, `jenis_kelamin_pengajar`, `alamat_pengajar`, `no_telepon_pengajar`, `universitas_pengajar`, `jurusan_universitas`, `lulusan_pengajar`, `tanggal_pendaftaran`) VALUES
('PID001', 'Ariyal Zarhan Ikhlas Haryanto', 'Makassar, 25 November 2006', 'Islam', 'Laki - Laki', 'Perumahan Pesona Anggrek Harapan', '082112071288', 'Universitas Guna Darma Depok', 'Teknik Informatika', 'S1', 'Monday, 09 September 2024 11:02:02'),
('PID002', 'Muhammad Fatur Imaniaji', 'Bekasi, 18 Oktober 2007', 'Islam', 'Laki - Laki', 'Perumahan Pondok Ungu Permai', '082169289780', 'Universita Ngawi Negeri', 'Teknik Ngawi', 'S2', 'Monday, 09 September 2024 10:53:38'),
('PID003', 'Alfi Zahra Quratu\' Aini', 'Bandar Lampung, 8 Oktober 2008', 'Islam', 'Laki - Laki', 'Perumahan Villa Mas Indah', '08299208893', 'Universitas Negeri Lampung', 'Teknik Informasi', 'D4', 'Monday, 09 September 2024 11:02:48');

-- --------------------------------------------------------

--
-- Table structure for table `login_db`
--

CREATE TABLE `login_db` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login_db`
--

INSERT INTO `login_db` (`username`, `password`) VALUES
('admin', 'adminbimbel#1234'),
('user', 'user123');

-- --------------------------------------------------------

--
-- Table structure for table `program_bimbel_pendaftar`
--

CREATE TABLE `program_bimbel_pendaftar` (
  `id` varchar(10) NOT NULL,
  `nama_pendaftar` varchar(255) DEFAULT NULL,
  `program_bimbingan` varchar(255) DEFAULT NULL,
  `hari_bimbingan` varchar(50) DEFAULT NULL,
  `jam_bimbingan` varchar(20) DEFAULT NULL,
  `tanggal_pendaftaran` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `program_bimbel_pendaftar`
--

INSERT INTO `program_bimbel_pendaftar` (`id`, `nama_pendaftar`, `program_bimbingan`, `hari_bimbingan`, `jam_bimbingan`, `tanggal_pendaftaran`) VALUES
('ID001', 'Atallah Carlen Syafaat', 'Bahasa Jepang', 'Selasa, Jum\'at', '19:00 - 20:30', 'Sunday, 08 September 2024 00:28:01'),
('ID002', 'Ariyal Zarhan Ikhlas Haryanto', 'Bahasa Inggris', 'Selasa, Jum\'at', '17:00 - 18:30', 'Sunday, 08 September 2024 00:30:59'),
('ID003', 'Bryllent Arciellio Lim', 'Bahasa Inggris', 'Selasa, Jum\'at', '17:00 - 18:30', 'Sunday, 08 September 2024 00:32:07'),
('ID004', 'Faleniko Mubintoro', 'Bahasa Jepang', 'Selasa, Jum\'at', '19:00 - 20:30', 'Sunday, 08 September 2024 00:33:59'),
('ID005', 'Damar Wijayanto', 'Bahasa Inggris', 'Selasa, Jum\'at', '15:00 - 16:30', 'Sunday, 08 September 2024 00:34:53'),
('ID006', 'Muhammad Abril Firdaus', 'Matematika', 'Senin, Kamis', '15:00 - 16:30', 'Sunday, 08 September 2024 00:36:19'),
('ID007', 'Marthin Yehezkiel Rante Lobo', 'Matematika', 'Senin, Kamis', '19:00 - 20:30', 'Sunday, 08 September 2024 00:37:24'),
('ID008', 'Stevan Rendyanata', 'Bahasa Inggris', 'Selasa, Jum\'at', '15:00 - 16:30', 'Sunday, 08 September 2024 00:42:39'),
('ID009', 'Muhammad Fatur Imaniaji', 'Bahasa Inggris', 'Selasa, Jum\'at', '15:00 - 16:30', 'Sunday, 08 September 2024 00:44:27'),
('ID010', 'Muhammad Soviyan', 'Matematika', 'Selasa, Jum\'at', '15:00 - 16:30', 'Sunday, 08 September 2024 00:46:00'),
('ID011', 'Alfi Zahra Quratu\' Aini', 'Bahasa Jepang', 'Senin, Kamis', '17:00 - 18:30', 'Monday, 09 September 2024 08:20:46');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `biaya_bimbel_pendaftar`
--
ALTER TABLE `biaya_bimbel_pendaftar`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `biodata_pendaftar`
--
ALTER TABLE `biodata_pendaftar`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `biodata_pengajar`
--
ALTER TABLE `biodata_pengajar`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `login_db`
--
ALTER TABLE `login_db`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `program_bimbel_pendaftar`
--
ALTER TABLE `program_bimbel_pendaftar`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
