package clase06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class Clase06 {

    public static void main(String[] args) {
        Auto[] autos = new Auto[4];

        autos[0] = new Auto("Fiat", "Punto", "Azul");
        autos[1] = new Auto("Renault", "Kangoo", "Bordo");
        autos[2] = new Auto("Ford", "Fiesta", "Verde");
        autos[3] = new Auto("VW", "Up", "Blanco");

        //recorrido por indices
        //for(int a=0;a<autos.length;a++) System.out.println(autos[a]);
        //recorrido forEach
        for (Auto a : autos) {
            System.out.println(a);
        }

        //Interface List
        //Lista Object
        List lista = new ArrayList();

        lista.add(new Auto("Peugeot", "207", "Negro"));
        lista.add(new Auto("Renault", "Fluence", "Gris"));
        lista.add("hola");
        lista.add(23);

        //copiar los autos de autos a lista
        for (Auto a : autos) {
            lista.add(a);
        }

        System.out.println("Longitud de lista: " + lista.size());

        //Recorrido por indices
        //for(int a=0; a<lista.size();a++)System.out.println(a);
        //Recorrido forEach
        //for(Object o:lista) System.out.println(o);
        //Metodo default forEach jdk8
        //lista.forEach(item->System.out.println(item));
        lista.forEach(System.out::println);

        //Uso de Generics <> JDK5
        //Lista tipada de tipo Auto
        List<Auto> lista2 = new ArrayList();
        lista2.add(new Auto("Fiat", "Idea", "Rojo"));
        lista2.add(new Auto("VW", "Gol", "Blanco"));

        //Me veo obligadoa castear ya que los objetos de esta lista son de tipo Object
        Auto auto1 = (Auto) lista.get(0);

        Auto auto2 = lista2.get(0);

        //Copiar los autos de la lista a lista2
        lista.forEach(item -> {
            if (item instanceof Auto) {
                lista2.add((Auto) item);
            }
        });

        System.out.println("------------------------------");
        lista2.forEach(System.out::println);

        //Diferencias entre set y list es que no permite duplicados, cuando list si
        //no hay orden de los elementos (?
        Set<Auto> setAutos;

        //Implementacion HashSet: es la más veloz pero no garantiza el orden de los elementos
        setAutos = new HashSet();
        setAutos.add(new Auto("Citroen", "C4", "Rojo"));
        setAutos.addAll(lista2);
        System.out.println("-------------------");
        setAutos.forEach(System.out::println);

        //Implementación TreeSet: Almacena en un arbol por orden natural
        //Almacena por el codigo hash
        setAutos = new TreeSet();
        setAutos.add(new Auto("Citroen", "C4", "Rojo"));
        setAutos.addAll(lista2);
        System.out.println("-------------------");
        setAutos.forEach(item -> {
            System.out.println(item + "\t \t " + item.toString().hashCode());
        });

        //Implementacion LinkedHashSet: por orden de ingreso
        setAutos = new LinkedHashSet();
        setAutos.add(new Auto("Citroen", "C4", "Rojo"));
        setAutos.addAll(lista2);
        System.out.println("-------------------");
        setAutos.forEach(System.out::println);

        //Clase Stack LIFO 
        //El ultimo que entra es el primero en salir
        //Del ultimo hacia el primero
        Stack<Auto> pilaAutos = new Stack();
        //Cada vez que realizo push, se realiza un metodo al final de la lista
        pilaAutos.push(new Auto("Mercedes", "Clase E", "Negro"));
        pilaAutos.addAll(lista2);
        System.out.println("-----------------------------");
        pilaAutos.forEach(System.out::println);
        System.out.println("-----------------------------");
        System.out.println("Longitud de Pila: " + pilaAutos.size());
        while (!pilaAutos.isEmpty()) {
            System.out.println(pilaAutos.pop());
        }
        System.out.println("Longitud de Pila: " + pilaAutos.size());

        //Interface Queue FIFO 
        Queue<Auto> colaAutos = new LinkedList();
        colaAutos.offer(new Auto("BMW","327","Azul"));
        System.out.println("--------------------------");
        colaAutos.forEach(System.out::println);
        System.out.println("--------------------------");
        System.out.println(colaAutos.size());
        while(!colaAutos.isEmpty()){
            //Me devuelve el primer elemento y lo quita
            System.out.println(colaAutos.poll());
        }
        System.out.println(colaAutos.size());
        
        System.out.println("--------------------------");
      /*  try{
            System.out.println(10/0);
            System.out.println("Esta linea no se ejecuta");
        }catch(Exception e){
            System.out.println("Ocurrio un error");
            System.out.println(e);
        }finally{
            //Opcional
            System.out.println("El programa termina normalmente");
        }*/
      
      //Caputa personalizada de exceptions
      try{
          GeneradorExceptions.generar(null,20);
      }catch(IndexOutOfBoundsException e){
          System.out.println("Indice fuera del rango");
      }catch(ArithmeticException e){
          System.out.println(" Division 0");
      }catch(NumberFormatException e){
          System.out.println("Formato de numero incorrector");
      }catch(NullPointerException e){
          System.out.println("Valor nulo");
      }catch(Exception e){
          System.out.println(e);
      }
      
      
      //Manejo de Exception para validar reglas de negocio
      
      Vuelo v1 = new Vuelo("aer1234",100);
      Vuelo v2 = new Vuelo("lat111",100);
      try{
          v1.VenderPasajes(30);
      }catch(NoHayMasPasajesException ex){
          ex.printStackTrace();
      }
      
      
    }
}
