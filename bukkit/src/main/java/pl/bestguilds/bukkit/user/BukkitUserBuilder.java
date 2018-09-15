package pl.bestguilds.bukkit.user;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.User;
import pl.bestguilds.bukkit.user.BukkitUser;
import pl.bestguilds.user.BestUserBuilder;

public class BukkitUserBuilder extends BestUserBuilder {

  BukkitUserBuilder() {
    super();
  }

  @NotNull
  @Override
  public User build() {
    Objects.requireNonNull(uuid);
    Objects.requireNonNull(name);
    Objects.requireNonNull(statistics);

    User user = new BukkitUser(uuid, name, statistics);

    if (guildMember != null)
      user.setGuildMember(guildMember);

    return user;
  }
}
