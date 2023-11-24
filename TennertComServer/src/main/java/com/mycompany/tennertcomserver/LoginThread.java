package com.mycompany.tennertcomserver;

import java.net.*;
import java.io.*;

public class LoginThread extends Thread {

    Datenbank db;
    
    ServerSocket server;
    
    public LoginThread(Datenbank db){
        this.db = db;
    }

    @Override
    public void run() {
        TryStartServer();
        
        Socket client;
        while (true) {
            try {
                client = server.accept();
                db.ClientFound(client);
            } catch (IOException e) {}
        }
    }

    public void TryStartServer() {
        try {
            server = new ServerSocket(3141);
            db.mainFrame.ChangePanel(1);
        } catch (IOException ex) {}
    }
}
