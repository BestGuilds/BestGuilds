package pl.bestguilds;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Updater {

  private static final String GITHUB_URL = "https://raw.githubusercontent.com/BestGuilds/BestGuilds/master/version.json";

  private Updater() {
  }

  public static void checkVersion(final Logger logger, final String version) {
    JsonArray array = readUrl(GITHUB_URL);
    List<JsonObject> jsonObjects = new ArrayList<>(array.size());

    for (JsonElement element : array) {
      jsonObjects.add(element.getAsJsonObject());
    }

    jsonObjects.sort((o1, o2) -> o2.get("id").getAsInt() - o1.get("id").getAsInt());

    final JsonObject currentObject = jsonObjects.get(0);
    String currentVersion = currentObject.get("version").getAsString();
    JsonArray changeLog = currentObject.get("changelog").getAsJsonArray();
    String priority = currentObject.get("priority").getAsString();

    if (!version.equalsIgnoreCase(currentVersion)) {
      logger.log(Level.WARNING, "You aren't using actual version of BestGuilds.");
      logger.log(Level.INFO, "Your version: " + version + ", newest version: " + currentVersion);
      logger.log(Level.INFO, "Update Priority: " + priority);
      logger.log(Level.INFO, "ChangeLogs: " + changeLog.getAsString());
      logger.log(Level.INFO,
          "If you want to update your version download the newest one from: " + "https://github.com/BestGuilds/BestGuilds/releases/");
    }
  }

  public static JsonArray readUrl(String urlString) {
    URL url;

    try {
      url = new URL(urlString);
    } catch (MalformedURLException exception) {
      throw new IllegalArgumentException(exception);
    }

    JsonArray result;
    BufferedReader reader = null;

    try {
      InputStreamReader input = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8);
      reader = new BufferedReader(input);
      result = new JsonParser().parse(reader).getAsJsonArray();
    } catch (IOException exception) {
      throw new IllegalArgumentException(exception);
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return result;
  }
}
