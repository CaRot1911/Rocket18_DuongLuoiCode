package Back_End.Exercise_1;

import Emty.MyMath;
import Emty.PrimaryStudent;
import Emty.SecondaryStudent;
import Emty.Student;
import Emty.hinhoc.HinhChuNhat;
import Emty.hinhoc.HinhHoc;
import Emty.hinhoc.HinhTron;

public class Static {
            private Student[] students;
            private HinhHoc[] hinhhoc;

            public void Questions1() throws Exception {

           students = new Student[3];

            students[0] = new Student("Nguyễn Văn A");
            students[1] = new Student("Nguyễn Văn B");
            students[2] = new Student("Nguyễn Văn C");

            for (Student elem : students) {
                System.out.println(elem.toString());
            }

            Student.setCollege("Đại học công nghệ");
        }

        public void Questions2(){
            System.out.println("Truoc khi tieu: ");
            System.out.println( Student.getMoneyGroup());

            students[0].Lay(50000);
            System.out.println("Sau khi tieu: " + Student.getMoneyGroup());

            students[1].Lay(20000);
            System.out.println("Sau khi tieu: " + Student.getMoneyGroup());

            students[2].Lay(150000);
            System.out.println("Sau khi tieu: "+ Student.getMoneyGroup());

            for (Student student : students){
                student.countMoney();
            }
            System.out.println("Sau khi dong: "+Student.getMoneyGroup());

        }

        public void Questions3(){
            System.out.println(MyMath.Min(1,2));
            System.out.println(MyMath.Max(1,2));
            System.out.println(MyMath.Sum(1,2));
        }

        public void Questions4(){
                Student.setCollege("Đại học Giao thông");
                for (Student student :students){
                    System.out.println(student.toString());
                }
        }

        public void Questions5(){
            System.out.println("Count: " + Student.count);
        }

        public void Questions6() throws Exception {
            PrimaryStudent student = new PrimaryStudent("Nguyen Van Huy");
            PrimaryStudent student1 = new PrimaryStudent("Nguyen Van Manh");
            SecondaryStudent student2 = new SecondaryStudent("Ha Ngoc Hung");
            SecondaryStudent student3 = new SecondaryStudent("Ha Huy Hung");
            SecondaryStudent student4 = new SecondaryStudent("Ha Hung");
            SecondaryStudent student5 = new SecondaryStudent("Doan Ngoc Hung");
            SecondaryStudent student6 = new SecondaryStudent("Ngo Ngoc Hung");

            System.out.println("PrimaryStudent: " + PrimaryStudent.count2);
            System.out.println("SecondaryStudent: " + SecondaryStudent.counts);
            System.out.println(Student.count);
        }

//        Demo ques7
        public void Questions7() throws Exception {
            Student student = new PrimaryStudent("Nguyen Van Huy");
            Student student1 = new PrimaryStudent("Nguyen Van Manh");
            Student student2 = new SecondaryStudent("Ha Ngoc Hung");
            Student student3 = new SecondaryStudent("Ha Huy Hung");
            Student student4 = new SecondaryStudent("Ha Hung");
            Student student5 = new SecondaryStudent("Doan Ngoc Hung");
            Student student6 = new SecondaryStudent("Ngo Ngoc Hung");
            Student student7 = new SecondaryStudent("Ngo Ngoc Hung");
        }

        public void Questions8() throws Exception {
            HinhHoc h = new HinhTron(3f);
            HinhHoc h1 = new HinhTron(4.3f);
            HinhHoc h2 = new HinhTron(2.3f);
            HinhHoc h3 = new HinhChuNhat(2f,3f);
            HinhHoc h4 = new HinhChuNhat(3f,3f);
            HinhHoc h5 = new HinhChuNhat(6f,9f);
        }

}
