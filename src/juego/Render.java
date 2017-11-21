/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Jose
 */
public class Render {
    private int x,y,size;
    public Render(int size){
    this.size=size;
    }
    
    public int getX(){
    return x;
    }
    public int getY(){
    return y;
    }
    public void setX(int x){
    this.x=x;
    }
    public void setY(int y){
    this.y=y;
    } 
     public void setPosicion(int x , int y){
          this.x=x;
          this.y=y;
    }
     
     //suma la posicion en la que se mueve la serpiente
     public void move(int dx,int dy) {
     x+=dx;
     y+=dy;
     }
    
    public Rectangle getbound(){
    return new Rectangle(x, y, size, size);
    }
    
    
    public boolean colision(Render o){
    if (o==this)
    return false;
    return getbound().intersects(o.getbound());
    }
    //separa el cuerpo de la serpeinte para que se vean en cuadros
    public void render(Graphics2D g2d){
    g2d.fillRect(x+1, y+1, size-2, size-2);
    }
}
