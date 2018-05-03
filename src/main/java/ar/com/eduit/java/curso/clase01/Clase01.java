/**
 * -Nombres: hay que darle unisidad a los nombres de paquetes
 *            en los paquetes no se usa camelcase.
 *
 * Dominio de donde estan los paquetes, cada punto es una carpeta
 */
package ar.com.eduit.java.curso.clase01;

/**
 * Clase principal del proyecto. Curso de JAVA, Mayo 2018.
 *
 * @author EducaciónIT
 */
public class Clase01 {

    //psvm -->tab arma el metodo main
    /**
     * Punto de entrada del proyecti
     *
     * @param args argumentos que ingresan desde cnsola
     *
     */
    public static void main(String[] args) {
        /*
        Curso: Java Standar Programming 8
        Días: Martes y Jueves 9
        Profesor: Carlos Ríos carlos.rios@educacionit.com
        Softwaew: jdk 8             www.oracle.com
                  netbeans ide 8.2  netbeans.org
        Materiales: alumni.educacionit.com
        user: email
        pass: dni
        
         */

        /**
         * Java Doc Debe colocarse antes de la declaracion de clase o metodo
         * queda difinido en la inetrace de la clase en ejecutar se puede
         * ingresar a generar java doc
         */
        //sout TAB atajo de teclado para system.out.println
        System.out.println("Hola mundo!!");

        //Tipo de datos primitivos de JAVA
        //Tipos de datos enteros
        //tipos de datos boolean 1 byte
        boolean bo = true;
        System.out.println(bo);
        bo = false;
        System.out.println(bo);

        //Tipo de datos byte 1 byte signed
        byte by = 100;
        System.out.println(by);

        /*
            byte by; (signed)
            se me creo un vector cn 256 numeros
            |------|------|
        -128       0       127

            byteU by viene de unsigned, sin signo
        |---------------|
        0               255
         */
        //Tipo de datos short 2 bytes, enteros cortos
        short sh = 500;
        System.out.println(sh);

        //Tipo de datos int 4 bytes
        int in = 2000;
        System.out.println(in);

        //Tipo de datos long    8 bytes
        //se agrega la L mayus para indicar que es Long y no un int, es una especie de casteo
        long lo = 50000000000L;
        System.out.println(lo);

        //Tipo de datos char, 2 bytes unsigned sin signo guarda un numero entero, pero imprime un caracter asci
        char ch = 65;
        System.out.println(ch);

        ch += 32; //le estoy sumando 32 a la variable 
        System.out.println(ch);

        //Tipos de punto flotante
        //Tipo float 32 bits, indicar que es float como el Long
        float fl = 5.45F;
        System.out.println(fl);

        //Tipo double 64 bits
        double dl = 5.45;
        System.out.println(dl);

        fl = 10;
        dl = 10;
        //Muest6ra 8 digitos, sin contar el ultimo digito, ya que no se tiene que contar porque es impresiso
        System.out.println(fl / 3);
        //Muestra 17 digitos, contando el punto pero excluyendo el ultimo, ya que suele ser impresiso
        System.out.println(dl / 3);
        fl = 100;
        dl = 100;
        //Al ser el entero mas grande, la parte decimal se achico, dejando un digito menos para el decimal. Se lo condisera punto flotante, ya que el punto va corriendose
        System.out.println(fl / 3);
        System.out.println(dl / 3);

        //Clase string: tiene comportamientos primitivos, pero es una clase
        String st = "Esto es una cadena de texto!!";//se guarda en un vector char
        System.out.println(st);

        //Recorrido de el String st como un vector
        for (int i = 0; i < st.length(); i++) {
            //el metodo charat le doy un indice y me devuelve un caracter
            System.out.print(st.charAt(i));
        }
        System.out.println();

        //Imprimir en mayusculas el string 
        for (int i = 0; i < st.length(); i++) {
            char car = st.charAt(i);
            if (car >= 97 && car <= 132) {
                car -= 32;
            }
            System.out.print(car);
        }
        System.out.println();
        
        //Operador Ternario ? si esto es verdad, tengo que restar 32, else serian los :
        for(int i = 0;i<st.length();i++){
            char car = st.charAt(i);
            System.out.print((car>=97&&car<=122)?car-=32:car);
        }
        System.out.println();
        
               
        funcion2("hola",2);
        funcion2(null,2);
        funcion2("hola",20);
        
        //Imprimir el string en minisculas
        st = "HoLa";
        for(int i = 0; i<st.length();i++){
            char car = st.charAt(i);
            System.out.print((car>=65&&car<=90)?car+=32:car);
        }
        System.out.println();
        
        System.out.println(st.toUpperCase());
        System.out.println(st.toLowerCase());
    }//end main   
    
    public static boolean funcion(boolean x){
       return x;
        /*if(x){
            return true;
        }
        return false;*/
    }
    
    public static void funcion2(String texto, int index){
        //Una forma de evitar las lineas y muchas validaciones, pregunto por el caso incorrecto para cortar la funcion antes
        //Operador binario tiene un solo | como un or excluyente, mira el primer el termino y mira el segundo (investigala siguiente condicion)
        //Operador Logico || mira el primero, mira el operador si ya obtiene resultado lo corta, sino lo mira
        if(texto == null || index>=texto.length()) return;
        System.out.println(texto.charAt(index));
    }
}//end Clase01
