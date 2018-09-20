package pl.bestguilds.api.command;

public interface ConsoleCommandSender extends CommandSender {

  String        NAME   = "[CONSOLE]";
  CommandSender SENDER = new ConsoleCommandSender() {
    @Override
    public String getName() {
      return NAME;
    }
  };

  static CommandSender get() {
    return SENDER;
  }

  @Override
  default String getName() {
    return NAME;
  }
}
