package pl.bestguilds.api.guild.event;

import pl.bestguilds.api.guild.Guild;

public class GuildCreatedEvent extends GuildEvent {

    public GuildCreatedEvent(Guild guild) {
        super(guild);
    }
}
