package Emty.hinhoc;

public class HinhChuNhat extends HinhHoc {
    public static int countHCN = 0;
    private float d;
    private float r;

    public HinhChuNhat(float d,float r) throws Exception {
        super();
        this.d = d;
        this.r = r;
        countHCN++;
    }

    public float getD() {
        return d;
    }

    public float getR() {
        return r;
    }

    @Override
    public float S() {
        return d*r;
    }

    @Override
    public float C() {
        return (d+r)*2;
    }
}
