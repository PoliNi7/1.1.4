package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Иван", "Иванов", (byte) 25);
        System.out.println("User с именем – Иван добавлен в базу данных");
        userService.saveUser("Игорь", "Шевченко", (byte) 28);
        System.out.println("User с именем – Игорь добавлен в базу данных");
        userService.saveUser("Мария", "Цой", (byte) 34);
        System.out.println("User с именем – Мария добавлен в базу данных");
        userService.saveUser("Валентин", "Снегирь", (byte) 45);
        System.out.println("User с именем – Валентин добавлен в базу данных");

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
