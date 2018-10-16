package pl.bestguilds.guild;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.Guild.Builder;
import pl.bestguilds.api.guild.GuildArea;
import pl.bestguilds.api.guild.GuildMember;

import java.util.Objects;

public class GuildBuilder implements Guild.Builder {

    private @Nullable String tag;
    private @Nullable String name;
    private @Nullable GuildArea area;
    private Set<GuildMember> members;
    private Set<Guild> allies;

    GuildBuilder() {
        this.members = HashSet.empty();
        this.allies = HashSet.empty();
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
    public Builder guildArea(@NotNull GuildArea area) {
        this.area = area;
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
        Objects.requireNonNull(this.area);

        return new GuildImpl(this.tag, this.name, this.area, this.members, this.allies);
    }
}
