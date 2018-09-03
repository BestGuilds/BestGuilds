package pl.bestguilds.guild;

import com.google.common.base.MoreObjects;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.guild.Guild;

public class GuildImpl implements Guild {

  private final String tag;
  private final String name;

  public GuildImpl(String tag, String name) {
    this.tag = tag;
    this.name = name;
  }

  @Override
  public @NotNull String getTag() {
    return tag;
  }

  @Override
  public @NotNull String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tag, this.name);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("tag", tag)
        .add("name", name)
        .toString();
  }
}