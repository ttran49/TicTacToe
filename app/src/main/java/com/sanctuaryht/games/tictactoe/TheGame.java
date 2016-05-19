package com.sanctuaryht.games.tictactoe;

/**
 * Created by tthuc on 5/19/2016.
 */
public class TheGame {
    private char board[];
    private float width;
    private float height;
    private int size=0;

    //contructors
    public TheGame(){
        board= new char[9];
    }
    public  TheGame(float width, float height){
        this.width=width;
        this.height=height;
    }

    //getters
    public float getWidth(){
        return width;
    }
    public float getHeight(){
        return height;
    }
    public int getSize(){
        return size;
    }

    protected boolean isEmpty(){
        return getSize()==0;
    }

    //return if the board is full
    protected boolean isFull(){
        return getSize()==board.length;
    }
    // getting the index depends on where the users
    //tap on the grid
    private int findIndex (float x, float y){
        //up top row
        if(y<= height/3){
            //check for columns
            if(x<= width/3)
                return 0;
            if(x >width/3 && x<= width*2/3)
                return 1;
            return 2;
        } else if (y > height/3 && y <= height*2/3){
            //check for collumns
            if(x<= width/3)
                return 3;
            if(x >width/3 && x<= width*2/3)
                return 4;
            return 5;
        } else {
            //check for collumns
            if(x<= width/3)
                return 6;
            if(x >width/3 && x<= width*2/3)
                return 7;
            return 8;
        }
    }
    //add a char to the array with index from the grid
    // 0  1  2
    // 3  4  5
    // 6  7  8
    // if full reset array
    // if same = do nothing
    public void add(char sym,float x, float y){
        //reset if full
        if (isFull()) {
            board = new char[9];
            size = 0;
        }

        //check for same symbol
        int index=findIndex(x,y);
        if(board[index]==0)
            return;
        if (sym==board[index])
            return;
        board[index]=sym;
        size++;
    }

    //return a char that wins
    public char checkWin(){
        if (isEmpty())
            return 0;
        return checkwin();
    }
    //return d if draw
    //return the char that win
    //return 0 if none has won yet
    private char checkwin(){
        //check horizontally
        if(board[0]==board[1]&& board[1]==board[2])
            return board[0];
        if(board[3]==board[4]&& board[4]==board[5])
            return board[3];
        if(board[6]==board[7]&& board[7]==board[8])
            return board[6];

        //check vertically
        if(board[0]==board[3]&& board[3]==board[6])
            return board[0];
        if(board[1]==board[4]&& board[4]==board[7])
            return board[1];
        if(board[2]==board[5]&& board[5]==board[8])
            return board[2];

        //check dia
        if(board[0]==board[4]&& board[4]==board[8])
            return board[0];
        if(board[2]==board[4]&& board[4]==board[6])
            return board[2];

        //check draw
        if(isFull())
            return 'd';
        return 0;
    }
}
