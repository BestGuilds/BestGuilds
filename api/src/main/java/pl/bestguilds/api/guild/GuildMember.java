package pl.bestguilds.api.guild;

import pl.bestguilds.api.user.User;

public interface GuildMember {

  Guild getGuild();

  User getUser();
}
