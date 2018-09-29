package pl.bestguilds.user;

import com.google.common.base.MoreObjects;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.statistics.Statistics;
import pl.bestguilds.api.user.User;
import pl.bestguilds.statistics.StatisticsImpl;

public abstract class BestUser extends StatisticsImpl implements User {

  protected final UUID        uuid;
  private final   String      name;
  private final   Statistics  statistics;
  private         GuildMember guildMember;

  public BestUser(UUID uuid, String name, Statistics statistics) {
    super(statistics);
    this.uuid = uuid;
    this.name = name;
    this.statistics = statistics;
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
  public Statistics getStatistics() {
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
    return Objects.hash(uuid, name, statistics, guildMember);
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
