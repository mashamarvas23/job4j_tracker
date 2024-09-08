package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковской системы
 *
 * @author Maria Vasileva
 * @version 1.0
 */

public class BankService {

    /**
     * Хранение клиента банка осуществляется в Map-структуре
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет клиента в банковскую систему
     *
     * @param user пользователь, которого необходимо добавить в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет клиента из системы
     *
     * @param passport паспортные данные пользователя, которого необходимо удалить из системы
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет клиенту новый счет
     *
     * @param passport паспортные данные клиента
     * @param account  добавляемый клиенту счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (Objects.nonNull(user) && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод ищет клиента по паспортным данным
     *
     * @param passport паспортные данные клиента
     * @return клиента
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет клиента по реквизитам банковского счета
     *
     * @param passport  паспортные данные клиента
     * @param requisite реквизиты счета
     * @return возвращает банковский счет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (Objects.nonNull(user)) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     *
     * @param sourcePassport       паспортные данные клиента-отправителя
     * @param sourceRequisite      реквизиты счета клиента-отправителя
     * @param destinationPassport  паспортные данные клиента-получателя
     * @param destinationRequisite реквизиты счета клиента-получателя
     * @param amount               -сумма перевода
     * @return Если счёт не найден или не хватает денег на счёте sourcePassport, то метод должен вернуть false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (Objects.nonNull(destAccount) && Objects.nonNull(sourceAccount) && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            result = true;
        }
        return result;

    }

    /**
     * @param user клиент
     * @return список банковских счетов клиента
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}