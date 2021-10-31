package src.Exercise_6_Abstraction_Question_1;

public class Test {
    public static void main(String[] args) {

        VnPhones vnPhones = new VnPhones();

        vnPhones.insertContact("Duong","12345678");
        vnPhones.insertContact("Huy","12345678");
        vnPhones.insertContact("Hung","12345678");

        //vnPhones.searchContact("Duong");

        //vnPhones.removeContact("huy");
        //vnPhones.searchContact("huy");

        vnPhones.updateContact("hung","2468");
        vnPhones.searchContact("hung");


        //System.out.println(vnPhones.getContacts().size());
    }
}
