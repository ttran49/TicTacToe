package com.sanctuaryht.games.tictactoe;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class DrawView extends View {
    private Paint paint = new Paint();
    private int width;
    private int height;
    private char gameStatus;
    private Canvas canvas;
    private char currentShape = 'O';
    ArrayList<Shape>shapes;
    TheGame newGame;

    public DrawView(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        this.width = canvas.getWidth();
        System.out.println("width:"+this.width);
        this.height = canvas.getHeight();
        drawGrid();
        if(this.newGame==null){
            this.newGame = new TheGame(this.width,this.height);
            this.gameStatus = 'S';
            this.shapes = new ArrayList<Shape>();
            System.out.println("GameInfo(Object): "+newGame);
            System.out.println("GameInfo(Canvas-Width): "+newGame.getWidth());
            System.out.println("GameInfo(Canvas-Height): "+newGame.getWidth());
        }
        else{
            drawShapes();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        final int action = e.getAction();
        switch(action & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN: {
                //if(it's a valid location to put the piece){
                if(this.gameStatus == 'F'){
                    this.shapes.clear();
                    this.newGame.resetGame();
                    this.gameStatus = 'S';
                }
                else if(this.currentShape == 'O' && newGame.available(this.currentShape,e.getX(),e.getY())!=-1) {
                    this.currentShape = 'X';
                    this.shapes.add(new O(e.getX(),e.getY()));
                    System.out.println("GameInfo(Add-O): "+newGame.add('O',e.getX(),e.getY()));
                }
                else if(this.currentShape == 'X' && newGame.available(this.currentShape,e.getX(),e.getY())!=-1) {
                    this.currentShape = 'O';
                    this.shapes.add(new X(e.getX(),e.getY()));
                    System.out.println("GameInfo(Add-X): "+newGame.add('X',e.getX(),e.getY()));
                }
                if(this.newGame.isFull()||this.newGame.checkWin()!=0){
                    this.gameStatus = 'F';
                    if(this.newGame.checkWin()=='T'){
                        Toast.makeText(this.getContext(),
                                "TIE", Toast.LENGTH_SHORT)
                                .show();
                    }
                    else {
                        Toast.makeText(this.getContext(),
                                "Winner Is " + this.newGame.checkWin(), Toast.LENGTH_SHORT)
                                .show();
                    }
                    System.out.println("GameInfo(Winner): "+this.newGame.checkWin());
                }
                //}
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
        this.paint.setColor(Color.WHITE);
        this.paint.setStrokeWidth(this.width/55);
        //vertical lines
        this.canvas.drawLine(this.width/3,0,this.width/3,this.height,this.paint);
        this.canvas.drawLine(this.width*2/3,0,this.width*2/3,this.height,this.paint);
        //horizontal lines
        this.canvas.drawLine(0,this.height/3,this.width,this.height/3,this.paint);
        this.canvas.drawLine(0,this.height*2/3,this.width,this.height*2/3,this.paint);
    }

    public int adjustedHeight(int index){
        switch(index){
            case 0:
            case 1:
            case 2:
                return this.height/6;
            case 3:
            case 4:
            case 5:
                return this.height/6*3;
            case 6:
            case 7:
            case 8:
                return this.height/6*5;
        }
        return -1;
    }

    public int adjustedWidth(int index){
        switch(index){
            case 0:
            case 3:
            case 6:
                return this.width/6;
            case 1:
            case 4:
            case 7:
                return this.width/6*3;
            case 2:
            case 5:
            case 8:
                return this.width/6*5;
        }
        return -1;
    }

    public void drawShapes(){
        Iterator<Shape>shape = this.shapes.iterator();
        while(shape.hasNext()){
            Shape curShape = shape.next();
            int index = this.newGame.findIndex(curShape.getX(),curShape.getY());
            int newX = adjustedWidth(index);
            int newY = adjustedHeight(index);
            if(curShape instanceof O) {
                System.out.println("GameInfo(O): " + curShape);
                paint.setColor(Color.RED);
                paint.setStrokeWidth(width / 55);
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(newX, newY, width / 13, this.paint);
            }
            else if(curShape instanceof X) {
                System.out.println("GameInfo(X): " + curShape);
                paint.setColor(Color.BLUE);
                paint.setStrokeWidth(width/ 55);
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawLine(newX-(width/13),newY-(width/13),newX+(width/13),newY+(width/13),this.paint);
                canvas.drawLine(newX+(width/13),newY-(width/13),newX-(width/13),newY+(width/13),this.paint);
            }

        }
    }
}