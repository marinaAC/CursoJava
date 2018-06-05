package ar.com.eduit.curso.java.util.validaciones;

import javafx.scene.control.Label;
import javax.swing.JLabel;

public class Validator {
    //Atributo que representa un lbl en swing
    private JLabel swLbl = null;
    private Label  fxLbl= null;
    //texto que hay que validar
    private String text;
    //nombre del apellido
    private String nombre;

    public Validator(Label fxLbl, String text, String nombre) {
        this.fxLbl = fxLbl;
        this.text = text;
        this.nombre = nombre;
    }

    public Validator(JLabel swLbl, String text, String nombre) {
        this.swLbl = swLbl;
        this.text = text;
        this.nombre = nombre;
    }
    private void setText(String text){
        if(swLbl!=null)swLbl.setText(text);
        if(fxLbl!=null)fxLbl.setText(text);
    }
    
    
    //valida que tenga la cantidad de caracteres correspondientes
    public boolean length(int length){
        if(text.length()==length)return true;
        setText(nombre+" debe tener "+length+" caracteres");
        return false;
    }
    
    //Valida que este entre4 un minimo y un maximo
    public boolean length(int min, int max){
        if(text.length()>=min && text.length()<=max)return true;
        setText(nombre+" debe tener entre "+min+" y "+max+" caracteres");
        return false;
    }
    
    public boolean isInteger(){
        try {
            Integer.parseInt(text);
        return true;
        } catch (Exception e) {
            setText(nombre+" debe ser un numero entero. ");
            return false;
        }
    }
    
    public boolean isInteger(int min, int max){
        if(!isInteger())return false;
        int nro=Integer.parseInt(text);
        if(nro>=min && nro<=max)return true;
        setText(nombre+ " debe ser un numero entre "+min+" y "+max+".");
        return false;
    }
}

