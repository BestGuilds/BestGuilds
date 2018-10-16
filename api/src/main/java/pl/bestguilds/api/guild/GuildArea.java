package pl.bestguilds.api.guild;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public interface GuildArea {

    Location getLocation();

    int getSize();

    void setSize(int size);

    boolean constants(Location location);

    Location getHome();

    void setHome(@NotNull Location location);
}
