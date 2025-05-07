package org.eternity.adventure.game;

public class CommandParser {
    public Command parseCommand(String input) {
        return parseCommand(split(input));
    }

    private Command parseCommand(String[] commands) {
        return switch (commands[0]) {
            case "go" ->
                switch (commands[1]) {
                    case "north" -> new Command.Move(Direction.NORTH);
                    case "south" -> new Command.Move(Direction.SOUTH);
                    case "east" -> new Command.Move(Direction.EAST);
                    case "west" -> new Command.Move(Direction.WEST);
                    default -> new Command.Unknown();
                };
            case "look" -> new Command.Look();
            case "help" -> new Command.Help();
            case "quit" -> new Command.Quit();
            default -> new Command.Unknown();
        };
    }

    private String[] split(String input) {
        return input.toLowerCase().trim().split("\\s+");
    }
}
