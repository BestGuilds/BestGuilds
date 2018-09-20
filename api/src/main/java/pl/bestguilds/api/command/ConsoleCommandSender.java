package pl.bestguilds.api.command;

public interface ConsoleCommandSender extends CommandSender {

  String        NAME   = "[CONSOLE";
  CommandSender sender = new ConsoleCommandSender() {
    @Override
    public String getName() {
      return NAME;
    }
  };

  static CommandSender get() {
    return sender;
  }

  @Override
  default String getName() {
    return NAME;
  }
}
