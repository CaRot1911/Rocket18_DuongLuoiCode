package com_vti_backend.repository;


import com_vti_database.ConnectWithDataBase;
import com_vti_entity.Employee;
import com_vti_entity.Manager;
import com_vti_entity.Project;
import com_vti_entity.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements  IAccountRepository{

    private final String pass = "123456";
    @Override
    public List<Employee> getListEmp(int idPr) throws SQLException, IOException {

        ConnectWithDataBase con = new ConnectWithDataBase();
        Connection connection = con.getConnection();

//        Statement statement = connection.createStatement();
        String query = "SELECT u.id,u.FullName,e.ProSkill FROM User u JOIN Employee e ON u.id = e.id JOIN Project p ON"
                +" e.projectId=p.projectId WHERE p.projectId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,idPr);
        ResultSet resultSet = preparedStatement.executeQuery();


        List<Employee> employeesLst = new ArrayList<>();
        while (resultSet.next()){
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setFullName(resultSet.getString("FullName"));
            employee.setProSkill(resultSet.getString("ProSkill"));

            employeesLst.add(employee);
        }
        con.disConnect();
        return employeesLst;
    }

    @Override
    public List<Manager> getListManager(int idPr) throws SQLException, IOException {
        List<Manager> managerList = new ArrayList<>();

        ConnectWithDataBase con = new ConnectWithDataBase();
        Connection connection = con.getConnection();

//        Statement statement = connection.createStatement();
        String query = "SELECT u.id,u.FullName,m.ExpInYear FROM User u JOIN Manager m ON u.id = m.id JOIN Project p ON m.id="
                +"p.idManager WHERE p.projectId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,idPr);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()){
            Manager manager = new Manager();
            manager.setId(resultSet.getInt("id"));
            manager.setFullName(resultSet.getString("FullName"));
            manager.setExpInYear(resultSet.getInt("ExpInYear"));

            managerList.add(manager);

        }
        con.disConnect();
        return managerList;
    }

    @Override
    public List<Manager> getListManager() throws SQLException, IOException {
        List<Manager> managerList = new ArrayList<>();

        ConnectWithDataBase con = new ConnectWithDataBase();
        Connection connection = con.getConnection();

        Statement statement = connection.createStatement();
        String query = "SELECT m.id,u.FullName,m.ExpInYear FROM Manager m JOIN User u ON u.id = m.id";

        ResultSet resultSet = statement.executeQuery(query);


        while (resultSet.next()){
            Manager manager = new Manager();
            manager.setId(resultSet.getInt("id"));
            manager.setFullName(resultSet.getString("FullName"));
            manager.setExpInYear(resultSet.getInt("ExpInYear"));

            managerList.add(manager);

        }
        con.disConnect();
        return managerList;
    }

    @Override
    public List<Project> getListId() throws SQLException, IOException {
        List<Project> projectList = new ArrayList<>();

        ConnectWithDataBase con = new ConnectWithDataBase();
        Connection connection = con.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Project";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            Project project = new Project();
            project.setIdPr(resultSet.getInt("projectId"));

            projectList.add(project);
        }
        con.disConnect();
        return projectList;
    }

    @Override
    public boolean Login(String mail, String pass) throws SQLException, IOException {
        List<User> userList = new ArrayList<>();


        ConnectWithDataBase con = new ConnectWithDataBase();
        Connection connection = con.getConnection();

        Statement statement = connection.createStatement();
        String query  =  "SELECT Email,Password FROM User";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            User user = new User();
            user.setEmail(resultSet.getString("Email"));
            user.setPassword(resultSet.getString("Password"));
            userList.add(user);
        }
        for (User elem : userList){
            if (mail.equalsIgnoreCase(elem.getEmail()) && pass.equalsIgnoreCase(elem.getPassword())){
                return true;
            }
        }
        con.disConnect();
        return false;
    }



}
