package pl.bestguilds.bukkit.user;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Objects;
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

  private Reference<Player> playerReference;

  BukkitUser(UUID uuid, String name, UserStatistics statistics) {
    super(uuid, name, statistics);
    this.playerReference = new WeakReference<>(Bukkit.getPlayer(uuid));
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

  public void setPlayer(Player player) {
    this.playerReference = new WeakReference<>(player);
  }

  public final Optional<Player> getPlayer() {
    Player player = playerReference.get();

    if (player == null || !player.isOnline()) {
      return Optional.empty();
    }

    return Optional.of(player);
  }
}
