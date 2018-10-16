package pl.bestguilds.api.user;

import io.vavr.control.Option;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;
import org.bukkit.permissions.ServerOperator;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public interface BukkitUser extends ServerOperator {

    Option<Player> getPlayer();

    default void sendMessage(@NotNull String message) {
        getPlayer().forEach(player -> player.sendMessage(message));
    }

    default void sendMessage(String... messages) {
        Arrays.stream(messages).forEach(this::sendMessage);
    }

    default void sendMessage(BaseComponent... components) {
        getPlayer().forEach(player -> player.sendMessage(components));
    }

    @Override
    default boolean isOp() {
        return false;
    }

    @Override
    default void setOp(boolean value) {
        //meh
    }
}
