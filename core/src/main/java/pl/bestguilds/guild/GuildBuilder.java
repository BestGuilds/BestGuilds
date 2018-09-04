package pl.bestguilds.guild;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.Guild.Builder;

public class GuildBuilder implements Guild.Builder {

  private @Nullable String tag;
  private @Nullable String name;

  GuildBuilder() {
  }

  @Override
  public Builder tag(@NotNull String tag) {
    this.tag = tag;
    return this;
  }

  @Override
  public Builder name(@NotNull String name) {
    this.name = name;
    return this;
  }

  @Override
  public Guild build() {
    Objects.requireNonNull(tag);
    Objects.requireNonNull(name);

    return new GuildImpl(tag, name);
  }
}
