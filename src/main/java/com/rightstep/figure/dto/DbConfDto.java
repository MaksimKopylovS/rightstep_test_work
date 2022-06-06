package com.rightstep.figure.dto;

import lombok.Data;

/* ДТО формирования полей для подключения к БД*/
@Data
public class DbConfDto {

    private final String SCHEMA_NAME = "rightstep";
    private String hostName;
    private String port;
    private String userName;
    private String userPass;
    private String dataBaseName;

    /*Формирование полного адреса подключения к БД*/
    public String getUrlDbSchema() {
        return "jdbc:postgresql://" + hostName + ":" + port + "/"+ dataBaseName + "?currentSchema=rightstep";
    }
    /*Формирование адреса для создания БД*/
    public String getUrlDb() {
        return "jdbc:postgresql://" + hostName + ":" + port + "/";
    }

    public static class Builder{
        private DbConfDto dbConfDto;

        public Builder(){
            dbConfDto = new DbConfDto();
        }

        public Builder setHostName(String hostName){
            dbConfDto.setHostName(hostName);
            return this;
        }

        public Builder  setPort(String port){
            dbConfDto.setPort(port);
            return this;
        }

        public Builder setUserName(String userName){
            dbConfDto.setUserName(userName);
            return this;
        }

        public Builder setUserPass(String userPass){
            dbConfDto.setUserPass(userPass);
            return this;
        }

        public Builder setDataBaseName(String dataBaseName){
            dbConfDto.setDataBaseName(dataBaseName);
            return this;
        }

        public DbConfDto build(){
            return this.dbConfDto;
        }
    }

}
