package mx.edu.ittepic.ricardojimenez.tpdm_u4_ejercicio1_ricardojimenez;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Icono {
    int x,y;
    Bitmap icono;


    public Icono(int x, int y, int imagen,Lienzo e) {
        this.x = x;
        this.y = y;
        this.icono = BitmapFactory.decodeResource(e.getResources(),imagen);
    }

    public void mover(int dedox,int dedoy){
        x = dedox - (icono.getWidth()/2);
        y = dedoy - (icono.getHeight()/2);
    }
    public void pintar(Canvas c, Paint p){
        c.drawBitmap(icono,x,y,p);
    }
    public boolean estaEnArea(int dedox,int dedoy)
    {
        int x2=x+icono.getWidth();
        int y2=y+icono.getHeight();
        if(dedox >=x && dedox<=x2 && dedoy >=y && dedoy<=y2){
//            if(dedoy >=y && dedoy<=y2){
                return true;
//            }
        }
        return false;
    }
    public boolean estaEnColision(Icono objetoB){
        if(!objetoB.equals(this) ) {
            int bx = objetoB.x;
            int by = objetoB.y;
            int bx2 = bx + objetoB.icono.getWidth();
            int by2 = by + objetoB.icono.getHeight();
            if (estaEnArea(bx2, by2)) {//p4 en b
                return true;
            }
            if (estaEnArea(bx, by)) { //p1 en b
                return true;
            }
            if (estaEnArea(bx, by2)) {//p3 en b
                return true;
            }
            if (estaEnArea(bx2, by)) {
                return true;
            }
        }
        return false;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bitmap getIcono() {
        return icono;
    }

    public void setIcono(Bitmap icono) {
        this.icono = icono;
    }
}
