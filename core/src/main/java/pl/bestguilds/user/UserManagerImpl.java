package pl.bestguilds.user;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.User;
import pl.bestguilds.api.user.UserManager;
import pl.bestguilds.util.Iterables;

public class UserManagerImpl implements UserManager {

    private final ConcurrentMap<UUID, User> userMap = new ConcurrentHashMap<>();

    @Override
    public Optional<User> getUser(@NotNull final UUID uuid) {
        return Optional.ofNullable(this.userMap.get(uuid));
    }

    @Override
    public Optional<User> getUser(@NotNull final String name) {
        return Iterables.find(getUsers(), user -> user.getName().equalsIgnoreCase(name));
    }

    @Override
    public Collection<User> getUsers() {
        return Collections.unmodifiableCollection(this.userMap.values());
    }
}