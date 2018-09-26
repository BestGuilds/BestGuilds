package pl.bestguilds.storage;

import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;
import org.bson.Document;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.storage.Storage;
import pl.bestguilds.api.user.User;

/**
 * Created by Xierip on 2018-09-26.
 * Web: http://xierip.pl
 */
public class MongoDBStorage implements Storage {

  private final BestGuildsAPI plugin;
  private final String        mongoURL;
  private final String        mongoDatabase;

  private MongoClient               clientAsync;
  private MongoDatabase             databaseAsync;
  private MongoCollection<Document> usersAsync;
  private MongoCollection<Document> guildsAsync;

  private com.mongodb.client.MongoClient               client;
  private com.mongodb.client.MongoDatabase             database;
  private com.mongodb.client.MongoCollection<Document> users;
  private com.mongodb.client.MongoCollection<Document> guilds;

  public MongoDBStorage(BestGuildsAPI plugin, String mongoURL, String mongoDatabase) {
    this.plugin = plugin;
    this.mongoURL = mongoURL;
    this.mongoDatabase = mongoDatabase;
  }

  @Override
  public void connect() throws Exception {
    clientAsync = MongoClients.create(mongoURL);
    databaseAsync = clientAsync.getDatabase(mongoDatabase);
    usersAsync = databaseAsync.getCollection("bestguilds_users");
    guildsAsync = databaseAsync.getCollection("bestguilds_guilds");

    client = com.mongodb.client.MongoClients.create(mongoURL);
    database = client.getDatabase(mongoDatabase);
    users = database.getCollection("bestguilds_users");
    guilds = database.getCollection("bestguilds_guilds");
    for (Document document : users.find()) {
      //TODO: LOAD USERS
    }
    for (Document document : guilds.find()) {
      //TODO: LOAD GUILDS
    }
  }

  @Override
  public void disconnect() throws Exception {
    clientAsync.close();
    client.close();
  }

  @Override
  public void update(User user, User.UpdateType type, Object... objects) {

  }

  @Override
  public void update(Guild guild, Guild.UpdateType type, Object... objects) {

  }

}
