package pl.bestguilds.guild;

import com.google.common.collect.ImmutableSet;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.util.IdentifyMap;
import pl.bestguilds.util.IdentifyMap.IdentifyHashMap;

import java.util.Optional;

public class GuildManagerImpl implements GuildManager {

    private final IdentifyMap<Guild> guildMap;

    public GuildManagerImpl() {
        this.guildMap = new IdentifyHashMap<>();
    }

    @Override
    public Optional<Guild> getGuildByTag(@NotNull String tag) {
        return this.guildMap.findSafe(guild -> guild.getTag().equalsIgnoreCase(tag));
    }

    @Override
    public Optional<Guild> getGuildByName(@NotNull String name) {
        return this.guildMap.findSafe(guild -> guild.getName().equalsIgnoreCase(name));
    }

    @Override
    public ImmutableSet<Guild> getGuilds() {
        return ImmutableSet.copyOf(guildMap.values());
    }
}
