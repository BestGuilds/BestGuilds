package pl.bestguilds.guild;

import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.api.manager.BaseManager;

public class GuildManagerImpl extends BaseManager<Guild> implements GuildManager {

    public GuildManagerImpl(BestGuildsAPI plugin) {
        super(plugin);
    }
}
