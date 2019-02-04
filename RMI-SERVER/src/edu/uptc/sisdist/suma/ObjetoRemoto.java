/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.sisdist.suma;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Carlos Arenas
 */
public class ObjetoRemoto extends UnicastRemoteObject implements InterfaceRemota{

    public ObjetoRemoto() throws RemoteException {
        super();
    }

    @Override
    public int suma(int a, int b){
        System.out.println ("Sumando " + a + " + " + b +"...");
        return a+b;
    }
    
    public int multiplicar(int a, int b){
        System.out.println ("Multiplicando " + a + " * " + b +"...");
        return a*b;
    }

    @Override
    public int resta(int a, int b) throws RemoteException {
        System.out.println ("Restando " + a + " * " + b +"...");
        return a-b;
    }

    @Override
    public int division(int a, int b) throws RemoteException {
         System.out.println ("Dividiendo " + a + " * " + b +"...");
        return a/b;
    }
    
}
