package com.rightstep.figure.controller;

import com.rightstep.figure.dto.Figure;
import com.rightstep.figure.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Контролер для обработки всех фигур*/
@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ColorController {

    private final ColorService colorService;

    /*Получение всех фигур по выбранному цвету и сортировкой по площади*/
    @GetMapping("/figures")
    public List<Figure> getColorOfShapesInAscendingArea(@RequestParam(name = "c", defaultValue = "all") String c) {
        System.out.println("Hello " + c);
        return c.equals("all") ? colorService.getColorOfShapesInAscendingArea() : colorService.findFiguresByColor(c);
    }
}
