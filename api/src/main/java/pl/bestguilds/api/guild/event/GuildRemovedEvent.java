package pl.bestguilds.api.guild.event;

import pl.bestguilds.api.guild.Guild;

public class GuildRemovedEvent extends GuildEvent {

    public GuildRemovedEvent(Guild guild) {
        super(guild);
    }
}
