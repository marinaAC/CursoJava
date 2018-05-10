
package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.interfaces.I_File;
import ar.com.eduit.curso.java.utils.ArchivoBinario;
import ar.com.eduit.curso.java.utils.ArchivoCaracter;


public class TestInterface {
    public static void main(String[] args) {
        //No se puede obtener un objeto de una interface ya que es igual a una abstracta
        I_File file = null;
        //file = new ArchivoCaracter();
        file = new ArchivoBinario(); 
        //Hay que elegir una de las implementaciones
        file.setText("Hola");
        file.appendText("Chau");
        System.out.println(file.getText());
        file.info();
    }
}
