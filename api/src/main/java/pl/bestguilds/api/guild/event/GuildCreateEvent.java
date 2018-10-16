package pl.bestguilds.api.guild.event;

import pl.bestguilds.api.guild.Guild;

public class GuildCreateEvent extends GuildEvent {

    public GuildCreateEvent(Guild guild) {
        super(guild);
    }
}
