package pl.bestguilds.api.command;

import io.vavr.collection.List;
import io.vavr.control.Option;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.arguments.Arguments;
import pl.bestguilds.api.command.executor.CommandExecutor;

import java.lang.reflect.Field;

public final class BukkitCommandInjector {

    private final BestGuildsAPI plugin;
    private final CommandMap commandMap;

    public BukkitCommandInjector(BestGuildsAPI plugin) {
        this.plugin = plugin;

        try {
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            this.commandMap = ((CommandMap) field.get(Bukkit.getServer()));
            field.setAccessible(false);
        } catch (IllegalAccessException | NoSuchFieldException exception) {
            throw new UnsupportedOperationException(exception);
        }
    }

    public void inject(final CommandExecutor guildCommand) {
        this.commandMap.register("bestguilds", bukkit(guildCommand));
    }

    private BukkitCommand bukkit(final CommandExecutor executor) {
        Command command = new Command("bestguilds", List.of("g", "guild", "guilds"), executor);
        return new BukkitCommand(command.getName(), "a guild command", "/g", command.getAliases().asJava()) {
            @Override
            public boolean execute(CommandSender sender, String string, String[] bukkitArgs) {
                final List<String> fittedArgs = List.of(bukkitArgs).subSequence(2, bukkitArgs.length);
                final Arguments args = Arguments.of(fittedArgs);
                final Option<String> arg0 = args.get(0);

                arg0
                        .flatMap(name -> plugin.getCommandManager().getCommand(name))
                        .getOrElse(command)
                        .execute(sender, args);

                return true;
            }
        };
    }
}