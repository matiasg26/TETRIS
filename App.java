package tetris;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Tetris!");
        stage.show();
        stage.setResizable(false);
        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot(), Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        stage.setScene(scene);
        // Create top-level object, set up the scene, and show the stage here.
    }

    /*
     * Here is the mainline! No need to change this.
     */
    public static void main(String[] argv) {
        // launch is a method inherited from Application
        launch(argv);
    }
}
