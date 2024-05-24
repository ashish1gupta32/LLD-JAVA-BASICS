package lld.proxyDesignPattern;

import lld.proxyDesignPattern.dao.EmployeeDao;
import lld.proxyDesignPattern.dao.EmployeeDaoImpl;
import lld.proxyDesignPattern.dao.EmployeeDaoProxy;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        try {
            employeeDao.insert("User", "data");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        try {
            employeeDao.insert("Admin", "data");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        StringBuilder sb=new StringBuilder();
    }
}
