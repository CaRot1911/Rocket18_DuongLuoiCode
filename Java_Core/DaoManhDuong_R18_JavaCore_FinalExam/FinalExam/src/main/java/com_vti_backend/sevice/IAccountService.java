package com_vti_backend.sevice;

import com_vti_entity.Employee;
import com_vti_entity.Manager;
import com_vti_entity.Project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IAccountService {
    public List<Employee> getListEmp(int idPr) throws SQLException, IOException;
    public List<Manager> getListManager(int idPr) throws SQLException, IOException;
    public List<Project> getListId() throws SQLException, IOException;
    public List<Manager> getListManager() throws SQLException, IOException;
    public boolean Login(String mail,String pass) throws SQLException, IOException;
}
