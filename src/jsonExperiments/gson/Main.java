package jsonExperiments.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author daniiltserin
 */
public class Main {

    public static void main(String[] args) {
        //        String json = "{\"brand\":\"Jeep\", \"doors\": 3}";
        //
        //        Gson gson = new Gson();
        //
        //        Car car = gson.fromJson(json, Car.class);
        //
        //        System.out.println(car.brand + "\n" + car.doors);

        Car car = new Car();
        car.brand = "Rover";
        car.doors = 5;
        car.setSome("some");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(car);
        System.out.println(json);
    }

}
