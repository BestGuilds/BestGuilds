package pl.bestguilds.user.statistic;

import pl.bestguilds.api.user.UserStatistics;
import pl.bestguilds.api.user.UserStatistics.Builder;

public class UserStatisticBuilder implements UserStatistics.Builder {

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

  @Override
  public UserStatistics build() {
    return new UserStatisticImpl(points, kills, deaths, assists);
  }
}
