package pl.bestguilds.api.command;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.util.Iterables;

public final class CommandManagerImpl implements CommandManager {

    private final BiMap<Command, String> subCommands;
    private Command mainCommand;

    public CommandManagerImpl() {
        this.subCommands = HashBiMap.create();
    }

    @Override
    public void register(@NotNull CommandExecutor<?> executor) {
        Class<? extends CommandExecutor> type = executor.getClass();

        if (!type.isAnnotationPresent(SubCommand.class)) {
            return;
        }

        SubCommand subCommand = type.getAnnotation(SubCommand.class);
        Command command = new CommandImpl(subCommand.value(), subCommand.aliases(), executor);

        this.subCommands.put(command, command.getName());
    }

    @Override
    public Command getMainCommand() {
        return mainCommand;
    }

    @Override
    public void setMainCommand(CommandExecutor<?> executor) {
        this.mainCommand = new CommandImpl("bestguilds", new String[]{"guilds", "g"}, executor);
    }

    @Override
    public Option<Command> getCommand(String name) {
        return Iterables.findSafe(getSubCommands(), command -> command.contains(name));
    }

    @Override
    public Set<Command> getSubCommands() {
        return HashSet.ofAll(this.subCommands.inverse().values());
    }
}
