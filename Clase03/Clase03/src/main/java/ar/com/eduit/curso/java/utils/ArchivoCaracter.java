
package ar.com.eduit.curso.java.utils;

import ar.com.eduit.curso.java.interfaces.I_File;


public class ArchivoCaracter  implements I_File{

    @Override
    public String getText() {
        return "Texto archivo caracter";
    }

    @Override
    public void setText(String text) {
        System.out.println("Se escribio el archivo");
    }

    @Override
    public void appendText(String text) {
        System.out.println("Se apendizo el archivo caracter");
    }
    
}
