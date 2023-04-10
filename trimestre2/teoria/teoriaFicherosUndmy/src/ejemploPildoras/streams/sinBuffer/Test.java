/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploPildoras.streams.sinBuffer;

import ejemploPildoras.streams.sinBuffer.Lectura;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author casty
 */
public class Test {
    public static void main(String[] args) {
        Lectura accediendo = new Lectura();
        accediendo.leerFichero();
        Escribiendo accediendoEscri = new Escribiendo();
        accediendoEscri.escribir();
        accediendoEscri.escribirFicheExistente();
        
    }
}

class Escribiendo {
    public String ruta = 
        "C:\\Users\\casty\\OneDrive\\Documentos\\NetBeansProjects\\programacion_2tri_v2\\teoria\\teoriaFicherosUndmy\\src\\ejemploPildoras\\ejemploEscritura.txt";
    
    public void escribir (){
        String frase = "prueba de escritura";
        try {
            FileWriter escritura = new FileWriter(ruta);
            for (int i = 0;i < frase.length(); i++){
                escritura.write(frase.charAt(i));
            }
            escritura.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    public void escribirFicheExistente (){
    String frase = "prueba de escritura pati";
        try {
            FileWriter escritura = new FileWriter(ruta,true); // añadimos
            for (int i = 0;i < frase.length(); i++){
                escritura.write(frase.charAt(i));
            }
            escritura.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    
    
}
