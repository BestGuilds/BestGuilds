package pl.bestguilds.api.user.event;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.User;

public class UserKilledUserEvent extends UserEvent {

    private final User killed;

    public UserKilledUserEvent(@NotNull User user, @NotNull User killed) {
        super(user);
        this.killed = killed;
    }

    public User getKilled() {
        return this.killed;
    }
}
