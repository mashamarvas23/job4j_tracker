package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
       var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("nsk");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindByPhoneNumber() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Maria", "Vasileva", "534999", "Samara")
        );
        ArrayList<Person> persons = phones.find("534");
        assertThat(persons.size()).isEqualTo(2);
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
        assertThat(persons.get(1).getSurname()).isEqualTo("Vasileva");
    }

    @Test
    public void whenNotFoundBySurname() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Maria", "Vasileva", "534999", "Samara")
        );
        ArrayList<Person> persons = phones.find("Petrov");
        assertThat(persons.size()).isEqualTo(0);
    }
}