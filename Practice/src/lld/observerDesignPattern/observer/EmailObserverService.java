package lld.observerDesignPattern.observer;

import lld.observerDesignPattern.observable.IphoneObservable;

public class EmailObserverService implements ObserverService {

    private String userName;
    private IphoneObservable iphoneObservable;

    public EmailObserverService(String userName, IphoneObservable iphoneObservable) {
        this.userName = userName;
        this.iphoneObservable = iphoneObservable;
    }

    @Override
    public void update() {
        sendEmail(userName, "product is in stock hurry up!");
    }

    private void sendEmail(String userName, String s) {
        System.out.printf("mail sent to %s\n", userName);
    }
}
