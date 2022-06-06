package com.rightstep.figure.repository;

import com.rightstep.figure.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

    Color getColorByName(String colorName);

}

