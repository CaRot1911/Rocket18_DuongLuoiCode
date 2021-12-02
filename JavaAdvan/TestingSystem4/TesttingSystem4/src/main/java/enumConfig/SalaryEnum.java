package enumConfig;

public enum SalaryEnum {
    Dev("600"),Test("700"),ScrumMaster("1500"),PM("2000");

    private String status;

    private SalaryEnum(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static SalaryEnum toEnum(String sql){
        for (SalaryEnum elem : SalaryEnum.values()){
            if(elem.getStatus().equals(sql)){
                return elem;
            }
        }
        return null;
    }
}
