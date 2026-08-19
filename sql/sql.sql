-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: recruitment_system
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--
USE recruitment_system;
DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
                         `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                         `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名称',
                         `password` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
                         `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
                         `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
                         `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
                         `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
                         `status` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态',
                         `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` VALUES (1,'admin','123456','管理员','http://localhost:1000/file/8826e8c280cb3bec6a4fbeb61514ee74.png','123456','123456@qq.com','启用','2024-12-07 09:29:35');

--
-- Table structure for table `advertising`
--

DROP TABLE IF EXISTS `advertising`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `advertising` (
                               `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                               `position` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '位置',
                               `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
                               `link` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '链接',
                               `main_img` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '封面图',
                               `sort` int NOT NULL COMMENT '排序',
                               `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='广告位';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertising`
--

INSERT INTO `advertising` VALUES (1,'轮播图右上','2','jobPositionDetail/10','http://localhost:1000/file/e5dfaf5e260179c1fad63d4accc94d95.webp',2,'2025-04-06 16:20:22');
INSERT INTO `advertising` VALUES (2,'轮播图右下','1','jobPositionDetail/10','http://localhost:1000/file/62237e188b991be9bfdc40fc9890c4d2.webp',1,'2025-04-06 16:20:36');

--
-- Table structure for table `application_record`
--

DROP TABLE IF EXISTS `application_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application_record` (
                                      `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                      `user_id` int NOT NULL COMMENT '用户ID',
                                      `resume_id` int NOT NULL COMMENT '简历ID',
                                      `job_position_id` int NOT NULL COMMENT '职位ID',
                                      `enterprise_id` int NOT NULL COMMENT '企业ID',
                                      `status` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '审核状态',
                                      `feedback` text COLLATE utf8mb4_unicode_ci COMMENT '企业反馈信息',
                                      `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='投递记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_record`
--

INSERT INTO `application_record` VALUES (6,1,1,1,1,'已安排面试',NULL,'2025-04-05 16:26:11');
INSERT INTO `application_record` VALUES (7,1,1,1,1,'已拒绝','经验太少了','2025-04-05 16:34:27');
INSERT INTO `application_record` VALUES (8,1,1,1,1,'已拒绝','21312','2025-04-06 04:50:16');
INSERT INTO `application_record` VALUES (9,1,1,1,1,'已安排面试',NULL,'2025-04-06 04:50:25');
INSERT INTO `application_record` VALUES (10,1,1,1,1,'待处理',NULL,'2025-04-06 04:50:52');
INSERT INTO `application_record` VALUES (11,1,1,1,1,'待处理',NULL,'2025-04-06 04:51:01');
INSERT INTO `application_record` VALUES (12,1,1,2,1,'待处理',NULL,'2025-04-06 15:10:59');
INSERT INTO `application_record` VALUES (13,1,1,10,10,'待处理',NULL,'2025-04-08 12:55:19');
INSERT INTO `application_record` VALUES (14,1,1,10,10,'待处理',NULL,'2025-04-08 12:56:51');
INSERT INTO `application_record` VALUES (15,1,1,10,10,'待处理',NULL,'2025-04-08 12:56:56');
INSERT INTO `application_record` VALUES (16,1,1,3,3,'待处理',NULL,'2025-04-08 12:57:00');

--
-- Table structure for table `enterprise`
--

DROP TABLE IF EXISTS `enterprise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enterprise` (
                              `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                              `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
                              `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
                              `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '昵称',
                              `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '头像',
                              `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话',
                              `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
                              `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态',
                              `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
                              `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '社会信用代码',
                              `industry` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属行业 ',
                              `scale` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '规模',
                              `nature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性质',
                              `founding_year` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '成立年份',
                              `address` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '地址',
                              `intro` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '简介',
                              `audit_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '审核状态',
                              `review_comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核意见',
                              `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='企业';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enterprise`
--

INSERT INTO `enterprise` VALUES (1,'tech_company1','password123','科技巨头','http://localhost:1000/file/73007b192c9cf880dabbc8070e51a795.png','13800138001','contact@tech.com','启用','云创科技有限公司','91310101MA1FPX1234','互联网','1000人以上','民营企业','2010','上海市浦东新区张江高科技园区','国内领先的云计算服务提供商','审核通过',NULL,'2025-04-07 16:11:11');
INSERT INTO `enterprise` VALUES (2,'finance_group','securepass','金融大师','http://localhost:1000/file/73007b192c9cf880dabbc8070e51a795.png','13800138002','info@finance.com','启用','金诚金融服务集团','91310101MA1FPX1235','金融','500-999人','上市公司','2005','北京市朝阳区建国路88号','综合性金融解决方案供应商','审核通过',NULL,'2025-04-07 16:11:11');
INSERT INTO `enterprise` VALUES (3,'health_care','health123','健康守护','http://localhost:1000/file/73007b192c9cf880dabbc8070e51a795.png','13800138003','service@health.com','启用','仁爱医疗健康有限公司','91310101MA1FPX1236','医疗健康','100-499人','外资企业','2015','广州市天河区珠江新城','高端私立医疗连锁机构','审核通过',NULL,'2025-04-07 16:11:11');
INSERT INTO `enterprise` VALUES (4,'edu_tech','edupass','未来教育','http://localhost:1000/file/73007b192c9cf880dabbc8070e51a795.png','13800138004','contact@edu.com','启用','启明教育科技','91310101MA1FPX1237','教育','50-99人','民营企业','2018','深圳市南山区科技园','STEAM教育课程研发机构','审核通过',NULL,'2025-04-07 16:11:11');
INSERT INTO `enterprise` VALUES (5,'auto_tech','autopass','智驱未来','http://localhost:1000/file/73007b192c9cf880dabbc8070e51a795.png','13800138005','info@auto.com','启用','华夏智能汽车技术','91310101MA1FPX1238','汽车制造','1000人以上','合资企业','2008','武汉市经济技术开发区','新能源汽车研发制造企业','审核通过',NULL,'2025-04-07 16:11:11');
INSERT INTO `enterprise` VALUES (6,'green_energy','greenpass','绿能先锋','http://localhost:1000/file/73007b192c9cf880dabbc8070e51a795.png','13800138006','contact@green.com','启用','阳光新能源发展','91310101MA1FPX1239','新能源','100-499人','民营企业','2012','成都市高新区','光伏发电系统集成商','审核通过','材料不全','2025-04-07 16:11:11');
INSERT INTO `enterprise` VALUES (7,'logistics_co','logipass','速达物流','http://localhost:1000/file/73007b192c9cf880dabbc8070e51a795.png','13800138007','service@logi.com','启用','九州速运物流','91310101MA1FPX1240','物流','500-999人','民营企业','2007','天津市滨海新区','全国AAAA级物流企业','审核通过',NULL,'2025-04-07 16:11:11');
INSERT INTO `enterprise` VALUES (8,'media_group','mediapass','星河传媒','http://localhost:1000/file/73007b192c9cf880dabbc8070e51a795.png','13800138008','info@media.com','启用','星河文化传媒集团','91310101MA1FPX1241','传媒','100-499人','外资企业','2014','杭州市西湖区','短视频内容制作与IP运营','审核通过',NULL,'2025-04-07 16:11:11');
INSERT INTO `enterprise` VALUES (9,'ai_tech','aipass123','智算未来','http://localhost:1000/file/73007b192c9cf880dabbc8070e51a795.png','13800138009','contact@ai.com','启用','深蓝人工智能研究院','91310101MA1FPX1242','人工智能','50-99人','民营企业','2019','西安市高新区','计算机视觉算法研发机构','审核通过',NULL,'2025-04-07 16:11:11');
INSERT INTO `enterprise` VALUES (10,'fashion_co','fashion123','风尚中国','http://localhost:1000/file/73007b192c9cf880dabbc8070e51a795.png','13800138010','info@fashion.com','启用','东方时尚服饰集团','91310101MA1FPX1243','服装','1000人以上','上市公司','2003','南京市建邺区','本土高端女装品牌运营商','审核通过',NULL,'2025-04-07 16:11:11');

--
-- Table structure for table `interview_record`
--

DROP TABLE IF EXISTS `interview_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interview_record` (
                                    `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                    `user_id` int NOT NULL COMMENT '用户',
                                    `resume_id` int NOT NULL COMMENT '简历',
                                    `job_position_id` int NOT NULL COMMENT '职位',
                                    `enterprise_id` int NOT NULL COMMENT '企业',
                                    `subscribe_time` timestamp NOT NULL COMMENT '预约时间',
                                    `remark` text COLLATE utf8mb4_unicode_ci COMMENT '备注',
                                    `status` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态',
                                    `feedback` text COLLATE utf8mb4_unicode_ci COMMENT '企业反馈信息',
                                    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='面试记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview_record`
--

INSERT INTO `interview_record` VALUES (1,1,1,1,1,'2025-04-16 16:00:00','12312','已录取','可以，非常好','2025-04-05 17:11:42');
INSERT INTO `interview_record` VALUES (2,1,1,1,1,'2025-04-10 16:00:00','312312','已录取','31321','2025-04-06 04:51:23');

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
                          `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `reporter_id` int NOT NULL COMMENT '举报者用户ID',
                          `enterprise_id` int NOT NULL COMMENT '被举报企业ID',
                          `reply_form_admin` text COLLATE utf8mb4_unicode_ci COMMENT '管理员回复',
                          `reason` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '举报原因',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='举报';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `job_position`
--

DROP TABLE IF EXISTS `job_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_position` (
                                `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
                                `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '类型',
                                `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '工作城市',
                                `work_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '具体工作地址',
                                `experience_required` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '经验要求',
                                `education_required` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学历要求',
                                `responsibilities` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '职责要求',
                                `enterprise_id` int NOT NULL COMMENT '所著企业',
                                `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `salary_range` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '薪资范围',
                                `quantity_of_delivery` int NOT NULL DEFAULT '0' COMMENT '投递量',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='职位';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_position`
--

INSERT INTO `job_position` VALUES (1,'Java开发工程师','全职','上海','上海市浦东新区张江高科技园区','3-5年','本科','负责云平台后端系统开发',1,'2025-04-07 16:11:11','20k-35k',128);
INSERT INTO `job_position` VALUES (2,'财务分析师','兼职','北京','北京市朝阳区建国路88号','5年以上','硕士','金融机构业务数据分析',2,'2025-04-07 16:11:11','25k-40k',96);
INSERT INTO `job_position` VALUES (3,'护士长','实习','广州','广州市天河区珠江新城','5-8年','大专','护理团队管理与质控',3,'2025-04-07 16:11:11','15k-22k',88);
INSERT INTO `job_position` VALUES (4,'教育产品经理','全职','深圳','深圳市南山区科技园','3-5年','本科','STEAM课程体系设计',4,'2025-04-07 16:11:11','18k-30k',76);
INSERT INTO `job_position` VALUES (5,'电池系统工程师','全职','武汉','武汉市经济技术开发区','3-5年','硕士','新能源汽车电池包研发',5,'2025-04-07 16:11:11','22k-35k',65);
INSERT INTO `job_position` VALUES (6,'光伏项目经理','全职','成都','成都市高新区','5年以上','本科','太阳能电站EPC管理',6,'2025-04-07 16:11:11','20k-32k',54);
INSERT INTO `job_position` VALUES (7,'冷链物流专员','兼职','天津','天津市滨海新区','1-3年','大专','生鲜冷链运输管理',7,'2025-04-07 16:11:11','8k-15k',42);
INSERT INTO `job_position` VALUES (8,'短视频编导','全职','杭州','杭州市西湖区','2-5年','本科','短视频内容策划制作',8,'2025-04-07 16:11:11','12k-25k',38);
INSERT INTO `job_position` VALUES (9,'算法科学家','全职','西安','西安市高新区','5年以上','博士','深度学习算法研发',9,'2025-04-07 16:11:11','35k-60k',28);
INSERT INTO `job_position` VALUES (10,'服装打版师','全职','南京','南京市建邺区','3-5年','大专','服装工艺版型设计',10,'2025-04-07 16:11:11','10k-18k',15);

--
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resume` (
                          `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
                          `full_Name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
                          `gender` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '性别',
                          `birth_date` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '出生日期',
                          `phone_number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '联系电话',
                          `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '联系邮箱',
                          `expected_position` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '期望职位',
                          `expected_salary` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '期望薪资',
                          `resume_url` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '简历文件的URL',
                          `education_experience` text COLLATE utf8mb4_unicode_ci COMMENT '教育经历',
                          `work_experience` text COLLATE utf8mb4_unicode_ci COMMENT '工作经历',
                          `project_experience` text COLLATE utf8mb4_unicode_ci COMMENT '项目经验',
                          `skills` text COLLATE utf8mb4_unicode_ci COMMENT '技能',
                          `user_id` int NOT NULL COMMENT '用户ID',
                          `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='简历';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

INSERT INTO `resume` VALUES (1,'简历1','小黄','男','1998-01-01','13888888888','123456@qq.com','Java开发工程师','10-15K','http://localhost:1000/file/3d1dd04e1a334aca770421dea69eff9c.png','<ol><li style=\"text-align: start;\">2015年9月 - 2019年6月，[大学名称]，[专业名称]，本科主修课程：高等数学、大学物理、[专业核心课程1]、[专业核心课程2]、[专业核心课程3]等，成绩优异，多次获得奖学金。参加[专业相关社团]，担任[职务]，组织并参与多次社团活动，锻炼了团队协作和组织能力。参与[专业相关科研项目]，在导师指导下，负责[具体任务]，通过实验和数据分析，为项目提供了有价值的参考。</li><li style=\"text-align: start;\">2019年9月 - 2022年6月，[大学名称]，[专业名称]，硕士研究生研究方向：[具体方向]，深入学习[专业前沿知识]，掌握了[研究方法]，在[期刊名称]发表论文[论文题目]。参加[学术会议名称]，与国内外同行交流学术成果，拓宽了学术视野。担任[助教]，协助导师指导本科生课程，提升了教学能力和专业知识的传授能力。</li><li style=\"text-align: start;\">2022年9月 - 2025年6月，[大学名称]，[专业名称]，博士研究生（预计2025年毕业）研究课题：[课题名称]，运用[研究方法]，对[研究对象]进行深入研究，取得了一系列创新性成果。参与[国际合作项目]，与[合作国家]的科研团队合作，负责[具体任务]，提升了国际交流和合作能力。担任[学生会干部]，组织并参与多项校园活动，培养了领导力和团队协作能力。</li></ol>','<ol><li style=\"text-align: start;\">2020年7月 - 2020年9月，[公司名称1]，[实习岗位]参与[项目名称]，负责[具体任务]，通过[工具或方法]，提高了项目的效率和质量。协助团队完成[工作任务]，与同事密切合作，积累了团队协作经验。学习公司的业务流程和企业文化，了解行业动态，为未来的职业发展奠定了基础。</li><li style=\"text-align: start;\">2022年7月 - 2023年6月，[公司名称2]，[岗位名称]负责[产品或服务]的开发与维护，运用[技术或工具]，优化了产品的性能和用户体验。独立完成[项目名称]，从需求分析到项目交付，全程把控项目进度和质量，提升了项目管理能力。与客户进行沟通和协调，了解客户需求，为客户提供解决方案，提高了客户满意度。</li><li style=\"text-align: start;\">2023年7月 - 至今，[公司名称3]，[岗位名称]担任[团队负责人]，领导团队完成多个重要项目，提升了团队的凝聚力和战斗力。推动[业务流程优化]，通过引入[新技术或方法]，提高了工作效率和业务质量。参与公司战略规划，为公司的业务发展提供决策支持，提升了战略思维能力。</li></ol>','<ol><li style=\"text-align: start;\">[项目名称1]（2021年1月 - 2021年6月）项目背景：[项目背景描述]项目目标：[项目目标描述]项目成果：成功开发了[产品或服务]，满足了客户的需求，获得了客户的高度评价。个人贡献：负责[具体任务]，运用[技术或工具]，解决了[技术难题]，为项目的成功做出了重要贡献。</li><li style=\"text-align: start;\">[项目名称2]（2022年7月 - 2022年12月）项目背景：[项目背景描述]项目目标：[项目目标描述]项目成果：通过[方法或手段]，提高了[业务指标]，为公司创造了显著的经济效益。个人贡献：作为[团队成员]，与团队成员密切合作，完成了[具体任务]，确保了项目的顺利进行。</li><li style=\"text-align: start;\">[项目名称3]（2024年1月 - 2024年6月）项目背景：[项目背景描述]项目目标：[项目目标描述]项目成果：优化了[业务流程]，提高了工作效率和质量，得到了公司领导的认可。个人贡献：担任[项目负责人]，负责项目的整体规划和实施，协调各方资源，确保了项目的按时交付。</li></ol>','<ol><li style=\"text-align: start;\">编程语言：熟练掌握[编程语言1]、[编程语言2]、[编程语言3]，能够运用其进行软件开发和数据分析。</li><li style=\"text-align: start;\">软件工具：熟练使用[办公软件名称]、[设计软件名称]、[项目管理软件名称]等工具，提高工作效率和质量。</li><li style=\"text-align: start;\">专业技能：具备[专业技能1]、[专业技能2]、[专业技能3]等专业技能，能够解决相关领域的技术问题。</li></ol>',1,'2025-03-03 15:15:07');
INSERT INTO `resume` VALUES (2,'3123','123','男','2025-04-16','312','312','3123','12312','http://localhost:1000/file/8da5e9c7dc7c4d4a9c6c0909ef2b69b3.jpg','<p>312312</p>',NULL,'<p>312</p>','<p>312312</p>',1,'2025-04-08 14:23:19');

--
-- Table structure for table `slideshow`
--

DROP TABLE IF EXISTS `slideshow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slideshow` (
                             `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                             `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
                             `main_img` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '封面图',
                             `link` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '链接',
                             `sort` int NOT NULL COMMENT '排序',
                             `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='轮播图';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slideshow`
--

INSERT INTO `slideshow` VALUES (1,'2','http://localhost:1000/file/e34f438f402c120b001fc5050e2f0a33.webp','jobPositionDetail/10',2,'2025-04-05 14:28:43');
INSERT INTO `slideshow` VALUES (2,'1','http://localhost:1000/file/08faeb08c67c0ffcec2c8dba67a6f615.webp','jobPositionDetail/10',1,'2025-04-05 14:28:51');

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                        `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
                        `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
                        `nickname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '昵称',
                        `avatar_url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '头像',
                        `tel` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话',
                        `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
                        `status` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态',
                        `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='普通用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

INSERT INTO `user` VALUES (1,'u1','123456','用户1','http://localhost:1000/file/8826e8c280cb3bec6a4fbeb61514ee74.png',NULL,NULL,'启用','2025-03-02 15:49:13');
INSERT INTO `user` VALUES (2,'u2','123456','用户2','http://localhost:1000/file/8826e8c280cb3bec6a4fbeb61514ee74.png',NULL,NULL,'启用','2025-04-08 14:27:12');
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-08 22:43:54
