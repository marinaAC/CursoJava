/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase04;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author EducaciónIT
 */
public class FXMLDocumentController implements Initializable {
    
    //Con esta anotacion estoy diciendo que este elemento existe en la vista
    //sino llega a estar este elemento voy a tener une error 
    //@FXML
    //private Label label;
    
    //@FXML
    //private void handleButtonAction(ActionEvent event) {
    //    System.out.println("You clicked me!");
    //    label.setText("Hello World!");
    //}
    private List<CheckBox> listaCheck;
    private ToggleGroup grupoEstado;
    @FXML
    private TextField txtNombre;
    @FXML
    private CheckBox chkBici;
    @FXML
    private CheckBox chkMoto;
    @FXML
    private CheckBox chkAuto;
    @FXML
    private TextArea txaTexto;
    @FXML
    private RadioButton radSoltero;
    @FXML
    private RadioButton radCasado;
    @FXML
    private RadioButton radViudo;
    @FXML
    private RadioButton radDivorciado;
    //en el ? es de generics
    @FXML
    private ComboBox<String> cmbColores;
    
    @FXML
    private void aceptar(ActionEvent event){
        //JOptionPane.showMessageDialog(null, "Hola "+txtNombre.getText()); tipo swing
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Hola "+txtNombre.getText());
        alert.show();
    }
    
    //Se ejecuta al iniciar el programa
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Formulario inicializado");
        armarListaCheck();
        armarGrupoEstado();
        cargarCmbColores();
    }    
    
    private void cargarCmbColores(){
        //cmbColores.getItems().addAll("Rojo","Verde","Azul","Blanco","Negro","Amarillo","Gris");
        //cmbColores.getSelectionModel().selectFirst();
        //utilizamos el mapa de colores, con un diccionario dentro, para poder realizar una clave de traduccion facil
        MapaColores.getMap().forEach((k,v)->cmbColores.getItems().add(k));
        cmbColores.getSelectionModel().selectFirst();
    }
    
    /**
     * Los elementos radio en java, para que funcionen tienen queestar agrupados en algo logico
     * 
     */ 
    private void armarGrupoEstado() {
        //se le agrega la logica para que solo se pueda seleccionar de a uno
        grupoEstado= new ToggleGroup();
        grupoEstado.getToggles().addAll(radSoltero,radCasado,radViudo,radDivorciado);
        grupoEstado.selectToggle(radSoltero);
    }    

    private void armarListaCheck() {
        //alt+shift+m
        //arma la lista check
        listaCheck = new ArrayList();
        listaCheck.add(chkBici);
        listaCheck.add(chkMoto);
        listaCheck.add(chkAuto);
    }    

    @FXML
    private void agregar(ActionEvent event) {
        String nombre= txtNombre.getText();
        if(nombre.length()<2)return;
        String texto = "Nombre: "+nombre+".\n";
        //if(chkBici.isSelected())texto+="Tiene Bici.\n";
        //if(chkMoto.isSelected())texto+="Tiene Moto.\n";
        //if(chkAuto.isSelected())texto+="Tiene Auto.\n";
        
        //Chequear como se realiza el for en esta lista
        for(CheckBox ch:listaCheck){
            if(ch.isSelected())texto+="Tiene "+ch.getText()+".\n";
        }
        texto+="Estado civil: "+((RadioButton)grupoEstado.getSelectedToggle()).getText()+".\n";
        texto+="Color: "+cmbColores.getValue()+".\n";
        txaTexto.setStyle("-fx-control-inner-background:"+MapaColores.getMap().get(cmbColores.getValue())+";");
        limpiar();
        txaTexto.setText(texto);
    }
    
    private void limpiar(){
        txtNombre.setText("");
        //chkBici.setSelected(false);
        //chkMoto.setSelected(false);
        //chkAuto.setSelected(false);
        for(CheckBox ch:listaCheck){
            ch.setSelected(false);
        }
        grupoEstado.selectToggle(radSoltero);
        txtNombre.requestFocus();
    }
    
   
    
}
