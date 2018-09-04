package pl.bestguilds.api.user;

public interface UserStatistic {

  int getPoints();

  void setPoints(int points);

  int getKills();

  void setKills(int kills);

  int getDeaths();

  void setDeaths(int deaths);

  int getAssists();

  void setAssists(int assists);

  interface Builder extends pl.bestguilds.api.util.Builder<UserStatistic> {

    Builder points(int points);

    Builder kills(int kills);

    Builder deaths(int deaths);

    Builder assists(int assists);
  }
}
