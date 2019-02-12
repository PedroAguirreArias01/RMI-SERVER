package co.edu.uptc.chatRMI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author guillermo
 */

//Interfaz que contiene los métodos del servidor que podrán ser invocados de forma remota por el cliente

public interface InterfazServidor extends Remote {
    
    
    public String registrar (String login)  throws RemoteException;
    
    public void difundirMensaje (String mensaje) throws RemoteException;
    
    public boolean desconectar (String login) throws RemoteException;
    
    
}
