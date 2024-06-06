package lld.observerDesignPattern;

import lld.observerDesignPattern.observable.IphoneObservable;
import lld.observerDesignPattern.observable.StockObservableImpl;
import lld.observerDesignPattern.observer.EmailObserverService;
import lld.observerDesignPattern.observer.MobileAlertObserverService;
import lld.observerDesignPattern.observer.ObserverService;

public class Main {
    public static void main(String[] args) {
        IphoneObservable observable=new StockObservableImpl();

        ObserverService observer1=new MobileAlertObserverService("observer1",observable);
        ObserverService observer2=new EmailObserverService("observer2",observable);
        ObserverService observer3=new MobileAlertObserverService("observer3",observable);
        ObserverService observer4=new EmailObserverService("observer4",observable);

        observable.addObserver(observer1);
        observable.addObserver(observer2);
        observable.addObserver(observer3);
        observable.addObserver(observer4);

        observable.setStock(10);
        observable.setStock(-10);
        observable.setStock(10);

    }
}
