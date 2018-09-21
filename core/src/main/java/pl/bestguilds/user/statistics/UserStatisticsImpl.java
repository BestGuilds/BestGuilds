package pl.bestguilds.user.statistics;

import com.google.common.base.MoreObjects;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.UserStatistics;

public class UserStatisticsImpl implements UserStatistics {

  private float points;
  private int kills;
  private int deaths;
  private int assists;

  UserStatisticsImpl(float points, int kills, int deaths, int assists) {
    this.points = points;
    this.kills = kills;
    this.deaths = deaths;
    this.assists = assists;
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
  public static UserStatisticsBuilder builder() {
    return new UserStatisticsBuilder();
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
