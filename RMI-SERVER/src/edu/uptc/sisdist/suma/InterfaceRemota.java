/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.sisdist.suma;
import java.rmi.*;
/**
 * Interface remota con los métodos que se pueden llamar de forma remota
 * @author Carlos Arenas
 */
public interface InterfaceRemota extends Remote {
    public int suma (int a, int b) throws RemoteException; 
    public int multiplicar(int a, int b) throws RemoteException;
    public int resta (int a, int b) throws RemoteException; 
    public int division(int a, int b) throws RemoteException;
    
    public String mensaje(String mensaje) throws  RemoteException;
    public String clientIP(String ip) throws RemoteException;
    public String nombre(String nombre) throws RemoteException;
    
}
