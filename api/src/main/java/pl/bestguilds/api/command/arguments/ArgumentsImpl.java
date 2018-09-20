package pl.bestguilds.api.command.arguments;

import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import pl.bestguilds.api.command.CommandException;
import pl.bestguilds.api.util.NumberUtil;

final class ArgumentsImpl implements Arguments {

  private final List<String> args;

  ArgumentsImpl(String[] args) {
    this.args = Arrays.asList(args);
  }

  @Override
  public int getSize() {
    return args.size();
  }

  @Override
  public ImmutableList<String> get() {
    return ImmutableList.copyOf(args);
  }

  @Override
  public String get(int index) throws ArgumentsException {
    return args.get(index);
  }

  @Override
  public <T> T get(int index, @NotNull Function<String, T> function) throws ArgumentsException {
    return function.apply(this.asString(index));
  }

  @Override
  public String asString(int index) throws ArgumentsException {
    if (this.args.size() <= index) {
      throw new ArgumentsException("Out of range, size: " + args.size() + ", index: " + index);
    }

    return args.get(index);
  }

  @Override
  public int asInt(int index) throws ArgumentsException {
    final String content = asString(index);

    try {
      return NumberUtil.parseInt(content);
    } catch (NumberFormatException exception) {
      throw new ArgumentsException("Cannot parse " + content + " to int.");
    }
  }

  @Override
  public long asLong(int index) throws ArgumentsException {
    final String content = asString(index);

    try {
      return NumberUtil.parseLong(content);
    } catch (NumberFormatException exception) {
      throw new ArgumentsException("Cannot parse " + content + " to long.");
    }
  }

  @Override
  public double asDouble(int index) throws ArgumentsException {
    final String content = asString(index);

    try {
      return NumberUtil.parseDouble(content);
    } catch (NumberFormatException exception) {
      throw new ArgumentsException("Cannot parse " + content + " to double.");
    }
  }

  @Override
  public boolean asBoolean(int index) throws ArgumentsException {
    final String content = asString(index);

    try {
      return Boolean.getBoolean(content);
    } catch (CommandException exception) {
      throw new ArgumentsException("Cannot parse " + content + " to boolean.");
    }
  }
}
