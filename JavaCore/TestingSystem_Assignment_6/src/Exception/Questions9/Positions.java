package Exception.Questions9;

import Exception.Questions8.ScannerUtils;

public class Positions {

    private Integer id;
    private String name;

    public Positions(){
        id = ScannerUtils.inputInt();
        name = ScannerUtils.inputString();
    }
}
