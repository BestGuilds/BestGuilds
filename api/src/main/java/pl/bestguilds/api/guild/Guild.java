package pl.bestguilds.api.guild;

import io.vavr.collection.Set;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.User;

import java.util.UUID;

public interface Guild {

    UUID getUUID();

    String getTag();

    String getName();

    GuildArea getArea();

    Set<GuildMember> getMembers();

    void addMember(@NotNull GuildMember guildMember);

    void addMember(@NotNull User user);

    boolean isMember(@NotNull User user);

    Set<Guild> getAllies();

    void addAlly(@NotNull Guild guild);

    boolean isAlly(@NotNull Guild guild);

    interface Builder extends pl.bestguilds.api.util.Builder<Guild> {

        Builder tag(@NotNull String tag);

        Builder name(@NotNull String name);

        Builder guildArea(@NotNull GuildArea area);

        Builder members(@NotNull java.util.Set<GuildMember> members);

        Builder allies(@NotNull java.util.Set<Guild> allies);
    }
}
