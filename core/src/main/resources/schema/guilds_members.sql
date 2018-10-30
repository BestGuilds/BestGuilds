CREATE TABLE IF NOT EXISTS `bestguilds_guilds_members` (
  `id`              INT AUTO_INCREMENT NOT NULL,
  `uuid`            BINARY(16)         NOT NULL,
  `guild_uuid`      BINARY(16)         NOT NULL,
  `guild_rank_id`   TINYINT            NOT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET = utf8;
