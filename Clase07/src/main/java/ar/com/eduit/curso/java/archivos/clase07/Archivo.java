
package ar.com.eduit.curso.java.archivos.clase07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Archivo implements I_Archivo {
    
    private File file;

    public Archivo(File file) {
        this.file = file;
    }
    
    public Archivo(String file){
        this.file = new File(file);
    }  
    
    @Override
    public void print() {
        
        int car;
        //Apartir de jdk7 se puede controlar el try catch, pasandole por parametro 
        //sino se utiliza esta version de try cath, hay que cerrar 
        try(FileReader in = new FileReader(file);)
        {
            while((car=in.read())!=-1){
                System.out.print((char)car);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    @Override
    public String getText() {
        //Al imprimir, hay un solo caractger en memoria, en el anterior metodo, 
        //en este habria que controlar que el archivo no exceda la memoria en uso
        StringBuilder sb = new StringBuilder();
        int car;
        try(FileReader in = new FileReader(file);)
        {
            while((car=in.read())!=-1){
                sb.append((char)car);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return sb.toString();  
    }

    @Override
    public void setText(String text) {
        //lo borra lo que estaba anteriormente
        try(FileWriter out = new FileWriter(file);){
            out.write(text);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void appendText(String text) {
        //Al poner true, le decimos que haga un append
        try(FileWriter out = new FileWriter(file,true);){
            out.write(text);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void addLine(String line) {
        //Se podria re llamar a este metodo para agregar una linea
        //appendText(line+"\n");
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file,true));){
            out.write(line);
            out.newLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<String> getLines() {
        String linea;
        List<String>lista = new ArrayList();
        try(BufferedReader in = new BufferedReader(new FileReader(file));){
            //Java 8
            //lista.addAll((List<String>)in.lines());
            while((linea=in.readLine())!=null){
                lista.add(linea);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    @Override
    public Set<String> getLinkedHashLines() {
        Set<String> set = new LinkedHashSet();
        set.addAll(getLines());
        return set;
    }

    @Override
    public Set<String> getTreeLines() {
        Set<String> set = new TreeSet();
        set.addAll(getLines());
        return set;
       
    }

    @Override
    public void removeLine(String line) {
        List<String>lista=getLines();
        lista.remove(line);
        addLines(lista);
    }

    @Override
    public void addLines(Collection<String> lines) {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file));){
            for(String st:lines){
                out.write(st+"\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
