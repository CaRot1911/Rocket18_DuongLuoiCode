public class Position {
    public int positionID;
    String positionName;

    public Position(){

    }

    public Position(int positionID, String positionName){
        this.positionID = positionID;
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionID=" + positionID +
                ", positionName='" + positionName + '\'' +
                '}';
    }
}
