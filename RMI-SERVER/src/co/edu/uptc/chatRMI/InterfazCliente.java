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
public interface InterfazCliente extends Remote {
    
    public void mostrarMensaje(String mensaje) throws RemoteException;
    
}
