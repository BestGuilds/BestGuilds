package pl.bestguilds.guild.rank;

import com.google.common.base.MoreObjects;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.user.User;

public class GuildRankImpl implements GuildMember {

  private final Guild guild;
  private final User  user;

  public GuildRankImpl(Guild guild, User user) {
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