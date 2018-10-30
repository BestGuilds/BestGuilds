package pl.bestguilds.api.event;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class BestEvent extends Event implements Cancellable {

    private final HandlerList handlerList;
    private boolean cancelled;

    protected BestEvent() {
        this.handlerList = new HandlerList();
        this.cancelled = false;
    }

    @Override
    public HandlerList getHandlers() {
        return this.handlerList;
    }

    public HandlerList getHandlerList() {
        return this.handlerList;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
