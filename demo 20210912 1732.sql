--
-- Script was generated by Devart dbForge Studio 2019 for MySQL, Version 8.2.23.0
-- Product home page: http://www.devart.com/dbforge/mysql/studio
-- Script date 2021/9/12 17:32:53
-- Server version: 5.5.5-10.4.13-MariaDB
-- Client version: 4.1
--

-- 
-- Disable foreign keys
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Set SQL mode
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Set character set the client will use to send SQL statements to the server
--
SET NAMES 'utf8';

--
-- Set default database
--
USE demo;

--
-- Drop table `account_auth_def`
--
DROP TABLE IF EXISTS account_auth_def;

--
-- Drop table `account_login_account`
--
DROP TABLE IF EXISTS account_login_account;

--
-- Drop table `account_login_authoritie`
--
DROP TABLE IF EXISTS account_login_authoritie;

--
-- Drop table `account_oauth_client_detail`
--
DROP TABLE IF EXISTS account_oauth_client_detail;

--
-- Drop table `account_role_auth`
--
DROP TABLE IF EXISTS account_role_auth;

--
-- Drop table `account_role_def`
--
DROP TABLE IF EXISTS account_role_def;

--
-- Drop table `account_user_role`
--
DROP TABLE IF EXISTS account_user_role;

--
-- Set default database
--
USE demo;

--
-- Create table `account_user_role`
--
CREATE TABLE account_user_role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  creator bigint(20) DEFAULT NULL COMMENT '创建人UserID',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
  modifier bigint(20) DEFAULT NULL COMMENT '最后修改人UserID',
  modify_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 2,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create table `account_role_def`
