/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennertcomserver;

import java.net.*;
import java.io.*;

public class ClientHandler extends Thread {

    Socket client;
    int index;

    ClientHandler(Socket client, int index) {
        this.client = client;
        this.index = index;
    }

    DataInputStream in;
    DataOutputStream out;

    public void run() { // Bearbeitung einer aufgebauten Verbindung
        in = new DataInputStream(client.getInputStream());
        out = new DataOutputStream(client.getOutputStream());
        
    }
}
