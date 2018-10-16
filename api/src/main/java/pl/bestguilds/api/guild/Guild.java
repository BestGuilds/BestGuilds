package pl.bestguilds.api.guild;

import com.google.common.collect.ImmutableSet;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.User;

import java.util.Set;
import java.util.UUID;

public interface Guild {

    UUID getUUID();

    String getTag();

    String getName();

    GuildArea getArea();

    ImmutableSet<GuildMember> getMembers();

    void addMember(@NotNull GuildMember guildMember);

    void addMember(@NotNull User user);

    boolean isMember(@NotNull User user);

    ImmutableSet<Guild> getAllies();

    void addAlly(@NotNull Guild guild);

    boolean isAlly(@NotNull Guild guild);

    interface Builder extends pl.bestguilds.api.util.Builder<Guild> {

        Builder tag(@NotNull String tag);

        Builder name(@NotNull String name);

        Builder guildArea(@NotNull GuildArea area);

        Builder members(@NotNull Set<GuildMember> members);

        Builder allies(@NotNull Set<Guild> allies);
    }
}
