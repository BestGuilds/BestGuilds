package pl.bestguilds.api.guild;

import com.google.common.collect.ImmutableSet;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.User;

import java.util.Set;

public interface Guild {

  String getTag();

  String getName();

  ImmutableSet<GuildMember> getMembers();

  void addMember(@NotNull GuildMember guildMember);

  void addMember(@NotNull User user);

  boolean isMember(@NotNull User user);

  ImmutableSet<Guild> getAllies();

  void addAlly(@NotNull Guild guild);

  boolean isAlly(@NotNull Guild guild);

  public enum UpdateType {}

  interface Builder extends pl.bestguilds.api.util.Builder<Guild> {

    Builder tag(@NotNull String tag);

    Builder name(@NotNull String name);

    Builder members(@NotNull Set<GuildMember> members);

    Builder allies(@NotNull Set<Guild> allies);
  }
}
