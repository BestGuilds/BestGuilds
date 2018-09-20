package pl.bestguilds.api.util;

import org.jetbrains.annotations.NotNull;

public final class NumberUtil {

  private NumberUtil() {
  }

  public static int parseInt(@NotNull String content) throws NumberFormatException {
    return Integer.parseInt(content);
  }

  public static long parseLong(@NotNull String content) throws NumberFormatException {
    return Long.parseLong(content);
  }

  public static double parseDouble(@NotNull String content) throws NumberFormatException {
    return Double.parseDouble(content);
  }
}
