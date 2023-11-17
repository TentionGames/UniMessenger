package com.mycompany.tennertcomserver;

import java.net.*;
import java.io.*;

public class LoginThread extends Thread {

    
    ServerSocket server;
    MainFrame mainFrame;

    LoginThread(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {
        TryStartServer();
        
        Socket client;
        while (true) {
            try {
                client = server.accept();
                mainFrame.comManager.ClientFound(client);
            } catch (IOException e) {}
        }
    }

    public void TryStartServer() {
        try {
            server = new ServerSocket(3141);
            mainFrame.ChangePanel(1);
        } catch (IOException ex) {}
    }
}
