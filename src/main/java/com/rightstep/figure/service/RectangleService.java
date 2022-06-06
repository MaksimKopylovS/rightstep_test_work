package com.rightstep.figure.service;

import com.rightstep.figure.comparator.RectangleDiagonalComparator;
import com.rightstep.figure.model.Rectangle;
import com.rightstep.figure.repository.RectangleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RectangleService {

    private final RectangleRepository rectangleRepository;

    /*Вытаскивает треугольники и сортирует их по диагонали */
    public List<Rectangle> getRectanglesInAscendingDiagonal() {
        return rectangleRepository.findAll().stream().sorted(new RectangleDiagonalComparator()).collect(Collectors.toList());
    }
}
