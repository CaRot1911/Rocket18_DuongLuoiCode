package Exception.Questions10;

import Exception.Questions8.ScannerUtils;

public class Group {
    private Integer id;
    private String nameGroup;

    public Group(){
        id = ScannerUtils.inputInt();
        nameGroup = ScannerUtils.inputString();
    }
}
