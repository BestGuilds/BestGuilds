package pl.bestguilds.user;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.manager.BaseManager;
import pl.bestguilds.api.user.User;
import pl.bestguilds.api.user.UserManager;

public class UserManagerImpl extends BaseManager<User> implements UserManager {

    public UserManagerImpl(BestGuildsAPI plugin) {
        super(plugin);
    }

    @Override
    public User getUser(@NotNull Player player) {
        return this.map.computeIfAbsent(player.getUniqueId(), uuid -> new UserImpl(player));
    }
}
