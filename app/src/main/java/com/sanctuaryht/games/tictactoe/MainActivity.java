package com.sanctuaryht.games.tictactoe;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by Han on 5/19/2016.
 */
public class MainActivity extends Activity {
    DrawView drawView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(drawView == null) {
            this.drawView = new DrawView(this);
            this.drawView.setBackgroundColor(Color.BLACK);
        }
        setContentView(this.drawView);
        Toast.makeText(getApplicationContext(),"onCreate", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext(),"onSave", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        Toast.makeText(getApplicationContext(),"onRestore", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume", Toast.LENGTH_SHORT).show();
    }
}