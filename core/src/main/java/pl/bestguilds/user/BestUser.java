package pl.bestguilds.user;

import com.google.common.base.MoreObjects;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.user.User;
import pl.bestguilds.api.user.UserStatistics;

public abstract class BestUser implements User {

  private final UUID           uuid;
  private final String         name;
  private final UserStatistics statistics;
  private       GuildMember    guildMember;

  public BestUser(UUID uuid, String name, UserStatistics statistic) {
    this.uuid = uuid;
    this.name = name;
    this.statistics = statistic;
  }

  @Override
  public UUID getUUID() {
    return uuid;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public UserStatistics getStatistics() {
    return statistics;
  }

  @Override
  public Optional<GuildMember> getGuildMember() {
    return Optional.ofNullable(guildMember);
  }

  @Override
  public void setGuildMember(@NotNull GuildMember guildMember) {
    this.guildMember = guildMember;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof BestUser)) {
      return false;
    }

    BestUser that = (BestUser) object;
    return this.uuid.equals(that.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.uuid, this.name);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("uuid", uuid)
        .add("name", name)
        .add("statistics", statistics)
        .add("guild", guildMember)
        .toString();
  }
}
