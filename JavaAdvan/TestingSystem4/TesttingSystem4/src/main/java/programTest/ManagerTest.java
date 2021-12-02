package programTest;

import entity.Manager;
import repository.ManagerRepository;

import java.util.List;

public class ManagerTest {
    public static void main(String[] args) {

        ManagerRepository managerRepository = new ManagerRepository();

        List<Manager> managerList = managerRepository.getListManager();

        for(Manager manager : managerList){
            System.out.println(manager.getAccountID() + "-" + manager.getManagementNumberOfYear());
        }
    }
}
