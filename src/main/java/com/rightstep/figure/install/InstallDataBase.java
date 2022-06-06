package com.rightstep.figure.install;

import com.rightstep.figure.dto.DbConfDto;
import com.rightstep.figure.install.config.CreateSecuredPropertiesConf;
import com.rightstep.figure.install.console.FillingFieldsWithDataBase;
import com.rightstep.figure.install.console.WorkInConsole;
import com.rightstep.figure.install.db.CreateDataBase;
import com.rightstep.figure.install.db.SqlQuery;

/*Класс инсталляции БД*/
public class InstallDataBase {

    public void start() {
        /*Проверяем наличие postgres в активной директории*/
        checkingForPostgres();

        /*Запускаем консоль, для заполнения DbConfDto*/
        FillingFieldsWithDataBase fillingFieldsWithDataBase = new FillingFieldsWithDataBase();
        /*Создание DTO для представления имени пароля адреса БД*/
        DbConfDto dbConfDto = new DbConfDto.Builder()
                .setHostName(fillingFieldsWithDataBase.getHostName())
                .setPort(fillingFieldsWithDataBase.getPort())
                .setUserName(fillingFieldsWithDataBase.getUserName())
                .setUserPass(fillingFieldsWithDataBase.getUserPass())
                .setDataBaseName(fillingFieldsWithDataBase.getDataBaseName())
                .build();

//        DbConfDto dbConfDto = new DbConfDto.Builder()
//                .setHostName("localhost")
//                .setPort("5432")
//                .setUserPass("Zz123456")
//                .setUserName("postgres")
//                .setDataBaseName("mydb").build();

        /*Соединяемся с БД и наполняем её*/
        new CreateDataBase.Builder()
                .createDataBase(dbConfDto)
                .createSchema(dbConfDto)
                .sendingSqlQuery(dbConfDto, SqlQuery.createTableSqlCommand(dbConfDto.getSCHEMA_NAME()))
                .build();

        /*Создание конфигурационного файла secured.properties*/
        new CreateSecuredPropertiesConf.Builder().createConf().editConf(dbConfDto).build();
    }

    /*Проверка, на доступность postgres в активной директории*/
    private void checkingForPostgres() {
        WorkInConsole workInConsole = new WorkInConsole();
        if (workInConsole.startReturn("postgres --version").startsWith("postgres")) {
            System.out.println("postgres установлен в активной дериктории");
        } else {
            System.out.println("postgres не установлен в активной дериктории");
        }
    }
}
