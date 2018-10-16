package pl.bestguilds.api.user;

import io.vavr.control.Option;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.statistics.Statistics;

import java.util.UUID;

public interface User extends BukkitUser, Statistics {

    UUID getUUID();

    String getName();

    Statistics getStatistics();

    Option<GuildMember> getGuildMember();

    void setGuildMember(@NotNull GuildMember guild);

    interface Builder extends pl.bestguilds.api.util.Builder<User> {

        Builder uuid(@NotNull UUID uuid);

        Builder name(@NotNull String name);

        Builder statistics(@NotNull Statistics statistics);

        Builder guildMember(@NotNull GuildMember guild);
    }
}
