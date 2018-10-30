CREATE TABLE IF NOT EXISTS `bestguilds_guilds` (
  `id`          INT AUTO_INCREMENT NOT NULL,
  `uuid`        BINARY(16)         NOT NULL,
  `tag`         VARCHAR(4)         NOT NULL,
  `name`        VARCHAR(32)        NOT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET = utf8;
