package pl.bestguilds.api.statistics;

import java.util.Comparator;
import pl.bestguilds.api.statistics.Statistics.StatisticsComparator.Type;

public interface Statistics {

  float getPoints();

  void setPoints(float points);

  int getKills();

  void setKills(int kills);

  int getDeaths();

  void setDeaths(int deaths);

  int getAssists();

  void setAssists(int assists);

  static <T extends Statistics> Comparator<T> getComparator(Type type) {
    return StatisticsComparator.compare(type);
  }

  class StatisticsComparator {

    static <T extends Statistics> Comparator<T> compare(Type type) {
      return (stats1, stats2) -> {
        switch (type) {
          case POINTS:
            return (int) (stats2.getPoints() - stats1.getPoints());
          case KILLS:
            return (int) (stats2.getKills() - stats1.getKills());
          case DEATHS:
            return (int) (stats2.getDeaths() - stats1.getDeaths());
          case ASSISTS:
            return (int) (stats2.getAssists() - stats1.getAssists());
        }
        return 0;
      };
    }

    public enum Type {
      POINTS,
      KILLS,
      DEATHS,
      ASSISTS,
      ;
    }
  }

  interface Builder extends pl.bestguilds.api.util.Builder<Statistics> {

    Builder points(float points);

    Builder kills(int kills);

    Builder deaths(int deaths);

    Builder assists(int assists);
  }
}
