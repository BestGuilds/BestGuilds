package pl.bestguilds.api.user.event;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.User;

public class UserJoinEvent extends UserEvent {

    public UserJoinEvent(@NotNull User user) {
        super(user);
    }
}
