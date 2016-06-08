package javafxExperiments;

import java.awt.Color;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

/**
 *
 * @author daniiltserin
 */
public class ScrollPaneEdu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = new Stage();
        primaryStage.setTitle("Scrollpane Experiments");

        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

        //creating button
        Button button = new Button();
        button.setTranslateY(20);
        button.setText("Отправить");
        button.setCursor(Cursor.CROSSHAIR);
        button.setPrefSize(200, 30);

        //scrollpane
        ScrollPane sp = new ScrollPane();
        sp.setLayoutX(100);
        sp.setLayoutY(10);
        sp.setCursor(Cursor.CLOSED_HAND);
        sp.setPrefSize(150, 100);
        sp.setTooltip(new Tooltip("Отправка данных"));
        sp.setContent(button);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setPannable(true);
        sp.setPrefViewportHeight(300);
        sp.setPrefViewportWidth(300);

        root.getChildren().add(sp);

    }

    public static void main(String[] args) {
        launch(args);
    }

}
