package pl.bestguilds.storage;

import java.sql.SQLException;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.storage.Storage;
import pl.bestguilds.api.storage.StorageException;
import pl.bestguilds.api.user.User;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Xierip on 2018-09-26.
 * Web: http://xierip.pl
 */
public class SQLiteStorage implements Storage {

  private final File       databaseFile;
  private       Connection connection;

  public SQLiteStorage(BestGuildsAPI plugin, String fileName) throws IOException {
    File dir = new File(plugin.getDataFolder(), "sqlite");
    dir.mkdirs();
    if (!fileName.toLowerCase().endsWith(".db")) {
      fileName += ".db";
    }
    databaseFile = new File(dir, fileName);
    if (!databaseFile.exists()) {
      databaseFile.createNewFile();
    }
  }

  @Override
  public void connect() throws StorageException {
    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:" + this.databaseFile.getPath());
      Statement statement = connection.createStatement();
      //TODO: CREATE TABLES
      ResultSet resultSet = statement.executeQuery("SELECT * FROM bestguilds_guilds");
      while (resultSet.next()) {
        //TODO: LOAD GUILDS
      }
      resultSet = statement.executeQuery("SELECT * FROM bestguilds_users");
      while (resultSet.next()) {
        //TODO: LOAD USERS
      }
      statement.close();
    } catch (SQLException | ClassNotFoundException exception) {
      throw new StorageException(exception);
    }
  }

  @Override
  public void disconnect() throws StorageException {
    try {
      connection.close();
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  public void update(User user, User.UpdateType type, Object... objects) {

  }

  @Override
  public void update(Guild guild, Guild.UpdateType type, Object... objects) {

  }
}
