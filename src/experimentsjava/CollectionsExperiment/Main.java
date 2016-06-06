package experimentsjava.CollectionsExperiment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lama
 */
public class Main {

    public static void main(String[] args) {
        String[] a1 = {"some", "1"};
        String[] a2 = {"Another", "2"};
        List<String[]> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);


        list.stream().forEach((_item) -> {
            for (String s : _item){
                System.out.println(s);
            }

        });
    }


}
