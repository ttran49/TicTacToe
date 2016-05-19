package com.sanctuaryht.games.tictactoe;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
    private Paint paint = new Paint();
    private int width;
    private int height;
    public DrawView(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        width = canvas.getWidth();
        height = canvas.getHeight();
        drawGrid(canvas);
        drawCircle(100,100,canvas);
    }

    public void drawGrid(Canvas canvas){
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(width/50);
        //vertical lines
        canvas.drawLine(width/3,0,width/3,height,paint);
        canvas.drawLine(width*2/3,0,width*2/3,height,paint);
        //horizontal lines
        canvas.drawLine(0,height/3,width,height/3,paint);
        canvas.drawLine(0,height*2/3,width,height*2/3,paint);
    }

    public void drawCircle(float x, float y, Canvas canvas){
        paint.setColor(Color.RED);
        paint.setStrokeWidth(width/50);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x,y,width/10,paint);
    }
}