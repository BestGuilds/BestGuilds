package pl.bestguilds.util;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public final class ChatColorUtil {

    private ChatColorUtil() {
    }

    @NotNull
    public static String colored(@NotNull String content) {
        return ChatColor.translateAlternateColorCodes('&', content);
    }
}
