package com.rightstep.figure.repository;

import com.rightstep.figure.model.Circle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CircleRepository extends JpaRepository<Circle, Long> {

    List<Circle> findAllByColor_Id(long l);

}
