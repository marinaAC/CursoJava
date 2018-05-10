package ar.com.eduit.curso.java.interfaces;

public interface I_File {
    /**
     * Este metodo devuelve el texto del archivo
     * @return
     */
    String getText();
    void setText(String text);
    void appendText(String text);
    
    //apartir de java 8
    default void info(){
        System.out.println("Interface Archivo");
    }
}
