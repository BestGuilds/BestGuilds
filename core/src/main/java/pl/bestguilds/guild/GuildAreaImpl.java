package pl.bestguilds.guild;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.World;
import pl.bestguilds.api.guild.GuildArea;

import java.lang.ref.WeakReference;

public class GuildAreaImpl implements GuildArea {

    private final Location location;
    private final WeakReference<World> world;
    private Location home;
    private int size;

    public GuildAreaImpl(Location location, Location home) {
        this.location = location;
        this.home = home;
        this.world = new WeakReference<>(location.getWorld());
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public World getWorld() {
        return this.world.get();
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean constants(Location loc) {
        final int x = loc.getBlockX();
        final int z = loc.getBlockZ();

        return Math.abs(this.location.getBlockX() - x) <= size
                && Math.abs(this.location.getBlockX() - z) <= size;
    }

    @Override
    public Location getHome() {
        return this.home;
    }

    @Override
    public void setHome(Location location) {
        Validate.isTrue(!constants(location), "Cannot set the home outside the guild area!");
        this.home = location;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof GuildAreaImpl)) {
            return false;
        }

        GuildAreaImpl that = (GuildAreaImpl) object;
        return this.location.equals(that.location)
                && this.home.equals(that.home)
                && this.size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.location, this.world, this.home, this.size);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("location", this.location)
                .add("size", this.size)
                .add("home", this.home)
                .toString();
    }
}