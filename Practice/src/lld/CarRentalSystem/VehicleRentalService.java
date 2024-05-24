package lld.CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalService {
    private List<User> userList;
    private List<Store> storeList;
    public VehicleRentalService(){
        userList = new ArrayList<>();
        storeList = new ArrayList<>();
    }

    void addUser(User user){
        userList.add(user);
    }
    void removeUser(User user){
        userList.remove(user);
    }
    void addStore(Store store){
        storeList.add(store);
    }
    void removeStore(Store store){
        storeList.remove(store);
    }
    public Store getStore(User user){
        return storeList.getFirst();
    }

    public User getUser(){
        return userList.getFirst();
    }

    public User getUser(int id){
        return userList.stream().filter(user -> user.getUserId()==id).toList().getFirst();
    }
}
