package enumConfig;

public enum TypeQuesEnum {
    Esay("0"),MultipleChoice("1");

    private String status;

    private TypeQuesEnum(String status){
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public static TypeQuesEnum toEnum(String sql){
        for(TypeQuesEnum item : TypeQuesEnum.values()){
            if(item.getStatus().equals(sql)){
                return item;
            }
        }
        return null;
    }
}
