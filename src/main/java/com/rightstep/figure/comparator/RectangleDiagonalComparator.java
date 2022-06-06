package com.rightstep.figure.comparator;

import com.rightstep.figure.model.Rectangle;

import java.util.Comparator;

/*Компаратор для сравнивания площадей треугольников.*/
public class RectangleDiagonalComparator implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        return Double.compare(o1.getDiagonal(), o2.getDiagonal());
    }
}
