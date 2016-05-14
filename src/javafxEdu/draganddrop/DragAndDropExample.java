package javafxEdu.draganddrop;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Lama
 */
public class DragAndDropExample extends Application {

    final Text source = new Text(50, 100, "DragMe");
    
    final Text target = new Text(30, 50, "Drag Here");

//    private static final DataFormat customFormat = new DataFormat("javafxEdu.draganddrop");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Scene scene = new Scene(root, 300, 250);
        root.getChildren().addAll(source, target);

        /**
         * теперь мы можем перетаскивать элемент.
         */
        source.setOnDragDetected((MouseEvent event) -> {
            //drag was detected. start drag gesture
            //allow any transfer mode
            Dragboard db = source.startDragAndDrop(TransferMode.ANY);

            //put a string on db
            ClipboardContent content = new ClipboardContent();
            content.putString(source.getText());
            db.setContent(content);

            event.consume();
        });

        target.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != target && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        target.setOnDragExited((DragEvent event) -> {
            target.setFill(Color.BLACK);
            event.consume();
        });

        target.setOnDragEntered((DragEvent event) -> {
            if (event.getGestureSource() != target && event.getDragboard().hasString()) {
                target.setFill(Color.GREEN);
                event.consume();
            }
        });

        target.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            boolean success = false;

            if (db.hasString()) {
                target.setText(db.getString());
                success = true;
            }

            event.setDropCompleted(success);
            event.consume();

        });

        source.setOnDragDone((DragEvent event) -> {
            if (event.getTransferMode() == TransferMode.MOVE) {
                source.setText("");
            }
//            source.setText("SetText");

            event.consume();
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
