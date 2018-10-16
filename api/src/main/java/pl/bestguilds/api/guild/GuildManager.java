package pl.bestguilds.api.guild;

import io.vavr.control.Option;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.manager.Manager;

public interface GuildManager extends Manager<Guild> {

    default Option<Guild> getGuildByTag(@NotNull String tag) {
        return findSafe(guild -> guild.getTag().equalsIgnoreCase(tag));
    }

    default Option<Guild> getGuildByName(@NotNull String name) {
        return findSafe(guild -> guild.getName().equalsIgnoreCase(name));
    }

    default Option<Guild> getGuildByLocation(@NotNull Location location) {
        return findSafe(guild -> guild.getArea().constants(location));
    }
}
