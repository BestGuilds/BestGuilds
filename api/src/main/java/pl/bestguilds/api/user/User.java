package pl.bestguilds.api.user;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;

public interface User {

  @NotNull
  UUID getUUID();

}