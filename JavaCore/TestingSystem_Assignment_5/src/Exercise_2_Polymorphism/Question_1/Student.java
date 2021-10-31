package Exercise_2_Polymorphism.Question_1;

public class Student implements IStudent{
    private Long id;
    private String name;
    private Integer group;

    public Student(Long id, String name, Integer group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    @Override
    public void diemDanh() {
        System.out.println(getName() + " điểm danh");
    }

    @Override
    public void hocBai() {
        System.out.println(getName() + " đang học bài");
    }

    @Override
    public void donVeSinh() {
        System.out.println(getName() + " đi dọn vệ sinh");
    }
}
