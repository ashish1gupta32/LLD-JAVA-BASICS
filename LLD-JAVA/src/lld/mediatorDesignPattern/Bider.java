package lld.mediatorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Bider implements Mediator{
    List<Colleague> userList=new ArrayList<>();
    @Override
    public void addBider(Colleague colleague) {
        userList.add(colleague);
    }

    @Override
    public void addBide(Colleague colleague, int val) {
        for(Colleague user:userList){
            if(user != colleague){
                user.receiveBidNotification(colleague,val);
            }
        }
    }
}
