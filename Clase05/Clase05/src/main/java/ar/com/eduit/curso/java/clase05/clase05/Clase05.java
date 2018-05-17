
package ar.com.eduit.curso.java.clase05.clase05;

public class Clase05 {
    
    public static void main(String[] args) {
        //Clase 05  Object - String - System
        
        /*
        Object: Es la clase padre de todas las clases en Java. En su interior
        se define un comportamiento que es hereado a todas las clases y puede ser
        sobreescrito.
        */
        class Ex1{}
        class Ex2 extends Ex1{
            public int length(String texto){
                if(texto==null) return -1;
                return texto.length();
            }
        }
        Ex2 ex2 = new Ex2();
        
        System.out.println(ex2.getClass());
        System.out.println(ex2.getClass().getName());
        System.out.println(ex2.getClass().getSimpleName());
        System.out.println(ex2.getClass().getSuperclass().getSimpleName());
        System.out.println(ex2.getClass().getSuperclass().getSuperclass().getName());
        System.out.println(ex2.getClass().getSuperclass().getSuperclass().getSuperclass());
        
        //null pointer Exception
        //System.out.println(
        //        ex2
        //        .getClass()
        //        .getSuperclass()
        //        .getSuperclass()
        //        .getSuperclass()
        //        .getName()
        //);
        
        System.out.println(ex2.length("hola"));
        String texto= "hola";
        System.out.println(texto.getClass().getName());
        System.out.println(texto.getClass().getSuperclass().getName());
        
        Object obj1 =ex2;
        Object obj2=texto;
        String texto2 =(String)obj2;
        
        class Ex{
            int dato;
            public Ex(int dato){
                this.dato = dato;
            }
            
            //sobreescritura del metodo equeals
            @Override
            public boolean equals(Object obj){
                if(!(obj instanceof Ex)) return false;
                return this.dato==((Ex)obj).dato;
            }
        }
        
        /**
         * me moria en Java
         * -> en e1 se le asigna un espacio de memoria 2
         * -> en el caso e2 es un puntero que apunta al mismo lugar en memoria (java referencia se llama)
         * Los objetos son referenciados y los primitivos crean un nuevo espacio de memoria
         * -> en el tercer caso, por mas que tengan el mismo estado, son dos objetos diferentes
         * -> el quinto caso se puede decir que tiene el mismo estado, pero es otro objeto, de otra familia
         */
        Ex e1 = new Ex(2);
        Ex e2 = e1;
        Ex e3 = new Ex(2);
        Ex e4 = new Ex(3);
        String e5 = "2";
        
        
        /**
         *Con los tipos de datos primitivos son diferentes
         * -> en el primer caso se asigna un espacio que va a tener guardado el dos
         * -> en el segundo caso se asigna un NUEVO lugar en memoria con el dato que contiene en el anterior
         */
        int n1=2;
        int n2=n1;
        
        //Es un id del objeto dentro de java, es una forma para identificarlos.Hacen referencia a la posicion de memoria, pero no quiere decir que sea el espacio asignado, ya que en dos procesos paralelos de java pueden existir hashcode iguales
        System.out.println("e1.hashCode()="+e1.hashCode());
        System.out.println("e2.hashCode()="+e2.hashCode());
        System.out.println("e3.hashCode()="+e3.hashCode());
        System.out.println("e4.hashCode()="+e4.hashCode());
        System.out.println("e5.hashCode()="+e5.hashCode());
        
        
        //Trabaja comparando los metodos hashcode
        System.out.println("e1.equals(e1)="+e1.equals(e1));
        System.out.println("e1.equals(e2)="+e1.equals(e2));
        System.out.println("e1.equals(e3)="+e1.equals(e3));
        System.out.println("e1.equals(e4)="+e1.equals(e4));
        System.out.println("e1.equals(e5)="+e1.equals(e5));
        
        //Clase String: representa un vector de caracteres inmutable, nunca mantiene el mismo objeto, siempre que se realiza un cambio se crea un objeto nuevo
        //Asignacion directa
        String cadena = "Hola soy una cadena de caracteres";
        String cadena2 = new String("Hola");
        char[] vector = {'h','o','l','a'};
        String cadena3 = new String(vector);
        
        String t = " ";
        System.out.println(t+"\t"+t.hashCode());
        t+="h";
        System.out.println(t+"\t"+t.hashCode());
        t+="o";
        System.out.println(t+"\t"+t.hashCode());
        t+="l";
        System.out.println(t+"\t"+t.hashCode());
        t+="a";
        System.out.println(t+"\t"+t.hashCode());
        
        //StringBuilder y StringBuffer
        //pueden contenter un string mutable en un objeto, aumentando la perfomance
        
        //StringBuffer desde jdk1 -> 30% + de velocidad
        //StringBuilder desde jdk5 y es del tipo safe Thread
        
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.toString()+"\t"+sb.hashCode());
        sb.append("h");
        System.out.println(sb.toString()+"\t"+sb.hashCode());
        sb.append("o");
        System.out.println(sb.toString()+"\t"+sb.hashCode());
        sb.append("l");
        System.out.println(sb.toString()+"\t"+sb.hashCode());
        sb.append("a");
        System.out.println(sb.toString()+"\t"+sb.hashCode());
        
        
        //Algunos metodos de la clase String()
        
        //.startWith()  .endsWith()
        
        System.out.println(cadena.startsWith("hola"));
        System.out.println(cadena.startsWith("Hola"));
        System.out.println(cadena.endsWith("chau"));
        
        //.contains()
        System.out.println(cadena.contains("una"));
        System.out.println(cadena.contains("chau"));
        
        //.equals() .equalsIgnoreCase()
        System.out.println(cadena2.equals("HOLA"));
        System.out.println(cadena2.equalsIgnoreCase("HOLA"));
        
        //-substring()
        System.out.println(cadena.substring(5));
        System.out.println(cadena.substring(5, 15));
        
        //Clase System
        //repsenta el Runtime, se encarga de negociar con el entorno de ejecucion
        //Una diferencia con otros lenguajes con c o c# que se compila en binario y va abstraerse del sistema operativo, ya que este binario es interpretado por la maquina virtual de java
        //out:Representa un stream de salida a consola sincronizado.
        //err: Representa un stream de salida a consola no sincronizado.
        //in: Representa un stream de entrada de consola sincronizado.
        
        System.out.println("Hola");
        System.out.println("Hola");
        System.out.println("Hola");
        System.out.println("Hola");
        System.out.println("Hola");
        System.out.println("Hola");
        System.out.println("Hola");
        System.out.println("Hola");
        System.out.println("Hola");
        System.out.println("Hola");
        System.out.println("Hola");
        System.out.println("Hola");
        System.out.println("Hola");
        System.err.println("Ocurrio un error.");
        
        //metodo .exit()
        //cierra el runtime
        //0 ok
        //1 error
        //-1 Warning
        //System.exit(0);
        //System.out.println("Esta linea no se ejecuta. ");
        
        //.getProperties()
        System.out.println(System.getProperties());
        System.out.println("---------------------------------------------");
        System.getProperties().forEach((k,v)->System.out.println(k+":  "+v));
        System.out.println("---------------------------------------------");
        System.getenv().forEach((k,v)->System.out.println(k+": "+v));
        
        System.out.println("---------------------------------------------");
        
        //.getProperty()
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getenv("NUMBER_OF_PROCESSORS"));
    }
}
