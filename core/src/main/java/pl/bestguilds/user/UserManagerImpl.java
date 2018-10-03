package pl.bestguilds.user;

import com.google.common.collect.ImmutableSet;
import java.util.Optional;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.User;
import pl.bestguilds.api.user.UserManager;
import pl.bestguilds.util.IdentifyMap;
import pl.bestguilds.util.IdentifyMap.IdentifyHashMap;

public class UserManagerImpl implements UserManager {

  private final IdentifyMap<User> userMap;

  public UserManagerImpl() {
    userMap = new IdentifyHashMap<>();
  }

  @Override
  public Optional<User> getUser(@NotNull UUID uuid) {
    return this.userMap.getSafe(uuid);
  }

  @Override
  public Optional<User> getUser(@NotNull String name) {
    return this.userMap.findSafe(user -> user.getName().equalsIgnoreCase(name));
  }

  @Override
  public ImmutableSet<User> getUsers() {
    return ImmutableSet.copyOf(this.userMap.values());
  }
}
