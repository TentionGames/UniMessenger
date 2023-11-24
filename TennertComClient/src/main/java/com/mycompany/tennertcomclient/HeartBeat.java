package com.mycompany.tennertcomclient;

public class HeartBeat extends Thread {

    long lastBeatReceived = System.currentTimeMillis();

    @Override
    public void run() {
        while (true) {
            Wait(1000);
            SendHB();
            ListenToHB();
        }
    }

    private void Wait(int millSec) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }

    private void SendHB() {
        MainFrame.serverHandler.SendMsg("HBT");
    }

    private void ListenToHB() {
        if (System.currentTimeMillis() - lastBeatReceived >= 3000) {
            MainFrame.mainFrame.ChangePanel(0);
        }
    }

    public void ReceivedBeat() {
        lastBeatReceived = System.currentTimeMillis();
    }
}
