/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.serpiente;

import juego.Jform_serpiente;
import java.awt.Image;
import java.io.File;
import java.nio.channels.Channels;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import juego.JPane_juegol;
import principal.Principal;

/**
 *
 * @author Jose
 */
public class JPane_usuariosl extends javax.swing.JPanel {
    private Datos_usuarios usuarios;
    File fichero;
    Principal principal;
    Jform_serpiente juego;
    private DefaultTableModel table_model_jugador;
    JPane_juegol puntos=new JPane_juegol();
    repositorio rep= new repositorio();

    /**
     * Creates new form JPane_usuariosl
     */
    public JPane_usuariosl() {
        initComponents();
    }
     public void setTableModel(DefaultTableModel table_model_jugador){
        this.table_model_jugador = table_model_jugador;
    }
        //actualiza la tabla general
         public void refreshTableModel()
    {
        ArrayList<Datos_usuarios> lista_jugadores = repositorio.obtenerTodos();
        while (table_model_jugador.getRowCount() > 0) {
            table_model_jugador.removeRow(0);
        }
        
        
        for(Datos_usuarios p : lista_jugadores)
        {
            String[] data = {Integer.toString(p.getId()), p.getFoto(),Integer.toString(p.getCedula()), p.getNombre(), p.getApellido(), Integer.toString(p.getEdad()), p.getFecha_nacimiento(),p.getFecha_registro(),Integer.toString(p.getPuntaje())};
            table_model_jugador.addRow(data);
        }
    }
     //actualiza la tabla de categoria infantil
     public void refreshTableModelInfantil()
    {
        ArrayList<Datos_usuarios> lista_jugadores = repositorio.categoriaInfantil();
        while (table_model_jugador.getRowCount() > 0) {
            table_model_jugador.removeRow(0);
        }
        
        
        for(Datos_usuarios p : lista_jugadores)
        {
            String[] data = {Integer.toString(p.getId()), p.getFoto(),Integer.toString(p.getCedula()), p.getNombre(), p.getApellido(), Integer.toString(p.getEdad()), p.getFecha_nacimiento(),p.getFecha_registro(),Integer.toString(p.getPuntaje())};
            table_model_jugador.addRow(data);
        }
    }
        //actualiza la tabla de categoria juvenil
        public void refreshTableModelJuvenil()
    {
        ArrayList<Datos_usuarios> lista_jugadores = repositorio.categoriaJuvenil();
        while (table_model_jugador.getRowCount() > 0) {
            table_model_jugador.removeRow(0);
        }
        
        
        for(Datos_usuarios p : lista_jugadores)
        {
            String[] data = {Integer.toString(p.getId()), p.getFoto(),Integer.toString(p.getCedula()), p.getNombre(), p.getApellido(), Integer.toString(p.getEdad()), p.getFecha_nacimiento(),p.getFecha_registro(),Integer.toString(p.getPuntaje())};
            table_model_jugador.addRow(data);
        }
    }
            //actualiza la tabla de categoria mayores
           public void refreshTableModelMayores()
    {
        ArrayList<Datos_usuarios> lista_jugadores = repositorio.categoriaMayores();
        while (table_model_jugador.getRowCount() > 0) {
            table_model_jugador.removeRow(0);
        }
        
        
        for(Datos_usuarios p : lista_jugadores)
        {
            String[] data = {Integer.toString(p.getId()), p.getFoto(),Integer.toString(p.getCedula()), p.getNombre(), p.getApellido(), Integer.toString(p.getEdad()), p.getFecha_nacimiento(),p.getFecha_registro(),Integer.toString(p.getPuntaje())};
            table_model_jugador.addRow(data);
        }
    }
              public void refreshTableModelInfantilPun()
    {
        ArrayList<Datos_usuarios> lista_jugadores = repositorio.categoriainfantilpun();
        while (table_model_jugador.getRowCount() > 0) {
            table_model_jugador.removeRow(0);
        }
        
        
        for(Datos_usuarios p : lista_jugadores)
        {
            String[] data = {Integer.toString(p.getId()), p.getFoto(),Integer.toString(p.getCedula()), p.getNombre(), p.getApellido(), Integer.toString(p.getEdad()), p.getFecha_nacimiento(),p.getFecha_registro(),Integer.toString(p.getPuntaje())};
            table_model_jugador.addRow(data);
        }
    }
       //deja los espacios vacios en el formulario
       public void resetformulario(){
      txtcedula.setText("");
      txtedad.setText("");
      txtnombre.setText("");
      txtapellido.setText("");
      
     
              }
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnfoto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtedad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        jLabelFoto = new javax.swing.JLabel();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();

        setBorder(javax.swing.BorderFactory.createTitledBorder("REGISTRO JUGADOR"));

