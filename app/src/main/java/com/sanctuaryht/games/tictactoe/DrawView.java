package com.sanctuaryht.games.tictactoe;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;

public class DrawView extends View {
    private Paint paint = new Paint();
    private int width;
    private int height;
    private Canvas canvas;
    ArrayList<Circle>circles = new ArrayList<Circle>();
    public DrawView(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        width = canvas.getWidth();
        height = canvas.getHeight();
        drawGrid();
        drawCircle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        final int action = e.getAction();
        switch(action & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN: {
                final float x = e.getX();
                final float y = e.getY();
                System.out.println("touched-x: "+x);
                System.out.println("touched-y "+y);
                circles.add(new Circle(x,y));
                invalidate();
                break;
            }
            case MotionEvent.ACTION_MOVE: {

            }
            case MotionEvent.ACTION_UP: {

            }
            case MotionEvent.ACTION_CANCEL: {

            }

        }
        return false;
    }

    public void drawGrid(){
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(width/50);

        //vertical lines
        canvas.drawLine(width/3,0,width/3,height,paint);
        canvas.drawLine(width*2/3,0,width*2/3,height,paint);
        //horizontal lines
        canvas.drawLine(0,height/3,width,height/3,paint);
        canvas.drawLine(0,height*2/3,width,height*2/3,paint);
    }

    public void drawCircle(){
        Iterator<Circle> i = circles.iterator();
        while(i.hasNext()){
            Circle c = i.next();
            paint.setColor(Color.RED);
            paint.setStrokeWidth(width/50);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(c.getX(),c.getY(),width/10,paint);
        }
    }
}