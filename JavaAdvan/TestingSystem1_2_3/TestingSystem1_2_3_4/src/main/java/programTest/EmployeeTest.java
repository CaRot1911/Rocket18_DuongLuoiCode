package programTest;

import entity.Employee;
import repository.EmployeeRepository;

import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {

        EmployeeRepository employeeRepository = new EmployeeRepository();

        List<Employee> employeeList = employeeRepository.getListEmployee();

        for(Employee employee : employeeList){
            System.out.println(employee.getAccountID().getAccountID() + "-" + employee.getWorkingNumberOfYear());
        }
    }
}
