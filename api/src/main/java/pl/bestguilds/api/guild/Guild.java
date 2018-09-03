package pl.bestguilds.api.guild;

import org.jetbrains.annotations.NotNull;

public interface Guild {

  @NotNull
  String getTag();

  @NotNull
  String getName();

  interface Builder extends javafx.util.Builder<Guild> {

    Builder tag(String tag);

    Builder name(String name);
  }
}