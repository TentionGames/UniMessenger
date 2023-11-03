/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennertcomserver;

import java.net.*;
import java.io.*;

/**
 *
 * @author marbu
 */
public class LoginThread extends Thread {

    ServerSocket server;
    CommunicationManager comManager;
    LoginThread(ServerSocket server, CommunicationManager comManager)
    {this.server = server;
    this.comManager = comManager;}
    
    @Override
    public void run() { // Bearbeitung einer aufgebauten Verbindung
        while (true) { // einzelner Thread bearbeitet eine aufgebaute Verbindung
            Socket client;
            try {
                client = server.accept();
                comManager.ClientFound(client);
            } catch (IOException e) {}
        }
    }

    
}
