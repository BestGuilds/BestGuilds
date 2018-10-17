package pl.bestguilds.api.user;

import io.vavr.control.Option;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.manager.Manager;

import java.util.UUID;

public interface UserManager extends Manager<User> {

    User getUser(@NotNull Player player);

    default Option<User> getUser(UUID uuid) {
        return getValue(uuid);
    }

    default Option<User> getUser(String name) {
        return findSafe(guild -> guild.getName().equalsIgnoreCase(name));
    }
}
