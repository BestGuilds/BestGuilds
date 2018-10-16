package pl.bestguilds.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.user.User;
import pl.bestguilds.api.user.event.UserQuitEvent;
import pl.bestguilds.user.UserImpl;

public class PlayerQuitListener implements Listener {

    private final BestGuildsAPI plugin;

    public PlayerQuitListener(BestGuildsAPI plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onQuit(PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        final User user = this.plugin.getUserManager().getUser(player);

        final UserImpl userImpl = (UserImpl) user;
        userImpl.setPlayer(null);

        Bukkit.getPluginManager().callEvent(new UserQuitEvent(user));
    }
}
