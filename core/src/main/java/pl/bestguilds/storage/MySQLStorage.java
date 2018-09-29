package pl.bestguilds.storage;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.storage.Storage;
import pl.bestguilds.api.storage.StorageException;
import pl.bestguilds.api.user.User;

/**
 * Created by Xierip on 2018-09-26.
 * Web: http://xierip.pl
 */
public class MySQLStorage implements Storage {

  private final BestGuildsAPI    plugin;
  private final HikariConfig     hikariConfig;
  private       HikariDataSource hikariDataSource;

  public MySQLStorage(BestGuildsAPI plugin, HikariConfig hikariConfig) {

    this.plugin = plugin;
    this.hikariConfig = hikariConfig;
  }

  @Override
  public void connect() throws StorageException {
    hikariDataSource = new HikariDataSource(hikariConfig);

    try {
      Statement statement = hikariDataSource.getConnection().createStatement();
      //TODO: CREATE TABLES
      ResultSet resultSet = statement.executeQuery("SELECT * FROM bestguilds_guilds");
      while (resultSet.next()) {
        //TODO: LOAD GUILDS
      }
      resultSet = statement.executeQuery("SELECT * FROM bestguilds_users");
      while (resultSet.next()) {
        //TODO: LOAD USERS
      }
    } catch (SQLException exception) {
      throw new StorageException(exception);
    }
  }

  @Override
  public void disconnect() throws StorageException {
    hikariDataSource.close();
  }

  @Override
  public void update(User user, User.UpdateType type, Object... objects) {

  }

  @Override
  public void update(Guild guild, Guild.UpdateType type, Object... objects) {

  }
}
