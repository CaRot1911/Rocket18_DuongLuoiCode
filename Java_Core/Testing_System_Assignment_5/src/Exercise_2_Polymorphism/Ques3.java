package Exercise_2_Polymorphism;

import Exercise_2_Polymorphism.Question_3.HinhChuNhat;
import Exercise_2_Polymorphism.Question_3.HinhVuong;

public class Ques3 {
    public static void main(String[] args) {


        HinhChuNhat hinhChuNhat = new HinhVuong(2d,2d);

        hinhChuNhat.tinhChuVi();
        hinhChuNhat.tinhDienTich();
    }
}
