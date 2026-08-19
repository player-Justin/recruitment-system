-- 举报表：若数据库中缺少 report 表，在 MySQL 中执行本脚本即可（与 ReportMapper.xml 字段一致）
USE recruitment_system;

DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `reporter_id` int NOT NULL COMMENT '举报者用户ID',
  `enterprise_id` int NOT NULL COMMENT '被举报企业ID',
  `reply_form_admin` text COLLATE utf8mb4_unicode_ci COMMENT '管理员回复',
  `reason` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '举报原因',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='举报';
