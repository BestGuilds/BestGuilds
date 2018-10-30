package pl.bestguilds.api.guild.event;

import pl.bestguilds.api.event.BestEvent;
import pl.bestguilds.api.guild.Guild;

public abstract class GuildEvent extends BestEvent {

    protected final Guild guild;

    public GuildEvent(Guild guild) {
        this.guild = guild;
    }

    public Guild getGuild() {
        return guild;
    }
}
