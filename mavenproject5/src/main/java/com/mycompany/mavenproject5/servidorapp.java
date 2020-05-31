
package com.mycompany.mavenproject5;

import java.io.*;
import java.net.*;

public class servidorapp {

    public static BufferedReader entrada;
    public static DataOutputStream salida;

    public static void main(String args[]) {
        String cadena = "cadena para enviar";

        ServerSocket ServidorSocket;
        Socket socket;
       
        try {
            // se instancia y se abre un puerto
            ServidorSocket = new ServerSocket(1234);
            //aceptamos la conexion del cliente
            socket = ServidorSocket.accept();
            
            //entrada se recibe los mensajaes del cliente
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje = entrada.readLine();
            System.out.println(mensaje);
            
            //salida se envia los mensajes al cliente
            salida = new DataOutputStream((socket.getOutputStream()));
            salida.writeUTF("mensaje del servidor");
            //cerramos la conexion
            socket.close();
            ServidorSocket.close();


        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        }
       
        }
    }
