package lecturaArchivos2;

import java.util.ArrayList;
import java.util.Collections;

public class OperacionData {

    //Arreglo de profesores
    ArrayList<Profesor> informacion = new ArrayList<>();

    //Agrega datos a la lista general
    public void agregarInformacion(ArrayList<Profesor> info) {
        //informacion = new ArrayList<Profesor>(info.subList(1, 4));
        informacion = info;
    }

    //Obtiene la lista de profesores
    public ArrayList<Profesor> obtenerInformacion() {
        return informacion;
    }

    public double obtenerPromedioCapacidad() {
        double suma = 0;
        return suma;
    }

    //Ordena a los profesores por canton
    public void ordenarPorCanton() {
        ArrayList<Profesor> dataPorCantones = new ArrayList<>();
        dataPorCantones.addAll(informacion);
        Collections.sort(dataPorCantones,
                (o1, o2) -> o1.canton.compareTo(o2.canton));
        for (int i = 0; i < dataPorCantones.size(); i++) {
            System.out.print(dataPorCantones.get(i));
        }
    }

    //Ordena a los profesores por sus nombres y apellidos
    public ArrayList<Profesor> ordenarPorNombres() {
        ArrayList<Profesor> dataPorNombres = new ArrayList<>();
        dataPorNombres.addAll(informacion);
        Collections.sort(dataPorNombres,
                (o1, o2) -> o1.nombres.compareTo(o2.nombres));
        return dataPorNombres;

    }

    //Suma el numero de docentes considerando el atributo personalidad ('Por Convocar' / 'Adecuado')
    public void totalPersonalidad() {
        int profesoresPorConvocar = 0;
        int profesoresAdecuado = 0;
        for (Profesor profesor : informacion) {
            if (profesor.getPersonalidad().equals("POR CONVOCAR")) {
                profesoresPorConvocar++;
            } else if (profesor.getPersonalidad().equals("ADECUADO")) {
                profesoresAdecuado++;
            }
        }
        System.out.println("Total de profesores con personalidad 'Por Convocar': " + profesoresPorConvocar);
        System.out.println("Total de profesores con personalidad 'Adecuado': " + profesoresAdecuado);
    }

    //Suma el numero de docentes considerando el atributo idoneidad ('Idoneo' / 'No Idoneo')
    public void totalIdoneidad() {
        int profesoresIdoneo = 0;
        int profesoresNoIdoneo = 0;
        for (Profesor profesor : informacion) {
            if (profesor.getDictamenIdoniedad().equals("IDONEO")) {
                profesoresIdoneo++;
            } else if (profesor.getDictamenIdoniedad().equals("NO IDONEO")) {
                profesoresNoIdoneo++;
            }
        }
        System.out.println("Total de profesores con idoneidad 'Idoneo': " + profesoresIdoneo);
        System.out.println("Total de profesores con idoneidad 'No idoneo': " + profesoresNoIdoneo);

    }

    //Imprime los datos almacenados en la lista de docentes
    public void lecturaData() {
        for (int i = 0; i < obtenerInformacion().size(); i++) {
            System.out.println(obtenerInformacion().get(i));

        }

    }

}
