package pl.bestguilds.api.command;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.command.executor.CommandExecutor;

public final class CommandManager {

    private final BiMap<Command, String> subCommands;

    public CommandManager() {
        this.subCommands = HashBiMap.create();
    }

    public void registerSubCommand(@NotNull CommandExecutor executor) {
        Class<? extends CommandExecutor> type = executor.getClass();

        if (!type.isAnnotationPresent(SubCommand.class)) {
            return;
        }

        final SubCommand subCommand = type.getAnnotation(SubCommand.class);
        final String name = subCommand.name();
        final List<String> aliases = List.of(subCommand.aliases());

        final Command command = new Command(name, aliases, executor);

        this.subCommands.put(command, command.getName());
    }

    public Option<Command> getCommand(String name) {
        return getSubCommands().find(command -> command.contains(name));
    }

    public Set<Command> getSubCommands() {
        return HashSet.ofAll(this.subCommands.inverse().values());
    }
}
