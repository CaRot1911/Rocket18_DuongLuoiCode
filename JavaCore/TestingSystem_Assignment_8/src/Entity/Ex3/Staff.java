package Entity.Ex3;

public class Staff <N> extends MyMap<N,String>{
    public Staff(N id, String name) {
        super(id, name);
    }

    public N getId(){
        return getKey();
    }

    public String getName(){
        return super.getValue();
    }
}
