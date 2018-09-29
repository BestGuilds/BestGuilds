package pl.bestguilds.bukkit.util;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import pl.bestguilds.bukkit.BukkitBestGuilds;

import java.beans.ConstructorProperties;
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

  private final Logger loggger = Bukkit.getLogger();



  private final HttpClient client = HttpClient.newBuilder()
          .version(HttpClient.Version.HTTP_2)
          .proxy(ProxySelector.getDefault())
          .followRedirects(HttpClient.Redirect.NORMAL)
          .build();

  private final HttpRequest request = HttpRequest.newBuilder(URI.create("http://www.google.com"))
          .timeout(Duration.ofSeconds(200))
          .header("Content-Type", "application/json")
          .version(HttpClient.Version.HTTP_2)
          .GET()
          .build();

  private final HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();

  private String ver;

  public  void init(Plugin plugin) {
    ver = plugin.getDescription().getVersion();
  }

  public final void checkForUpdates() {
    try {
      final HttpResponse<String> response = client.send(request, handler);

      if (response.statusCode() != 200) {
        throw new IOException("Server doesn't answer");
      } else {
        if (!response.body().equalsIgnoreCase(ver)) {
          loggger.log(Level.INFO, "You aren't using actual version of BestGuilds \n Your version:" + ver + "newest version:" + response.body());
          loggger.log(Level.INFO, "If you want to update your version download the newest one from our github.com");
        }
      }
    } catch (IOException | InterruptedException exception) {
      exception.printStackTrace();
    }
  }
}
