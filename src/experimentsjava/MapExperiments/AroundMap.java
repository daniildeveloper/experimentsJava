package experimentsjava.MapExperiments;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author daniiltserin
 */
public class AroundMap {

    Iterator<Map.Entry<Integer, Integer>> it;
    Map<Integer, Integer> map = new HashMap<>();

    public AroundMap() {
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
    }

    /**
     * использует для обхода Iterator, Map.Entry и цикл while. Выкидывает
     * NullPointerException
     */
    public void usingIterator() {
        long i = 0;
        it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = it.next();
            i += pair.getKey() + pair.getValue();
            System.out.println(i);
        }

    }

    /**
     * классический метод
     */
    public void classicalAround() {
        long i = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            i += pair.getKey() + pair.getValue();
            System.out.println(i);
        }
    }

}
