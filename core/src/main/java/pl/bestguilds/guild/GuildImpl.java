package pl.bestguilds.guild;

import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import io.vavr.collection.HashSet;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.GuildArea;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.user.User;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class GuildImpl implements Guild {

    private final UUID uuid;
    private final String tag;
    private final String name;
    private final GuildArea area;

    private final Set<GuildMember> members;
    private final Set<Guild> allies;

    GuildImpl(String tag, String name, GuildArea area, Set<GuildMember> members, Set<Guild> allies) {
        this.uuid = UUID.nameUUIDFromBytes(("guild: " + tag + "-" + name).getBytes(Charsets.UTF_8));
        this.tag = tag;
        this.name = name;
        this.area = area;
        this.members = members;
        this.allies = allies;
    }

    public static GuildBuilder builder() {
        return new GuildBuilder();
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }

    @Override
    public String getTag() {
        return this.tag;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public GuildArea getArea() {
        return this.area;
    }

    @Override
    public void addMember(@NotNull GuildMember guildMember) {
        this.members.add(guildMember);
    }

    @Override
    public void addMember(@NotNull User user) {
        addMember(new GuildMemberImpl(this, user));
    }

    @Override
    public boolean isMember(@NotNull User user) {
        return getMembers().forAll(guildMember -> guildMember.getUser().equals(user));
    }

    @Override
    public io.vavr.collection.Set<GuildMember> getMembers() {
        return HashSet.ofAll(this.members);
    }

    @Override
    public void addAlly(@NotNull Guild guild) {
        this.allies.add(guild);
    }

    @Override
    public boolean isAlly(@NotNull Guild guild) {
        return getAllies().contains(guild);
    }

    @Override
    public io.vavr.collection.Set<Guild> getAllies() {
        return HashSet.ofAll(this.allies);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof GuildImpl)) {
            return false;
        }

        GuildImpl that = (GuildImpl) object;
        return this.uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.uuid, this.tag, this.area, this.name, this.members, this.allies);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("uuid", this.uuid)
                .add("tag", this.tag)
                .add("name", this.name)
                .add("area", this.area)
                .add("members", this.members)
                .add("allies", this.allies)
                .toString();
    }
}
