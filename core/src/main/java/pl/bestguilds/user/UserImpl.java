package pl.bestguilds.user;

import com.google.common.base.MoreObjects;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.user.User;

public class UserImpl implements User {

  private final UUID   uuid;
  private final String name;
  private       Guild  guild;

  public UserImpl(UUID uuid, String name) {
    this.uuid = uuid;
    this.name = name;
  }

  @Override
  public @NotNull UUID getUUID() {
    return uuid;
  }

  @Override
  public @NotNull String getName() {
    return name;
  }

  @Override
  public Optional<Guild> getGuild() {
    return Optional.ofNullable(guild);
  }

  @Override
  public void setGuild(Guild guild) {
    this.guild = guild;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.uuid, this.name);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("uuid", uuid)
        .add("name", name)
        .add("guild", guild)
        .toString();
  }
}