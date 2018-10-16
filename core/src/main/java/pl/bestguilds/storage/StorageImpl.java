package pl.bestguilds.storage;

import pl.bestguilds.api.storage.Storage;
import pl.bestguilds.api.storage.StorageType;

public class StorageImpl implements Storage {

    private final StorageType type;

    public StorageImpl(StorageType type) {
        this.type = type;
    }

    @Override
    public StorageType getType() {
        return this.type;
    }

    @Override
    public void connect() {

    }

    @Override
    public void disconnect() {

    }
}
