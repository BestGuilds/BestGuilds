package pl.bestguilds.statistics;

import pl.bestguilds.api.statistics.Statistics;
import pl.bestguilds.api.statistics.Statistics.Builder;

public class StatisticsBuilder implements Statistics.Builder {

  private float points;
  private int   kills;
  private int   deaths;
  private int   assists;

  StatisticsBuilder() {
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
  public Statistics build() {
    return new StatisticsImpl(points, kills, deaths, assists);
  }
}
