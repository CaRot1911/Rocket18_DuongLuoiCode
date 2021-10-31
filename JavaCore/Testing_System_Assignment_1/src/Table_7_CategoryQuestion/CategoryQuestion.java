package Table_7_CategoryQuestion;

public class CategoryQuestion {
    public int categoryID;
    String categoryName;

    CategoryQuestion() {

    }

    public CategoryQuestion(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryQuestion{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
