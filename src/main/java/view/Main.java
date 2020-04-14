
package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Renê
 */
public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        
        
        URL url = new File("src/main/java/view/home.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Titulo do seu sistema");
        stage.setResizable(false);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}