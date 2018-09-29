package pl.bestguilds.bukkit.user;

import pl.bestguilds.api.user.User;
import pl.bestguilds.user.BestUserBuilder;

import java.util.Objects;

public class BukkitUserBuilder extends BestUserBuilder {

  BukkitUserBuilder() {
    super();
  }

  @Override
  public final User build() {
    Objects.requireNonNull(uuid);
    Objects.requireNonNull(name);
    Objects.requireNonNull(statistics);

    User user = new BukkitUser(uuid, name, statistics);

    if (guildMember != null) {
      user.setGuildMember(guildMember);
    }

    return user;
  }
}
