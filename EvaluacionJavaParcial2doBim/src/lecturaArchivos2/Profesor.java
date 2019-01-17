/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;

/**
 *
 * @author reroes
 */
/*
{"cedula":"1803742806","nombres":"MULLO ROMERO ESTHER DEL CARMEN", 
"zona":"ZONA 3","provincia":"TUNGURAHUA", 
"canton":"AMBATO", "personalidad": "POR CONVOCAR", 
"razonamiento":"POR CONVOCAR", 
"dictamenIdoniedad":"NO IDONEO"}
*/

public class Profesor {
    String cedula;
    String nombres;
    String zona;
    String provincia;
    String canton;
    String personalidad;
    String razonamiento;
    String dictamenIdoniedad;

    //Metodo constructor
    public Profesor(String cedula, String nombres, String zona, String provincia, String canton, String personalidad, String razonamiento, String dictamenIdoniedad) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.zona = zona;
        this.provincia = provincia;
        this.canton = canton;
        this.personalidad = personalidad;
        this.razonamiento = razonamiento;
        this.dictamenIdoniedad = dictamenIdoniedad;
    }

    //Obtiene el parametro de personalidad del objeto
    public String getPersonalidad(){
        return this.personalidad;
    }
    
    //Obtiene el parametro de idoneidad del objeto
    public String getDictamenIdoniedad(){
        return this.dictamenIdoniedad;
    }
    
    //Metodo para formatear la salida de un objeto
    public String toString(){
        return String.format("%-15s | %-40s | %-10s | %-10s \n", cedula, nombres, zona, canton);
    }
}







