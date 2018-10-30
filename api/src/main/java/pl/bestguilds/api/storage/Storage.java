package pl.bestguilds.api.storage;

import pl.bestguilds.api.user.User;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface Storage {

    CompletableFuture<io.vavr.collection.Map<UUID, User>> loadUsers();

    CompletableFuture<Void> saveUsers(Map<UUID, User> users);
}
