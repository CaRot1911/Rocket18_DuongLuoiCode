package src.Exercise_5_Question_1_2;

public class Worker extends Employees{

    private Long rank;

    public Worker(String fullName, Long age, String sex, String address,Long rank) {
        super(fullName, age, sex, address);
        this.rank = rank;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return super.toString() + " "+  rank;
    }
}
