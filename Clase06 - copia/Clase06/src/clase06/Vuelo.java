package clase06;

public class Vuelo {

    private String nombre;
    private int cantidadPasajes;

    @Override
    public String toString() {
        return "Vuelo{" + "nombre=" + nombre + ", cantidadPasajes=" + cantidadPasajes + '}';
    }

    public Vuelo(String nombre, int cantidadPasajes) {
        this.nombre = nombre;
        this.cantidadPasajes = cantidadPasajes;
    }

    //Formas de lanzar la exception con un throws
    //synchronized: Bloquea el objeto "vuelo", lo tiene en espera hasta obtener el anterior resultado
    public synchronized void  VenderPasajes(int cantidad) throws NoHayMasPasajesException{
        if(cantidad>cantidadPasajes){
            new NoHayMasPasajesException(nombre,cantidad);
        }
        cantidadPasajes-=cantidad;
    }
}
