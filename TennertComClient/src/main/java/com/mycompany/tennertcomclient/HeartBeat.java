/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennertcomclient;

/**
 *
 * @author Carsten
 */
public class HeartBeat extends Thread {

    long lastBeatSend = System.currentTimeMillis();
    long lastBeatReceived = System.currentTimeMillis();

    @Override
    public void run() {
        while (true) {
            if (System.currentTimeMillis() - lastBeatSend >= 1000) {
                MainFrame.serverHandler.SendMsg("HBT");
                lastBeatSend = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - lastBeatReceived >= 2000) {
                MainFrame.mainFrame.ChangePanel(0);
            }
        }
    }

    public void ReceivedBeat() {
        lastBeatReceived = System.currentTimeMillis();
    }
}
