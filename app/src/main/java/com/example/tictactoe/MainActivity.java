package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean currentplayer = true;
    int activeplayer = 0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    int[][] winningposition = {{0,1,2}, {3,4,5}, {6,7,8},
                                 {0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
      int count = 0;




    public void playertab(View view)
    {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (gamestate[tappedImage] == 2){
            count ++;
            gamestate[tappedImage] = activeplayer;
            img.setTranslationY(-1000f);
            if (!currentplayer) {

                rematch(view);
            }
        if (activeplayer == 0)
        {

            img.setImageResource(R.drawable.img_1);
            TextView status = findViewById(R.id.textView2);
            status.setText("O's Turn");
            activeplayer = 1;
        }
        else {
            img.setImageResource(R.drawable.img_2);
            TextView status = findViewById(R.id.textView2);
            status.setText("X's Turn");
            activeplayer = 0;

        }
        img.animate().translationYBy(1000.f).setDuration(300);
        }

        int flag = 0;
        for (int[] winningposition: winningposition){
            if (gamestate[winningposition[0]] == gamestate[winningposition[1]] &&
                    gamestate[winningposition[1]] == gamestate[winningposition[2]] && gamestate[winningposition[0]] != 2 ) {
                flag = 1;

                if (gamestate[winningposition[0]] == 0) {
                    TextView status = findViewById(R.id.textView2);
                    status.setText("X WON");
                }
                else {
                    TextView status = findViewById(R.id.textView2);
                    status.setText("O WON");
                }

            }
        }
        if (count == 9 && flag == 0)
        {
            TextView status = findViewById(R.id.textView2);
            status.setText("Tie");
        }

        }


    public void rematch(View view)
    {

        TextView status = findViewById(R.id.textView2);
        status.setText("X's Turn");
        activeplayer = 0;
        currentplayer = true;
        count =0;
        for (int i = 0; i <9 ; i++) {
            gamestate[i] = 2;
        }
        ImageView id1 = (ImageView) findViewById(R.id.imageView11);
        id1.setImageResource(0);
        ImageView id2 = (ImageView) findViewById(R.id.imageView12);
        id2.setImageResource(0);
        ImageView id3 = (ImageView) findViewById(R.id.imageView13);
        id3.setImageResource(0);
        ImageView id4 = (ImageView) findViewById(R.id.imageView14);
        id4.setImageResource(0);
        ImageView id5 = (ImageView) findViewById(R.id.imageView15);
        id5.setImageResource(0);
        ImageView id6 = (ImageView) findViewById(R.id.imageView16);
        id6.setImageResource(0);
        ImageView id7 = (ImageView) findViewById(R.id.imageView17);
        id7.setImageResource(0);
        ImageView id8 = (ImageView) findViewById(R.id.imageView18);
        id8.setImageResource(0);
        ImageView id9 = (ImageView) findViewById(R.id.imageView19);
        id9.setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}