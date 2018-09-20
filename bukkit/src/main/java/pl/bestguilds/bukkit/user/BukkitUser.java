package pl.bestguilds.bukkit.user;

import java.util.Optional;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.UserStatistics;
import pl.bestguilds.user.BestUser;
import pl.bestguilds.user.BestUserBuilder;
import pl.bestguilds.bukkit.util.ChatColorUtil;

public class BukkitUser extends BestUser {

  BukkitUser(UUID uuid, String name, UserStatistics statistics) {
    super(uuid, name, statistics);
  }

  @NotNull
  @Contract(" -> new")
  public static BestUserBuilder builder() {
    return new BukkitUserBuilder();
  }

  @Override
  public void sendMessage(@NotNull String content) {
    getPlayer().ifPresent(player -> player.sendMessage(ChatColorUtil.colored(content)));
  }

  private Optional<Player> getPlayer() {
    return Optional.ofNullable(Bukkit.getPlayer(this.getUUID()));
  }
}
