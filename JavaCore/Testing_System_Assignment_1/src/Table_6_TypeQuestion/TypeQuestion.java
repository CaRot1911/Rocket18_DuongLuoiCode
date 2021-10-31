package Table_6_TypeQuestion;

public class TypeQuestion {
    public int typeID;
    String typeName;

    TypeQuestion() {

    }

    public TypeQuestion(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "typeID=" + typeID +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
