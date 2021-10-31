package Emty.hinhoc;

public class HinhHoc {
    public static int count = 0;
    public final int max = 5;

    public HinhHoc() throws Exception {
        count++;
        if(count > max){
            throw new Exception("Số lượng hình tối đa là:" + max);
        }

    }

    public float S(){
        return 0;
    }
    public float C(){
        return 0;
    }
}
