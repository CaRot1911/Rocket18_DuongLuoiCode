package Back_End.Exercise_1;

import Emty.Students;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File_IOStream implements Serializable {

    public void Questions1() throws IOException, ClassNotFoundException {
        Students student = new Students(1,"A");
        Students student1 = new Students(2,"A");
        Students student2 = new Students(3,"A");
        List<Students> lst = new ArrayList<>();
        lst.add(student);
        lst.add(student1);
        lst.add(student2);

        String filePath = "E:\\VTI\\VTI_Java\\TestingSystem_Assignment_7\\file\\VTI.ser";
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Students elem : lst){
            oos.writeObject(elem);
        }
        oos.close();

        int count = 0;
        List<Students> newLst = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ois.read();
        try{
            for (;;){
                Students s = (Students) ois.readObject();
                newLst.add(s);

            }
        }catch (EOFException e){
            System.out.println();
        }

        fis.close();
        ois.close();
        for (Students students : newLst){
            System.out.println(students.toString());
        }

    }
}
