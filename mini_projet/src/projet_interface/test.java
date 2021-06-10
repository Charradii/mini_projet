package projet_interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projet_employe.employe;
import projet_employe_service.employeService;

import java.util.ArrayList;
import java.util.Iterator;

public class test extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("interface1.fxml"));
        primaryStage.setTitle("Gestion entreprise");
        primaryStage.setScene(new Scene(root,685,500));
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

    }

