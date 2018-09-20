package pl.bestguilds.api.user;

public interface UserStatistics {

  int getPoints();

  void setPoints(int points);

  int getKills();

  void setKills(int kills);

  int getDeaths();

  void setDeaths(int deaths);

  int getAssists();

  void setAssists(int assists);

  interface Builder extends pl.bestguilds.api.util.Builder<UserStatistics> {

    Builder points(int points);

    Builder kills(int kills);

    Builder deaths(int deaths);

    Builder assists(int assists);
  }
}
