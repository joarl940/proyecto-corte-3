/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import principal.Principal;

/**
 *
 * @author Jose
 */
public class JPane_juegol extends javax.swing.JPanel implements Runnable, KeyListener{
    
 

    
private Thread hilo;
private final int ancho=500;
private final int alto=400;

private boolean movimiento;
private long tiempo;

private Graphics2D g2d;
private  BufferedImage image;


private int SIZE=10;
private Render cuerpo,comida;
private ArrayList<Render> snake;
private int puntos;
private int nivel;
private boolean finJuego;

//movimiento
private int dx,dy;

//key input
private boolean arriba,abajo,derecha,izquierda,inicio;


    public JPane_juegol() {
        initComponents();
       setFocusable(true);
       requestFocus();
        addKeyListener(this);
    }
@Override
    public void addNotify(){
    super.addNotify();
    hilo=new Thread(this);
    hilo.start();
    }
    private void setFPS(int fps){
    tiempo=1000/fps;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int k=e.getKeyCode();
        if(k==KeyEvent.VK_UP) arriba=true;
        if(k==KeyEvent.VK_DOWN) abajo=true;
        if(k==KeyEvent.VK_RIGHT) derecha=true;
        if(k==KeyEvent.VK_LEFT) izquierda=true;
        if(k==KeyEvent.VK_ENTER) inicio =true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k=e.getKeyCode();
        if(k==KeyEvent.VK_UP) arriba=false;
        if(k==KeyEvent.VK_DOWN) abajo=false;
        if(k==KeyEvent.VK_RIGHT) derecha=false;
        if(k==KeyEvent.VK_LEFT) izquierda=false;
        if(k==KeyEvent.VK_ENTER) inicio =false;
    }


@Override
public void run(){
    if(movimiento)return;
    inicio();
    long startTime;
    long elapsed;
    long wait;
    while(movimiento){
    startTime=System.nanoTime();
    update();
    requestRender();
    elapsed=System.nanoTime()-startTime;
    wait=tiempo-elapsed/100000000;
    if(wait>0){
    try{
    Thread.sleep(wait);
    }catch(Exception e) {
    e.printStackTrace();
    }    
        
    }
    }

}
private void inicio(){
    image=new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_ARGB);
    g2d=image.createGraphics();
movimiento=true;
setUplevel();
finJuego=false;
nivel=1;
    setFPS(nivel*10);
}
public void setUplevel(){
snake=new ArrayList<Render>();
cuerpo=new Render(SIZE);
cuerpo.setPosicion(ancho/2, alto/2);
snake.add(cuerpo);

for(int i=1;i<2;i++){
    Render e=new Render(SIZE);
    e.setPosicion(cuerpo.getX()+(i*SIZE),cuerpo.getY());
    snake.add(e);
}
comida=new Render(SIZE);
setComida();
puntos=0;
}
public void setComida(){
int x=(int)(Math.random()*(ancho-SIZE));
int y=(int)(Math.random()*(alto-SIZE));
x=x-(x%SIZE);
y=y-(y%SIZE);
comida.setPosicion(x, y);
}


  private void update() {
      if(finJuego){
      if(inicio){
      setUplevel();
      }
      return;
     
      }
if(arriba&&dy==0){
dy=-SIZE;
dx=0;
}
if(abajo&&dy==0){
dy=SIZE;
dx=0;
}
if(izquierda&&dx==0){
dy=0;
dx=-SIZE;
}
if(derecha&&dx==0&&dy!=0){
dy=0;
dx=SIZE;
}
if (dx!=0||dy!=0){ 
for(int i=snake.size()-1;i>0;i--){
snake.get(i).setPosicion(snake.get(i-1).getX(),snake.get(i-1).getY());
        }
cuerpo.move(dx, dy);

}
for(Render e:snake){
    if(e.colision(cuerpo)){
    finJuego=true;
    break;
    }

}
if(comida.colision(cuerpo)){
puntos++;
setComida();
Render e=new Render(SIZE);
e.setPosicion(-100,-100);
snake.add(e);
if(puntos%10==0){
    nivel++;
    if  (nivel>10)
        nivel=10;
    setFPS(nivel*10);
}
}

if(cuerpo.getX()<0)cuerpo.setX(ancho);
if(cuerpo.getY()<0)cuerpo.setY(alto);
if(cuerpo.getX()>ancho)cuerpo.setX(0);
if(cuerpo.getY()>alto)cuerpo.setY(0);


  }

    private void requestRender() {
        render(g2d);
        Graphics g=getGraphics();
        g.drawImage(image,0,0, null);
        g.dispose();
    }
    
    public void render(Graphics2D g2d){
        g2d.clearRect(0, 0, ancho,alto);
        g2d.setColor(Color.WHITE);
        for (Render e:snake) {
            e.render(g2d);
                    }
    g2d.setColor(Color.GREEN);
    comida.render(g2d);
    if(finJuego){
      JOptionPane.showMessageDialog(this,"FIN DEL JUEGO");
      System.exit(0);
 
      
      
    
    }
    
    g2d.setColor(Color.WHITE);
    g2d.drawString("Jugador:  Arley    "+"puntos:   "+puntos+"    nivel  "+nivel,10,10);
     if(dx==0&&dy==0){
    g2d.drawString("INICIO", 150,200);
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

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
