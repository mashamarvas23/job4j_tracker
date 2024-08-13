package ru.job4j.ex;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;

public class FactorialTest {
    @Test
    public void whenException() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () ->
                        factorial.calc(-5)
        );
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void whenSuccess() {
        Factorial factorial = new Factorial();
        int excpectedResult = 120;
        int actualResult = factorial.calc(5);
        assertThat(actualResult).isEqualTo(excpectedResult);
    }
}