package pl.bestguilds.user;

import com.google.common.base.MoreObjects;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.user.User;
import pl.bestguilds.api.user.UserStatistic;

public class UserImpl implements User {

  private final UUID          uuid;
  private final String        name;
  private final UserStatistic statistic;
  private       GuildMember   guildMember;

  UserImpl(@NotNull UUID uuid, @NotNull String name, @NotNull UserStatistic statistic) {
    this.uuid = uuid;
    this.name = name;
    this.statistic = statistic;
  }

  @Override
  public @NotNull UUID getUUID() {
    return uuid;
  }

  @Override
  public @NotNull String getName() {
    return name;
  }

  @Override
  public @NotNull UserStatistic getStatistic() {
    return statistic;
  }

  @Override
  public Optional<GuildMember> getGuildMember() {
    return Optional.ofNullable(guildMember);
  }

  @Override
  public void setGuildMember(@NotNull GuildMember guildMember) {
    this.guildMember = guildMember;
  }

  @NotNull
  @Contract(" -> new")
  public static UserBuilder builder() {
    return new UserBuilder();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof UserImpl)) {
      return false;
    }

    UserImpl that = (UserImpl) object;
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
        .add("statistic", statistic)
        .add("guild", guildMember)
        .toString();
  }
}
