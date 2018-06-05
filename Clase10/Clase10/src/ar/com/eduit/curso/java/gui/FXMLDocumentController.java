package ar.com.eduit.curso.java.gui;

import ar.com.eduit.curso.java.connector.Connector;
import ar.com.eduit.curso.java.dao.repositorios.AlumnoR;
import ar.com.eduit.curso.java.dao.repositorios.CursoR;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.util.Fx.FxTable;
import ar.com.eduit.curso.java.util.validaciones.Validator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class FXMLDocumentController implements Initializable {
    
    private AlumnoR ar;
    private CursoR cr;
    
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEdad;
    @FXML
    private Label lblInfoAlumno;
    @FXML
    private ComboBox<Curso> cmbCursos;
    @FXML
    private TableView<Alumno> tblAlumnos;
    @FXML
    private TextField txtBuscarApe;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ar = new AlumnoR(Connector.getConnection());
        cr = new CursoR(Connector.getConnection());
        cargar();
    }    

    private void cargar() {
        cmbCursos.getItems().addAll(cr.getAll());
        cmbCursos.getSelectionModel().selectFirst();
        
        //cargar tblalumnos
        new FxTable().cargar(ar.getAll(), tblAlumnos);
    }    

    @FXML
    private void agregarAlumno(ActionEvent event) {
        if(validarAlumno()){
            Alumno alumno = new Alumno(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    Integer.parseInt(txtEdad.getText()),
                    cmbCursos.getSelectionModel().getSelectedItem().getId()
            );
            ar.save(alumno);
            lblInfoAlumno.setText("Se dio de alta un alumno id: "+alumno.getId());
            limpiarAlumno();
            cargar();
        }
    }
    
    private boolean validarAlumno(){
        //validar nombre entre 2 y 20 caracteres;
        if(!new Validator(lblInfoAlumno,txtNombre.getText(),"nombre").length(2,20))return false;
        //validar apellido entre 2 y 20 caracteres;
        if(!new Validator(lblInfoAlumno, txtApellido.getText(),"apellido").length(2,20))return false;
        //validar edad entre 18 y 120 años;
        if(!new Validator(lblInfoAlumno, txtEdad.getText(),"edad").isInteger(18,120))return false;
        return true;
    }
    
    private void limpiarAlumno(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        cmbCursos.getSelectionModel().selectFirst();
        txtNombre.requestFocus();
    }
    
    @FXML
    private void buscarApe(KeyEvent evt){
        new FxTable().cargar(ar.getLikeApellido(txtBuscarApe.getText()), tblAlumnos);
    }
    
    @FXML
    private void borrarAlumno(ActionEvent evt){
        Alumno alumno = tblAlumnos.getSelectionModel().getSelectedItem();
        if(alumno == null)return;
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Borrar Alumnos. ");
        alert.setContentText("Desea borrar el alumno "+alumno.getNombre()+"?");
        if(alert.showAndWait().get().equals(ButtonType.OK)){
            ar.remove(alumno);
            lblInfoAlumno.setText("Se borro un alumno");
        }
        cargar();
    }
}
