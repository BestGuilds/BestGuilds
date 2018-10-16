package pl.bestguilds.api.user.event;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.user.User;

public class UserQuitEvent extends UserEvent {

    public UserQuitEvent(@NotNull User user) {
        super(user);
    }
}
