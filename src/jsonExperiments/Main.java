package jsonExperiments;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.Map.Entry;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Lama
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException, IOException {

        File file = new File(Main.class.getResource("json.json").toURI());
        Reader r = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(r);

        String lineString = br.readLine();
        StringBuilder sb = new StringBuilder();

        while (lineString != null) {
            sb.append(lineString).append("\n");
            lineString = br.readLine();
        }

        String fileAsString = sb.toString();

        JsonObject person;
        try (JsonReader jsonReader = Json.createReader(new StringReader(fileAsString))) {
            person = jsonReader.readObject();
            //Json to Map
            JsonElement root = new JsonParser().parse(fileAsString);
            com.google.gson.JsonObject object = root.getAsJsonObject().get("config").getAsJsonObject();
            Gson gson = new Gson();
            for (Entry<String, JsonElement> entry : object.entrySet()) {
                ConfigModel model = gson.fromJson(entry.getValue(), ConfigModel.class);
                System.out.println(model.getDescription());

            }
        }

        System.out.println("Name: " + person.getString("name"));
        System.out.println("Description: " + person.getString("description"));

    }

}
