package minesweeper.view;

import javax.swing.JOptionPane;
import minesweeper.model.Size;
import minesweeper.presenter.GamePresenter;

public class OptionsGUI extends javax.swing.JDialog {
    
    Size size;
    int numberOfMines;
    GameViewer game;
    GamePresenter presenter;
    
    public OptionsGUI(GameViewer game, GamePresenter presenter) {
        super(game, "Change board options");
        size = new Size(9, 9);
        numberOfMines = 10;
        this.game = game;
        this.presenter = presenter;
        setVisible(true);
        initComponents();
    }
    
    public boolean checkParameters() {
        if (size.height < 9 || size.height > 24) {
            JOptionPane.showMessageDialog(null, "La altura debe ser un valor entre 9 y 24");
            return false;
        }
        if (size.width < 9 || size.width > 30) {
            JOptionPane.showMessageDialog(null, "El ancho debe ser un valor entre 9 y 30");
            return false;
        }
        if (numberOfMines < 10 || numberOfMines > size.width*size.height* 2 / 3) {
            JOptionPane.showMessageDialog(null, "El número de minas deber ser un valor entre 10\ny " + size.width*size.height* 2 / 3 + " para esta configuración de tablero");
            return false;
        }
        return true;
    }

    public void setEnabled(boolean enabled) {
        heightText.setEnabled(enabled);
        widthText.setEnabled(enabled);
        minesText.setEnabled(enabled);
    }    
    
    public Size getBoardSize() {
        return size;
    }
    
    public int getNumberOfMines() {
        return numberOfMines;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        easy = new javax.swing.JRadioButton();
        medium = new javax.swing.JRadioButton();
        hard = new javax.swing.JRadioButton();
        personalized = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        heightText = new javax.swing.JFormattedTextField();
        widthText = new javax.swing.JFormattedTextField();
        minesText = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscaminas - Opciones");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        acceptButton.setText("Aceptar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(easy);
        easy.setSelected(true);
        easy.setText("Principiante (9 x 9, 10 minas)");
        easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyActionPerformed(evt);
            }
        });

        buttonGroup.add(medium);
        medium.setText("Intermedio (16 x 16, 40 minas)");
        medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumActionPerformed(evt);
            }
        });

        buttonGroup.add(hard);
        hard.setText("Avanzado (16 x 30, 99 minas)");
        hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardActionPerformed(evt);
            }
        });

        buttonGroup.add(personalized);
        personalized.setText("Personalizado");
        personalized.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalizedActionPerformed(evt);
            }
        });

        jLabel1.setText("Alto (9-24):");

        jLabel2.setText("Ancho (9-30):");

        jLabel3.setText("Minas (10 mín.):");

        heightText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##"))));
        heightText.setEnabled(false);

        widthText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        widthText.setEnabled(false);

        minesText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        minesText.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(acceptButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(easy)
                            .addComponent(medium)
                            .addComponent(hard))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(heightText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(widthText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(minesText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(personalized))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(easy)
                    .addComponent(personalized))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(medium)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(acceptButton)
                            .addComponent(cancelButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(heightText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(widthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hard))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(minesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 49, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumActionPerformed
        setEnabled(false);
        size = new Size(16, 16);
        numberOfMines = 40;
    }//GEN-LAST:event_mediumActionPerformed

    private void personalizedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalizedActionPerformed
        setEnabled(true);
    }//GEN-LAST:event_personalizedActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void easyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easyActionPerformed
        setEnabled(false);
        size = new Size(9, 9);
        numberOfMines = 10;
    }//GEN-LAST:event_easyActionPerformed

    private void hardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardActionPerformed
        setEnabled(false);
        size = new Size(16, 30);
        numberOfMines = 99;
    }//GEN-LAST:event_hardActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        if (personalized.isSelected())
            if (heightText.getText().equals("") || widthText.getText().equals("") || minesText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
                return;
            } else {
                size = new Size(Integer.parseInt(heightText.getText()), Integer.parseInt(widthText.getText()));
                numberOfMines = Integer.parseInt(minesText.getText());
                if (!checkParameters())
                    return;
            }
        presenter.changeGameOptions(size, numberOfMines);
        dispose();
    }//GEN-LAST:event_acceptButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton cancelButton;
    private javax.swing.JRadioButton easy;
    private javax.swing.JRadioButton hard;
    private javax.swing.JFormattedTextField heightText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton medium;
    private javax.swing.JFormattedTextField minesText;
    private javax.swing.JRadioButton personalized;
    private javax.swing.JFormattedTextField widthText;
    // End of variables declaration//GEN-END:variables
}
