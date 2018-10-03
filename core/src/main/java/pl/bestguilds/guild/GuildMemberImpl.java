package pl.bestguilds.guild;

import com.google.common.base.MoreObjects;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.user.User;

import java.util.Objects;

public class GuildMemberImpl implements GuildMember {

    private final Guild guild;
    private final User user;

    GuildMemberImpl(@NotNull Guild guild, @NotNull User user) {
        this.guild = guild;
        this.user = user;
    }

    @Override
    public Guild getGuild() {
        return guild;
    }

    @Override
    public User getUser() {
        return user;
    }

    //TODO guild hierarchy

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof GuildMemberImpl)) {
            return false;
        }

        GuildMemberImpl that = (GuildMemberImpl) object;
        return this.user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guild, user);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("guild", guild)
                .add("user", user)
                .toString();
    }
}
