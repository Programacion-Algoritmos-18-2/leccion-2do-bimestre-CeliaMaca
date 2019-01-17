package lecturaArchivos2;

import java.util.ArrayList;
import java.util.Scanner;

public class PruebaLeerArchivoTexto {

    public static void imprimirEncabezados() {
        System.out.println("==========================================");
        System.out.println("=============== BIENVENIDO ===============");
        System.out.println("==========================================");
        System.out.println("\nSeleccione una opción:\n");
        System.out.println("1. Imprimir docentes ordenados por cantón");
        System.out.println("2. Generar archivo de docentes ordenados por nombres y apellidos");
        System.out.println("3. Obtener cuántos docentes tienen personalidad ADECUADO o POR CONVOCAR");
        System.out.println("4. Obtener cuántos docentes están catalogados como IDONEO o NO IDONEO");
        System.out.println("5. Terminar");
        System.out.print("\nOpcion seleccionada: ");
    }

    public static void main(String args[]) {

        LeerArchivoTexto aplicacion = new LeerArchivoTexto();
        OperacionData operacion = new OperacionData();
        Scanner lector = new Scanner(System.in);
        ArrayList<Profesor> lista = new ArrayList<>();
        int variableSwitch = 0;
        boolean terminar = false;

        //Abre archivo TXT y carga los datos en el arreglo
        aplicacion.abrirArchivo("data/data2.txt");
        lista.addAll(aplicacion.leerRegistrosTXT());

        //Abre archivo CSV y carga los datos en el arreglo
        aplicacion.abrirArchivo("data/data1.csv");
        lista.addAll(aplicacion.leerRegistrosCSV());

        //Carga la informacion de la lista
        operacion.agregarInformacion(lista);

        do {
            imprimirEncabezados();
            variableSwitch = lector.nextInt();
            switch (variableSwitch) {

                case 1:
                    //Imprime los encabezados y los datos de los profesores ordenados por canton
                    System.out.print("\n");
                    System.out.printf("%-15s | %-40s | %-10s | %-10s \n\n", "CÉDULA", "NOMBRES Y APELLIDOS", "ZONA", "CANTÓN");
                    operacion.ordenarPorCanton();
                    break;

                case 2:
                    //Obtiene la lista de profesores ordenado por nombres y apellidos
                    ArrayList<Profesor> listaProfesores = operacion.ordenarPorNombres();

                    //Genera archivo de profesores ordenados por nombres y apellidos
                    CrearArchivoTexto crearArchivo = new CrearArchivoTexto();
                    String texto = "";
                    for (Profesor profesor : listaProfesores) {
                        texto += profesor.toString();
                    }
                    crearArchivo.crearArchivo(texto);
                    break;
                
                case 3:
                    //Imprime el total de profesores "Por Convocar" o "Adecuado"
                    operacion.totalPersonalidad();
                    break;
                    
                case 4:
                    //Imprime el total de profesores "Idoneo" o "No Idoneo"
                    operacion.totalIdoneidad();
                    break;
                    
                case 5:
                    terminar = true;
                    System.exit(0);

            }
            System.out.print("\n\n");
        } while (terminar == false);
        
    }
}
