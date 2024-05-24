package lld.factoryDesignPattern.factory;

import lld.factoryDesignPattern.CarType;
import lld.factoryDesignPattern.cars.Car;
import lld.factoryDesignPattern.cars.LuxuryGermanCar;
import lld.factoryDesignPattern.cars.SportsGermanCar;

public class GermanCarFactory implements CarFactory{
    @Override
    public Car createCar(CarType type) {

        return switch (type){
            case SPORTS -> new SportsGermanCar();
            case LUXURY -> new LuxuryGermanCar();
        };

    }
}
