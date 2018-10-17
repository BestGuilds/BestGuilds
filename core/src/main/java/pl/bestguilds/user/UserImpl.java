package pl.bestguilds.user;

import com.google.common.base.MoreObjects;
import io.vavr.control.Option;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.GuildMember;
import pl.bestguilds.api.statistics.Statistics;
import pl.bestguilds.api.user.User;
import pl.bestguilds.statistics.BaseStatistics;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.UUID;

public class UserImpl extends BaseStatistics implements User {

    private final UUID uuid;
    private final String name;
    private final Statistics statistics;
    private GuildMember guildMember;
    private Reference<Player> playerReference;

    UserImpl(UUID uuid, String name, Statistics statistics) {
        this.uuid = uuid;
        this.name = name;
        this.statistics = statistics;
    }

    UserImpl(@NotNull Player player) {
        this(player.getUniqueId(), player.getName(), new BaseStatistics());
        this.playerReference = new WeakReference<>(player);
    }

    @NotNull
    @Contract(" -> new")
    public static User.Builder builder() {
        return new UserBuilder();
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Statistics getStatistics() {
        return statistics;
    }

    @Override
    public Option<GuildMember> getGuildMember() {
        return Option.of(guildMember);
    }

    @Override
    public void setGuildMember(@NotNull GuildMember guildMember) {
        this.guildMember = guildMember;
    }

    @Override
    public Option<Player> getPlayer() {
        return Option.of(playerReference.get())
                .orElse(() -> Option.of(Bukkit.getPlayer(uuid))
                        .peek(this::setPlayer));
    }

    public void clearPlayerReference() {
        this.playerReference.clear();
    }

    public void setPlayer(Player player) {
        this.playerReference = new WeakReference<>(player);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof UserImpl)) {
            return false;
        }

        UserImpl that = (UserImpl) object;
        return this.uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.uuid, this.name, this.statistics, this.guildMember);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("uuid", this.uuid)
                .add("name", this.name)
                .add("statistics", this.statistics)
                .add("guildMember", this.guildMember)
                .toString();
    }
}
