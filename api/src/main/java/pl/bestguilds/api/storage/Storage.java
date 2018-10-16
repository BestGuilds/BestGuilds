package pl.bestguilds.api.storage;

public interface Storage {

    StorageType getType();

    void connect() throws StorageException;

    void disconnect() throws StorageException;
}
