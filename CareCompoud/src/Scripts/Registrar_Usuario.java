/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scripts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author usuario
 */
public class Registrar_Usuario {

    public static String[][] ficheroUser;

    public String[][] getFicheroUser() {
        return ficheroUser;
    }

    public void setFicheroUser(String[][] ficheroUser) {
        this.ficheroUser = ficheroUser;
    }

    public Registrar_Usuario(String[][] ficheroUser) {
        this.ficheroUser = ficheroUser;
        
    }
    

    public String[][] retornarFichero() {

        // variables necesarias
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        //Registrar_Usuario ru = new Registrar_Usuario();
        try {
            // Apertura del fichero y creacion de BufferedReader para leer
            archivo = new File("src\\BD_txts\\USUARIOS.TXT"); // Aquí cambiarle la ruta y colocarle la ruta de tu archivo .txt
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea = "";
            String filas[];
            // String fichero[][];
            String datosFichero = "";
            int nLineas = 0;

            //Contar Líneas del Fichero
            while ((linea = br.readLine()) != null) {

                datosFichero += linea + "\n";

                nLineas++;

            }

            filas = datosFichero.split("\n");

            //fichero = new String[filas.length][ru.contarColumnas(filas[0], '|')];
            ficheroUser = new String[filas.length][contarColumnas(filas[0], '|')];

            int j = 0;

            for (int i = 0; i < filas.length; i++) {

                //fichero[i] = filas[i].split("\\|");
                ficheroUser[i] = filas[i].split("\\|");

            }
            
            

        }// System.out.println(ficheroUser[1][0]); 
        
        catch (Exception e) {
            e.printStackTrace();
        } finally { // Se cierra (libera) el fichero, ya que si quieres usar ese archivo TXT
            // para otra operación, debe estar cerrado.
            try {
                
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        return ficheroUser;
    } 

    public int contarColumnas(String cadena, char caracter) {

        int cantidad = 0;
        char[] arrayChar = cadena.toCharArray();

        for (int i = 0; i < arrayChar.length; i++) {

            if (arrayChar[i] == caracter) {
                cantidad++;
            }

        }
        return cantidad + 1;
    }
    
}
