package org.eternity.adventure.game;

import java.util.Arrays;
import java.util.List;

public class FakeInputOutput implements InputOutput {
    int currentInput;
    private List<String> inputs;
    private StringBuilder outputs;

    public FakeInputOutput(String ... inputs) {
        this.currentInput = 0;
        this.inputs = List.of(inputs);
        this.outputs = new StringBuilder();
    }

    public List<String> outputs() {
        return Arrays.stream(outputs.toString().split("\n")).toList();
    }

    @Override
    public String input() {
        return inputs.get(currentInput++);
    }

    @Override
    public void showLine(String text) {
        outputs.append(text + "\n");
    }

    @Override
    public void show(String text) {
        outputs.append(text);
    }
}
