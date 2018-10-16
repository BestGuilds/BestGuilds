package pl.bestguilds.api.user;

import io.vavr.control.Option;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.manager.Manager;

public interface UserManager extends Manager<User> {

    User getUser(@NotNull Player player);

    default Option<User> getUser(@NotNull String name) {
        return findSafe(guild -> guild.getName().equalsIgnoreCase(name));
    }
}
