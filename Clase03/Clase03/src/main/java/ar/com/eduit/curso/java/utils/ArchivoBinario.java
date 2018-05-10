
package ar.com.eduit.curso.java.utils;

import ar.com.eduit.curso.java.interfaces.I_File;

public class ArchivoBinario implements I_File {

    @Override
    public String getText() {
        return "Texto archivo binario";
    }

    @Override
    public void setText(String text) {
        System.out.println("Escribiendo archivo binario");
    }

    @Override
    public void appendText(String text) {
        System.out.println("Apendizando archivo binario");
    }
    
}
