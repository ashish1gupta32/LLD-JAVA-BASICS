package lld.proxyDesignPattern.dao;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void insert(String rol,Object data){
        System.out.println("data is inserted in main table");
    }
}
