package pl.bestguilds.guild;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.Guild.Builder;
import pl.bestguilds.api.guild.GuildMember;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GuildBuilder implements Guild.Builder {

    private @Nullable String tag;
    private @Nullable String name;
    private Set<GuildMember> members;
    private Set<Guild> allies;

    GuildBuilder() {
        this.members = new HashSet<>(1);
        this.allies = new HashSet<>(0);
    }

    @Override
    public Builder tag(@NotNull String tag) {
        this.tag = tag;
        return this;
    }

    @Override
    public Builder name(@NotNull String name) {
        this.name = name;
        return this;
    }

    @Override
    public Builder members(@NotNull Set<GuildMember> members) {
        this.members = members;
        return this;
    }

    @Override
    public Builder allies(@NotNull Set<Guild> allies) {
        this.allies = allies;
        return this;
    }

    @NotNull
    @Override
    public Guild build() {
        Objects.requireNonNull(this.tag);
        Objects.requireNonNull(this.name);

        return new GuildImpl(this.tag, this.name, this.members, this.allies);
    }
}
