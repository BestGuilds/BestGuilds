package pl.bestguilds.api.guild;

import org.bukkit.Location;
import org.bukkit.World;

public interface GuildArea {

    Location getLocation();

    World getWorld();

    int getSize();

    void setSize(int size);

    boolean constants(Location location);

    Location getHome();

    void setHome(Location location);
}
