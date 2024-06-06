package lld.mediatorDesignPattern;


public class User implements Colleague {
    Mediator mediator;
    String name;
    User(Mediator mediator,String name){
        this.name=name;
        this.mediator=mediator;
        mediator.addBider(this);
    }
    @Override
    public void placeBid(int val) {
        mediator.addBide(this,val);
    }
    @Override
    public String getName(){return this.name;}
    @Override
    public void receiveBidNotification(Colleague colleague, int val) {
        System.out.println(name+" has notified that "+colleague.getName()+" has bided "+ val+" amount");
    }
}
