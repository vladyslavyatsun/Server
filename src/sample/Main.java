package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();

        primaryStage.setTitle("Receiver");
        primaryStage.setScene(new Scene(root, 425, 475));
        primaryStage.show();

        Server server = new Server(controller);
        server.start();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
