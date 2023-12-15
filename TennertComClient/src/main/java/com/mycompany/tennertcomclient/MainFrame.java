package com.mycompany.tennertcomclient;

import java.awt.event.KeyEvent;
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

        ConnectPanel = new javax.swing.JPanel();
        ConnectInfo = new javax.swing.JLabel();
        ConnectRetryButton = new javax.swing.JButton();
        LoginPanel = new javax.swing.JPanel();
        label_login = new javax.swing.JLabel();
        label_benutzername = new javax.swing.JLabel();
        tInput_benutzername = new javax.swing.JTextField();
        label_password = new javax.swing.JLabel();
        button_login = new javax.swing.JButton();
        button_registrieren = new javax.swing.JButton();
        label_loginError = new javax.swing.JLabel();
        tInput_password = new javax.swing.JPasswordField();
        ChatPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ChatField = new javax.swing.JTextArea();
        inf_Nachricht = new javax.swing.JTextField();
        btn_Send = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_Nutzer = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_Rooms = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        btn_JoinRoom = new javax.swing.JButton();
        lbl_currentRoom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        ConnectInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ConnectInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConnectInfo.setText("Kein Server gefunden!");

        ConnectRetryButton.setText("Retry");
        ConnectRetryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectRetryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConnectPanelLayout = new javax.swing.GroupLayout(ConnectPanel);
        ConnectPanel.setLayout(ConnectPanelLayout);
        ConnectPanelLayout.setHorizontalGroup(
            ConnectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectPanelLayout.createSequentialGroup()
                .addGroup(ConnectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConnectPanelLayout.createSequentialGroup()
                        .addGap(590, 590, 590)
                        .addComponent(ConnectRetryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ConnectPanelLayout.createSequentialGroup()
                        .addGap(475, 475, 475)
                        .addComponent(ConnectInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(479, Short.MAX_VALUE))
        );
        ConnectPanelLayout.setVerticalGroup(
            ConnectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnectPanelLayout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(ConnectInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConnectRetryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );

        label_login.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_login.setText("LOGIN");
        label_login.setToolTipText("");

        label_benutzername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_benutzername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_benutzername.setText("Benutzername:");
        label_benutzername.setToolTipText("");

        tInput_benutzername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tInput_benutzername.setToolTipText("Bitte Benutzernamen hier eintragen");
        tInput_benutzername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        label_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_password.setText("Password:");
        label_password.setToolTipText("");

        button_login.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button_login.setText("Login");
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_loginActionPerformed(evt);
            }
        });

        button_registrieren.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button_registrieren.setText("Registrieren");
        button_registrieren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_registrierenActionPerformed(evt);
            }
        });

        label_loginError.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_loginError.setForeground(new java.awt.Color(255, 51, 51));
        label_loginError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_loginError.setText(" ");

        tInput_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addComponent(label_login)
                        .addGap(583, 583, 583))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addComponent(label_password, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(554, 554, 554))))
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(label_loginError, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 308, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_registrieren, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(534, 534, 534))
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tInput_password)
                    .addComponent(tInput_benutzername, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(label_benutzername, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(label_login)
                .addGap(27, 27, 27)
                .addComponent(label_benutzername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tInput_benutzername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(label_password)
                .addGap(7, 7, 7)
                .addComponent(tInput_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(label_loginError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_registrieren)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        ChatPanel.setPreferredSize(new java.awt.Dimension(1280, 720));

        ChatField.setEditable(false);
        ChatField.setColumns(20);
        ChatField.setRows(5);
        jScrollPane1.setViewportView(ChatField);

        inf_Nachricht.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inf_NachrichtKeyPressed(evt);
            }
        });

        btn_Send.setText(">");
        btn_Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SendActionPerformed(evt);
            }
        });

        list_Nutzer.setModel(new DefaultListModel());
        jScrollPane2.setViewportView(list_Nutzer);

        jLabel1.setText("Andere Benutzer");

        list_Rooms.setModel(new DefaultListModel());
        jScrollPane3.setViewportView(list_Rooms);

        jLabel2.setText("Rooms:");

        btn_JoinRoom.setText("Join Room");
        btn_JoinRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_JoinRoomActionPerformed(evt);
            }
        });

        lbl_currentRoom.setText("default");

        javax.swing.GroupLayout ChatPanelLayout = new javax.swing.GroupLayout(ChatPanel);
        ChatPanel.setLayout(ChatPanelLayout);
        ChatPanelLayout.setHorizontalGroup(
            ChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChatPanelLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(ChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChatPanelLayout.createSequentialGroup()
                        .addComponent(lbl_currentRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ChatPanelLayout.createSequentialGroup()
                        .addGroup(ChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ChatPanelLayout.createSequentialGroup()
                                .addComponent(inf_Nachricht, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Send))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addGroup(ChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChatPanelLayout.createSequentialGroup()
                                .addGroup(ChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(137, 137, 137))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChatPanelLayout.createSequentialGroup()
                                .addComponent(btn_JoinRoom)
                                .addGap(247, 247, 247))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChatPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(268, 268, 268))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChatPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(244, 244, 244))))))
        );
        ChatPanelLayout.setVerticalGroup(
            ChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChatPanelLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_JoinRoom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChatPanelLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(lbl_currentRoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Send, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inf_Nachricht, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ConnectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ChatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConnectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ChatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_loginActionPerformed
        db.getServerHandler().SendLogin(tInput_benutzername.getText(), new String(tInput_password.getPassword()));
    }//GEN-LAST:event_button_loginActionPerformed

    private void button_registrierenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_registrierenActionPerformed
        db.getServerHandler().SendRegister(tInput_benutzername.getText(), new String(tInput_password.getPassword()));
    }//GEN-LAST:event_button_registrierenActionPerformed

    private void ConnectRetryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectRetryButtonActionPerformed
        db.getServerHandler().TryConnect();
    }//GEN-LAST:event_ConnectRetryButtonActionPerformed

    private void btn_JoinRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_JoinRoomActionPerformed
        if(getSelectedRoom() >= 0){
            db.getServerHandler().SendMsg("JRR" + getSelectedRoom());
        }
    }//GEN-LAST:event_btn_JoinRoomActionPerformed

    private void btn_SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SendActionPerformed
        db.getServerHandler().SendMsg("MSG"+inf_Nachricht.getText());
        inf_Nachricht.setText("");
    }//GEN-LAST:event_btn_SendActionPerformed

    private void inf_NachrichtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inf_NachrichtKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            db.getServerHandler().SendMsg("MSG"+inf_Nachricht.getText());
            inf_Nachricht.setText("");
        }
    }//GEN-LAST:event_inf_NachrichtKeyPressed

    private final Datenbank db;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            public void run() {
                Datenbank datenbank = null;
                datenbank = new Datenbank();
                
                datenbank.getMainFrame().setVisible(true);
                datenbank.getMainFrame().ChangePanel(0);
                datenbank.getServerHandler().start();
            }
        });
    }

    public void ChangePanel(int newPanel) {
        ConnectPanel.setVisible(newPanel == 0);
        LoginPanel.setVisible(newPanel == 1);
        ChatPanel.setVisible(newPanel == 2);
    }

    public void DisplayLoginError(String errMsg) {
        label_loginError.setText(errMsg);
    }

    public void DisplayNutzerList(String[] nutzer) {
        DefaultListModel routesmodel = ((DefaultListModel) list_Nutzer.getModel());
        routesmodel.clear();
        for (int i = 0; i < nutzer.length; i++) {
            if(nutzer[i].isEmpty()) continue;
            routesmodel.addElement(nutzer[i]);
        }
    }
    
    public void DisplayNewNutzer(String nutzer){
        ((DefaultListModel) list_Nutzer.getModel()).addElement(nutzer);
    }
    
    public void RemoveName(String clientName){
        ((DefaultListModel) list_Nutzer.getModel()).removeElement(clientName);
    }
    
    public void DisplayNewRoomList(String[] rooms){
        DefaultListModel routesmodel = ((DefaultListModel) list_Rooms.getModel());
        routesmodel.clear();
        for (int i = 0; i < rooms.length; i++) {
            routesmodel.addElement(rooms[i]);
        }
    }
    
    public void DisplayNewRoomChat(String roomName, String chat){
        lbl_currentRoom.setText(roomName);
        ChatField.setText(chat);
    }
    
    public void DisplayMSG(String nutzer, String msg){
        ChatField.setText(ChatField.getText() + nutzer + ":\t" + msg + "\n");
    }
    
    public int getSelectedRoom(){
        return list_Rooms.getSelectedIndex();
    }
    
    public void ChangeRoomName(int roomIndex, boolean inRoom, String roomName){
        if(inRoom) lbl_currentRoom.setText(roomName);
        ((DefaultListModel) list_Rooms.getModel()).setElementAt(roomName, roomIndex);
    }
    
    public void AddRoom(String roomName){
        ((DefaultListModel) list_Rooms.getModel()).addElement(roomName);
    }
    
    public void DeleteRoom(int roomIndex){
        ((DefaultListModel) list_Rooms.getModel()).remove(roomIndex);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ChatField;
    private javax.swing.JPanel ChatPanel;
    private javax.swing.JLabel ConnectInfo;
    private javax.swing.JPanel ConnectPanel;
    private javax.swing.JButton ConnectRetryButton;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JButton btn_JoinRoom;
    private javax.swing.JButton btn_Send;
    private javax.swing.JButton button_login;
    private javax.swing.JButton button_registrieren;
    private javax.swing.JTextField inf_Nachricht;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_benutzername;
    private javax.swing.JLabel label_login;
    private javax.swing.JLabel label_loginError;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel lbl_currentRoom;
    private javax.swing.JList<String> list_Nutzer;
    private javax.swing.JList<String> list_Rooms;
    private javax.swing.JTextField tInput_benutzername;
    private javax.swing.JPasswordField tInput_password;
    // End of variables declaration//GEN-END:variables
}
