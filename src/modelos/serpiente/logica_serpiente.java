/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.serpiente;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import principal.Principal;

/**
 *
 * @author Jose
 */
public class logica_serpiente extends javax.swing.JFrame implements  Runnable {

    /**
     * Creates new form logica_serpiente
     */
    JButton[] serp = new JButton[200];
    JButton bono_comida;
    JTextArea t;
    int x = 680, y = 500, gu = 2, moverx = 1, movery = 0, veloci = 50, diferencia = 0,  puntos = 0;
    int[] lbx = new int[300];
    int[] lby = new int[300];
    Point[] lbp = new Point[300];
    Point bfp = new Point();
    Thread hilo;
    boolean comida= false, izquierda= false, derecha = true, arriba= true, abajo = true,bono = true;
    Random r = new Random();
    
    
    public logica_serpiente() {
        initComponents();
        jLabelPuntos.setText(String.valueOf(puntos));
        bono_comida = new JButton();
        bono_comida.setEnabled(false);
        iniciarvalores() ;
                
        crearserpiente();
        
       
        hilo = new Thread(this);
        hilo.start(); // inicio del metodo run
    }
    
    
    
    public void iniciarvalores() {
        gu = 3;
        lbx[0] = 100;
        lby[0] = 150;
        moverx = 10;
        movery = 0;
        diferencia = 0;
        puntos = 0;
        comida= false;
        izquierda = false;
        derecha = true;
        arriba = true;
        abajo= true;
        bono = true;
    }
      public void crearserpiente() {
        //crea la serpiente de tamaño 3
        for (int i = 0; i < 3; i++) {
            serp[i] = new JButton("lb" + i);
            serp[i].setEnabled(false);
            jPanel_juego.add(serp[i]);
            serp[i].setBounds(lbx[i], lby[i], 10, 10);
            lbx[i + 1] = lbx[i] - 10;
            lby[i + 1] = lby[i];
        }
    }
      
    void reiniciar() {
        iniciarvalores();
        jPanel_juego.removeAll();

        hilo.stop();

        crearserpiente();
        jLabelPuntos.setText(String.valueOf(puntos));

        hilo = new Thread(this);
        hilo.start();
    }
        void crecer() {
        serp[gu] = new JButton();
        serp[gu].setEnabled(false);
        jPanel_juego.add(serp[gu]);

        int a = 10 + (10 * r.nextInt(48));
        int b = 10 + (10 * r.nextInt(23));

        lbx[gu] = a;
        lby[gu] = b;
        serp[gu].setBounds(a, b, 10, 10);

        gu++;
    }
  //metodo para ubicar la serpiente segun la direccion dada por el jugador
    void ubicarSerpiente() {
        for (int i = 0; i < gu; i++) {
            lbp[i] = serp[i].getLocation();
        }

        lbx[0] += moverx;
        lby[0] += movery;
        serp[0].setBounds(lbx[0], lby[0], 10, 10);

        for (int i = 1; i < gu; i++) {
            serp[i].setLocation(lbp[i - 1]);
        }

        if (lbx[0] == x) {
            lbx[0] = 10;
        } else if (lbx[0] == 0) {
            lbx[0] = x - 10;
        } else if (lby[0] == y) {
            lby[0] = 10;
        } else if (lby[0] == 0) {
            lby[0] = y - 10;
        }

        if (lbx[0] == lbx[gu - 1] && lby[0] == lby[gu - 1]) {
            comida = false;
            puntos+= 5;
            jLabelPuntos.setText(String.valueOf(puntos));
            if (puntos % 50 == 0 && bono== true) {
                jPanel_juego.add(bono_comida);
                bono_comida.setBounds((10 * r.nextInt(50)), (10 * r.nextInt(25)), 15, 15);
                bfp = bono_comida.getLocation();
                bono= false;
            }
        }

        if (bono == false) {
            if (bfp.x <= lbx[0] && bfp.y <= lby[0] && bfp.x + 10 >= lbx[0] && bfp.y + 10 >= lby[0]) {
                jPanel_juego.remove(bono_comida);
                puntos += 100;
                jLabelPuntos.setText(String.valueOf(puntos));    
                bono = true;
            }
        }

        if (comida== false) {
            crecer();
            comida = true;
        } else {
            serp[gu - 1].setBounds(lbx[gu - 1], lby[gu - 1], 10, 10);
        }

        for (int i = 1; i < gu; i++) {
            if (lbp[0] == lbp[i]) {
                JOptionPane.showMessageDialog(this,"fin del juego"+puntos);
            
                try {
                    hilo.join();
                } catch (InterruptedException ie) {
                }
                break;
            }
        }


        jPanel_juego.repaint();
        show();
    }


 

