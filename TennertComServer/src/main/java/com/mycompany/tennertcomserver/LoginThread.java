package com.mycompany.tennertcomserver;

import java.net.*;
import java.io.*;

public class LoginThread extends Thread {

    private Datenbank db;

    private ServerSocket server;

    public LoginThread(Datenbank db) {
        this.db = db;
    }

    @Override
    public void run() {
        TryStartServer();
        
        while (true) {
            TryForClient();
        }
    }

    public void TryForClient() {
        try {
            Socket client = server.accept();
            db.getClientManager().ClientFound(client);
        } catch (IOException e) {
        }
    }

    public void TryStartServer() {
        try {
            server = new ServerSocket(3141);
            db.getMainFrame().ChangePanel(1);
            db.getRoomManager().AddRoom("default");
            db.getLogHandler().ServerGestartet();
        } catch (IOException ex) {
        }
    }
}
