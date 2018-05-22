
package clase06;


public class NoHayMasPasajesException extends Exception {
    String nombre;
    int cantidad;

    public NoHayMasPasajesException(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "El vuelo "+  nombre + ",no tiene " + cantidad + " pasajes";
    }
    
    
    
    
}
