package lld.observerDesignPattern.observable;

import lld.observerDesignPattern.observer.ObserverService;

import java.util.ArrayList;
import java.util.List;

public class StockObservableImpl implements IphoneObservable {
    private final List<ObserverService> observerList=new ArrayList<>();
    private int stock=0;
    @Override
    public void addObserver(ObserverService observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(ObserverService observer) {
        observerList.remove(observer);
    }

    @Override
    public void setStock(int deltaStock) {
        if (stock == 0){
            notifyObserver();
        }
        stock=stock+deltaStock;

    }

    @Override
    public void notifyObserver() {
        observerList.forEach(ObserverService::update);
    }

    @Override
    public int getStockCount() {
        return 0;
    }
}
