package pl.bestguilds.storage;

import io.vavr.collection.Map;
import pl.bestguilds.BestGuildsPlugin;
import pl.bestguilds.api.storage.Storage;
import pl.bestguilds.api.user.User;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class StorageImpl implements Storage {

    private final BestGuildsPlugin plugin;

    public StorageImpl(BestGuildsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public CompletableFuture<Map<UUID, User>> loadUsers() {
        return null;
    }

    @Override
    public CompletableFuture<Void> saveUsers(java.util.Map<UUID, User> users) {
        return null;
    }

    private <T> CompletableFuture<T> makeFuture(Callable<T> supplier) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return supplier.call();
            } catch (Exception e) {
                throw (RuntimeException) e;
            }
        }, command -> this.plugin.getServer().getScheduler().runTaskAsynchronously(plugin, command));
    }

    private CompletableFuture<Void> makeFuture(Runnable runnable) {
        return CompletableFuture.runAsync(runnable,
                command -> this.plugin.getServer().getScheduler().runTaskAsynchronously(plugin, command));
    }
}
