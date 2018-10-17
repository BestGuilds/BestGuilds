package pl.bestguilds.guild;

import org.bukkit.Location;
import pl.bestguilds.api.guild.GuildArea;

public class GuildAreaImpl implements GuildArea {

    private final Location location;
    private int size;
    private Location home;

    GuildAreaImpl(final Location location) {
        this.location = location;
        this.home = location;
    }

    GuildAreaImpl(final Location location, Location home) {
        this.location = location;
        this.home = home;
    }

    @Override
    public Location getLocation() {
        return this.location;
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
        int x = loc.getBlockX();
        int z = loc.getBlockZ();

        int thisX = this.location.getBlockX();
        int thisZ = this.location.getBlockZ();

        return Math.abs(thisX - x) <= size && Math.abs(thisZ - z) <= size;
    }

    @Override
    public Location getHome() {
        return this.home;
    }

    @Override
    public void setHome(Location location) {
        this.home = location;
    }
}