    @Override
    public void run() {
        for (;;) {
            // Mueve la serpiente haciala derecha al comienzo del juego,
            //mueve la serpiente de izquierda a derecha, 
            //si el jugador presiona arriba, abajo,deracha o izquierda
            //la serpiente cambia su dirección de acuerdo con la flecha presionada

            ubicarSerpiente();
            try {
                Thread.sleep(veloci);
            } catch (InterruptedException ie) {
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_juego = new javax.swing.JPanel();
        jPanel_puntos = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelJugador = new javax.swing.JLabel();
        jLabelPuntos = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_juego.setBackground(new java.awt.Color(0, 0, 255));
        jPanel_juego.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel_juegoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_juegoLayout = new javax.swing.GroupLayout(jPanel_juego);
        jPanel_juego.setLayout(jPanel_juegoLayout);
        jPanel_juegoLayout.setHorizontalGroup(
            jPanel_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel_juegoLayout.setVerticalGroup(
            jPanel_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        jPanel_puntos.setBackground(new java.awt.Color(255, 255, 204));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jugador");

        jLabel2.setText("puntos");

        jLabelPuntos.setText("0");

        jButton2.setText("Reiniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_puntosLayout = new javax.swing.GroupLayout(jPanel_puntos);
        jPanel_puntos.setLayout(jPanel_puntosLayout);
        jPanel_puntosLayout.setHorizontalGroup(
            jPanel_puntosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_puntosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel_puntosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel_puntosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelPuntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(113, 113, 113)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel_puntosLayout.setVerticalGroup(
            jPanel_puntosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_puntosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_puntosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel_puntosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_puntosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_puntosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addContainerGap())
                    .addGroup(jPanel_puntosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_puntosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPuntos))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_juego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_puntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel_puntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_juego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
this.reiniciar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // TODO add your handling code here:
     Principal volver=new Principal();
     volver.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel_juegoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel_juegoKeyPressed
        // TODO add your handling code here:3
      // mueve a la izquierda la serpiente
        if (izquierda == true && evt.getKeyCode() == KeyEvent.VK_LEFT) {
            moverx = -10; 
            movery = 0;
            derecha= false;     
            arriba = true;      
            abajo = true;     
        }
        // mueve hacia arriba la serpiente
        if (arriba == true && evt.getKeyCode() == KeyEvent.VK_UP) {
            moverx = 0;
            movery = -10; 
            abajo = false;     
            derecha= true;      
            izquierda = true;   
        }
        // smueve a la derecha la serpiente
        if (derecha == true && evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            moverx = +10; 
            movery = 0;
            izquierda = false;
            arriba= true;
            abajo = true;
        }
        // mueve hacia abajo la serpiente
        if (abajo== true && evt.getKeyCode() == KeyEvent.VK_DOWN) {
            moverx = 0;
            movery = +10; 
            arriba = false;
            derecha = true;
            izquierda= true;
        }
        
    }//GEN-LAST:event_jPanel_juegoKeyPressed

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
            java.util.logging.Logger.getLogger(logica_serpiente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logica_serpiente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logica_serpiente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logica_serpiente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logica_serpiente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelJugador;
    private javax.swing.JLabel jLabelPuntos;
    private javax.swing.JPanel jPanel_juego;
    private javax.swing.JPanel jPanel_puntos;
    // End of variables declaration//GEN-END:variables
}
