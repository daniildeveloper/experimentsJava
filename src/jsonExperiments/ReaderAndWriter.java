package jsonExperiments;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lama
 */
public class ReaderAndWriter {

    public static void main(String[] args) {
        List<String[]> list = new ArrayList<>();
        String[] s1 = {"a", "b", "c"};
        String[] s2 = {"d", "3", "c2"};

        list.add(s2);
        list.add(s1);

        list.stream().forEach((_item) -> {
            for (String s : _item) {
                System.out.println(s);
            }

        });

        Gson g = new Gson();

    }

}
