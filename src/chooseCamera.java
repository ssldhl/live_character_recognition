/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sushil
 */
public class chooseCamera extends javax.swing.JFrame {

    /**
     * Creates new form chooseCamera
     */
    private String video_device[] = new String[20];
    private String video_mrl[] = new String[20];
    private String video_default_device="";
    private String video_default_mrl="";
    
    public chooseCamera() {
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

        clickinfoLabel = new javax.swing.JLabel();
        linkLabel = new javax.swing.JLabel();
        tutorialexistingSeparator = new javax.swing.JSeparator();
        existingcameraLabel = new javax.swing.JLabel();
        cameralistCombo = new javax.swing.JComboBox();
        deleteLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        selectaddSeparator = new javax.swing.JSeparator();
        addcameraLabel = new javax.swing.JLabel();
        mrlLabel = new javax.swing.JLabel();
        mrlTextfield = new javax.swing.JTextField();
        videodevicenameLabel = new javax.swing.JLabel();
        videodevicenameTextfield = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        addproceedSeparator = new javax.swing.JSeparator();
        proceedLabel = new javax.swing.JLabel();
        defaultButton = new javax.swing.JButton();
        defaultLabel = new javax.swing.JLabel();
        proceedButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Choose Camera...");
        setFocusTraversalPolicyProvider(true);
        setName("chooseCameraframe");
        setPreferredSize(new java.awt.Dimension(829, 505));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        clickinfoLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        clickinfoLabel.setText("Click the link below to find out how to add a new camera already attached to your computer");

        linkLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        linkLabel.setForeground(new java.awt.Color(0, 153, 153));
        linkLabel.setText("<html><u>HOW TO?</u></html>");
        linkLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linkLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linkLabelMouseClicked(evt);
            }
        });

        existingcameraLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        existingcameraLabel.setText("Select an existing camera:");

        cameralistCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default" }));

        deleteLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        deleteLabel.setText("Don't want this camera to appear on the list. Well, you can delete it too.");

        deleteButton.setText("Remove the selected camera");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        addcameraLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        addcameraLabel.setText("Add a new camera:");

        mrlLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        mrlLabel.setText("MRL:");

        videodevicenameLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        videodevicenameLabel.setText("Video Device Name:");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        proceedLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        proceedLabel.setText("Please make sure that a correct camera is selected");

        defaultButton.setText("Make Default");
        defaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultButtonActionPerformed(evt);
            }
        });

        defaultLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        defaultLabel.setText("You can make this camera your default camera so that you can directly start it the next time you run the application");
        defaultLabel.setToolTipText("");

        proceedButton.setText("Proceed");
        proceedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tutorialexistingSeparator)
            .addComponent(selectaddSeparator)
            .addComponent(addproceedSeparator)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clickinfoLabel)
                    .addComponent(linkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(existingcameraLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cameralistCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(defaultButton)
                    .addComponent(deleteButton)
                    .addComponent(addcameraLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(videodevicenameLabel)
                            .addComponent(mrlLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(videodevicenameTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(mrlTextfield)))
                    .addComponent(proceedLabel)
                    .addComponent(defaultLabel)
                    .addComponent(deleteLabel)
                    .addComponent(addButton)
                    .addComponent(proceedButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clickinfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tutorialexistingSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(cameralistCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(existingcameraLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(2, 2, 2)
                .addComponent(defaultLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defaultButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteLabel)
                .addGap(5, 5, 5)
                .addComponent(deleteButton)
                .addGap(18, 18, 18)
                .addComponent(selectaddSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addcameraLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(videodevicenameLabel)
                    .addComponent(videodevicenameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mrlLabel)
                    .addComponent(mrlTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addproceedSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(proceedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proceedButton)
                .addGap(101, 101, 101))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        
        if(videodevicenameTextfield.getText().length()==0||mrlTextfield.getText().length()==0){
            javax.swing.JOptionPane.showMessageDialog(null, "The required field cannot be left empty", "Invalid Input", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        else if(!mrlTextfield.getText().endsWith("://")){
           javax.swing.JOptionPane.showMessageDialog(null, "The MRL field entry is not correct\nPlease try again", "Invalid Input", javax.swing.JOptionPane.ERROR_MESSAGE);
           mrlTextfield.setText("");
        }
        else{
            int position = cameralistCombo.getItemCount()-1;
                    
            video_device[position] = videodevicenameTextfield.getText();
            
             String temp_string = mrlTextfield.getText();
            video_mrl[position] = temp_string;
            
            //javax.swing.JOptionPane.showMessageDialog(null, "Video Device name "+video_device[position]+"\nVideo MRL "+ video_mrl[position]+"\nAt position "+position, "Output", javax.swing.JOptionPane.ERROR_MESSAGE);
            
            cameralistCombo.addItem(videodevicenameTextfield.getText());
            cameralistCombo.setSelectedItem(videodevicenameTextfield.getText());
            videodevicenameTextfield.setText("");
            mrlTextfield.setText("");
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void linkLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkLabelMouseClicked
        // TODO add your handling code here:
         try{  
             java.io.File file = new java.io.File("src/tutorial/tutorial.mp4").getAbsoluteFile();
             if (java.awt.Desktop.isDesktopSupported()){  
                        java.awt.Desktop.getDesktop().open(file);
             }
        }  
        catch(Exception ert){
             javax.swing.JOptionPane.showMessageDialog(null,ert, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_linkLabelMouseClicked

    private void defaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultButtonActionPerformed
        //TODO add your handling code here:
        String itemText = (String)cameralistCombo.getSelectedItem( );
        if(itemText.equals("Default")){
            javax.swing.JOptionPane.showMessageDialog(null,"This is already default", "Invalid Action", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        else{
        video_default_device = video_device[cameralistCombo.getSelectedIndex()-1];
        video_default_mrl = video_mrl[cameralistCombo.getSelectedIndex()-1];
        javax.swing.JOptionPane.showMessageDialog(null,"The default device is set to "+video_default_device, "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_defaultButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        String itemText = (String)cameralistCombo.getSelectedItem( );
        int position = cameralistCombo.getSelectedIndex()-1;
        if(itemText.equals("Default")){
           javax.swing.JOptionPane.showMessageDialog(null,"The default value cannot be deleted","Error", javax.swing.JOptionPane.ERROR_MESSAGE); 
        }
        else{
            cameralistCombo.removeItemAt(cameralistCombo.getSelectedIndex());
            video_device[position] = "";
            video_mrl[position] = "";
            //javax.swing.JOptionPane.showMessageDialog(null, "Video Device name "+video_device[position]+"\nVideo MRL "+ video_mrl[position]+"\nAt position "+position, "Output", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void proceedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedButtonActionPerformed
        // TODO add your handling code here:
            try (java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter("cameralist",false))) {
                for(int i=0;i<cameralistCombo.getItemCount()-1;i++){
                    out.write(video_device[i]);
                    out.newLine();
                    out.write(video_mrl[i]);
                    out.newLine();
                }
                out.close();
            }
        catch (java.io.IOException ert){
            javax.swing.JOptionPane.showMessageDialog(null,ert, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
            
        try (java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter("defaultcamera",false))) {
           out.write(video_default_device);
           out.newLine();
           out.write(video_default_mrl);
           out.close();
        }
        catch (java.io.IOException ert){
            javax.swing.JOptionPane.showMessageDialog(null,ert, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
         
        String itemText = (String)cameralistCombo.getSelectedItem( );
        if(!itemText.equals("Default")){
                try (java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter("activecamera",false))) {
                    for(int i=0;i<cameralistCombo.getItemCount()-1;i++){
                        if(itemText.equals(video_device[i])){
                            out.write(video_device[i]);
                            out.newLine();
                            out.write(video_mrl[i]);
                        }
                    }
                out.close();
            }
            catch (java.io.IOException ert){
                javax.swing.JOptionPane.showMessageDialog(null,ert, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        dispose();
    }//GEN-LAST:event_proceedButtonActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chooseCamera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chooseCamera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chooseCamera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chooseCamera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new chooseCamera().setVisible(true);
            }
        });
    }

    public void firstcall() {
        java.util.Scanner s = null;
        int i;
        int j=0;
        
        for(i=0;i<20;i++)
        {
            video_device[i]="";
            video_mrl[i]="";
        }
        i=0;
        try (java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter("activecamera",false))) {
               out.write("default");
               out.close();
            }
            catch (java.io.IOException ert){
                javax.swing.JOptionPane.showMessageDialog(null,ert, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        
        try {
            s = new java.util.Scanner(new java.io.BufferedReader(new java.io.FileReader("cameralist")));
            s.useLocale(java.util.Locale.US);
		while (s.hasNext()) {
                    if (s.hasNextLine()) {
			video_device[i] = s.nextLine();
                        cameralistCombo.addItem(video_device[i]);
			i++;
			} else {
				break;
			}
                    if(s.hasNextLine()){
                        video_mrl[j]=s.nextLine();
                        j++;
                    }else{
                        break;
                    }
		}
	}catch(java.io.IOException ert){
		javax.swing.JOptionPane.showMessageDialog(null,ert, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        s.close();
        
        try {
            s = new java.util.Scanner(new java.io.BufferedReader(new java.io.FileReader("defaultcamera")));
            s.useLocale(java.util.Locale.US);
            while (s.hasNext()) {
            if (s.hasNextLine()) {
            video_default_device = s.nextLine();
            }
            else{ break;}
            if (s.hasNextLine()) {
            video_default_mrl = s.nextLine();
            }else{break;}
            }
	}catch(java.io.IOException ert){
		javax.swing.JOptionPane.showMessageDialog(null,ert, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        s.close();
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addcameraLabel;
    private javax.swing.JSeparator addproceedSeparator;
    private javax.swing.JComboBox cameralistCombo;
    private javax.swing.JLabel clickinfoLabel;
    private javax.swing.JButton defaultButton;
    private javax.swing.JLabel defaultLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JLabel existingcameraLabel;
    private javax.swing.JLabel linkLabel;
    private javax.swing.JLabel mrlLabel;
    private javax.swing.JTextField mrlTextfield;
    private javax.swing.JButton proceedButton;
    private javax.swing.JLabel proceedLabel;
    private javax.swing.JSeparator selectaddSeparator;
    private javax.swing.JSeparator tutorialexistingSeparator;
    private javax.swing.JLabel videodevicenameLabel;
    private javax.swing.JTextField videodevicenameTextfield;
    // End of variables declaration//GEN-END:variables
}
