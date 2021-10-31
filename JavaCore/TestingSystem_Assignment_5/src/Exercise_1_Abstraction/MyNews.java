package Exercise_1_Abstraction;

import java.util.ArrayList;
import java.util.Scanner;

public class MyNews {

    public static void main(String[] args) {

        ArrayList<News> newsArrayList = new ArrayList<>();
        News news = new News();
        int chose = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Input chose: ");
            chose = sc.nextInt();
            switch (chose)
            {
                case 1: // Insert news
                    System.out.println("ID: ");
                    news.id = sc.nextInt();
                    System.out.println("Title: ");
                    news.title = sc.next();
                    System.out.println("PublishDate: ");
                    news.publishDate = sc.next();
                    System.out.println("Author: ");
                    news.author = sc.next();
                    System.out.println("Content: ");
                    news.content = sc.next();
                    System.out.println("=====================");
                    System.out.println("Input Rates: ");
                    news.Calculate();
                    newsArrayList.add(news);break;
                case 2:
                    for (News elem : newsArrayList){
                        elem.Display();
                    }
                    break;
                case 3:
                    System.out.println(news.getAverageRate());
                    break;
                case 4:
                    break;
            }

        }while(chose!=4);

    }
}
