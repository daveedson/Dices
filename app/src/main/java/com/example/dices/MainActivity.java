package com.example.dices;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceimage1 = findViewById(R.id.dice1);
        final ImageView diceimage2 = findViewById(R.id.dice2);


        final int [] diceimages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};






        Button  btnroll = findViewById(R.id.btnrolldice);



      final   MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound); //object creation for media player.



        btnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rnd = new Random();
                int RandomNumber = rnd.nextInt(6);//0...5
                int Random = rnd.nextInt(5);//0...4

                Log.i("Dices","The generated random number is....." + RandomNumber+ "");

                diceimage1.setImageResource(diceimages[RandomNumber]);
                diceimage2.setImageResource(diceimages[Random]);


                YoYo.with(Techniques.Shake) //animation for dice1 shakes
                        .duration(500)
                        .repeat(0)
                        .playOn(diceimage1);

                YoYo.with(Techniques.Shake) //animation for dice2 shakes
                        .duration(500)
                        .repeat(0)
                        .playOn(diceimage2);


                mp.start();


            }
        });
    }




}
