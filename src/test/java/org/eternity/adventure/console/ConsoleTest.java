package org.eternity.adventure.console;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleTest {
    @Test
    public void input() {
        System.setIn(new ByteArrayInputStream("input\n".getBytes()));

        String command = new Console().input();

        assertThat(command).isEqualTo("input");
    }

    @Test
    public void showLine() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        new Console().showLine("showLine");

        assertThat(output.toString()).isEqualToIgnoringNewLines("showLine");
    }

    @Test
    public void show() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        new Console().show("show");

        assertThat(output.toString()).isEqualToIgnoringNewLines("show");
    }
}
