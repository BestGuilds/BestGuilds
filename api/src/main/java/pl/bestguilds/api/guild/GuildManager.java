package pl.bestguilds.api.guild;

import io.vavr.control.Option;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.manager.Manager;

import java.util.UUID;

public interface GuildManager extends Manager<Guild> {

    default Option<Guild> getGuildById(UUID uuid) {
        return getValue(uuid);
    }

    default Option<Guild> getGuildByTag(String tag) {
        return findSafe(guild -> guild.getTag().equalsIgnoreCase(tag));
    }

    default Option<Guild> getGuildByName(String name) {
        return findSafe(guild -> guild.getName().equalsIgnoreCase(name));
    }

    default Option<Guild> getGuildByLocation(@NotNull Location location) {
        return findSafe(guild -> guild.getArea().constants(location));
    }

    default void addGuild(Guild guild) {
        addValue(guild.getUUID(), guild);
    }

    default void removeGuild(Guild guild) {
        removeValue(guild.getUUID());
    }
}
