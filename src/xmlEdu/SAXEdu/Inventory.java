package xmlEdu.SAXEdu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lama
 */
public class Inventory {

    public List<Animal> animal = new ArrayList<>();

    public static class Animal {

        @Override
        public String toString() {
            return name + "(" + animalClass + ", " + species + ")";
        }

        /**
         *
         */
        public static enum AnimalClass {
            mammal,
            reptile,
            bird,
            fish,
            amphibian,
            invertebrate
        }


        public AnimalClass animalClass;

        public String name, habitat, species, food, temperament;

        public Double weight;

        public FoodRecipe foodRecipe;
    }

    public class FoodRecipe {

        public String name;
        public List<String> ingridient = new ArrayList<>();

        @Override
        public String toString() {
            return name + ": " + ingridient.toString();
        }
    }

    public FoodRecipe foodRecipe;


}
