package lld.proxyDesignPattern.dao;

import java.nio.file.AccessDeniedException;

public class EmployeeDaoProxy implements EmployeeDao{
    EmployeeDao employeeDao;
    public EmployeeDaoProxy(){
        employeeDao=new EmployeeDaoImpl();
    }
    @Override
    public void insert(String role,Object data) throws AccessDeniedException {
        if ("ADMIN".equalsIgnoreCase(role))
            employeeDao.insert(role,data);
        else throw new AccessDeniedException("access denied");
    }
}
