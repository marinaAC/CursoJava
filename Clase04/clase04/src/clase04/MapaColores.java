
package clase04;

import java.util.LinkedHashMap;
import java.util.Map;


public class MapaColores {
    //su valor es dela clase, no puede tener valor en un objeto
    public static Map<String,String> getMap(){
        Map<String,String>mapa = new LinkedHashMap();
        mapa.put("Rojo", "red");
        mapa.put("Verde", "green");
        mapa.put("Azul", "blue");
        mapa.put("Blanco", "white");
        mapa.put("Negro", "black");
        mapa.put("Amarillo", "yellow");
        mapa.put("Gris", "gray");
        return mapa;
    }
}