--
CREATE TABLE account_role_def (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  code varchar(50) NOT NULL,
  name varchar(500) NOT NULL,
  `desc` varchar(500) NOT NULL,
  enabled tinyint(1) NOT NULL,
  remark varchar(500) NOT NULL,
  creator bigint(20) DEFAULT NULL COMMENT '创建人UserID',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
  modifier bigint(20) DEFAULT NULL COMMENT '最后修改人UserID',
  modify_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 2,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create table `account_role_auth`
--
CREATE TABLE account_role_auth (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  role_id bigint(20) NOT NULL,
  auth_id bigint(20) NOT NULL,
  creator bigint(20) DEFAULT NULL COMMENT '创建人UserID',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
  modifier bigint(20) DEFAULT NULL COMMENT '最后修改人UserID',
  modify_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 3,
AVG_ROW_LENGTH = 8192,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create table `account_oauth_client_detail`
--
CREATE TABLE account_oauth_client_detail (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  client_id varchar(256) DEFAULT NULL,
  resource_ids varchar(256) DEFAULT NULL,
  client_secret varchar(256) DEFAULT NULL,
  scope varchar(256) DEFAULT NULL,
  authorized_grant_types varchar(256) DEFAULT NULL,
  web_server_redirect_uri varchar(256) DEFAULT NULL,
  authorities varchar(256) DEFAULT NULL,
  access_token_validity int(11) DEFAULT NULL,
  refresh_token_validity int(11) DEFAULT NULL,
  additional_information varchar(4096) DEFAULT NULL,
  autoapprove varchar(256) DEFAULT NULL,
  creator_id bigint(20) DEFAULT NULL COMMENT '创建人UserID',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
  modifier bigint(20) DEFAULT NULL COMMENT '最后修改人UserID',
  modify_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  creator_name varchar(32) DEFAULT NULL COMMENT '创建人名称',
  modifier_name varchar(32) DEFAULT NULL COMMENT '修改人名称',
  modifier_id bigint(20) DEFAULT NULL COMMENT '修改人名称',
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 2,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create table `account_login_authoritie`
--
CREATE TABLE account_login_authoritie (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_id bigint(20) NOT NULL,
  authority varchar(50) NOT NULL,
  creator bigint(20) DEFAULT NULL COMMENT '创建人UserID',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
  modifier bigint(20) DEFAULT NULL COMMENT '最后修改人UserID',
  modify_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 3,
AVG_ROW_LENGTH = 8192,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create table `account_login_account`
--
CREATE TABLE account_login_account (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  password varchar(500) NOT NULL,
  enabled tinyint(1) NOT NULL,
  user_id bigint(20) NOT NULL,
  creator bigint(20) DEFAULT NULL COMMENT '创建人UserID',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
  modifier bigint(20) DEFAULT NULL COMMENT '最后修改人UserID',
  modify_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  creator_name varchar(32) DEFAULT NULL COMMENT '创建人名称',
  modifier_name varchar(32) DEFAULT NULL COMMENT '修改人名称',
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 2,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create table `account_auth_def`
--
CREATE TABLE account_auth_def (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  code varchar(50) NOT NULL,
  name varchar(500) NOT NULL,
  `desc` varchar(500) NOT NULL,
  enabled tinyint(1) NOT NULL,
  remark varchar(500) NOT NULL,
  creator_id bigint(20) DEFAULT NULL COMMENT '创建人UserID',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
  modifier bigint(20) DEFAULT NULL COMMENT '最后修改人UserID',
  modify_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 3,
AVG_ROW_LENGTH = 8192,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

-- 
-- Dumping data for table account_user_role
--
INSERT INTO account_user_role VALUES
(1, 1, 1, NULL, '2021-06-30 08:35:59', NULL, '2021-06-30 08:35:59');

-- 
-- Dumping data for table account_role_def
--
INSERT INTO account_role_def VALUES
(1, '1', '1', '1', 1, '1', NULL, '2021-06-30 08:36:24', NULL, '2021-06-30 08:36:24');

-- 
-- Dumping data for table account_role_auth
--
INSERT INTO account_role_auth VALUES
(1, 1, 1, NULL, '2021-06-30 08:36:40', NULL, '2021-06-30 08:36:40'),
(2, 1, 2, NULL, '2021-06-30 08:40:04', NULL, '2021-06-30 08:40:04');

-- 
-- Dumping data for table account_oauth_client_detail
--
INSERT INTO account_oauth_client_detail VALUES
(1, 'reader', NULL, '$e0801$fbrC/IIOY/1VkwYaspuQm0iCH1J5sV5TqvKcAdG+Id/1CL5t7GiezBu4kEj0Jj7GHv5+fcx66hjlRtJOi2RXAw==$HrKF2dpVBdkwkJ0LGi0Ce7ACGZgG5L2UTfk3xMPaZG8=', 'info', 'password,authorization_code,refresh_token', NULL, NULL, NULL, NULL, NULL, 'true', NULL, '2021-06-29 11:01:44', NULL, '2021-07-01 16:49:04', NULL, NULL, NULL);

-- 
-- Dumping data for table account_login_authoritie
--
INSERT INTO account_login_authoritie VALUES
(1, 1, 'USER', NULL, '2021-06-29 11:02:56', NULL, '2021-06-29 11:02:56'),
(2, 1, 'USER_ADMIN', NULL, '2021-06-29 11:03:07', NULL, '2021-06-29 11:03:07');

-- 
-- Dumping data for table account_login_account
--
INSERT INTO account_login_account VALUES
(1, 'admin', '$e0801$2vPtcRSe4HSTQgaI1suSTiJQgg3rorvPMdhy9x4y8rsfGucKQktaLG7NhQojMoZiVmRuO+ymriS9YjF13Z7kOg==$2/F8pKr876JFyaKiMoWgYJhe0pi7tfvrtDv0oWP1GnE=', 1, 1, NULL, '2021-06-29 11:02:36', NULL, '2021-07-01 16:49:29', NULL, NULL);

-- 
-- Dumping data for table account_auth_def
--
INSERT INTO account_auth_def VALUES
(1, 'ROLE_USER', '1', '1', 1, '1', NULL, '2021-06-30 08:36:55', NULL, '2021-07-19 09:47:32'),
(2, 'ROLE_USER_ADMIN', '1', '1', 1, '1', NULL, '2021-06-30 08:37:02', NULL, '2021-07-19 09:47:34');

-- 
-- Restore previous SQL mode
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Enable foreign keys
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;