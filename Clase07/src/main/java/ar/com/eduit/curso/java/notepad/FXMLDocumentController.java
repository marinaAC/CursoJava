package ar.com.eduit.curso.java.notepad;
import ar.com.eduit.curso.java.archivos.clase07.Archivo;
import ar.com.eduit.curso.java.archivos.clase07.I_Archivo;
import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


public class FXMLDocumentController implements Initializable {
    
    private I_Archivo archivo;
    private FileChooser fc;
    @FXML
    private TextArea txaTexto;
    @FXML
    private AnchorPane form;
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nuevo(ActionEvent event) {
        txaTexto.setText("");
    }

    @FXML
    private void abrir(ActionEvent event) {
        fc = new FileChooser();
        fc.setTitle("Abrir Archivo");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().add(new ExtensionFilter("tex","*.txt"));
        //Hay que declarar cual es el componente padre para que no puedas deseleccionar la ventana
        File file = fc.showOpenDialog(form.getScene().getWindow());
        if(file == null)return;
        archivo = new Archivo(file);
        txaTexto.setText(archivo.getText());
    }

    @FXML
    private void guardar(ActionEvent event) {
        fc = new FileChooser();
        fc.setTitle("Guardar Archivo");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().add(new ExtensionFilter("tex","*.txt"));
        File file = fc.showSaveDialog(form.getScene().getWindow());
        if(file == null)return;
        archivo = new Archivo(file);
        archivo.setText(txaTexto.getText());
        txaTexto.setText("");
    }

    @FXML
    private void acerca(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Block de notas");
        alert.setContentText("Cuerso de Java Maryo 2018");
        alert.show();
    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }
    
}
