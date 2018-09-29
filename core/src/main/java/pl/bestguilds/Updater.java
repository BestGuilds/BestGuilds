package pl.bestguilds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProxySelector;
import java.net.URI;

import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Updater {

  private static final String GITHUB_URL = "https://raw.githubusercontent.com/BestGuilds/BestGuilds/master/version.txt";

  private Updater() {
  }

  public static void checkVersion(final Logger logger, final String version) {
    URL url;

    try {
      url = new URL(GITHUB_URL);
    } catch (MalformedURLException exception) {
      throw new IllegalArgumentException(exception);
    }

    String currentVersion;

    try {
      InputStreamReader input = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8);
      BufferedReader reader = new BufferedReader(input);

      currentVersion = reader.readLine();
    } catch (IOException exception) {
      throw new IllegalArgumentException(exception);
    }

    if (!currentVersion.equalsIgnoreCase(version)) {
      logger.log(Level.WARNING, "You aren't using actual version of BestGuilds \n Your version: " + version + "newest version:" + currentVersion);
      logger.log(Level.INFO, "If you want to update your version download the newest one from: " + GITHUB_URL);
    }
  }
}
