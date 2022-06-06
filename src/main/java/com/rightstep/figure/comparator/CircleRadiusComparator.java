package com.rightstep.figure.comparator;

import com.rightstep.figure.model.Circle;

import java.util.Comparator;

/*Компаратор для сравнивания радиусов круга.*/
public class CircleRadiusComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle o1, Circle o2) {
        return Double.compare(o1.getRadius(), o2.getRadius());
    }
}
