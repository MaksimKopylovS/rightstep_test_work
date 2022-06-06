package com.rightstep.figure.service;

import com.rightstep.figure.comparator.CircleRadiusComparator;
import com.rightstep.figure.model.Circle;
import com.rightstep.figure.repository.CircleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CircleService {

    private final CircleRepository circleRepository;

    /*Метод вытаскивает все круги и сортирует их по радиусу*/
    public List<Circle> getCirclesInIncreasingRadius(){
        return circleRepository.findAll().stream().sorted(new CircleRadiusComparator()).collect(Collectors.toList());
    }
}
