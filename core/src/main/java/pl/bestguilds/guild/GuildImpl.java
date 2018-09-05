package pl.bestguilds.guild;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.user.User;
import pl.bestguilds.guild.rank.GuildRankImpl;

public class GuildImpl implements Guild {

  private final String           tag;
  private final String           name;
  private final Set<GuildMember> members;
  private final Set<Guild>       allies;

  GuildImpl(String tag, String name, Set<GuildMember> members, Set<Guild> allies) {
    this.tag = tag;
    this.name = name;
    this.members = members;
    this.allies = allies;
  }

  @Override
  public @NotNull String getTag() {
    return tag;
  }

  @Override
  public @NotNull String getName() {
    return name;
  }

  @Override
  public ImmutableSet<GuildMember> getMembers() {
    return ImmutableSet.copyOf(this.members);
  }

  @Override
  public void addMember(@NotNull GuildMember guildMember) {
    this.members.add(guildMember);
  }

  @Override
  public void addMember(@NotNull User user) {
    addMember(new GuildRankImpl(this, user));
  }

  @NotNull
  @Contract(" -> new")
  public static GuildBuilder builder() {
    return new GuildBuilder();
  }

  @Override
  public boolean isMember(@NotNull User user) {
    return getMembers().stream().anyMatch(member -> member.getUser().equals(user));
  }

  @Override
  public ImmutableSet<Guild> getAllies() {
    return ImmutableSet.copyOf(allies);
  }

  @Override
  public void addAlly(@NotNull Guild guild) {
    allies.add(guild);
  }

  @Override
  public boolean isAlly(@NotNull Guild guild) {
    return getAllies().stream().anyMatch(g -> g.equals(guild));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof GuildImpl)) {
      return false;
    }

    GuildImpl that = (GuildImpl) object;
    return this.tag.equals(that.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tag, this.name);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("tag", tag)
        .add("name", name)
        .add("members", members)
        .add("allies", allies)
        .toString();
  }
}
