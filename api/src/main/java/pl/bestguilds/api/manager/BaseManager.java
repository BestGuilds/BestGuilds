package pl.bestguilds.api.manager;

import com.google.common.collect.ImmutableSet;
import pl.bestguilds.api.BestGuildsAPI;

import java.util.Map;
import java.util.Optional;
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
    public Optional<T> getValue(UUID uuid) {
        return Optional.ofNullable(this.map.get(uuid));
    }

    @Override
    public ImmutableSet<T> getValues() {
        return ImmutableSet.copyOf(this.map.values());
    }
}
