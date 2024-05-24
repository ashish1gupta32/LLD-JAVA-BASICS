package lld.observerDesignPattern.observable;

import lld.observerDesignPattern.observer.ObserverService;

public interface IphoneObservable {
    void addObserver(ObserverService observer);
    void removeObserver(ObserverService observer);
    void setStock(int deltaStock);
    void notifyObserver();
    int getStockCount();
}
