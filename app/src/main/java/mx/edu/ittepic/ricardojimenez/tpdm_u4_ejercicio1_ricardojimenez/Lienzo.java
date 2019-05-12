package mx.edu.ittepic.ricardojimenez.tpdm_u4_ejercicio1_ricardojimenez;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    String posicion="";
    int ix,iy,ix2,iy2;
    Icono icono,icono2,puntero;
    boolean b = false;
    public Lienzo(Context context) {
        super(context);
        icono = new Icono(400,900,R.drawable.bandera,this);
        icono2 = new Icono(100,200,R.drawable.firefox,this);
        ix = 700;
        iy=300;
        puntero = null;
    }
    protected void onDraw(Canvas c){

//        el evento ondraw permite dibujar en la pantalla del celular
        //el objeto Canvas ejecuta el dibujo
//        el objeto Paint indica sus caracteristicas como tamano, color,etc
        Paint p = getPaint();
        c.drawColor(Color.BLUE);
//        p.setColor(Color.WHITE);
//        p.setTextSize(60f);
//        c.drawText("Ricardo Jimenez",50,50,p);
//        p.setTextSize(60f);
//        c.drawText(posicion,100,800,p);
//        p.setColor(Color.RED);
//        c.drawRect(100f,200f,350f,350f,p);
//        p.setColor(Color.GREEN);
//        c.drawCircle(500f,500f,200f,p);
//        p.setColor(Color.YELLOW);
//        c.drawOval(200f,350f,550f,450f,p);
//        c.drawBitmap(icono.getIcono(),icono.getX(),icono.getY(),p);
//        c.drawBitmap(icono2.getIcono(),icono2.getX(),icono2.getY(),p);
        icono.pintar(c,p);
        icono2.pintar(c,p);
        if (b){
            c.drawText("SI",ix,iy,p);
        }
    }
    private Paint getPaint(){
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(60f);
        return p;
    }

    public boolean onTouchEvent(MotionEvent me){
//        el evento onTochEvent permite detectar los toques
//        de uno o mas dedos que se hacen en el area de dibujo

        int accion = me.getAction();
        int posx= (int)me.getX();
        int posy= (int)me.getY();

        posicion = posx +" , "+posy;
        switch (accion){
            case MotionEvent.ACTION_DOWN: //presinado
                if(icono.estaEnArea(posx,posy)) {
                    puntero = icono;
                }
                if(icono2.estaEnArea(posx,posy)) {
                    puntero = icono2;
                }
                break;
            case MotionEvent.ACTION_MOVE: //moviendose sin soltar

                if(puntero!=null){
                    puntero.mover(posx,posy);
                    if(puntero.estaEnColision(icono2)){
                        b=true;
                    }else
                    if(puntero.estaEnColision(icono)){
                        b=true;
                    }else{ b=false;}

                }

                break;
            case MotionEvent.ACTION_UP:  //soltar

                puntero=null;
                break;
        }
        invalidate();
        return true;
    }
}
