package com.rightstep.figure.service;

import com.rightstep.figure.comparator.FigureAreaComparator;
import com.rightstep.figure.dto.CircleDto;
import com.rightstep.figure.dto.Figure;
import com.rightstep.figure.dto.RectangleDto;
import com.rightstep.figure.model.Color;
import com.rightstep.figure.repository.CircleRepository;
import com.rightstep.figure.repository.ColorRepository;
import com.rightstep.figure.repository.RectangleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ColorService {

    private final RectangleRepository rectangleRepository;
    private final CircleRepository circleRepository;
    private final ColorRepository colorRepository;

    /*Вытаскивает все фигуры и сортирует их по площади*/
    public List<Figure> getColorOfShapesInAscendingArea() {
        ModelMapper modelMapper = new ModelMapper();
        List<Figure> listRectangle = rectangleRepository.findAll().stream().map(rectangle -> modelMapper.map(rectangle, RectangleDto.class)).collect(Collectors.toList());
        List<Figure> listCircle = circleRepository.findAll().stream().map(circle -> modelMapper.map(circle, CircleDto.class)).collect(Collectors.toList());
        List<Figure> list = Stream.concat(listRectangle.stream(), listCircle.stream()).collect(Collectors.toList());
        return list.stream().sorted(new FigureAreaComparator()).collect(Collectors.toList());
    }

    /*Вытаскивает фигуры заданного цвета и сортирует их по площади*/
    public List<Figure> findFiguresByColor(String colorName){
        Color color = colorRepository.getColorByName(colorName);
        ModelMapper modelMapper = new ModelMapper();
        List<Figure> listCircle = circleRepository.findAllByColor_Id(color.getId()).stream().map(circle -> modelMapper.map(circle, CircleDto.class)).collect(Collectors.toList());
        List<Figure> listRectangle = rectangleRepository.findAllByColor_Id(color.getId()).stream().map(rectangle -> modelMapper.map(rectangle, RectangleDto.class)).collect(Collectors.toList());
        List<Figure> list = Stream.concat(listRectangle.stream(), listCircle.stream()).collect(Collectors.toList());
        return list.stream().sorted(new FigureAreaComparator()).collect(Collectors.toList());
    }

}
