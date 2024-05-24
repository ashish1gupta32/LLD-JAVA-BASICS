package lld.factoryDesignPattern.factory;

import lld.factoryDesignPattern.CarType;
import lld.factoryDesignPattern.cars.Car;
import lld.factoryDesignPattern.cars.LuxuryEuropenCar;
import lld.factoryDesignPattern.cars.SportsEuropeanCar;

public class EuropeanCarFactory implements CarFactory{
    @Override
    public Car createCar(CarType type) {

        return switch (type) {
            case SPORTS -> new SportsEuropeanCar();
            case LUXURY -> new LuxuryEuropenCar();
        };

    }
}
