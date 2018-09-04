package pl.bestguilds;

import java.util.Objects;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.bestguilds.api.BestGuildsAPI;

public final class BestGuilds {

  @Nullable
  private static BestGuildsAPI instance = null;

  private BestGuilds() {
  }

  static void setInstance(@NotNull BestGuildsAPI instance) {
    BestGuilds.instance = instance;
  }

  @Contract(pure = true)
  public BestGuildsAPI get() {
    Objects.requireNonNull(instance, "instance");

    return instance;
  }
}