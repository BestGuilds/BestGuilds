CREATE TABLE IF NOT EXISTS `bestguilds_users` (
  `id`          INT AUTO_INCREMENT NOT NULL,
  `uuid`        BINARY(16)         NOT NULL,
  `name`        VARCHAR(16)        NOT NULL,
  `points`      FLOAT              DEFAULT 500,
  `kills`       SMALLINT           DEFAULT 0,
  `deaths`      SMALLINT           DEFAULT 0,
  `assists`     SMALLINT           DEFAULT 0,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET = utf8;
