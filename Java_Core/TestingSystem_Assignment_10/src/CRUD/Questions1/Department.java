package CRUD.Questions1;

import CRUD.ConnectData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Department  {
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

    public ArrayList<Department> getDepartments() throws SQLException {
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
        return departmentList;
    }

}
