
package ar.com.eduit.curso.java.util.archivos;

import java.util.Collection;
import java.util.List;
import java.util.Set;


public interface I_Archivo {
    
     void print();
    String getText();
    void setText(String text);
    void appendText(String text);
    void addLine(String line);
    void addLines(Collection<String>lines);
    /**
     *Devuelve un List de lineas con duplicados
     */
    List<String>getLines();
    /**
     *Devuelve un set de lineas sin duplicados;
     */
    Set<String>getLinkedHashLines();
    /**
     *Devuelve sin lineas duplicadas y ordenadas alfabeticamente
     */
    Set<String>getTreeLines();
    /**
     * Borra la linea
     */
    void removeLine(String line);
}

