package com.rightstep.figure.comparator;

import com.rightstep.figure.dto.Figure;

import java.util.Comparator;

/*Компаратор для сравнивания площадей фигур*/
public class FigureAreaComparator implements Comparator<Figure> {

    @Override
    public int compare(Figure o1, Figure o2) {
        return Double.compare(o1.getArea(),o2.getArea());
    }
}
