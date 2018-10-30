package pl.bestguilds.api.user.event;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.event.BestEvent;
import pl.bestguilds.api.user.User;

public abstract class UserEvent extends BestEvent {

    protected final User user;

    public UserEvent(@NotNull final User user) {
        this.user = user;
    }

    public final User getUser() {
        return this.user;
    }
}
