/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author EducaciónIT
 */
public class Clase04 extends Application {
    
    /**
     *clase starter que crea un recurso xml y llama al controler
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //La escena es lo que va dentro de la ventana, lo que modelamos de la vista
        Scene scene = new Scene(root);
        stage.setTitle("Primer formulario");
        //stage.setMaximized(true);
        //es dada por el sistema operativo, es toda la ventana de windows
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
