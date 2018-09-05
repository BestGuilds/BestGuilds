package pl.bestguilds.user.statistic;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.UserStatistic;
import pl.bestguilds.api.user.UserStatistic.Builder;

public class UserStatisticBuilder implements UserStatistic.Builder {

  private int points;
  private int kills;
  private int deaths;
  private int assists;

  UserStatisticBuilder() {
    this.points = 500;
  }

  @Override
  public Builder points(int points) {
    this.points = points;
    return this;
  }

  @Override
  public Builder kills(int kills) {
    this.kills = kills;
    return this;
  }

  @Override
  public Builder deaths(int deaths) {
    this.deaths = deaths;
    return this;
  }

  @Override
  public Builder assists(int assists) {
    this.assists = assists;
    return this;
  }

  @NotNull
  @Override
  public UserStatistic build() {
    return new UserStatisticImpl(points, kills, deaths, assists);
  }
}
