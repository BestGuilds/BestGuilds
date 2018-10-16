package pl.bestguilds.api.user;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;

public interface BukkitUser {

    Optional<Player> getPlayer();

    default void sendMessage(@NotNull String message) {
        getPlayer().ifPresent(player -> player.sendMessage(message));
    }

    default void sendMessage(String... messages) {
        Arrays.stream(messages).forEach(this::sendMessage);
    }

    default void sendMessage(BaseComponent... components) {
        getPlayer().ifPresent(player -> player.sendMessage(components));
    }
}
