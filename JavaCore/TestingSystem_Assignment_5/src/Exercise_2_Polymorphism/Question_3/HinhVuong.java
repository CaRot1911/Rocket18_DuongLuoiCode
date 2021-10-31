package Exercise_2_Polymorphism.Question_3;

public class HinhVuong extends HinhChuNhat {

    private Double a;
    public HinhVuong(Double cd, Double cr) {
        super(cd, cr);
        this.a = cd;
        this.a = cr;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }


    public void tinhchuVi() {
        System.out.println("HV");
        System.out.println("C: " + 4*getA());
    }

    public void tinhdienTich() {
        System.out.println("HV");
        System.out.println("S: " + getA()*getA());
    }
}
