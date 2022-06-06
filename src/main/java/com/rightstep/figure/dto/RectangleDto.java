package com.rightstep.figure.dto;

import com.rightstep.figure.model.Color;
import lombok.NoArgsConstructor;

/*ДТО для работы с Треугольниками*/
@NoArgsConstructor
public class RectangleDto extends Figure {

    private long id;
    private String color;
    private String name;
    private double side_one;
    private double side_two;
    private double diagonal;
    private double area;
    private double perimetr;

    public RectangleDto(long id, Color color, String name, double area, double perimetr) {
        super(id, color, name, area, perimetr);
    }

    /*Вычисление периметра прямоугольника*/
    @Override
    public double calculatePerimeter() {
        return (side_one + side_two) * 2;
    }

    /*Вычисление площади прямоугольника*/
    @Override
    public double calculateArea() {
        return side_one * side_two;
    }
}
