/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennertcomserver;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author marbu
 */
public class CommunicationManager {
    ArrayList<ClientHandler> clientHandlers = new ArrayList();
    
    public void ClientFound(Socket client) {
        ClientHandler clientHandler = new ClientHandler(client, clientHandlers.size()-1);
        clientHandlers.add(clientHandler);
        clientHandler.start();
    }
}
