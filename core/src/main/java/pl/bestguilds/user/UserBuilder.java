package pl.bestguilds.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.statistics.Statistics;
import pl.bestguilds.api.user.User;
import pl.bestguilds.api.user.User.Builder;

import java.util.Objects;
import java.util.UUID;

public class UserBuilder implements User.Builder {

    private @Nullable UUID uuid;
    private @Nullable String name;
    private @Nullable Statistics statistics;
    private @Nullable GuildMember guildMember;

    UserBuilder() {
    }

    @Override
    public Builder uuid(@NotNull UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public Builder name(@NotNull String name) {
        this.name = name;
        return this;
    }

    @Override
    public Builder statistics(@NotNull Statistics statistics) {
        this.statistics = statistics;
        return this;
    }

    @Override
    public Builder guildMember(@NotNull GuildMember guildMember) {
        this.guildMember = guildMember;
        return this;
    }

    @Override
    public User build() {
        Objects.requireNonNull(this.uuid);
        Objects.requireNonNull(this.name);
        Objects.requireNonNull(this.statistics);

        User user = new UserImpl(this.uuid, this.name, this.statistics);

        if (this.guildMember != null) {
            user.setGuildMember(this.guildMember);
        }

        return user;
    }
}
