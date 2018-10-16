package pl.bestguilds.api.manager;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import pl.bestguilds.api.BestGuildsAPI;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseManager<T> implements Manager<T> {

    protected final BestGuildsAPI plugin;
    protected final Map<UUID, T> map;

    public BaseManager(final BestGuildsAPI plugin) {
        this.plugin = plugin;
        this.map = new ConcurrentHashMap<>();
    }

    @Override
    public Option<T> getValue(UUID uuid) {
        return Option.of(this.map.get(uuid));
    }

    @Override
    public Set<T> getValues() {
        return HashSet.ofAll(this.map.values());
    }
}
