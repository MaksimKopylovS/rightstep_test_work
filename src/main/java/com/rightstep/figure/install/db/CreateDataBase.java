package com.rightstep.figure.install.db;

import com.rightstep.figure.dto.DbConfDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*Класс для соединения, создания, наполнения, базы данных*/
public class CreateDataBase {

    private Connection conn;
    private Statement stmt;

    //Создание базы данных
    private void createDataBase(DbConfDto dbConfDto) {
        System.out.println("Создание базы начало...");
        String createDataBase = "CREATE DATABASE " + dbConfDto.getDataBaseName();
        sendingSqlQuery(dbConfDto, dbConfDto.getUrlDb(), createDataBase);
    }

    //Создание схемы БД
    private void createSchema(DbConfDto dbConfDto) {
        System.out.println("Создание схемы начало...");
        String crateSchema = "CREATE SCHEMA " + dbConfDto.getSCHEMA_NAME();
        sendingSqlQuery(dbConfDto, dbConfDto.getUrlDbSchema(), crateSchema);
    }

    //Выполнение SQL запросов, на вход надо падать ДТО адрес БД и запрос который нужно выполнить
    private void sendingSqlQuery(DbConfDto dbConfDto, String url, String sqlQuery) {
        System.out.println("Начало выполнения запроса...");
        try {
            //STEP 1: Регистрация JDBC драйвера
            DriverManager.registerDriver(new org.postgresql.Driver());
            //STEP 2: Открытие соединения
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url, dbConfDto.getUserName(), dbConfDto.getUserPass());
            //STEP 3: создание соединения с БД для передачи запроса
            stmt = conn.createStatement();
            //STEP 4 Отправка запроса
            stmt.executeUpdate(sqlQuery);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public static class Builder {

        private CreateDataBase createDataBase;

        public Builder() {
            createDataBase = new CreateDataBase();
        }

        public Builder createDataBase(DbConfDto dbConfDto) {
            createDataBase.createDataBase(dbConfDto);
            return this;
        }

        public Builder createSchema(DbConfDto dbConfDto) {
            createDataBase.createSchema(dbConfDto);
            return this;
        }

        public Builder sendingSqlQuery(DbConfDto dbConfDto, String sqlQuery) {
            createDataBase.sendingSqlQuery(dbConfDto, dbConfDto.getUrlDbSchema(), sqlQuery);
            return this;
        }

        public CreateDataBase build() {
            return createDataBase;
        }
    }
}
