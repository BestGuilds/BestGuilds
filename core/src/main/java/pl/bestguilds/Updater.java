package pl.bestguilds;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Updater {
  private static final String GITHUB_URL = "https://raw.githubusercontent.com/BestGuilds/BestGuilds/master/version.txt";

  private static final HttpClient client = HttpClient.newBuilder()
      .version(HttpClient.Version.HTTP_2)
      .proxy(ProxySelector.getDefault())
      .followRedirects(HttpClient.Redirect.NORMAL)
      .build();

  private static final HttpRequest request = HttpRequest.newBuilder(URI.create(GITHUB_URL))
      .timeout(Duration.ofSeconds(200))
      .header("Content-Type", "application/json")
      .version(HttpClient.Version.HTTP_2)
      .GET()
      .build();

  private static final HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();

  private Updater() {
  }

  public static void checkVersion(final Logger logger, final String version) {
    try {
      final HttpResponse<String> response = client.send(request, handler);

      if (response.statusCode() != 200) {
        logger.warning("Server doesn't answer.");
      } else {
        if (!response.body().equalsIgnoreCase(version)) {
          logger
              .log(Level.WARNING, "You aren't using actual version of BestGuilds \n Your version: " + version + "newest version:" + response.body());
          logger.log(Level.INFO, "If you want to update your version download the newest one from: " + GITHUB_URL);
        }
      }
    } catch (IOException | InterruptedException exception) {
      exception.printStackTrace();
    }
  }
}
