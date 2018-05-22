
package clase06;


public class GeneradorExceptions {
    public static void generar(){
        int [] vector = new int[10];
        vector[20]=40;
    }
    
    public static void generar(boolean x){
        if(x){
            System.out.println(10/0);
        }
    }
    
    public static void generar(String nro){
        int numero = Integer.parseInt(nro);
    }
    
    public static void generar(String texto, int indice){
        System.out.println(texto.charAt(indice));
    }
}
