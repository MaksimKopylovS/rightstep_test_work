package com.rightstep.figure.install.config;

import com.rightstep.figure.dto.DbConfDto;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*Класс создаёт конфигурационный файл secured.properties*/
public class CreateSecuredPropertiesConf {

    /*Создание пустого конфигурационного файла*/
    private void createConf() {
        try {
            Files.createFile(Paths.get("./secured.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Наполнение конфигурационного файла*/
    private void editConf(DbConfDto dbConfDto) {
        try (FileWriter writer = new FileWriter("./secured.properties", false)) {
            writer.write(getConfig(dbConfDto));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Поля для наполнения конфигурационного файла*/
    private String getConfig(DbConfDto dbConfDto) {
        return "DB_USR = " + dbConfDto.getUserName() + "\n" +
                "DB_PWD = " + dbConfDto.getUserPass() + "\n" +
                "DB_URL = " + dbConfDto.getUrlDbSchema() + "\n";
    }

    /*Сборщик конфигурационного файла*/
    public static class Builder {

        private CreateSecuredPropertiesConf createSecuredPropertiesConf;

        public Builder() {
            createSecuredPropertiesConf = new CreateSecuredPropertiesConf();
        }

        public Builder createConf() {
            createSecuredPropertiesConf.createConf();
            return this;
        }

        public Builder editConf(DbConfDto dbConfDto) {
            createSecuredPropertiesConf.editConf(dbConfDto);
            return this;
        }

        public CreateSecuredPropertiesConf build() {
            return new CreateSecuredPropertiesConf();
        }
    }


}
