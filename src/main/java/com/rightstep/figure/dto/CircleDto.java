package com.rightstep.figure.dto;

import com.rightstep.figure.model.Color;
import lombok.NoArgsConstructor;

/*ДТО Круга*/
@NoArgsConstructor
public class CircleDto extends Figure {

    private Long id;
    private String color;
    private double radius;
    private String name;
    private double perimetr;
    private double area;

    public CircleDto(long id, Color color, String name, double area, double perimetr) {
        super(id, color, name, area, perimetr);
    }

//Вычисление периметра круга
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

//Вычисление площади круга
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}