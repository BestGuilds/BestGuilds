package pl.bestguilds.statistics;

import com.google.common.base.MoreObjects;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.statistics.Statistics;

public class BaseStatistics implements Statistics {

  private float points;
  private int   kills;
  private int   deaths;
  private int   assists;

  BaseStatistics(float points, int kills, int deaths, int assists) {
    this.points = points;
    this.kills = kills;
    this.deaths = deaths;
    this.assists = assists;
  }

  public BaseStatistics() {
    this.points = 500; //TODO start points configuration
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
