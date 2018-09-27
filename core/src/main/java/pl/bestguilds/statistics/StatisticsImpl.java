package pl.bestguilds.statistics;

import com.google.common.base.MoreObjects;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.statistics.Statistics;

public class StatisticsImpl implements Statistics {

  private float points;
  private int   kills;
  private int   deaths;
  private int   assists;

  StatisticsImpl(float points, int kills, int deaths, int assists) {
    this.points = points;
    this.kills = kills;
    this.deaths = deaths;
    this.assists = assists;
  }

  public StatisticsImpl(@NotNull Statistics statistics) {
    this(statistics.getPoints(), statistics.getKills(), statistics.getDeaths(), statistics.getAssists());
  }

  @Override
  public float getPoints() {
    return points;
  }

  @Override
  public void setPoints(float points) {
    this.points = points;
  }

  @Override
  public int getKills() {
    return kills;
  }

  @Override
  public void setKills(int kills) {
    this.kills = kills;
  }

  @Override
  public int getDeaths() {
    return deaths;
  }

  @Override
  public void setDeaths(int deaths) {
    this.deaths = deaths;
  }

  @Override
  public int getAssists() {
    return assists;
  }

  @Override
  public void setAssists(int assists) {
    this.assists = assists;
  }

  @NotNull
  @Contract(" -> new")
  public static StatisticsBuilder statisticsBuilder() {
    return new StatisticsBuilder();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("points", points)
        .add("kills", kills)
        .add("deaths", deaths)
        .add("assists", assists)
        .toString();
  }
}
