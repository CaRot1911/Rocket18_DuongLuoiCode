package src.Exercise_4_Question_1;

public class Student {
    private Long id;
    private String name;
    private double hometown;
    private double summary;

    public Student(){
        this.summary = 0f;
        this.hometown = 0f;
    }

    public Student(Long id, String name, double hometown, double summary) {
        this.id = id;
        this.name = name;
        this.hometown = hometown;
        this.summary = summary;
    }


    public void setHometown(double hometown) {
        this.hometown = hometown;
    }

    public void setSummary(double summary) {
        this.summary = summary;
    }

    public double getHometown() {
        return hometown;
    }

    public double getSummary() {
        return summary;
    }

    public void Display(){
        System.out.println("Id: " + id);
        System.out.println("Name: "+name );
        System.out.println("Summary: "+summary);

        if (getSummary() < 4d){
            System.out.println("Academic ability: Weak");
        }else if (4d < getSummary() && getSummary() < 6d){
            System.out.println("Academic ability: Average");
        }else if(6d < getSummary() && getSummary() < 8d){
            System.out.println("Academic ability: Rather");
        }else if (getSummary() > 8d){
            System.out.println("Academic ability: Good");
        }
    }
}
