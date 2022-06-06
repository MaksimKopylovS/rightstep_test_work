package com.rightstep.figure.dto;

import com.rightstep.figure.model.Color;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Абстрактный ДТО фигур*/
@NoArgsConstructor
@Data
public abstract class Figure {

    private long id;
    private Color color;
    private String name;
    private double area;
    private double perimetr;

    public Figure(long id, Color color, String name, double area, double perimetr) {
        this.id = id;
        this.color = color;
        this.name = name;
        this.area = area;
        this.perimetr = perimetr;
    }

    /*абстрактный метод для получения периметра*/
    public abstract double calculatePerimeter();

    /*абстрактный метод для получения площади*/
    public abstract double calculateArea();
}
