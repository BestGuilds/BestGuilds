package pl.bestguilds.api.storage;

import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.user.User;

public interface Storage {

  void connect() throws Exception;

  void disconnect() throws Exception;

  void update(User user, User.UpdateType type, Object... objects);

  void update(Guild guild, Guild.UpdateType type, Object... objects);

}
