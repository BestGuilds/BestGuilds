package pl.bestguilds.guild;

import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.user.User;

public class GuildImpl implements Guild {

  private final UUID             uuid;
  private final String           tag;
  private final String           name;
  private final Set<GuildMember> members;
  private final Set<Guild>       allies;

  GuildImpl(String tag, String name, Set<GuildMember> members, Set<Guild> allies) {
    this.uuid = UUID.nameUUIDFromBytes(("guild: " + tag + "-" + name).getBytes(Charsets.UTF_8));
    this.tag = tag;
    this.name = name;
    this.members = members;
    this.allies = allies;
  }

  @NotNull
  @Contract(" -> new")
  public static GuildBuilder builder() {
    return new GuildBuilder();
  }

  @Override
  public UUID getUUID() {
    return uuid;
  }

  @Override
  public String getTag() {
    return tag;
  }

  @Override
  public String getName() {
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
    addMember(new GuildMemberImpl(this, user));
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
    return this.uuid.equals(that.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.uuid, this.tag, this.name, this.members, this.allies);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("uuid", uuid)
        .add("tag", tag)
        .add("name", name)
        .add("members", members)
        .add("allies", allies)
        .toString();
  }
}
