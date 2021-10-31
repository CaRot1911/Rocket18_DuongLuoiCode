package com_vti_backend.sevice;

import com_vti_backend.repository.IAccountRepository;
import com_vti_entity.Employee;
import com_vti_entity.Manager;
import com_vti_entity.Project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccountService implements IAccountService{

    IAccountRepository iAccountRepository;

    public AccountService(IAccountRepository iAccountRepository) {
        this.iAccountRepository = iAccountRepository;
    }

    @Override
    public List<Employee> getListEmp(int idPr) throws SQLException, IOException {
        return iAccountRepository.getListEmp(idPr);
    }

    @Override
    public List<Manager> getListManager(int idPr) throws SQLException, IOException {
        return iAccountRepository.getListManager(idPr);
    }

    @Override
    public List<Project> getListId() throws SQLException, IOException {
        return iAccountRepository.getListId();
    }

    @Override
    public List<Manager> getListManager() throws SQLException, IOException {
        return iAccountRepository.getListManager();
    }

    @Override
    public boolean Login(String mail, String pass) throws SQLException, IOException {
        return iAccountRepository.Login(mail,pass);
    }


}
