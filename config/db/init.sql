use blog;

CREATE TABLE `article` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(25) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `content` longtext,
  `comment_amount` int(5) DEFAULT NULL,
  `category` varchar(25) DEFAULT NULL,
  `tag` varchar(50) DEFAULT NULL,
  `updated_date` datetime,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `comments` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `article_id` int(5) NOT NULL,
  `is_top` char(1) NOT NULL,
  `parent_comment_id` int(5) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(25) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

