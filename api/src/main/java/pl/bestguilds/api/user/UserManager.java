package pl.bestguilds.api.user;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.manager.Manager;

import java.util.Optional;

public interface UserManager extends Manager<User> {

    User getUser(@NotNull Player player);

    default Optional<User> getUser(@NotNull String name) {
        return findSafe(guild -> guild.getName().equalsIgnoreCase(name));
    }
}
