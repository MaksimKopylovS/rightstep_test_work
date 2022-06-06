package com.rightstep.figure.install.db;

/*Класс для SQL запросов*/
public final class SqlQuery {

    public static String createTableSqlCommand(String mySchema) {
        return "CREATE TABLE " + mySchema + ".rectangle (\n" +
                "  id serial PRIMARY KEY NOT NULL UNIQUE,\n" +
                "  id_color serial NOT NULL UNIQUE,\n" +
                "  name VARCHAR(255) NOT NULL UNIQUE,\n" +
                "  side_one double precision NOT NULL,\n" +
                "  side_two double precision NOT NULL,\n" +
                "  diagonal double precision NOT NULL,\n" +
                "  area double precision NOT NULL,\n" +
                "  perimetr double precision NOT NULL);\n" +
                "  \n" +
                "CREATE TABLE " + mySchema + ".circle (\n" +
                "  id serial PRIMARY KEY NOT NULL UNIQUE,\n" +
                "  id_color serial NOT NULL UNIQUE,\n" +
                "  name VARCHAR(255) NOT NULL UNIQUE,\n" +
                "  perimetr double precision,\n" +
                "  area double precision,\n" +
                "  radius double precision);\n" +
                "  \n" +
                "CREATE TABLE " + mySchema + ".color (\n" +
                "  id serial PRIMARY KEY NOT NULL UNIQUE,\n" +
                "  name VARCHAR(255) NOT NULL UNIQUE);\n" +
                "  \n" +
                "INSERT INTO rightstep.color (name) VALUES ('red'::character varying);\n" +
                "INSERT INTO rightstep.color (name) VALUES ('green'::character varying);\n" +
                "INSERT INTO rightstep.color (name) VALUES ('blue'::character varying);\n" +
                "INSERT INTO rightstep.color (name) VALUES ('black'::character varying);\n" +
                "INSERT INTO rightstep.color (name) VALUES ('white'::character varying);\n" +
                "\n" +
                "ALTER TABLE " + mySchema + ".rectangle \n" +
                "ADD CONSTRAINT fk_rectangle_color\n" +
                "  FOREIGN KEY (id_color)\n" +
                "  REFERENCES " + mySchema + ".color (id)\n" +
                "  ON DELETE NO ACTION\n" +
                "  ON UPDATE NO ACTION;\n" +
                "  \n" +
                "ALTER TABLE " + mySchema + ".circle\n" +
                "ADD CONSTRAINT fk_cercle_color\n" +
                "  FOREIGN KEY (id_color)\n" +
                "  REFERENCES " + mySchema + ".color (id)\n" +
                "  ON DELETE NO ACTION\n" +
                "  ON UPDATE NO ACTION;\n" +
                "  \n" +
                "INSERT INTO " + mySchema + ".rectangle (id_color, name, side_one, side_two, diagonal, area, perimetr) VALUES ('1', 'rectangle1', '3', '5', '5.831', '15', '16');\n" +
                "INSERT INTO " + mySchema + ".rectangle (id_color, name, side_one, side_two, diagonal, area, perimetr) VALUES ('2', 'rectangle2', '4', '6', '7.2111', '24', '20');\n" +
                "INSERT INTO " + mySchema + ".rectangle (id_color, name, side_one, side_two, diagonal, area, perimetr) VALUES ('3', 'rectangle3', '5', '7', '8.6023', '35', '24');\n" +
                "INSERT INTO " + mySchema + ".rectangle (id_color, name, side_one, side_two, diagonal, area, perimetr) VALUES ('4', 'rectangle4', '6', '8', '10', '48', '28');\n" +
                "INSERT INTO " + mySchema + ".rectangle (id_color, name, side_one, side_two, diagonal, area, perimetr) VALUES ('5', 'rectangle5', '3.23', '4.41', '5.466351616937938', '14.2443', '15.28');\n" +
                "\n" +
                "INSERT INTO " + mySchema + ".circle (id_color, name, perimetr, area, radius) VALUES ('1', 'circle1', '31.41593', '78.53981633974483', '5');\n" +
                "INSERT INTO " + mySchema + ".circle (id_color, name, perimetr, area, radius) VALUES ('2', 'circle2', '37.69911', '113.09733552923255', '6');\n" +
                "INSERT INTO " + mySchema + ".circle (id_color, name, perimetr, area, radius) VALUES ('3', 'circle3', '43.9823', '153.93804002589985', '7');\n" +
                "INSERT INTO " + mySchema + ".circle (id_color, name, perimetr, area, radius) VALUES ('4', 'circle4', '50.26548', '201.06192982974676', '8');\n" +
                "INSERT INTO " + mySchema + ".circle (id_color, name, perimetr, area, radius) VALUES ('5', 'circle5', '25.13274', '50.26548245743669', '4');\n" +
                "\n" +
                "  \n" +
                "\n" +
                "\n";
    }
}
