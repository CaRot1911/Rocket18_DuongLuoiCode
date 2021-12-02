package programTest;

import entity.Address;
import repository.AddressRepository;

import java.util.List;

public class AddressTest {

    public static void main(String[] args) {

        AddressRepository addressRepository = new AddressRepository();

        List<Address> addressList = addressRepository.getAllAddress();

        for (Address elem : addressList){
            System.out.println(elem.getAddressID() + "-" + elem.getAddressName());
        }
    }
}
