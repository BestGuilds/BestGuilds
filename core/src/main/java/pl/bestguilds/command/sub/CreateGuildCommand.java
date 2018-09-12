package pl.bestguilds.command.sub;

import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.BestGuildsAPI;
import pl.bestguilds.api.command.CommandException;
import pl.bestguilds.api.command.SubCommand;
import pl.bestguilds.api.command.UserCommandExecutor;
import pl.bestguilds.api.command.arguments.Arguments;
import pl.bestguilds.api.user.User;

public class CreateGuildCommand extends UserCommandExecutor {

  public CreateGuildCommand(@NotNull BestGuildsAPI plugin) {
    super(plugin);
  }

  @SubCommand("create")
  @Override
  public void execute(User sender, Arguments args) throws CommandException {
    sender.sendMessage("=)");
  }
}
