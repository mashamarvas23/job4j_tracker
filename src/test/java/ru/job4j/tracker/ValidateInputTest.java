package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {
    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenMultipleValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"1", "2"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selectedFirst = input.askInt("Enter menu:");
        assertThat(selectedFirst).isEqualTo(1);
        int selectedSecond = input.askInt("Enter menu:");
        assertThat(selectedSecond).isEqualTo(2);
    }

    @Test
    void whenInValidNegativeInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selectedFirst = input.askInt("Enter menu:");
        assertThat(selectedFirst).isEqualTo(-1);
    }
}