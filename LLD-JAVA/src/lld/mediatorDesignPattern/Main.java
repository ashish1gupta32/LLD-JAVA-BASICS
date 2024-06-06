package lld.mediatorDesignPattern;

public class Main {
    public static void main(String[] args){
        Mediator mediator=new Bider();
        Colleague user1=new User(mediator,"User1");
        Colleague user2=new User(mediator,"User2");
        Colleague user3=new User(mediator,"User3");
        Colleague user4=new User(mediator,"User4");

        user1.placeBid(127);
        System.out.println("..............");
        user2.placeBid(130);
        System.out.println("..............");
        user3.placeBid(156);
        System.out.println("..............");
        user4.placeBid(189);

    }
}
