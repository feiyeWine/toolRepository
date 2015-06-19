-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015-06-03 15:46:41
-- 服务器版本： 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- 表的结构 `appliance`
--

CREATE TABLE IF NOT EXISTS `appliance` (
  `Appliance_ID` varchar(40) CHARACTER SET utf8 NOT NULL,
  `Appliance_Name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Appliance_Num` int(11) NOT NULL,
  `Appliance_Price` double NOT NULL,
  PRIMARY KEY (`Appliance_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `appliance`
--

INSERT INTO `appliance` (`Appliance_ID`, `Appliance_Name`, `Appliance_Num`, `Appliance_Price`) VALUES
('001', '数字万用表', 16, 258),
('002', '验电笔', 13, 23.5),
('003', '数字电视高清线测试', 18, 350),
('004', '斜口钳', 120, 60),
('005', '尖嘴钳', 25, 87),
('006', '如意钳', 20, 87),
('007', '平嘴钳', 43, 88.3),
('008', '水口钳	', 23, 54),
('009', '弯嘴钳', 25, 43.5),
('010', '老虎钳', 29, 90.2),
('011', '剥线钳	', 38, 81.1),
('012', '圆尖烙铁头	', 43, 5),
('013', '斜面烙铁头	', 13, 5),
('014', '无酸焊油', 19, 16),
('015', '耐氧化电烙铁	', 48, 27.5),
('016', '吸锡网线	', 92, 6.5),
('017', '温控预热平台	', 8, 750),
('018', '圆形锡炉	', 48, 79),
('019', '一字螺丝刀	', 165, 19),
('020', '十字螺丝刀	', 105, 11),
('021', '高压绝缘起子	', 26, 22),
('022', '六角起子', 28, 10.8),
('023', '六角扳手组	', 41, 35),
('024', '双开手扳手	', 76, 50),
('025', '棘轮扭力扳手	', 28, 198),
('026', '星型扳手', 26, 55),
('027', '活动扳手', 14, 42),
('028', '防静电工作布	', 25, 180),
('029', '弯尖镊子', 57, 35),
('030', '长尖镊子', 21, 16.7),
('031', '扁平嘴镊子	', 33, 19.5),
('032', '圆尖镊子', 35, 35),
('033', '游标卡尺', 37, 79),
('034', '吸尘球	', 185, 5),
('035', '音波清洗器', 9, 685),
('036', '软管蛇灯', 16, 35),
('037', '四爪抓物器	', 34, 27.5),
('038', '卷尺	', 43, 10),
('039', '绝缘PVC胶布	', 264, 5),
('040', '毛刷	', 210, 5);

-- --------------------------------------------------------

--
-- 表的结构 `automobile`
--

CREATE TABLE IF NOT EXISTS `automobile` (
  `Automobile_ID` varchar(40) CHARACTER SET utf8 NOT NULL,
  `Automobile_Name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Automobile_Price` double NOT NULL,
  `Automobile_Num` int(11) NOT NULL,
  PRIMARY KEY (`Automobile_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `automobile`
--

INSERT INTO `automobile` (`Automobile_ID`, `Automobile_Name`, `Automobile_Price`, `Automobile_Num`) VALUES
('001', '轮胎', 400, 235),
('002', '发动机', 8000, 35),
('003', '油箱', 100, 23),
('004', '差速器', 800, 65),
('005', '传动轴', 500, 22),
('006', '减震器\r\n', 300, 59),
('007', '前后大灯', 1000, 225),
('008', '座椅', 1000, 15);

-- --------------------------------------------------------

--
-- 表的结构 `computer`
--

CREATE TABLE IF NOT EXISTS `computer` (
  `Computer_ID` varchar(40) CHARACTER SET utf8 NOT NULL,
  `Computer_Name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Computer_Num` int(11) NOT NULL,
  `Computer_Price` double NOT NULL,
  PRIMARY KEY (`Computer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `computer`
--

INSERT INTO `computer` (`Computer_ID`, `Computer_Name`, `Computer_Num`, `Computer_Price`) VALUES
('001', '数字万用表	', 19, 258),
('002', '网络测线仪	', 39, 120),
('003', '查线器	', 18, 900),
('004', '光纤测试笔	', 33, 169),
('005', '光纤切割刀', 26, 780),
('006', '光纤切割笔	', 62, 190),
('007', '三孔式光纤剥线钳', 28, 95),
('008', '水口钳	', 23, 54),
('009', '弯嘴钳', 25, 43.5),
('010', '老虎钳', 29, 90.2),
('011', '剥线钳	', 38, 81.1),
('012', '圆尖烙铁头	', 43, 5),
('013', '斜面烙铁头	', 13, 5),
('014', '无酸焊油', 19, 16),
('015', '耐氧化电烙铁	', 48, 27.5),
('016', '吸锡网线	', 92, 6.5),
('017', '温控预热平台	', 8, 750),
('018', '圆形锡炉	', 48, 79),
('019', '一字螺丝刀	', 165, 19),
('020', '十字螺丝刀	', 105, 11),
('021', '高压绝缘起子	', 26, 22),
('022', '六角起子', 28, 10.8),
('023', '六角扳手组	', 41, 35),
('024', '双开手扳手	', 76, 50),
('025', '棘轮扭力扳手	', 28, 198),
('026', '星型扳手', 26, 55),
('027', '活动扳手', 14, 42),
('028', '防静电工作布	', 25, 180),
('029', '弯尖镊子', 57, 35),
('030', '长尖镊子', 21, 16.7),
('031', '扁平嘴镊子	', 33, 19.5),
('032', '圆尖镊子', 35, 35),
('033', '游标卡尺', 37, 79),
('034', '吸尘球	', 185, 5),
('035', '音波清洗器', 9, 685),
('036', '软管蛇灯', 16, 35),
('037', '四爪抓物器	', 34, 27.5),
('038', '卷尺	', 43, 10),
('039', '绝缘PVC胶布	', 264, 5),
('040', '毛刷	', 210, 5),
('041', '验电笔	', 58, 23.5),
('042', '斜口钳	', 23, 60);

-- --------------------------------------------------------

--
-- 表的结构 `construction`
--

CREATE TABLE IF NOT EXISTS `construction` (
  `Construction_ID` varchar(40) CHARACTER SET utf8 NOT NULL,
  `Construction_Name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Construction_Price` double NOT NULL,
  `Construction_Num` int(11) NOT NULL,
  PRIMARY KEY (`Construction_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `construction`
--

INSERT INTO `construction` (`Construction_ID`, `Construction_Name`, `Construction_Price`, `Construction_Num`) VALUES
('001', '机械履带', 1500, 23),
('002', '大型机械发动机', 30000, 10),
('003', '铲斗', 10000, 5),
('004', '大型机千斤顶', 1600, 4),
('005', '液压泵', 10000, 3),
('006', '挖掘机挖斗', 11000, 2),
('007', '机械链条', 2000, 14),
('008', '支重轮', 4000, 7),
('009', '起重机吊钩', 2000, 2);

-- --------------------------------------------------------

--
-- 表的结构 `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `Employee_Id` varchar(20) CHARACTER SET utf8 NOT NULL,
  `Employee_Password` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Employee_Name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Employee_Authority` varchar(20) CHARACTER SET utf8 NOT NULL DEFAULT 'normal',
  `Employee_Department` varchar(40) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Employee_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `employee`
--

INSERT INTO `employee` (`Employee_Id`, `Employee_Password`, `Employee_Name`, `Employee_Authority`, `Employee_Department`) VALUES
('001', '001', 'zhao', 'advance', 'Construction'),
('002', '002', 'qian', 'normal', 'Automobile'),
('003', '003', 'sun', 'normal', 'Appliance'),
('004', '004', 'li', 'advance', 'Computer'),
('033', 'miao', '喵喵', 'advance', 'Computer');

-- --------------------------------------------------------

--
-- 表的结构 `expensive`
--

CREATE TABLE IF NOT EXISTS `expensive` (
  `Employee_ID` varchar(40) NOT NULL,
  `Tool_ID` varchar(40) NOT NULL,
  `Tool_Department` varchar(40) CHARACTER SET utf8 NOT NULL,
  `Borrow_Time` date NOT NULL,
  `Return_Time` date NOT NULL,
  PRIMARY KEY (`Employee_ID`,`Tool_ID`,`Tool_Department`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `inexpensive`
--

CREATE TABLE IF NOT EXISTS `inexpensive` (
  `Employee_ID` varchar(40) NOT NULL,
  `Tool_ID` varchar(40) NOT NULL,
  `Tool_Department` varchar(40) CHARACTER SET utf8 NOT NULL,
  `Borrow_Time` date NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'normal',
  PRIMARY KEY (`Employee_ID`,`Tool_ID`,`Tool_Department`,`Borrow_Time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `inexpensive`
--

INSERT INTO `inexpensive` (`Employee_ID`, `Tool_ID`, `Tool_Department`, `Borrow_Time`, `status`) VALUES
('001', '001', 'appliance', '2015-06-01', 'damage');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
