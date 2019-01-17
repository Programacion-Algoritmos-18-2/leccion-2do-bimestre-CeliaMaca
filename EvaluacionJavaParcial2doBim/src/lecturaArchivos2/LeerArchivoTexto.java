package lecturaArchivos2;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

public class LeerArchivoTexto {

    private Scanner entrada;

    //Abre un archivo
    public void abrirArchivo(String archivo) {
        try {
            entrada = new Scanner(new File(archivo));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    }    

    //Lee los registros de un archivo TXT
    public ArrayList<Profesor> leerRegistrosTXT() {

        OperacionData operacion = new OperacionData();
        ArrayList<Profesor> lista = new ArrayList<>();

        try // lee registros del archivo, usando el objeto Scanner
        {
            entrada.nextLine();
            while (entrada.hasNext()) {
                Gson g = new Gson();
                String linea = entrada.nextLine();
                //Se transforma un JSON a un objeto de tipo Profesor
                Profesor p = g.fromJson(linea, Profesor.class);
                //Agrega el objeto a la lista de profesores
                lista.add(p);

            }

        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        return lista;
    }
    
    //Lee los registros de un archivo CSV
    public  ArrayList<Profesor>  leerRegistrosCSV(){
        OperacionData operacion = new OperacionData();
        ArrayList<Profesor> lista = new ArrayList<>();
        entrada.useDelimiter(",");
        entrada.hasNext();
        while(entrada.hasNext()){
            String linea [] = entrada.nextLine().split(",");
            //Se crea un objeto profesor y se lo agrega a la lista de profesores
            lista.add(new Profesor(linea[0], linea[1], linea[2], linea[3], linea[4], linea[5], linea[6], linea[7]));
        }
        return lista;       
        
    }

    //Cierra el archivo
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    }
}