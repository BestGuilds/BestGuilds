package pl.bestguilds.guild;

import java.util.Objects;
import org.jetbrains.annotations.Nullable;
import pl.bestguilds.api.guild.Guild;
import pl.bestguilds.api.guild.Guild.Builder;

public class GuildBuilder implements Guild.Builder {

  private @Nullable String tag;
  private @Nullable String name;

  @Override
  public Builder tag(String tag) {
    this.tag = tag;

    return this;
  }

  @Override
  public Builder name(String name) {
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