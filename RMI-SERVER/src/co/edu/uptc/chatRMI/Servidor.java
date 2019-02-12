package co.edu.uptc.chatRMI;



import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guillermo
 */

//Clase que realiza las funciones del servidor

public class Servidor implements InterfazServidor {
    
    ArrayList<String> usuariosRegistrados;
    
    static String hostRegistry;
    
    public Servidor() {
        usuariosRegistrados = new ArrayList();
        
    }
    
    public String registrar(String login) {
        
        String respuesta;
        
        if(usuariosRegistrados.contains(login)) {
            respuesta = "usuarioDuplicado";
        }
        else {
            usuariosRegistrados.add(login);
            respuesta = "usuarioAnadido";
            System.out.println("Usuario " + login +" registrado.");
        }
        
        return respuesta;
        
    }
    

    
    @Override
    public boolean desconectar (String login) { //return true si desconectado
        
        boolean desconectado = false;
        
        //Quitamos al usuario del mapa de usuarios registrados
        desconectado = usuariosRegistrados.remove(login);
        
        if(desconectado) { 
            System.out.println("Usuario " + login + " desconectado");
        }
        
        return desconectado;
    }
    
    public void inicializarObjetoRemoto(){
        
        
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }

        
        try {
            
            InterfazServidor interfaz = new Servidor();
            InterfazServidor stub = (InterfazServidor) UnicastRemoteObject.exportObject(interfaz, 0);
            Registry registry = LocateRegistry.getRegistry();
            String nombre_objeto_remoto = "//localhost/servidor";
            registry.rebind(nombre_objeto_remoto, stub);
            //Naming.rebind (nombre_objeto_remoto, interfaz);
            System.out.println("Servidor bound");
            
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
        
        
    } 

    public void difundirMensaje(String mensaje) {
        
        //Debe invocar al metodo mostrar mensaje de cada usuario registrado
        
        for (int i = 0 ; i<usuariosRegistrados.size() ; i++) {
            mostrarMensaje(usuariosRegistrados.get(i), mensaje);
            
        }
        
        
    }
    
    public void mostrarMensaje(String nombreObjetoRemoto, String mensaje) {
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        
        try {
            Registry registry = LocateRegistry.getRegistry(hostRegistry);
            System.out.print("Buscando el objeto remoto de "+nombreObjetoRemoto + "...");
            String nombre_objeto_remoto = nombreObjetoRemoto;
            InterfazCliente instancia_local = (InterfazCliente) registry.lookup(nombre_objeto_remoto);
            System.out.println(" Objeto remoto encontrado");

            //Envia el mensaje al usuario
            instancia_local.mostrarMensaje(mensaje);
            System.out.println("Mensaje enviado");
                    
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
 
    
    public static void main(String args[]) {
        System.setProperty("java.security.policy","file:C:/Users/PEDRO/Desktop/RMI-SERVER/RMI-SERVER/server.policy");
        System.setProperty("java.rmi.server.codebase","file:/C:/Users/PEDRO/Desktop/RMI-SERVER/RMI-SERVER/build/classes/co/edu/uptc/chatRMI");
        Servidor server = new Servidor();
        server.inicializarObjetoRemoto();
        //hostRegistry = args[0];
    }
}
