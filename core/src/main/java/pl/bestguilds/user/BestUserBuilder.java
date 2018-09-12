package pl.bestguilds.user;

import java.util.Objects;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.user.User;
import pl.bestguilds.api.user.User.Builder;
import pl.bestguilds.api.user.UserStatistic;

public abstract class BestUserBuilder implements User.Builder {

  @Nullable
  protected UUID          uuid;
  @Nullable
  protected String        name;
  @Nullable
  protected UserStatistic statistic;
  @Nullable
  protected GuildMember   guildMember;

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
  public Builder statistic(@NotNull UserStatistic statistic) {
    this.statistic = statistic;
    return this;
  }

  @Override
  public Builder guildRank(@NotNull GuildMember guildMember) {
    this.guildMember = guildMember;
    return this;
  }
}
