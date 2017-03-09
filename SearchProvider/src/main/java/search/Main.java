package search;

import java.io.IOException;
import java.util.List;

/**
 * Created by kp on 2017-03-09.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        SearchProvider searchEngine = new GoogleSearchByApi("C:\\Users\\kp\\Desktop\\soft\\AccessFiles\\accessGS.txt");

        List<String> list =  searchEngine.getLinks("Wrocław",20);

        int i =1;
        for (String link:list) {
            System.out.println(i++ +" "+ link);
        }

        System.out.println("================================================");

        searchEngine = new GoogleSearchByWeb();

        list = searchEngine.getLinks("Wroclaw", 20);

        i=1;
        for (String link:list) {
            System.out.println(i++ +" "+ link);
        }
    }
}
