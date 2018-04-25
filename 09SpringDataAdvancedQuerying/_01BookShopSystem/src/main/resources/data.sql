DROP PROCEDURE IF EXISTS `usp_get_books_count_by_author_name`;

-- CREATE PROCEDURE `usp_get_books_count_by_author_name` (
-- IN `f_name` VARCHAR(50),
-- `l_name` VARCHAR(50))
--    SELECT COUNT(`b`.`id`) AS `books_count`
--    FROM `authors` AS `a`
--    JOIN `books` AS `b`
--    ON `a`.`id` = `b`.`author_id`
--    WHERE `a`.`first_name` = `f_name`
--    AND `a`.`last_name` = `l_name`;
