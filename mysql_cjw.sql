/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : cjw

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2016-02-26 10:25:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cid` int(12) NOT NULL AUTO_INCREMENT,
  `cname` char(30) NOT NULL,
  `credit` int(4) DEFAULT NULL,
  `c_time` char(30) DEFAULT NULL,
  `c_details` char(100) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=2020 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('2001', 'Java基础', '32', 'Monday', '学习java基础知识123');
INSERT INTO `course` VALUES ('2002', 'Servlet', '2', 'q', '3001授课&3002授课');
INSERT INTO `course` VALUES ('2003', 'JSP', '1', 's', 'p');
INSERT INTO `course` VALUES ('2004', 'MySQL', '2', '3', '4');
INSERT INTO `course` VALUES ('2005', 'Spring', '32', '3', '4');
INSERT INTO `course` VALUES ('2015', 'ws', '22', 'today', '2');
INSERT INTO `course` VALUES ('2016', '2', '11', 'Monday', '333');
INSERT INTO `course` VALUES ('2017', '11111', '12', '22222', '3');
INSERT INTO `course` VALUES ('2018', '22222222222', '1', '2222222222222', null);
INSERT INTO `course` VALUES ('2019', 'tfryugiugy', null, 'kjlkjutuytuy', '2');

-- ----------------------------
-- Table structure for `c_t`
-- ----------------------------
DROP TABLE IF EXISTS `c_t`;
CREATE TABLE `c_t` (
  `ctid` int(12) NOT NULL AUTO_INCREMENT,
  `cid` int(12) NOT NULL,
  `tid` int(12) NOT NULL,
  PRIMARY KEY (`ctid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_t
-- ----------------------------
INSERT INTO `c_t` VALUES ('1', '2001', '3001');
INSERT INTO `c_t` VALUES ('2', '2002', '3002');
INSERT INTO `c_t` VALUES ('3', '2003', '3003');
INSERT INTO `c_t` VALUES ('4', '2004', '3004');
INSERT INTO `c_t` VALUES ('5', '2005', '3005');
INSERT INTO `c_t` VALUES ('24', '2015', '3003');
INSERT INTO `c_t` VALUES ('29', '2016', '3005');
INSERT INTO `c_t` VALUES ('31', '2017', '3006');
INSERT INTO `c_t` VALUES ('32', '2018', '3007');
INSERT INTO `c_t` VALUES ('33', '2019', '3009');
INSERT INTO `c_t` VALUES ('34', '2002', '3001');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(12) NOT NULL AUTO_INCREMENT,
  `sname` char(30) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1001', '学生一');
INSERT INTO `student` VALUES ('1002', '学生二');
INSERT INTO `student` VALUES ('1003', '学生三');
INSERT INTO `student` VALUES ('1004', '学生四');
INSERT INTO `student` VALUES ('1005', '学生五');
INSERT INTO `student` VALUES ('1007', '测试名2');

-- ----------------------------
-- Table structure for `s_c_t`
-- ----------------------------
DROP TABLE IF EXISTS `s_c_t`;
CREATE TABLE `s_c_t` (
  `scid` int(12) NOT NULL AUTO_INCREMENT,
  `sid` int(12) NOT NULL,
  `cid` int(12) NOT NULL,
  `tid` int(12) DEFAULT NULL,
  PRIMARY KEY (`scid`),
  KEY `s-c_ibfk_s` (`sid`),
  KEY `s-c_ibfk_c` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_c_t
-- ----------------------------
INSERT INTO `s_c_t` VALUES ('101', '1001', '2001', '3001');
INSERT INTO `s_c_t` VALUES ('103', '1002', '2001', '3001');
INSERT INTO `s_c_t` VALUES ('104', '1002', '2003', '3003');
INSERT INTO `s_c_t` VALUES ('105', '1003', '2004', '3004');
INSERT INTO `s_c_t` VALUES ('112', '1005', '2002', '3001');
INSERT INTO `s_c_t` VALUES ('114', '1001', '2004', '3004');
INSERT INTO `s_c_t` VALUES ('115', '1001', '2005', '3005');
INSERT INTO `s_c_t` VALUES ('118', '1001', '2002', '3002');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` int(12) NOT NULL AUTO_INCREMENT,
  `tname` char(30) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=3011 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('3001', '教师一');
INSERT INTO `teacher` VALUES ('3002', '教师二');
INSERT INTO `teacher` VALUES ('3003', '教师三');
INSERT INTO `teacher` VALUES ('3004', 'cs');
INSERT INTO `teacher` VALUES ('3005', 's5');
INSERT INTO `teacher` VALUES ('3006', '06');
INSERT INTO `teacher` VALUES ('3007', '3007');
INSERT INTO `teacher` VALUES ('3008', '3008');
INSERT INTO `teacher` VALUES ('3009', '3009');
INSERT INTO `teacher` VALUES ('3010', '3010');
