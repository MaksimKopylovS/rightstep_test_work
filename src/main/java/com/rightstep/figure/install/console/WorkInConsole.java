package com.rightstep.figure.install.console;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/*Класс для работы с консолью*/
public class WorkInConsole implements com.rightstep.figure.install.console.Console {

    /*Метод для ввода команд в консоль, возвращает результат выполненной команды.*/
    @Override
    public String startReturn(String command){
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = "";
        try(BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("CP866")))){
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    /*Метод для скрытого ввода пароль в консоль, возвращает введённый пароль.*/
    @Override
    public String passwordExample() {
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }
        char[] passwordArray = console.readPassword("Enter your password form DB: ");
        return new String(passwordArray);
    }

    /*Метод для ввода значений в консоль возвращает введённый текст*/
    @Override
    public String setStr() {
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }
        return console.readLine("Ввод: ");
    }
}
