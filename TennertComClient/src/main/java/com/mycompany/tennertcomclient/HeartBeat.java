/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennertcomclient;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carsten
 */
public class HeartBeat extends Thread {

    long lastBeatReceived = System.currentTimeMillis();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
            MainFrame.serverHandler.SendMsg("HBT");
            if (System.currentTimeMillis() - lastBeatReceived >= 3000) {
                MainFrame.mainFrame.ChangePanel(0);
            }
        }
    }

    public void ReceivedBeat() {
        lastBeatReceived = System.currentTimeMillis();
    }
}
