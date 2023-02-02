package com.qa.polymorphism.repos;

import com.qa.polymorphism.entities.Car;

import java.util.List;

public interface CarRepo {

    void create(Car c);

    List<Car> read();

    void update();

    void delete();
}
