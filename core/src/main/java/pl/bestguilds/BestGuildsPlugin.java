package pl.bestguilds;

import io.papermc.lib.PaperLib;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.BukkitCommandInjector;
import pl.bestguilds.api.command.CommandManager;
import pl.bestguilds.api.guild.GuildManager;
import pl.bestguilds.api.user.UserManager;
import pl.bestguilds.command.GuildCommand;
import pl.bestguilds.command.sub.CreateGuildCommand;
import pl.bestguilds.guild.GuildManagerImpl;
import pl.bestguilds.listener.PlayerJoinListener;
import pl.bestguilds.listener.PlayerQuitListener;
import pl.bestguilds.user.UserManagerImpl;

import java.util.Arrays;

public final class BestGuildsPlugin extends JavaPlugin implements BestGuildsAPI {

    private UserManager userManager;
    private GuildManager guildManager;
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        PaperLib.suggestPaper(this);

        this.userManager = new UserManagerImpl(this);
        this.guildManager = new GuildManagerImpl(this);
        this.commandManager = new CommandManager();

        BukkitCommandInjector commandInjector = new BukkitCommandInjector(this);
        registerCommands(commandInjector);
        registerListeners();

        BestGuilds.setInstance(this);
    }

    private void registerCommands(@NotNull BukkitCommandInjector injector) {
        this.commandManager.registerSubCommand(
                new CreateGuildCommand(this)
        );

        injector.inject(new GuildCommand(this));
    }

    private void registerListeners() {
        registerListenersHelper(
                new PlayerJoinListener(this),
                new PlayerQuitListener(this)
        );
    }

    private void registerListenersHelper(Listener... listeners) {
        Arrays.stream(listeners).forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
    }

    @Override
    public UserManager getUserManager() {
        return this.userManager;
    }

    @Override
    public GuildManager getGuildManager() {
        return this.guildManager;
    }

    @Override
    public CommandManager getCommandManager() {
        return this.commandManager;
    }
}
