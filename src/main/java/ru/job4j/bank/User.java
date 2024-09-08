package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных клиента банка
 *
 * @author Maria Vasileva
 * @version 1.0
 */
public class User {
    /**
     * Хранит паспортные данные клиента
     */
    private String passport;

    /**
     * Хранит ФИО клиента
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивание клиентов по паспортным данным
     *
     * @param o клиент
     * @return true, если паспортные данные клиентов равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}