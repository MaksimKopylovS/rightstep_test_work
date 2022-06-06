package com.rightstep.figure.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "circle")
@NoArgsConstructor
public class Circle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_color")
    private Color color;

    @Column(name = "radius")
    private double radius;

    @Column(name = "name")
    private String name;

    @Column(name = "perimetr")
    private double perimetr;

    @Column(name = "area")
    private double area;

}
