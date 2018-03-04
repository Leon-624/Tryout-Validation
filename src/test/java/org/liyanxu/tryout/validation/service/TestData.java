package org.liyanxu.tryout.validation.service;

import org.liyanxu.tryout.validation.api.model.Car;
import org.liyanxu.tryout.validation.api.model.Person;

public class TestData {

    public static Car getValidCar() {
        return Car.builder()
                .year(2016)
                .make("VW")
                .model("Passat")
                .color("Black")
                .build();
    }

    public static Car getInvalidCar() {
        return Car.builder()
                .year(2016)
                .make("VW")
                .model(null)
                .color("Black")
                .build();
    }

    public static Person getValidPerson() {
        Car car = getValidCar();
        return Person.builder()
                .age(24)
                .name("Leon")
                .firstCar(car)
                .secondCar(null)
                .build();
    }

    public static Person getValidPersonWithInvalidCar() {
        Car car = getInvalidCar();
        return Person.builder()
                .age(24)
                .name("Leon")
                .firstCar(car)
                .secondCar(null)
                .build();
    }

    public static Person getInvalidPersonWithValidCar() {
        Car car = getValidCar();
        return Person.builder()
                .age(300)
                .name("Leon")
                .firstCar(car)
                .secondCar(null)
                .build();
    }
}
