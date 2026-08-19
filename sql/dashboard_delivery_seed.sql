-- 管理端首页「职位投递排行」演示数据：已有库可单独执行本脚本更新投递量
UPDATE `job_position` SET `quantity_of_delivery` = CASE `id`
    WHEN 1 THEN 128
    WHEN 2 THEN 96
    WHEN 3 THEN 88
    WHEN 4 THEN 76
    WHEN 5 THEN 65
    WHEN 6 THEN 54
    WHEN 7 THEN 42
    WHEN 8 THEN 38
    WHEN 9 THEN 28
    WHEN 10 THEN 15
    ELSE `quantity_of_delivery`
END
WHERE `id` BETWEEN 1 AND 10;
