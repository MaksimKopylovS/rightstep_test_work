package com.rightstep.figure.controller;

import com.rightstep.figure.model.Circle;
import com.rightstep.figure.service.CircleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*Контроллер для обработки запросов связанных с кругами*/
@RestController
@RequestMapping()
@RequiredArgsConstructor
public class CircleController {

    private final CircleService circleService;

    /*Получение всех кругов по увеличению радиуса*/
    @GetMapping("/circles")
    public List<Circle> getCirclesInIncreasingRadius(){
        return circleService.getCirclesInIncreasingRadius();
    }
}
