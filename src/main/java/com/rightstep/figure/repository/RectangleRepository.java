package com.rightstep.figure.repository;

import com.rightstep.figure.model.Rectangle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RectangleRepository extends JpaRepository<Rectangle, Long> {
    List<Rectangle> findAllByColor_Id(long l);
}
