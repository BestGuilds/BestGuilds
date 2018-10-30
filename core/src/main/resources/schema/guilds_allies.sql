CREATE TABLE IF NOT EXISTS `bestguilds_guilds_allies` (
  `id`          INT AUTO_INCREMENT NOT NULL,
  `guild_uuid`  BINARY(16)         NOT NULL,
  `guild2_uuid` BINARY(16)         NOT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET = utf8;
