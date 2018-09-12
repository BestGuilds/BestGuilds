package pl.bestguilds.guild;

import com.google.common.base.MoreObjects;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.user.User;

public class GuildMemberImpl implements GuildMember {

  private final Guild guild;
  private final User  user;

  GuildMemberImpl(@NotNull Guild guild, @NotNull User user) {
    this.guild = guild;
    this.user = user;
  }

  @Override
  public Guild getGuild() {
    return guild;
  }

  @Override
  public User getUser() {
    return user;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("guild", guild)
        .add("user", user)
        .toString();
  }
}
