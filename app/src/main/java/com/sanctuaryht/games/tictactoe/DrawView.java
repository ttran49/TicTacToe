package com.sanctuaryht.games.tictactoe;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
    Paint paint = new Paint();

    public DrawView(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(15);

        int width= canvas.getWidth();
        int height= canvas.getHeight();
        //vertical lines
        canvas.drawLine(width/3,0,width/3,height,paint);
        canvas.drawLine(width*2/3,0,width*2/3,height,paint);
        //horizontal lines
        canvas.drawLine(0,height/3,width,height/3,paint);
        canvas.drawLine(0,height*2/3,width,height*2/3,paint);
    }
    }


