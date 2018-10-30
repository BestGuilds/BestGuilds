package pl.bestguilds.api.command;

import com.google.common.base.MoreObjects;
import io.vavr.collection.List;
import org.bukkit.command.CommandSender;
import pl.bestguilds.api.command.arguments.Arguments;
import pl.bestguilds.api.command.executor.CommandExecutor;

public class Command {

    private final String name;
    private final List<String> aliases;
    private final transient CommandExecutor executor;

    Command(final String name,
            final List<String> aliases,
            final CommandExecutor executor) {
        this.name = name;
        this.aliases = aliases;
        this.executor = executor;
    }

    public String getName() {
        return name;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void execute(final CommandSender sender, final Arguments args) {
        this.executor.execute(sender, args);
    }

    public boolean contains(final String name) {
        return nameWithAliases().contains(name);
    }

    private List<String> nameWithAliases() {
        return this.aliases.push(this.name);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", this.name)
                .add("aliases", this.aliases)
                .add("executor", this.executor)
                .toString();
    }
}
