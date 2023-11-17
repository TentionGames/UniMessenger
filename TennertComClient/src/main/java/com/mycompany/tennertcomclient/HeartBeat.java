package com.mycompany.tennertcomclient;

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
