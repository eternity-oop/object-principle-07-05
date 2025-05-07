package org.eternity.adventure.game;

public sealed interface Command {
    record Move(Direction direction) implements Command {}
    record Unknown() implements Command {}
    record Look() implements Command {}
    record Help() implements Command {}
    record Quit() implements Command {}
}
