package ar.com.eduit.curso.java.test;
import ar.com.eduit.curso.java.archivos.clase07.Archivo;
import ar.com.eduit.curso.java.archivos.clase07.I_Archivo;

public class TestArchivo {
    public static void main(String[] args) {
        //String file = "c:texto.txt";
        
        String file = "res/texto.txt";
        I_Archivo archivo = new Archivo(file);
        //archivo.print();
        archivo.setText("Curso de Java. \n");
        archivo.appendText("Primavera.\n");
        archivo.appendText("Verano.\n");
        archivo.appendText("Otoño.\n");
        archivo.appendText("Invierno.\n");
        archivo.addLine("Lunes");
        archivo.addLine("Martes");
        archivo.addLine("Miercoles");
        archivo.addLine("Jueves");
        archivo.addLine("Viernes");
        archivo.addLine("Sabado");
        archivo.addLine("Domingo");
        archivo.addLine("Lunes");
        archivo.addLine("Verano.\n");
        //System.out.println(archivo.getText());
        //archivo.getLines().forEach(System.out::println);
        ///archivo.getLinkedHashLines().forEach(System.out::println);
        archivo.removeLine("Jueves");
        archivo.getTreeLines().forEach(System.out::println);
        
    } 
}
