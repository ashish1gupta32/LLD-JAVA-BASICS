package lld.factoryDesignPattern.factory;

import lld.factoryDesignPattern.CarType;
import lld.factoryDesignPattern.cars.Car;

public interface CarFactory {
    Car createCar(CarType type);
}
