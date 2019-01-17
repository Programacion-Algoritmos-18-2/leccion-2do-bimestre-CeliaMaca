package lecturaArchivos2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrearArchivoTexto {
    
    //Crea un nuevo archivo en el directorio root del proyecto con la informacion pasada por parametro
    public void crearArchivo(String texto){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("ArchivoGenerado.txt", "UTF-8");
            writer.println(texto);
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearArchivoTexto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CrearArchivoTexto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }
}
