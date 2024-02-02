package unimessengerclient;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PrivateRoom {
    
    JFrame PRFrame = new javax.swing.JFrame();
    JScrollPane PRScroll = new javax.swing.JScrollPane();
    JTextArea PRChat = new javax.swing.JTextArea();
    JLabel PRPartnerLabel = new javax.swing.JLabel();
    JTextField PRInput = new javax.swing.JTextField();
    JButton PRSendBtn = new javax.swing.JButton();
    
    private Datenbank db;
    private String partner;
    
    public PrivateRoom(Datenbank db, String partner){
        
        this.db = db;
        this.partner = partner;
        
        //UI
        PRFrame.setVisible(true);
        PRFrame.setMinimumSize(new java.awt.Dimension(720, 500));
        PRChat.setColumns(20);
        PRChat.setRows(5);
        PRScroll.setViewportView(PRChat);

        PRPartnerLabel.setText(partner);

        PRSendBtn.setText(">");
        PRSendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(PRInput.getText().isBlank()) return;
                db.getServerHandler().SendMsg("SPM" + partner + "%SPLIT%" + PRInput.getText());
            }
        });

        javax.swing.GroupLayout PRFrameLayout = new javax.swing.GroupLayout(PRFrame.getContentPane());
        PRFrame.getContentPane().setLayout(PRFrameLayout);
        PRFrameLayout.setHorizontalGroup(
            PRFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PRFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PRFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PRPartnerLabel)
                    .addGroup(PRFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PRFrameLayout.createSequentialGroup()
                            .addComponent(PRInput, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PRSendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(PRScroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        PRFrameLayout.setVerticalGroup(
            PRFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PRFrameLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(PRPartnerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PRScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PRFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PRInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRSendBtn))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }
    
    public boolean isPartner(String partner){
        return this.partner.equals(partner);
    }
    
    public void AddMsg(String sender, String msg){
        PRChat.setText(PRChat.getText() + sender + ":\t" + msg + "\n");
    }
    
}
