package com.mycompany.tennertcomserver;

import java.net.*;
import java.util.ArrayList;

public class CommunicationManager {
    ArrayList<ClientHandler> clientHandlers = new ArrayList();
    
    public void ClientFound(Socket client) {
        ClientHandler clientHandler = new ClientHandler(client, clientHandlers.size()-1);
        clientHandlers.add(clientHandler);
        clientHandler.start();
    }
}
