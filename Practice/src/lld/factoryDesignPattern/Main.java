package lld.factoryDesignPattern;

import lld.factoryDesignPattern.cars.Car;
import lld.factoryDesignPattern.factory.CarFactory;
import lld.factoryDesignPattern.factory.EuropeanCarFactory;
import lld.factoryDesignPattern.factory.GermanCarFactory;


import java.util.List;

import static lld.factoryDesignPattern.CarType.*;

public class Main {
    public static void main(String[] args) {
        CarFactory germanCarFactory=new GermanCarFactory();
        EuropeanCarFactory europeanCarFactory = new EuropeanCarFactory();

//        Car germanSportsCar = germanCarFactory.createCar(SPORTS);
//        Car germanLuxuryCar = germanCarFactory.createCar(LUXURY);
//        Car europeanSportsCar = europeanCarFactory.createCar(SPORTS);
//        Car europeanLuxuryCar = europeanCarFactory.createCar(LUXURY);

        List.of(
                germanCarFactory.createCar(SPORTS),
                germanCarFactory.createCar(LUXURY),
                europeanCarFactory.createCar(SPORTS),
                europeanCarFactory.createCar(LUXURY)
        ).forEach(Car::drive);
    }
}
