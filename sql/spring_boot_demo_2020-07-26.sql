# ************************************************************
# Database: spring_boot_demo
# Generation Time: 2020-07-26 15:23:37 +0000
# ************************************************************

# Dump of table heartbeat
# ------------------------------------------------------------

DROP TABLE IF EXISTS `heartbeat`;

CREATE TABLE `heartbeat` (
  `app_id` varchar(32) DEFAULT 'default_id',
  `beat_num` bigint(20) unsigned DEFAULT '0',
  `last_beat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `app_start_time` timestamp NULL DEFAULT NULL,
  UNIQUE KEY `app_id_unique` (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table item
# ------------------------------------------------------------

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(11) unsigned NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  `product_date` datetime DEFAULT NULL,
  `add_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `item_order` (`order_id`),
  CONSTRAINT `item_order` FOREIGN KEY (`order_id`) REFERENCES `oorder` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table logistics
# ------------------------------------------------------------

DROP TABLE IF EXISTS `logistics`;

CREATE TABLE `logistics` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(11) unsigned NOT NULL,
  `company_name` varchar(128) DEFAULT NULL,
  `start_city` varchar(64) DEFAULT NULL,
  `target_city` varchar(64) DEFAULT NULL,
  `distance` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lg_order` (`order_id`),
  CONSTRAINT `lg_order` FOREIGN KEY (`order_id`) REFERENCES `oorder` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table oorder
# ------------------------------------------------------------

DROP TABLE IF EXISTS `oorder`;

CREATE TABLE `oorder` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(64) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `order_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `logistics_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
