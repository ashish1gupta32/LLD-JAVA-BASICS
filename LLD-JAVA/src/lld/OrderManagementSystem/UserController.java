package lld.OrderManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User>userList=new ArrayList<>();
    void addUser(User user){
        userList.add(user);
    }
}
