package pl.bestguilds.util;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public final class ChatColorUtil {

    private ChatColorUtil() {
    }

    public static String colored(@NotNull String content) {
        return ChatColor.translateAlternateColorCodes('&', content);
    }
}
