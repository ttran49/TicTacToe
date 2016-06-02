package com.sanctuaryht.games.tictactoe;

/**
 * Created by Han on 5/24/2016.
 */
public abstract class Shape {
    private float x;
    private float y;
    public Shape(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
}
