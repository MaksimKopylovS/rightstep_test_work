package com.rightstep.figure.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "rectangle")
@NoArgsConstructor
public class Rectangle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_color")
    private Color color;

    @Column(name = "name")
    private String name;

    @Column(name = "side_one")
    private double side_one;

    @Column(name = "side_two")
    private double side_two;

    @Column(name = "diagonal")
    private double diagonal;

    @Column(name = "perimetr")
    private double perimetr;

    @Column(name = "area")
    private double area;

}
