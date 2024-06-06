package lld.proxyDesignPattern.dao;

import java.nio.file.AccessDeniedException;

public interface EmployeeDao {
    void insert(String role,Object data) throws AccessDeniedException;
}
