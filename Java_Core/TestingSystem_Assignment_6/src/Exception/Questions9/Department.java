package Exception.Questions9;

import Exception.Questions8.ScannerUtils;

public class Department {
    private Integer id;
    private String name;

    public Department(){
        id = ScannerUtils.inputInt();
        name = ScannerUtils.inputString();
    }
}
