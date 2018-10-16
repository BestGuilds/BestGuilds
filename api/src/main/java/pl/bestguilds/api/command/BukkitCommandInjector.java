package pl.bestguilds.api.command;

import io.vavr.collection.List;
import io.vavr.control.Option;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.arguments.Arguments;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class BukkitCommandInjector implements CommandInjector {

    private final CommandMap commandMap;
    private final BestGuildsAPI plugin;

    public BukkitCommandInjector(BestGuildsAPI plugin) {
        this.plugin = plugin;

        try {
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            this.commandMap = ((CommandMap) field.get(Bukkit.getServer()));
            field.setAccessible(false);
        } catch (IllegalAccessException | NoSuchFieldException exception) {
            throw new CommandException(exception);
        }
    }

    @Override
    public void inject() {
        this.commandMap.register("bestguilds", bukkit());
    }

    @SuppressWarnings("unchecked")
    private BukkitCommand bukkit() {
        final Command command = plugin.getCommandManager().getMainCommand();

        return new BukkitCommand(command.getName(), "a guild command", "/g", Arrays.asList(command.getAliases())) {
            @Override
            public boolean execute(CommandSender sender, String x, String[] bukkitArgs) {
                final Command mainCommand = plugin.getCommandManager().getMainCommand();

                if (bukkitArgs.length < 1) {
                    mainCommand.getExecutor().execute(sender, Arguments.of(bukkitArgs));
                    return true;
                }

                final List<String> newArgs = List.of(bukkitArgs).subSequence(2, bukkitArgs.length);
                final Arguments args = Arguments.of(newArgs);

                final Option<Command> subCommand = plugin.getCommandManager().getCommand(bukkitArgs[1]);

                Option.of(subCommand.getOrElse(mainCommand))
                        .forEach(cmd -> cmd.getExecutor().execute(sender, args));
                return true;
            }
        };
    }
}