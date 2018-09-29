package pl.bestguilds.bukkit.util;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.beans.ConstructorProperties;

public final class ChatColorUtil {

  private ChatColorUtil() { }

  @NotNull
  public static String colored(@NotNull String content) {
    return ChatColor.translateAlternateColorCodes('&', content);
  }

}
