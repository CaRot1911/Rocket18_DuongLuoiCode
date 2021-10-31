package Exercise_1_Abstraction;

import java.util.Scanner;

public class News implements INews{

    Scanner sc = new Scanner(System.in);

     public Integer id;
     public String title;
     public String publishDate;
     public String author;
     public String content;
     public Float averageRate;

    public News() {
    }

    public News(Integer id, String title, String publishDate, String author, String content, Float averageRate) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.content = content;
        this.averageRate = averageRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Float getAverageRate() {
        return Calculate();
    }

    @Override
    public void Display() {
        System.out.println("Title: " + getTitle());
        System.out.println("PublishDate: " + getPublishDate());
        System.out.println("Author: " + getAuthor());
        System.out.println("Content: " + getContent());
        System.out.println("AverageRate: " + getAverageRate());

    }

    @Override
    public Float Calculate() {
        System.out.println("Input: ");
        Float sum = 0f;
        Float avg = 0f;
        Integer[] Rates = new Integer[3];
        for (int i=0;i<3;i++){
            Rates[i] = sc.nextInt();
            sum = sum + Rates[i];
            avg = sum/3;
        }
        return avg;
    }
}
