package Emty.hinhoc;

public class HinhTron extends HinhHoc{
    public static int countHT = 0;
    private final float PI = 3.14f;
    private float R;
    public HinhTron(float R) throws Exception {
        super();
        this.R = R;
        countHT ++;
    }


    public float getR() {
        return R;
    }

    public void setR(float r) {
        R = r;
    }

    @Override
    public float S() {
        return (float) (Math.pow(R,2)*PI);
    }

    @Override
    public float C() {
        return 4*R*PI;
    }
}
