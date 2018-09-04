package pl.bestguilds.guild;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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

  GuildImpl(String tag, String name) {
    this.tag = tag;
    this.name = name;
    this.members = ConcurrentHashMap.newKeySet();
  }

  @Override
  public @NotNull String getTag() {
    return tag;
  }

  @Override
  public @NotNull String getName() {
    return name;
  }

  @NotNull
  @Contract(" -> new")
  public static GuildBuilder builder() {
    return new GuildBuilder();
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

  @Override
  public int hashCode() {
    return Objects.hash(this.tag, this.name);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("tag", tag)
        .add("name", name)
        .toString();
  }
}
