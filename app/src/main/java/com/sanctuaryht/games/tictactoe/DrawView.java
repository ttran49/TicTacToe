package com.sanctuaryht.games.tictactoe;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
    private Paint paint = new Paint();
    private int canvasW;
    private int canvasH;
    public DrawView(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvasW = canvas.getWidth();
        canvasH = canvas.getHeight();
        drawCircle(100,100,canvas);
    }

    public void drawCircle(float x, float y, Canvas canvas){
        paint.setColor(Color.RED);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x,y,canvasW/10,paint);
    }
}
