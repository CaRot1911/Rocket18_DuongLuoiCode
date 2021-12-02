package programTest;

import entity.Salary;
import repository.SalaryRepository;

import java.util.List;

public class SalaryTest {

    public static void main(String[] args) {

        SalaryRepository salaryRepository = new SalaryRepository();

        List<Salary> salaryList = salaryRepository.getAllSalary();

        for (Salary elem : salaryList){
            System.out.println(elem.getSalaryID() +"-" +elem.getSalaryName());
        }
    }
}
