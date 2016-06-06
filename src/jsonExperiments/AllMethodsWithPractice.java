package jsonExperiments;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * this methid contains another methods with practice
 *
 * @author Lama
 */
public class AllMethodsWithPractice {

    public Gson gson;
    ExampleObject eo;

    public AllMethodsWithPractice() {
        gson = new Gson();
        eo = new ExampleObject();
    }

    class ExampleObject {

        public int a = 3;
        public String s = "String";
        public double d = 22.12;
    }

    /**
     * Gson.toJson() convert Java object to Json
     */
    public void tojson() {

        try {
            //Java object to Json and save into file
            gson.toJson(eo, new FileWriter("C:\\Users\\Lama\\Desktop\\json.json"));
        } catch (IOException ex) {
            Logger.getLogger(AllMethodsWithPractice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