        btnfoto.setText("Cargar foto");
        btnfoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfotoActionPerformed(evt);
            }
        });

        jLabel1.setText("cedula");

        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre");

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        jLabel3.setText("Apellido");

        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoKeyTyped(evt);
            }
        });

        jLabel4.setText("Edad");

        txtedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtedadKeyTyped(evt);
            }
        });

        jLabel5.setText("Fecha nacimiento");

        btnguardar.setBackground(new java.awt.Color(204, 255, 255));
        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabelFoto.setBackground(new java.awt.Color(255, 255, 255));

        jDateChooserFecha.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(50, 50, 50))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtedad, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jDateChooserFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnfoto)
                        .addGap(19, 19, 19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnfoto)))
                .addGap(27, 27, 27)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime ahora=LocalDateTime.now();
        String fecha_registro=ahora.format(formatter);
        String foto=fichero.toString();
       int cedula=Integer.parseInt(txtcedula.getText());
               
        if( txtcedula.getText().isEmpty() ||
    txtedad.getText().isEmpty() || 
        txtnombre.getText().isEmpty() ||// TODO add your handling code here:
        txtapellido.getText().isEmpty())
       {
     JOptionPane.showMessageDialog(this, "Por favor diligencie todo el formulario", "Error", JOptionPane.ERROR_MESSAGE);
      
}else{
        if(cedula!=0){  
       rep.validacion(cedula);
         resetformulario();
          }
        else{
        
               
           
                
            
    
      try {
            String formato = jDateChooserFecha.getDateFormatString();
            Date date = jDateChooserFecha.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            String fecha = String.valueOf(sdf.format(date));


        usuarios=Datos_usuarios.crear(0,foto,Integer.parseInt(txtcedula.getText()),txtnombre.getText(),txtapellido.getText(),Integer.parseInt(txtedad.getText()),fecha,fecha_registro,0);
        repositorio.crear(usuarios);
        JOptionPane.showMessageDialog(this, "Jugador registrado", "Bien", JOptionPane.INFORMATION_MESSAGE);
        
        
         this.resetformulario();
         juego=new Jform_serpiente();
         juego.setVisible(true);
         
      } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Al menos elija una FECHA DE NACIMIENTO VALIDA ", "Error..!!", JOptionPane.ERROR_MESSAGE);

}  
          
          
        }
        }
        
        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        // TODO add your handling code here:
        //metodo que deja ingresar asolo datos numericos en el campo de texto
             char c=evt.getKeyChar();     
           if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               evt.consume();
              JOptionPane.showMessageDialog(this,"DATOS INCORRECTOS DEBEN SER NUMERICO","ERROR",JOptionPane.ERROR_MESSAGE);
               }
    
    
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void txtedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtedadKeyTyped
        // TODO add your handling code here:
        //metodo que deja ingresar asolo datos numericos en el campo de texto
             char c=evt.getKeyChar();     
           if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               evt.consume();
              JOptionPane.showMessageDialog(this,"DATOS INCORRECTOS DEBEN SER NUMERICO","ERROR",JOptionPane.ERROR_MESSAGE);
               }
    }//GEN-LAST:event_txtedadKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:
         //metodo que deja ingresar solo datos tipo texto en el campo de texto
        char c=evt.getKeyChar();             
          if(Character.isDigit(c)) { 
              getToolkit().beep();   
              evt.consume(); 
               
            JOptionPane.showMessageDialog(this,"DATOS INCORRECTOS DEBEN SER TEXTO","ERROR",JOptionPane.ERROR_MESSAGE);
               
          } 
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyTyped
        // TODO add your handling code here:
         //metodo que deja ingresar solo datos tipo texto en el campo de texto
        char c=evt.getKeyChar();             
          if(Character.isDigit(c)) { 
              getToolkit().beep();   
              evt.consume(); 
               
            JOptionPane.showMessageDialog(this,"DATOS INCORRECTOS DEBEN SER TEXTO","ERROR",JOptionPane.ERROR_MESSAGE);
               
          } 
    }//GEN-LAST:event_txtapellidoKeyTyped

    private void btnfotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfotoActionPerformed
        // TODO add your handling code here:
        int resultado;
cargar_foto ventana = new cargar_foto();
FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG yPNG","jpg","png");
ventana.jfchCargarfoto.setFileFilter(filtro);
resultado= ventana.jfchCargarfoto.showOpenDialog(null);
if (JFileChooser.APPROVE_OPTION == resultado){
fichero = ventana.jfchCargarfoto.getSelectedFile();
try{
ImageIcon icon = new ImageIcon(fichero.toString());
Icon icono = new
ImageIcon(icon.getImage().getScaledInstance(jLabelFoto.getWidth(), jLabelFoto.getHeight(), Image.SCALE_DEFAULT));
jLabelFoto.setText(null);
jLabelFoto.setIcon( icono );
}catch(Exception ex){
    JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);
}
}

    }//GEN-LAST:event_btnfotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfoto;
    private javax.swing.JButton btnguardar;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
