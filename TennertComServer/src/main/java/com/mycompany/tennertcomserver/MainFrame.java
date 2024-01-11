package com.mycompany.tennertcomserver;

import java.io.*;
import javax.swing.DefaultListModel;

public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame(Datenbank db) {
        this.db = db;
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

        frm_ChangeRoomName = new javax.swing.JFrame();
        txtIpt_RoomName = new javax.swing.JTextField();
        btn_ChangeName = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        frm_AddRoom = new javax.swing.JFrame();
        txtIpt_RoomNameAdd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_RoomAdd = new javax.swing.JButton();
        frm_Verwarnen = new javax.swing.JFrame();
        btn_VerwarnenSenden = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Inp_verwarnen = new javax.swing.JTextArea();
        panStartServer = new javax.swing.JPanel();
        labStartInfo = new javax.swing.JLabel();
        butStartRetry = new javax.swing.JButton();
        panChat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_Clients = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_Rooms = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        btn_AddRoom = new javax.swing.JButton();
        btn_RenameRoom = new javax.swing.JButton();
        btn_DeleteRoom = new javax.swing.JButton();
        btn_Verwarnen = new javax.swing.JButton();
        btn_Kicken = new javax.swing.JButton();
        btn_Bannen = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        LogField = new javax.swing.JTextArea();

        frm_ChangeRoomName.setBounds(new java.awt.Rectangle(490, 260, 300, 200));
        frm_ChangeRoomName.setMinimumSize(new java.awt.Dimension(300, 200));

        btn_ChangeName.setText("Change Name");
        btn_ChangeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChangeNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Room Name:");

        javax.swing.GroupLayout frm_ChangeRoomNameLayout = new javax.swing.GroupLayout(frm_ChangeRoomName.getContentPane());
        frm_ChangeRoomName.getContentPane().setLayout(frm_ChangeRoomNameLayout);
        frm_ChangeRoomNameLayout.setHorizontalGroup(
            frm_ChangeRoomNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frm_ChangeRoomNameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(114, 114, 114))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frm_ChangeRoomNameLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(txtIpt_RoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(frm_ChangeRoomNameLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btn_ChangeName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frm_ChangeRoomNameLayout.setVerticalGroup(
            frm_ChangeRoomNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frm_ChangeRoomNameLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIpt_RoomName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_ChangeName)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        frm_AddRoom.setBounds(new java.awt.Rectangle(490, 260, 300, 200));
        frm_AddRoom.setMinimumSize(new java.awt.Dimension(300, 200));

        jLabel3.setText("Room Name:");

        btn_RoomAdd.setText("Add Room");
        btn_RoomAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RoomAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frm_AddRoomLayout = new javax.swing.GroupLayout(frm_AddRoom.getContentPane());
        frm_AddRoom.getContentPane().setLayout(frm_AddRoomLayout);
        frm_AddRoomLayout.setHorizontalGroup(
            frm_AddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frm_AddRoomLayout.createSequentialGroup()
                .addGroup(frm_AddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frm_AddRoomLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txtIpt_RoomNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frm_AddRoomLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btn_RoomAdd))
                    .addGroup(frm_AddRoomLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel3)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        frm_AddRoomLayout.setVerticalGroup(
            frm_AddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frm_AddRoomLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIpt_RoomNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_RoomAdd)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        frm_Verwarnen.setMinimumSize(new java.awt.Dimension(300, 200));

        btn_VerwarnenSenden.setText("Verwarnen");
        btn_VerwarnenSenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VerwarnenSendenActionPerformed(evt);
            }
        });

        Inp_verwarnen.setColumns(20);
        Inp_verwarnen.setRows(5);
        jScrollPane4.setViewportView(Inp_verwarnen);

        javax.swing.GroupLayout frm_VerwarnenLayout = new javax.swing.GroupLayout(frm_Verwarnen.getContentPane());
        frm_Verwarnen.getContentPane().setLayout(frm_VerwarnenLayout);
        frm_VerwarnenLayout.setHorizontalGroup(
            frm_VerwarnenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frm_VerwarnenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_VerwarnenSenden)
                .addGap(108, 108, 108))
            .addGroup(frm_VerwarnenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        frm_VerwarnenLayout.setVerticalGroup(
            frm_VerwarnenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frm_VerwarnenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_VerwarnenSenden)
                .addGap(18, 18, 18))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
            .addGroup(panStartServerLayout.createSequentialGroup()
                .addGap(602, 602, 602)
                .addComponent(butStartRetry)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panStartServerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labStartInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
                .addContainerGap())
        );
        panStartServerLayout.setVerticalGroup(
            panStartServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panStartServerLayout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(labStartInfo)
                .addGap(18, 18, 18)
                .addComponent(butStartRetry)
                .addContainerGap(303, Short.MAX_VALUE))
        );

        list_Clients.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(list_Clients);

        jLabel1.setText("Clients");

        list_Rooms.setModel(new DefaultListModel());
        jScrollPane2.setViewportView(list_Rooms);

        jLabel4.setText("Räume");

        btn_AddRoom.setText("Add Room");
        btn_AddRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddRoomActionPerformed(evt);
            }
        });

        btn_RenameRoom.setText("Rename Room");
        btn_RenameRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RenameRoomActionPerformed(evt);
            }
        });

        btn_DeleteRoom.setText("Delete Room");
        btn_DeleteRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteRoomActionPerformed(evt);
            }
        });

        btn_Verwarnen.setText("Verwarnen");
        btn_Verwarnen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VerwarnenActionPerformed(evt);
            }
        });

        btn_Kicken.setText("Rauswerfen");
        btn_Kicken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KickenActionPerformed(evt);
            }
        });

        btn_Bannen.setText("Bann");
        btn_Bannen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BannenActionPerformed(evt);
            }
        });

        LogField.setEditable(false);
        LogField.setColumns(20);
        LogField.setRows(5);
        jScrollPane3.setViewportView(LogField);

        javax.swing.GroupLayout panChatLayout = new javax.swing.GroupLayout(panChat);
        panChat.setLayout(panChatLayout);
        panChatLayout.setHorizontalGroup(
            panChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(210, 210, 210))
            .addGroup(panChatLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panChatLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(panChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChatLayout.createSequentialGroup()
                                .addComponent(btn_AddRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_RenameRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164))
                            .addGroup(panChatLayout.createSequentialGroup()
                                .addGroup(panChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_DeleteRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panChatLayout.createSequentialGroup()
                                        .addComponent(btn_Verwarnen, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_Kicken, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_Bannen, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panChatLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(212, 212, 212))))
        );
        panChatLayout.setVerticalGroup(
            panChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChatLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panChatLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Verwarnen)
                            .addComponent(btn_Kicken)
                            .addComponent(btn_Bannen))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_AddRoom)
                            .addComponent(btn_RenameRoom)
                            .addComponent(btn_DeleteRoom)))
                    .addComponent(jScrollPane3))
                .addContainerGap(132, Short.MAX_VALUE))
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
        db.getLoginThread().TryStartServer();
    }//GEN-LAST:event_butStartRetryActionPerformed

    private void btn_AddRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddRoomActionPerformed
        frm_AddRoom.setVisible(true);
    }//GEN-LAST:event_btn_AddRoomActionPerformed

    private void btn_RenameRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RenameRoomActionPerformed
        if(getSelectedRoom() >= 0) frm_ChangeRoomName.setVisible(true);
    }//GEN-LAST:event_btn_RenameRoomActionPerformed

    private void btn_DeleteRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteRoomActionPerformed
        db.getRoomManager().CurrRoomDelete();
    }//GEN-LAST:event_btn_DeleteRoomActionPerformed

    private void btn_ChangeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChangeNameActionPerformed
        frm_ChangeRoomName.setVisible(false);
        db.getRoomManager().CurrRoomChangeName(txtIpt_RoomName.getText());
    }//GEN-LAST:event_btn_ChangeNameActionPerformed

    private void btn_RoomAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RoomAddActionPerformed
        frm_AddRoom.setVisible(false);
        db.getRoomManager().AddRoom(txtIpt_RoomNameAdd.getText());
    }//GEN-LAST:event_btn_RoomAddActionPerformed

    private void btn_VerwarnenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VerwarnenActionPerformed
        verwarnenIdx = getSelectedName();
        if(verwarnenIdx < 0) return;
        frm_Verwarnen.setVisible(true);
    }//GEN-LAST:event_btn_VerwarnenActionPerformed

    private void btn_KickenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KickenActionPerformed
        verwarnenIdx = getSelectedName();
        if(verwarnenIdx < 0) return;
        db.getClientManager().ClientKick(verwarnenIdx);
    }//GEN-LAST:event_btn_KickenActionPerformed

    private void btn_BannenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BannenActionPerformed
        verwarnenIdx = getSelectedName();
        if(verwarnenIdx < 0) return;
        db.getClientManager().ClientBann(verwarnenIdx);
    }//GEN-LAST:event_btn_BannenActionPerformed

    int verwarnenIdx;
    
    private void btn_VerwarnenSendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VerwarnenSendenActionPerformed
        db.getClientManager().ClientVerwarnen(verwarnenIdx, Inp_verwarnen.getText());
        frm_Verwarnen.setVisible(false);
    }//GEN-LAST:event_btn_VerwarnenSendenActionPerformed

    private Datenbank db;
    
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
                Datenbank datenbank = new Datenbank();
                
                datenbank.getMainFrame().setVisible(true);
                datenbank.getMainFrame().ChangePanel(0);
                datenbank.getLoginThread().start();
                datenbank.getHeartBeat().start();
            }
        });
    }
    
    public void ChangePanel(int newPanel){
        panStartServer.setVisible(newPanel == 0);
        panChat.setVisible(newPanel == 1);
    }
    
    public void DisplayError(String Error){
        
    }
    
    //Log
    
    public void AddLog(String log){
        LogField.setText(LogField.getText() + log + "\n");
    }
    
    //Namen
    
    public int getSelectedName(){
        return list_Clients.getSelectedIndex();
    }
    
    public void AddName(String clientName, String roomName){
        ((DefaultListModel) list_Clients.getModel()).addElement(clientName + " (" + roomName + ")");
    }
    
    public void RemoveName(int index){
        ((DefaultListModel) list_Clients.getModel()).remove(index);
    }
    
    public void ChangeName(int index, String clientName, String roomName){
        ((DefaultListModel) list_Clients.getModel()).set(index, clientName + " (" + roomName + ")");
    }
    
    //Räume
    
    public int getSelectedRoom(){
        return list_Rooms.getSelectedIndex();
    }
    
    public void ChangeRoomName(int roomIndex, int anzUser, String roomName){
        ((DefaultListModel) list_Rooms.getModel()).setElementAt(roomName + " (" + anzUser + " User)", roomIndex);
    }
    
    public void AddRoom(String roomName){
        ((DefaultListModel) list_Rooms.getModel()).addElement(roomName + " (0 User)");
    }
    
    public void DeleteRoom(int roomIndex){
        ((DefaultListModel) list_Rooms.getModel()).remove(roomIndex);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Inp_verwarnen;
    private javax.swing.JTextArea LogField;
    private javax.swing.JButton btn_AddRoom;
    private javax.swing.JButton btn_Bannen;
    private javax.swing.JButton btn_ChangeName;
    private javax.swing.JButton btn_DeleteRoom;
    private javax.swing.JButton btn_Kicken;
    private javax.swing.JButton btn_RenameRoom;
    private javax.swing.JButton btn_RoomAdd;
    private javax.swing.JButton btn_Verwarnen;
    private javax.swing.JButton btn_VerwarnenSenden;
    private javax.swing.JButton butStartRetry;
    private javax.swing.JFrame frm_AddRoom;
    private javax.swing.JFrame frm_ChangeRoomName;
    private javax.swing.JFrame frm_Verwarnen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labStartInfo;
    private javax.swing.JList<String> list_Clients;
    private javax.swing.JList<String> list_Rooms;
    private javax.swing.JPanel panChat;
    private javax.swing.JPanel panStartServer;
    private javax.swing.JTextField txtIpt_RoomName;
    private javax.swing.JTextField txtIpt_RoomNameAdd;
    // End of variables declaration//GEN-END:variables
}
