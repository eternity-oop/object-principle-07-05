package org.eternity.adventure.console;

import org.eternity.adventure.game.InputOutput;

import java.util.Scanner;

public class Console implements InputOutput {
    private Scanner scanner;

    public Console() {
        this.scanner = new Scanner(System.in);
    }

    public String input() {
        return scanner.nextLine().toLowerCase().trim();
    }

    public void showLine(String text) {
        System.out.println(text);
    }

    public void show(String text) {
        System.out.print(text);
    }
}
