package pl.bestguilds.user;

import java.util.Objects;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.statistics.Statistics;
import pl.bestguilds.api.user.User;
import pl.bestguilds.api.user.User.Builder;

public class BestUserBuilder implements User.Builder {

  @Nullable
  protected UUID        uuid;
  @Nullable
  protected String      name;
  @Nullable
  protected Statistics  statistics;
  @Nullable
  protected GuildMember guildMember;

  protected BestUserBuilder() {
  }

  @Override
  public Builder uuid(@NotNull UUID uuid) {
    this.uuid = uuid;
    return this;
  }

  @Override
  public Builder name(@NotNull String name) {
    this.name = name;
    return this;
  }

  @Override
  public Builder statistics(@NotNull Statistics statistics) {
    this.statistics = statistics;
    return this;
  }

  @Override
  public Builder guildMember(@NotNull GuildMember guildMember) {
    this.guildMember = guildMember;
    return this;
  }

  @Override
  public final User build() {
    Objects.requireNonNull(uuid);
    Objects.requireNonNull(name);
    Objects.requireNonNull(statistics);

    User user = new BestUser(uuid, name, statistics);

    if (guildMember != null) {
      user.setGuildMember(guildMember);
    }

    return user;
  }
}
