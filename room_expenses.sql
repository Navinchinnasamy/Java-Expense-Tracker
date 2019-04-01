-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2019 at 12:59 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `room_expenses`
--

-- --------------------------------------------------------

--
-- Table structure for table `expenses`
--

CREATE TABLE `expenses` (
  `id` int(10) UNSIGNED NOT NULL,
  `purchased_by` int(11) NOT NULL,
  `description` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `amount` double(8,2) NOT NULL,
  `purchased_at` date NOT NULL,
  `bills` text COLLATE utf8mb4_unicode_ci,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `expenses`
--

INSERT INTO `expenses` (`id`, `purchased_by`, `description`, `amount`, `purchased_at`, `bills`, `created_at`, `updated_at`) VALUES
(1, 1, 'Vegitables', 72.00, '2018-11-21', '', '2018-12-04 01:28:09', '2018-12-04 01:28:09'),
(2, 1, 'Curd', 40.00, '2018-11-30', '', '2018-12-04 01:34:01', '2018-12-04 01:34:01'),
(3, 4, 'Vegetables & Groceries', 237.00, '2018-11-14', '', '2018-12-04 01:34:53', '2018-12-04 01:34:53'),
(4, 4, 'Groceries', 220.00, '2018-11-30', '', '2018-12-04 01:37:44', '2018-12-04 01:37:44'),
(5, 5, 'Purchase', 65.00, '2018-12-01', '', '2018-12-04 01:38:26', '2018-12-04 01:38:26'),
(6, 5, 'Veg', 12.00, '2018-12-02', '', '2018-12-04 01:38:52', '2018-12-04 01:38:52'),
(7, 2, 'Oil', 210.00, '2018-11-24', '', '2018-12-04 01:39:29', '2018-12-04 01:39:29'),
(8, 2, 'Purchase', 125.00, '2018-11-30', '', '2018-12-04 01:56:30', '2018-12-04 01:56:30'),
(9, 1, 'Added from Console', 25.37, '2019-04-01', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `general_expenses`
--

CREATE TABLE `general_expenses` (
  `id` int(10) UNSIGNED NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `amount` double(8,2) NOT NULL,
  `expense_month` date NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `general_expenses`
--

INSERT INTO `general_expenses` (`id`, `description`, `amount`, `expense_month`, `created_at`, `updated_at`) VALUES
(1, 'room_rent', 6800.00, '2018-12-01', '2018-12-04 00:16:23', '2018-12-04 01:41:32'),
(2, 'eb_bill', 0.00, '2018-12-01', '2018-12-04 00:16:23', '2018-12-04 01:41:32'),
(3, 'cleaning_charge', 100.00, '2018-12-01', '2018-12-04 00:16:23', '2018-12-04 01:41:32'),
(4, 'cable_charge', 100.00, '2018-12-01', '2018-12-04 00:16:23', '2018-12-04 01:41:32');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(2, '2014_10_12_100000_create_password_resets_table', 1),
(3, '2017_05_08_044445_Expenses', 1),
(4, '2017_08_22_142342_create_general_expenses_table', 1),
(5, '2017_12_11_171744_rent_paid', 1),
(6, '2014_10_12_000000_create_users_table', 2);

-- --------------------------------------------------------

--
-- Table structure for table `paid_rents`
--

CREATE TABLE `paid_rents` (
  `id` int(10) UNSIGNED NOT NULL,
  `paid_by` int(11) NOT NULL,
  `paid_at` date NOT NULL,
  `total_amount` double(8,2) NOT NULL,
  `equal_share` double(8,2) NOT NULL,
  `share_details` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` int(11) NOT NULL DEFAULT '2',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `remember_token`, `role`, `created_at`, `updated_at`) VALUES
(1, 'Navin', 'navinchinnasamy@gmail.com', '$2y$10$TQH31brXw9/Z4xA9l3zihucBm.WwlB/QDZLGO5GnEygWZEmf66XYm', NULL, 1, '2018-11-10 07:16:02', '2018-11-10 07:16:02'),
(2, 'Thangaraj', 'thangaraj.m@gmail.com', '$2y$10$3cuy7g.NNVZk5cqmkSmMkuD8LJM5UhVXhw780E4nVRt0GYXoaPKDC', NULL, 2, '2018-12-04 00:42:41', '2018-12-04 00:42:41'),
(3, 'Karthikeyan', 'karthikeyan.s@gmail.com', '$2y$10$38IGAAnlKNV93DxfQVDn5e6XOAucw0CxGfKlPQDqth9ll0wIMNDFe', NULL, 2, '2018-12-04 00:56:25', '2018-12-04 00:56:25'),
(4, 'Kumaresan', 'kumaresan@gmail.com', '$2y$10$BQQu7J4MDb6KfsGVQsjz4O0Gbzsy5AbyGp3yJuG.HS.JByyRYEvRa', NULL, 2, '2018-12-04 01:31:15', '2018-12-04 01:31:15'),
(5, 'Raghupathy', 'raghupathy@gmail.com', '$2y$10$8pqkUZxhjvFG93qqjdkg8eLvO/iWuKOzJwK29AI4/P0m4QpUDnWsq', NULL, 2, '2018-12-04 01:32:58', '2018-12-04 01:32:58');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `expenses`
--
ALTER TABLE `expenses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `general_expenses`
--
ALTER TABLE `general_expenses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `paid_rents`
--
ALTER TABLE `paid_rents`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `expenses`
--
ALTER TABLE `expenses`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `general_expenses`
--
ALTER TABLE `general_expenses`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `paid_rents`
--
ALTER TABLE `paid_rents`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
