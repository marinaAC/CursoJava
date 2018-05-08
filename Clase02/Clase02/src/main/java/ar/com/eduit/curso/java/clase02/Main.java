package ar.com.eduit.curso.java.clase02;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        //Clase 02 POO
        //Las clases declaran los atributos, y los objetos le ponen estado.
        //clase interna
        class Auto {

            //atributos
            String marca;
            String modelo;
            String color;
            int velocidad;

            //METODO CONSTRUCTOR
            /*  
                Tiene caracteristicas especiales, el mismo nombre que la clase.
                Inicializan a un objeto, se invoca automaticamente al construir un objeto
                Si una clase no tiene constructor el compilador agrega uno vacio en tiempo de compilacion.
             */
            //Anotation aparecieron apartir de java 5
            //Este metodo esta deprecado, se encuentra obsoleto. Quiere decir que se puede usar, pero proximamente se puede llegar a sacar

            /**
             * Metodo deprecado por ser inseguro el 08/05/2018 por Carlos rios
             * usar Auto(String marca, String modelo, String color)
             *
             * @deprecated
             */
            @Deprecated
            Auto() {
                //creo el constructor vacio, para conservar el funcionamiento anterior
            }

            Auto(String marca, String modelo, String color) {
                this.marca = marca;
                this.modelo = modelo;
                this.color = color;
                this.velocidad = 0;
            }

            //métodos
            void acelerar() { //internamente el compilador les modifica el nombre ej: acelerar
                //velocidad+=10;
                //if(velocidad>100) velocidad = 100;
                acelerar(10);
            }

            //sobrecarga de metodos
            void acelerar(int kms) { //acelerarInt
                velocidad += kms;
                if (velocidad > 100) {
                    velocidad = 100;
                }
            }

            void frenar() {
                velocidad -= 10;
                if (velocidad < -20) {
                    velocidad = -20;
                }
            }

            //No esta bueno que las clases de negocios me impriman cosas
            void imprimirVelocidad() {
                System.out.println(velocidad);
            }

            //A diferencia de los void, tienen retorno de valor
            int getVelocidad() {
                return velocidad;
            }

            //Metodo sobreescrito
            @Override
            public String toString() {
                return marca + " " + modelo + " " + color + " " + velocidad + " kms.";
            }
        }//end class Auto
        System.out.println("-- auto1 --");
        Auto auto1 = new Auto();
        auto1.marca = "Fiat";
        auto1.modelo = "Idea";
        auto1.color = "Rojo";
        auto1.acelerar();       //10
        auto1.acelerar();       //20
        auto1.acelerar();       //30
        auto1.frenar();         //20
        System.out.println(auto1.marca + " " + auto1.modelo + " " + auto1.color + " " + auto1.velocidad);
        //Los atributos String se inicializan en null automaticamente.
        //Los atributos numericos se inicializan en 0 automaticamente.

        System.out.println("-- auto2 --");
        Auto auto2 = new Auto();
        auto2.marca = "Ford";
        auto2.modelo = "Fiesta";
        auto2.color = "Azul";
        //Esta tratando de acelerar mas de lo permitido
        for (int a = 0; a <= 467; a++) {
            auto2.acelerar();
        }
        System.out.println(auto2.marca + " " + auto2.modelo + " " + auto2.color + " " + auto2.velocidad);

        System.out.println("--Auto3--");
        Auto auto3 = new Auto("Renault", "Kangoo", "Bordo");
        auto3.acelerar();
        auto3.imprimirVelocidad();
        System.out.println(auto3.getVelocidad());
        //clase que arma cuadros de dialogos, se tiene que importar, se encuentra en el paquete javaxswing
        //todo lo que esta en el paquete java.lang
        JOptionPane.showMessageDialog(null, "Velocidad = " + auto3.getVelocidad());

        auto3.acelerar(25);
        //Metodo toString() todos heredan de object
        //devuelve el nombre de la clase, que pertenece al main
        //y es interna a la clase portadora, y devuelve un codigo llamado hash. 
        //Utilizado para identificar los objetos en memoria
        //Esto sucede antes de que lo haya sobreescrito
        System.out.println(auto3.toString());
        System.out.println(auto3);
        //Las clases que estan dentro de un mismo paquete no es necesario importarlas
        System.out.println("-- empleado1 --");
        Empleado empleado1 = new Empleado(1, "Leonardo", "Herrera", 40000);
        System.out.println(empleado1);
        
        //Construir diagrama UML
        /*
         * Operadores de Visibilidad 
           Modificador              Alcance
           omitido(default)         es visible desde la misma clase y clases del mismo paquete.
           public                   es visible desde cualquier clase de cualquier paquete
           private                  solo es visibles desde lamisma clase.
           protected                Es visible desde la misma clase y clases hijas, mismo paquete.
        */
    }//end main
}//end Clase02
