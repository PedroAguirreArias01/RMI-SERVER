/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.sisdist.rmiserver;

import edu.uptc.sisdist.suma.InterfaceRemota;
import edu.uptc.sisdist.suma.ObjetoRemoto;
import java.rmi.*;

/**
 *
 * @author CarfherPC
 */
public class RMIServer {

    public RMIServer() {
        try {
            // Se indica a rmiregistry donde estan las clases.
            // Cambiar el path al sitio en el que esta. Es importante
            // mantener la barra al final.
            System.setProperty(
                    "java.rmi.server.codebase",
                    "file:/C:/Users/RA302/Desktop/RMI-JAVA/RMIServer/build/classes");

            // Se publica el objeto remoto
            InterfaceRemota objetoRemoto = new ObjetoRemoto();
            Naming.rebind("ObjetoRemoto", objetoRemoto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Servidor RMI lanzado!");
        new RMIServer();
        //lnlknlkcxnlcnk
    }

}
