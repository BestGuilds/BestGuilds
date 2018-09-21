package pl.bestguilds.user.statistics;

import pl.bestguilds.api.user.UserStatistics;
import pl.bestguilds.api.user.UserStatistics.Builder;

public class UserStatisticsBuilder implements UserStatistics.Builder {

  private float points;
  private int   kills;
  private int   deaths;
  private int   assists;

  UserStatisticsBuilder() {
    this.points = 500;
  }

  @Override
  public Builder points(float points) {
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
    return new UserStatisticsImpl(points, kills, deaths, assists);
  }
}
