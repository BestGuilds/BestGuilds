package pl.bestguilds.api.guild;

import org.bukkit.Location;

public interface GuildArea {

    Location getLocation();

    int getSize();

    void setSize(int size);

    boolean constants(Location location);

    Location getHome();

    void setHome(Location location);
}
