package pl.bestguilds.user;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.User;
import pl.bestguilds.api.user.UserManager;
import pl.bestguilds.util.Iterables;

public class UserManagerImpl implements UserManager {

  private final ConcurrentMap<UUID, User> userMap;

  public UserManagerImpl() {
    userMap = new ConcurrentHashMap<>();
  }

  @Override
  public Optional<User> getUser(@NotNull UUID uuid) {
    return Optional.ofNullable(this.userMap.get(uuid));
  }

  @Override
  public Optional<User> getUser(@NotNull String name) {
    return Iterables.find(getUsers(), user -> user.getName().equalsIgnoreCase(name));
  }

  @Override
  public ImmutableSet<User> getUsers() {
    return ImmutableSet.copyOf(this.userMap.values());
  }
}
