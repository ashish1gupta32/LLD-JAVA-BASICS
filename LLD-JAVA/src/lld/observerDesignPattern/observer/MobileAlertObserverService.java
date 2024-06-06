package lld.observerDesignPattern.observer;

import lld.observerDesignPattern.observable.IphoneObservable;

public class MobileAlertObserverService implements ObserverService {
    private String userName;
    private IphoneObservable iphoneObservable;

    public MobileAlertObserverService(String userName, IphoneObservable iphoneObservable) {
        this.userName = userName;
        this.iphoneObservable = iphoneObservable;
    }

    @Override
    public void update() {
        sendAlert(userName, "product is in stock hurry up!");
    }

    private void sendAlert(String userName, String s) {
        System.out.printf("alert sent to %s\n", userName);
    }

}
