package pl.bestguilds.storage;

import org.bukkit.Bukkit;
import pl.bestguilds.api.storage.Storage;
import pl.bestguilds.api.storage.StorageFactory;
import pl.bestguilds.api.storage.StorageType;

import java.util.logging.Level;

public class StorageFactoryImpl implements StorageFactory {

    private final Storage storage;

    private static final StorageType DEFAULT_TYPE = StorageType.JSON;

    public StorageFactoryImpl(String storageType) {
        StorageType type = StorageType.of(storageType).orElseGet(() -> {
            Bukkit.getLogger().log(Level.WARNING, "Bad storage type. Use default.");
            return DEFAULT_TYPE;
        });

        this.storage = new StorageImpl(type);
    }

    @Override
    public Storage getStorage() {
        return this.storage;
    }
}
