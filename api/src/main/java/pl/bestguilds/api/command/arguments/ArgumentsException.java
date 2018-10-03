package pl.bestguilds.api.command.arguments;

import pl.bestguilds.api.command.CommandException;

public final class ArgumentsException extends CommandException {

    public ArgumentsException() {
        super();
    }

    ArgumentsException(String message) {
        super(message);
    }
}
