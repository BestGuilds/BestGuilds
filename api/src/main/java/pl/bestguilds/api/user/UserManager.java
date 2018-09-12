package pl.bestguilds.api.user;

import com.google.common.collect.ImmutableSet;
import java.util.Optional;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

public interface UserManager {

  Optional<User> getUser(@NotNull UUID uuid);

  Optional<User> getUser(@NotNull String name);

  ImmutableSet<User> getUsers();
}
