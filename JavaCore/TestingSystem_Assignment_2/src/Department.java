public class Department {
    public int DepartmentID;
    String departmentName;

    Department(){

    }

    public Department(int DepartmentID, String departmentName){
        this.DepartmentID = DepartmentID;
        this.departmentName = departmentName;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentID(int departmentID) {
        this.DepartmentID = departmentID;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + DepartmentID +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
