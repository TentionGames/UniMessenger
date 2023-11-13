/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tennertcomserver;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author marbu
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panStartServer = new javax.swing.JPanel();
        labStartInfo = new javax.swing.JLabel();
        butStartRetry = new javax.swing.JButton();
        panChat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        labStartInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labStartInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStartInfo.setText("Anderer Server läuft schon!");

        butStartRetry.setText("Retry");
        butStartRetry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butStartRetryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panStartServerLayout = new javax.swing.GroupLayout(panStartServer);
        panStartServer.setLayout(panStartServerLayout);
        panStartServerLayout.setHorizontalGroup(
            panStartServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labStartInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panStartServerLayout.createSequentialGroup()
                .addGap(602, 602, 602)
                .addComponent(butStartRetry)
                .addContainerGap(632, Short.MAX_VALUE))
        );
        panStartServerLayout.setVerticalGroup(
            panStartServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panStartServerLayout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(labStartInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butStartRetry)
                .addContainerGap(348, Short.MAX_VALUE))
        );

        jList1.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Clients");

        javax.swing.GroupLayout panChatLayout = new javax.swing.GroupLayout(panChat);
        panChat.setLayout(panChatLayout);
        panChatLayout.setHorizontalGroup(
            panChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChatLayout.createSequentialGroup()
                .addContainerGap(498, Short.MAX_VALUE)
                .addGroup(panChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChatLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(451, 451, 451))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChatLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(619, 619, 619))))
        );
        panChatLayout.setVerticalGroup(
            panChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChatLayout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panStartServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panChat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panStartServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panChat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butStartRetryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butStartRetryActionPerformed
        loginThread.TryStartServer();
    }//GEN-LAST:event_butStartRetryActionPerformed

    public static MainFrame mainFrame;
    public static CommunicationManager comManager;
    public static LoginThread loginThread;
    public static HeartBeat heartBeat;
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                
                comManager = new CommunicationManager();
                loginThread = new LoginThread(mainFrame);
                loginThread.start();
                heartBeat = new HeartBeat();
                heartBeat.start();
            }
        });
    }
    
    public void ChangePanel(int newPanel){
        mainFrame.panStartServer.setVisible(newPanel == 0);
        mainFrame.panChat.setVisible(newPanel == 1);
    }
    
    public void AddName(String clientName){
        ((DefaultListModel)mainFrame.jList1.getModel()).addElement(clientName);
    }
    
    public void RemoveName(String clientName){
        ((DefaultListModel)mainFrame.jList1.getModel()).removeElement(clientName);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butStartRetry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labStartInfo;
    private javax.swing.JPanel panChat;
    private javax.swing.JPanel panStartServer;
    // End of variables declaration//GEN-END:variables
}
