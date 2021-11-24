package programTest;

import entity.DetailDepartment;
import repository.DetailDepartmentRepository;

import java.util.List;

public class DetailDepartmentTest {

    public static void main(String[] args) {

        DetailDepartmentRepository departmentRepository = new DetailDepartmentRepository();

        List<DetailDepartment> list = departmentRepository.getAllDetailDepartment();

        for (DetailDepartment elem : list){
            System.out.println(elem.getDepartmentID().getDepartmentID() + "-" + elem.getAddressID().getAddressID() + "-" + elem.getEmulationPoint());
        }
    }
}
