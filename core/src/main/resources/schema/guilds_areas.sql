CREATE TABLE IF NOT EXISTS `bestguilds_guilds_areas` (
  `id`          INT AUTO_INCREMENT NOT NULL,
  `uuid`        BINARY(16)         NOT NULL,
  `world_uuid`  BINARY(16)         NOT NULL,
  `x`           SMALLINT           NOT NULL,
  `z`           SMALLINT           NOT NULL,
  `size`        SMALLINT           NOT NULL,
  `home_x`      SMALLINT           NOT NULL,
  `home_y`      SMALLINT           NOT NULL,
  `home_z`      SMALLINT           NOT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET = utf8;
