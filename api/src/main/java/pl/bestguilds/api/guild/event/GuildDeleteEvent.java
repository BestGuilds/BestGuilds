package pl.bestguilds.api.guild.event;

import pl.bestguilds.api.guild.Guild;

public class GuildDeleteEvent extends GuildEvent {

    public GuildDeleteEvent(Guild guild) {
        super(guild);
    }
}
