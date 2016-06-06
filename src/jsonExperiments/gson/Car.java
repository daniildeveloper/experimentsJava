package jsonExperiments.gson;

import com.google.gson.annotations.Expose;

/**
 *
 * @author daniiltserin
 */
public class Car {

    public String brand = null;
    public int doors = 0;

    @Expose
    private String some = null;

    public String getSome() {
        return some;
    }

    public void setSome(String some) {
        this.some = some;
    }

}
