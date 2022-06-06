package com.rightstep.figure.install.console;

/*Класс для заполнения полей, через консоль, необходимых для соединения с БД */
public class FillingFieldsWithDataBase extends WorkInConsole {

    public String getHostName() {
        System.out.println("Введите доменое имя БД");
        return setStr();
    }

    public String getPort() {
        System.out.println("Введите порт");
        return setStr();
    }

    public String getUserName() {
        System.out.println("Введите имя пользователя");
        return setStr();
    }

    public String getUserPass() {
        System.out.println("Введите пароль");
        return passwordExample();
    }

    public String getDataBaseName() {
        System.out.println("Введите имя базы данных");
        return setStr();
    }
}
