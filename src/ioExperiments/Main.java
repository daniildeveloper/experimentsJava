package ioExperiments;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Lama
 */
public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        File file = new File(new URI(Main.class.getResource("file.json").toString()));

        String fileParentPath = file.getParent();
        File fileParent = new File(fileParentPath);

        System.out.println(fileParent.length());

    }

}
