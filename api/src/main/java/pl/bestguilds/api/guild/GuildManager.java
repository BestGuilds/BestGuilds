package pl.bestguilds.api.guild;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.manager.Manager;

import java.util.Optional;

public interface GuildManager extends Manager<Guild> {

    default Optional<Guild> getGuildByTag(@NotNull String tag) {
        return findSafe(guild -> guild.getTag().equalsIgnoreCase(tag));
    }

    default Optional<Guild> getGuildByName(@NotNull String name) {
        return findSafe(guild -> guild.getName().equalsIgnoreCase(name));
    }

    default Optional<Guild> getGuildByLocation(@NotNull Location location) {
        return findSafe(guild -> guild.getArea().constants(location));
    }
}
