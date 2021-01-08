CREATE TABLE `stations` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `road_id` bigint NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `trains` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `owner_name` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  `speed_limit` varchar(45) DEFAULT NULL,
  `number` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `schedules` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `train_id` int unsigned NOT NULL,
  `station_order` int NOT NULL,
  `station_id` int unsigned NOT NULL,
  `arrival_time` datetime DEFAULT NULL,
  `departure_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `train_idx` (`train_id`),
  KEY `station_idx` (`station_id`),
  CONSTRAINT `station` FOREIGN KEY (`station_id`) REFERENCES `stations` (`id`),
  CONSTRAINT `train` FOREIGN KEY (`train_id`) REFERENCES `trains` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `passengers` (
  `id` int unsigned NOT NULL,
  `version` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `second_name` varchar(45) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `station_connections` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `station_id_from` int unsigned NOT NULL,
  `station_id_to` int unsigned NOT NULL,
  `distance` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `from_idx` (`station_id_from`),
  KEY `to_idx` (`station_id_to`),
  CONSTRAINT `from` FOREIGN KEY (`station_id_from`) REFERENCES `stations` (`id`),
  CONSTRAINT `to` FOREIGN KEY (`station_id_to`) REFERENCES `stations` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `tickets` (
  `id` int unsigned NOT NULL,
  `purchase_time` datetime DEFAULT NULL,
  `seat_id` varchar(45) DEFAULT NULL,
  `passanger_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `tickets_history` (
  `id` int unsigned NOT NULL,
  `ticket_purchase_time` datetime DEFAULT NULL,
  `ticket_id` varchar(45) DEFAULT NULL,
  `train_number` varchar(45) DEFAULT NULL,
  `carriage_number` varchar(45) DEFAULT NULL,
  `seat_number` varchar(45) DEFAULT NULL,
  `passanger_name` varchar(45) DEFAULT NULL,
  `passanger_second_name` varchar(45) DEFAULT NULL,
  `passanger_birth_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci