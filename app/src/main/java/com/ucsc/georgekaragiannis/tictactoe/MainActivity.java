package com.ucsc.georgekaragiannis.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean state = true;
    private boolean[] Position = new boolean[9]; //prevents from 2nd press
    private int[] XorO = new int[9];
    private boolean boardIsFull = false;
    private boolean b;

    // each variable points to an ImageButton
    ImageButton image0;
    ImageButton image1;
    ImageButton image2;
    ImageButton image3;
    ImageButton image4;
    ImageButton image5;
    ImageButton image6;
    ImageButton image7;
    ImageButton image8;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout relative = (RelativeLayout) findViewById(R.id.Relative);

        //initialize the variables
        image0 = (ImageButton) findViewById(R.id.imageButton00);
        image1 = (ImageButton) findViewById(R.id.imageButton01);
        image2 = (ImageButton) findViewById(R.id.imageButton02);
        image3 = (ImageButton) findViewById(R.id.imageButton10);
        image4 = (ImageButton) findViewById(R.id.imageButton11);
        image5 = (ImageButton) findViewById(R.id.imageButton12);
        image6 = (ImageButton) findViewById(R.id.imageButton20);
        image7 = (ImageButton) findViewById(R.id.imageButton21);
        image8 = (ImageButton) findViewById(R.id.imageButton22);

        for(int j=0;j<9;j++){
            Position[j] = true; // true when an imageButton has not been pressed
            XorO[j] = 9 + j; // initialize the array, so that each element has a distinct value
                            // above 9
        }


    }

    public void clickBoard(View v){

        boolean scenario1; //row0
        boolean scenario2; //col0
        boolean scenario3; //diagonal1
        boolean scenario4; //col1
        boolean scenario5; //col2
        boolean scenario6; //diagonal2
        boolean scenario7; //row1
        boolean scenario8; //row2

        ImageButton vv = (ImageButton) v; // a reference to the imageButton pressed
        String s = (String) v.getTag();

        int i = Integer.parseInt(s); //i indicates the imageButton

        if (state == true && Position[i] == true ){
            vv.setImageResource(R.drawable.cross);
            state = false; // draw a circle next
            XorO[i] = 2; // insert a 2 in the array if a cross is drawn
            Position[i] = false; // prevents from second press
        } else if(state == false && Position[i] == true){
            vv.setImageResource(R.drawable.circle);
            state = true; //draw a cross next
            XorO[i] = 1; // inserrt a 1 in the array if a circle is drawn
            Position[i] = false;
        }

        b = (Position[0] == false && Position[1] == false && Position[2] == false
                && Position[3] == false && Position[4] == false && Position[5] == false
                && Position[6] == false && Position[7] == false && Position[8] == false);

        if ( b ) {

            boardIsFull = true;
        }

        scenario1 = (XorO[0] == XorO[1] && XorO[1] == XorO[2]);
        scenario2 = (XorO[0] == XorO[3] && XorO[3] == XorO[6]);
        scenario3 = (XorO[0] == XorO[4] && XorO[4] == XorO[8]);
        scenario4 = (XorO[1] == XorO[4] && XorO[4] == XorO[7]);
        scenario5 = (XorO[2] == XorO[5] && XorO[5] == XorO[8]);
        scenario6 = (XorO[2] == XorO[4] && XorO[4] == XorO[6]);
        scenario7 = (XorO[3] == XorO[4] && XorO[4] == XorO[5]);
        scenario8 = (XorO[6] == XorO[7] && XorO[7] == XorO[8]);

        // textViews when x/o wins or a tie occurs
        TextView x = (TextView) findViewById(R.id.Xwon);
        TextView o = (TextView) findViewById(R.id.Owon);
        TextView d = (TextView) findViewById(R.id.DrawView);

        if(Xwins()){
            x.setVisibility(View.VISIBLE); // make it visible
            for(int j=0;j<9;j++){
                Position[j] = false; // Halt the game when a win occurs. Cannot press any button
            }
        }

        if(Owins()){
            o.setVisibility(View.VISIBLE); // make it visible
            for(int j=0;j<9;j++){
                Position[j] = false; // Halt the game when a win occurs
            }
        }

        if(boardIsFull && Xwins() == false && Owins() == false){
            d.setVisibility(View.VISIBLE);
        }


        // when a win occurs, highlight the winning buttons, by changing the alpha
        // and the color (blue)
        if(scenario1){

            image0.setAlpha(127);
            image0.setBackgroundColor(Color.parseColor("#5D87C1"));
            image1.setAlpha(127);
            image1.setBackgroundColor(Color.parseColor("#5D87C1"));
            image2.setAlpha(127);
            image2.setBackgroundColor(Color.parseColor("#5D87C1"));
        }

        if(scenario2){

            image0.setAlpha(127);
            image0.setBackgroundColor(Color.parseColor("#5D87C1"));
            image3.setAlpha(127);
            image3.setBackgroundColor(Color.parseColor("#5D87C1"));
            image6.setAlpha(127);
            image6.setBackgroundColor(Color.parseColor("#5D87C1"));
        }

        if(scenario3){

            image0.setAlpha(127);
            image0.setBackgroundColor(Color.parseColor("#5D87C1"));
            image4.setAlpha(127);
            image4.setBackgroundColor(Color.parseColor("#5D87C1"));
            image8.setAlpha(127);
            image8.setBackgroundColor(Color.parseColor("#5D87C1"));
        }

        if(scenario4){

            image1.setAlpha(127);
            image1.setBackgroundColor(Color.parseColor("#5D87C1"));
            image4.setAlpha(127);
            image4.setBackgroundColor(Color.parseColor("#5D87C1"));
            image7.setAlpha(127);
            image7.setBackgroundColor(Color.parseColor("#5D87C1"));
        }

        if(scenario5){

            image2.setAlpha(127);
            image2.setBackgroundColor(Color.parseColor("#5D87C1"));
            image5.setAlpha(127);
            image5.setBackgroundColor(Color.parseColor("#5D87C1"));
            image8.setAlpha(127);
            image8.setBackgroundColor(Color.parseColor("#5D87C1"));
        }

        if(scenario6){

            image2.setAlpha(127);
            image2.setBackgroundColor(Color.parseColor("#5D87C1"));
            image4.setAlpha(127);
            image4.setBackgroundColor(Color.parseColor("#5D87C1"));
            image6.setAlpha(127);
            image6.setBackgroundColor(Color.parseColor("#5D87C1"));
        }

        if(scenario7){

            image3.setAlpha(127);
            image3.setBackgroundColor(Color.parseColor("#5D87C1"));
            image4.setAlpha(127);
            image4.setBackgroundColor(Color.parseColor("#5D87C1"));
            image5.setAlpha(127);
            image5.setBackgroundColor(Color.parseColor("#5D87C1"));
        }

        if(scenario8){

            image6.setAlpha(127);
            image6.setBackgroundColor(Color.parseColor("#5D87C1"));
            image7.setAlpha(127);
            image7.setBackgroundColor(Color.parseColor("#5D87C1"));
            image8.setAlpha(127);
            image8.setBackgroundColor(Color.parseColor("#5D87C1"));

        }

    }

    public void newGame(View v){

        //set image resources to blank
        image0.setImageResource(R.drawable.blank);
        image1.setImageResource(R.drawable.blank);
        image2.setImageResource(R.drawable.blank);
        image3.setImageResource(R.drawable.blank);
        image4.setImageResource(R.drawable.blank);
        image5.setImageResource(R.drawable.blank);
        image6.setImageResource(R.drawable.blank);
        image7.setImageResource(R.drawable.blank);
        image8.setImageResource(R.drawable.blank);

        for(int j=0; j<9; j++){
            Position[j] = true; // reset the array, so that you can click again
            XorO[j] = 9 + j; // reset XorO (start over)
        }

        state = true; // start with X again
        boardIsFull = false; //reset boolean, as the board is not full in a new game

        // make the textView invisible at the start of each new game
        TextView x = (TextView) findViewById(R.id.Xwon);
        TextView o = (TextView) findViewById(R.id.Owon);
        TextView d = (TextView) findViewById(R.id.DrawView);
        x.setVisibility(View.INVISIBLE);
        o.setVisibility(View.INVISIBLE);
        d.setVisibility(View.INVISIBLE);

        // set the alpha and the background color back to the default
        image0.setBackgroundColor(Color.parseColor("#BDBDC1"));
        image0.setAlpha(255);
        image1.setBackgroundColor(Color.parseColor("#BDBDC1"));
        image1.setAlpha(255);
        image2.setBackgroundColor(Color.parseColor("#BDBDC1"));
        image2.setAlpha(255);
        image3.setBackgroundColor(Color.parseColor("#BDBDC1"));
        image3.setAlpha(255);
        image4.setBackgroundColor(Color.parseColor("#BDBDC1"));
        image4.setAlpha(255);
        image5.setBackgroundColor(Color.parseColor("#BDBDC1"));
        image5.setAlpha(255);
        image6.setBackgroundColor(Color.parseColor("#BDBDC1"));
        image6.setAlpha(255);
        image7.setBackgroundColor(Color.parseColor("#BDBDC1"));
        image7.setAlpha(255);
        image8.setBackgroundColor(Color.parseColor("#BDBDC1"));
        image8.setAlpha(255);

    }

    // returns true if X wins
    private boolean Xwins(){
        boolean Xwin;
        boolean scenario1 = (XorO[0]==2 && XorO[1]==2 && XorO[2]==2); //row0
        boolean scenario2 = (XorO[0]==2 && XorO[3]==2 && XorO[6]==2); //col0
        boolean scenario3 = (XorO[0]==2 && XorO[4]==2 && XorO[8]==2); //diagonal1
        boolean scenario4 = (XorO[1]==2 && XorO[4]==2 && XorO[7]==2); //col1
        boolean scenario5 = (XorO[2]==2 && XorO[5]==2 && XorO[8]==2); //col2
        boolean scenario6 = (XorO[2]==2 && XorO[4]==2 && XorO[6]==2); //diagonal2
        boolean scenario7 = (XorO[3]==2 && XorO[4]==2 && XorO[5]==2); //row1
        boolean scenario8 = (XorO[6]==2 && XorO[7]==2 && XorO[8]==2); //row2
        Xwin = (scenario1||scenario2||scenario3||scenario4||scenario5
                ||scenario6||scenario7||scenario8); // if one of the scenarios is true, then X wins


        if(Xwin){
            return true;
        }

        return false;

    }

    // returns true if O wins
    private boolean Owins(){
        boolean Owin;
        boolean scenario1 = (XorO[0]==1 && XorO[1]==1 && XorO[2]==1); //row0
        boolean scenario2 = (XorO[0]==1 && XorO[3]==1 && XorO[6]==1); //col0
        boolean scenario3 = (XorO[0]==1 && XorO[4]==1 && XorO[8]==1); //diagonal1
        boolean scenario4 = (XorO[1]==1 && XorO[4]==1 && XorO[7]==1); //col1
        boolean scenario5 = (XorO[2]==1 && XorO[5]==1 && XorO[8]==1); //col2
        boolean scenario6 = (XorO[2]==1 && XorO[4]==1 && XorO[6]==1); //diagonal2
        boolean scenario7 = (XorO[3]==1 && XorO[4]==1 && XorO[5]==1); //row1
        boolean scenario8 = (XorO[6]==1 && XorO[7]==1 && XorO[8]==1); //row2
        Owin = (scenario1||scenario2||scenario3||scenario4||scenario5
                ||scenario6||scenario7||scenario8); // if one of the scenarios is true, then O wins

        if(Owin){
            return true;
        }

        return false;
    }


}
