package pl.bestguilds.api.util;

import org.jetbrains.annotations.NotNull;

public final class NumberUtil {

  private NumberUtil() {
  }

  public static int parseInt(@NotNull String content) throws NumberFormatException {
    try {
      return Integer.parseInt(content);
    } catch (NumberFormatException exception) {
      throw new NumberFormatException(exception.getMessage());
    }
  }

  public static long parseLong(@NotNull String content) throws NumberFormatException {
    try {
      return Long.parseLong(content);
    } catch (NumberFormatException exception) {
      throw new NumberFormatException(exception.getMessage());
    }
  }

  public static double parseDouble(@NotNull String content) throws NumberFormatException {
    try {
      return Double.parseDouble(content);
    } catch (NumberFormatException exception) {
      throw new NumberFormatException(exception.getMessage());
    }
  }

  public static float parseFloat(@NotNull String content) throws NumberFormatException {
    try {
      return Float.parseFloat(content);
    } catch (NumberFormatException exception) {
      throw new NumberFormatException(exception.getMessage());
    }
  }
}
