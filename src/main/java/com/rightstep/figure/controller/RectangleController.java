package com.rightstep.figure.controller;

import com.rightstep.figure.model.Rectangle;
import com.rightstep.figure.service.RectangleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*Контролер для получения треугольников*/
@RestController
@RequestMapping()
@RequiredArgsConstructor
public class RectangleController {

    private final RectangleService rectangleService;

    /*Получение всех треугольником с сортировкой по возрастанию диагонали*/
    @GetMapping("/rectangles")
    public List<Rectangle> getRectanglesInAscendingDiagonal(){
        return rectangleService.getRectanglesInAscendingDiagonal();
    }
}
