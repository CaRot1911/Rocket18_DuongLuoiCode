package src.Exercise_5_Question_1_2;

public class Engineer extends Employees{
    private String trainingIndustry;

    public Engineer(String fullName, Long age, String sex, String address,String trainingIndustry) {
        super(fullName, age, sex, address);
        this.trainingIndustry = trainingIndustry;
    }

    public String getTrainingIndustry() {
        return trainingIndustry;
    }

    public void setTrainingIndustry(String trainingIndustry) {
        this.trainingIndustry = trainingIndustry;
    }

    @Override
    public String toString() {
        return super.toString() + " " + trainingIndustry;
    }
}
