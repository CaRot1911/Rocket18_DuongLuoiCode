package CRUD.Questions2;

import CRUD.ConnectData;

import java.sql.*;
import java.util.ArrayList;

public class Department {

    private int id;
    private String depName;

    public Department(){

    }
    public Department(int id, String depName) {
        this.id = id;
        this.depName = depName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void getDepartments() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/sql_noit";
        String username = "root";
        String password = "123456";

        ConnectData connectData = new ConnectData();
        Connection connection = connectData.getConnection(dbURL,username,password);

        Statement statement = connection.createStatement();

        String query = "SELECT * FROM Department";

        ResultSet resultSet = statement.executeQuery(query);

        /* Create ArrayList Department*/
        ArrayList<Department> departmentList = new ArrayList<>();

        while (resultSet.next()){
            Department department = new Department();
            department.setId(resultSet.getInt("DepartmentID"));
            department.setDepName(resultSet.getString("DepartmentName"));

            departmentList.add(department);
        }
        int check = 0;
        for (Department elem : departmentList){
            if(elem.getId() == 5){
                System.out.println(elem.getId() + "-" +elem.getDepName());
                check++;
            }
        }
        if(check == 0){
            System.out.println("Cannot find department which has id = 5");
        }
        connectData.disConnections();
    }

    public void getDepartmentsByID(int id) throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/sql_noit";
        String username = "root";
        String password = "123456";

        ConnectData connectData = new ConnectData();
        Connection connection = connectData.getConnection(dbURL,username,password);

        Statement statement = connection.createStatement();

        String query = "SELECT * FROM Department";

        ResultSet resultSet = statement.executeQuery(query);

        /* Create ArrayList Department*/
        ArrayList<Department> departmentList = new ArrayList<>();

        while (resultSet.next()){
            Department department = new Department();
            department.setId(resultSet.getInt("DepartmentID"));
            department.setDepName(resultSet.getString("DepartmentName"));

            departmentList.add(department);
        }
        int check = 0;
        for (Department elem : departmentList){
            if(elem.getId() == id){
                System.out.println(elem.getId() + "-" +elem.getDepName());
                check++;
            }
        }
        if(check == 0){
            System.out.println("Cannot find department which has id = 5");
        }
        connectData.disConnections();
    }

    public boolean isDepartmentNameExists(String name) throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/sql_noit";
        String username = "root";
        String password = "123456";

        ConnectData connectData = new ConnectData();
        Connection connection = connectData.getConnection(dbURL,username,password);

        Statement statement = connection.createStatement();

        String query = "SELECT * FROM Department";

        ResultSet resultSet = statement.executeQuery(query);

        /* Create ArrayList Department*/
        ArrayList<Department> departmentList = new ArrayList<>();

        while (resultSet.next()){
            Department department = new Department();
            department.setId(resultSet.getInt("DepartmentID"));
            department.setDepName(resultSet.getString("DepartmentName"));

            departmentList.add(department);
        }
        connectData.disConnections();
        for (Department elem : departmentList){
            if(elem.getDepName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }


    /*Check name in Department*/
    public static boolean check(String name) throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/sql_noit";
        String username = "root";
        String password = "123456";

        ConnectData connectData = new ConnectData();
        Connection connection = connectData.getConnection(dbURL,username,password);


        Statement statement = connection.createStatement();
        String query = "SELECT * FROM department";
        boolean checkName = true;
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            if(resultSet.getString("DepartmentName").equalsIgnoreCase(name)){
                checkName = true;
                break;
            }else{
                checkName = false;
            }
        }
        return checkName;
    }

    /*Check Department ID */
    public static boolean check1(int id) throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/sql_noit";
        String username = "root";
        String password = "123456";

        ConnectData connectData = new ConnectData();
        Connection connection = connectData.getConnection(dbURL,username,password);


        Statement statement = connection.createStatement();
        String query = "SELECT * FROM department";
        boolean checkID = true;
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            if(resultSet.getInt("DepartmentID") == id){
                checkID = true;
                break;
            }else{
                checkID = false;
            }
        }
        return checkID;
    }

    public void  createDepartment (String name) throws Exception {
        String dbURL = "jdbc:mysql://localhost:3306/sql_noit";
        String username = "root";
        String password = "123456";

        ConnectData connectData = new ConnectData();
        Connection connection = connectData.getConnection(dbURL,username,password);


        String query = "INSERT INTO department(DepartmentName) VALUES (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,name);

        /*Try catch*/
        if(check(name) == false){
            int count = preparedStatement.executeUpdate();
            System.out.println("After: " + count);
        }else {
            throw new Exception("Department Name is Exists!");
        }
        connectData.disConnections();
    }

    public void  updateDep(String name,int id) throws Exception {
        String dbURL = "jdbc:mysql://localhost:3306/sql_noit";
        String username = "root";
        String password = "123456";

        ConnectData connectData = new ConnectData();
        Connection connection = connectData.getConnection(dbURL,username,password);


        String query = "UPDATE department SET DepartmentName = ? WHERE DepartmentID = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,id);

        /*Try catch*/
        if(check1(id) == true){
                if(check(name) == false){
                    int count = preparedStatement.executeUpdate();
                    System.out.println("After: " + count);
                }
                else {
                    throw new Exception("Department Name is Exists!");
                }
        }else {
            throw new Exception("Cannot find department which has id = " + id);
        }
        connectData.disConnections();
    }

    public void deleteDepartment (int id) throws Exception {
        String dbURL = "jdbc:mysql://localhost:3306/sql_noit";
        String username = "root";
        String password = "123456";

        ConnectData connectData = new ConnectData();
        Connection connection = connectData.getConnection(dbURL,username,password);


        String query = "DELETE FROM department WHERE DepartmentID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        if(check1(id) == true){
            int count = preparedStatement.executeUpdate();
            System.out.println("Count : "+count);
        }else {
            throw new Exception("ID input not in Department");
        }
        connectData.disConnections();
    }

    public void deleteDepartmentUsingProcedure(int id) throws Exception {
        String dbURL = "jdbc:mysql://localhost:3306/sql_noit";
        String username = "root";
        String password = "123456";

        ConnectData connectData = new ConnectData();
        Connection connection = connectData.getConnection(dbURL,username,password);


        String query = "{CALL sp_delete_department(?)}";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(2,id);

        if(check1(id) == true){
            preparedStatement.executeUpdate();
        }else {
            throw new Exception("Cannot find department which has id = "  + id);
        }

        connectData.disConnections();

    }
}
