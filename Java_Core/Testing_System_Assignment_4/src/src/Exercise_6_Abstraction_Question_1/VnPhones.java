package src.Exercise_6_Abstraction_Question_1;

public class VnPhones extends Phone{





    @Override
    void insertContact(String name, String phone){
        getContacts().add(new Contacts(name,phone));
    }

    @Override
    void removeContact(String name) {
        Integer count =0;
        for(Contacts elem : contacts) {
            if (name.equalsIgnoreCase(elem.getName())==true) {
                contacts.remove(elem);
                count++;
            }
        }
        if(count == 0){
            System.out.println("No name!!!");
        }
    }

    @Override
    void updateContact(String name, String newPhone) {
        int index = -1;
        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).getName().equalsIgnoreCase(name)){
                index = i;
                break;
            }
        }
      if(index > -1){
          contacts.set(index,new Contacts(name,newPhone));
      }
    }

    @Override
    void searchContact(String name) {
        Integer count =0;
        for(Contacts elem : contacts){
            if(name.equalsIgnoreCase(elem.getName())){
                System.out.println(elem);
                count++;
            }
        }
        if(count == 0){
            System.out.println("No name!!!");
        }
    }

    @Override
    public String toString() {
        return "contacts=" + contacts;
    }
}
