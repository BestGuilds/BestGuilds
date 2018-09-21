package pl.bestguilds;

import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.bestguilds.api.BestGuildsAPI;

public final class BestGuilds {

  @Nullable
  private static BestGuildsAPI instance;

  private BestGuilds() {
  }

  static void setInstance(@NotNull BestGuildsAPI instance) {
    if (BestGuilds.instance != null) {
      BestGuilds.instance = instance;
    }
  }

  @Nullable
  @Contract(pure = true)
  public BestGuildsAPI get() {
    return instance;
  }

  @Contract(pure = true)
  public Optional<BestGuildsAPI> getSafe() {
    return Optional.ofNullable(instance);
  }
}
