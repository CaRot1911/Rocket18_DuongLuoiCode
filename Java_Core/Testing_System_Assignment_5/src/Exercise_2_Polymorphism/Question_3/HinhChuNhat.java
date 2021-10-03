package Exercise_2_Polymorphism.Question_3;

public class HinhChuNhat {

    private Double cd;
    private Double cr;

    public HinhChuNhat(Double cd, Double cr) {
        this.cd = cd;
        this.cr = cr;
    }

    public Double getCd() {
        return cd;
    }

    public void setCd(Double cd) {
        this.cd = cd;
    }

    public Double getCr() {
        return cr;
    }

    public void setCr(Double cr) {
        this.cr = cr;
    }

    public void  tinhChuVi(){
        System.out.println("HCN");
        System.out.println("C: " + (getCd()+getCr())*2);
    }

    public void tinhDienTich(){
        System.out.println("HCN");
        System.out.println("S: " + (getCd()*getCr()));
    }
}
