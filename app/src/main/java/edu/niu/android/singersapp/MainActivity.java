/************************************************************************
 *                                                                      *
 * CSCI 322/522             Assignment 5               current semester *
 *                                                                      *
 *          App Name: Singers App                                       *
 *                                                                      *
 *          Class Name:MainActivity.java                                *
 *                                                                      *
 *         Developer(s): Akshaya Rajarajan and Mohan Krishna Pasupuleti *
 *                                                                      *
 *          Due Date:     11/03/2023                                    *
 *                                                                      *
 *      Purpose: MainActivity.java is a Java file that serves as the    *
 *               main entry point for an Android app. We create a grid  *
 *               layout and we set the image buttons in the grid layout.*
 *               After that we set the images of singers to the buttons.*
 *               We instantiate the objects for Profiles class and put  *
 *               them in an ArrayList. We then create an intent to the  *
 *               profiles class to navigate to the next view.           *
 ************************************************************************/


package edu.niu.android.singersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int SIDE = 3;
    private ImageButton[][] buttons;
    private TextView status;
    private int id;
    public static final String EXTRA_MESSAGE = "";
    public static ArrayList<Profiles> arr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        buildUiByCode();
        Profiles swift = new Profiles("Taylor Swift", 33, "Pennsylvania, USA", "December 13, 1989", "5 feet 10 inches", R.drawable.taylor_swift_picture);
        Profiles Gom = new Profiles("Selena Gomezy", 29, "Grand Prairie, Texas, USA", "July 22, 1992", "5 feet 5 inches", R.drawable.salena_gomez);
        Profiles Dsp = new Profiles("Devi Sri Prasad", 44, "Chennai, India", "2 August 1979", "5 Feet 11 Inches", R.drawable.dsp);
        Profiles Ed = new Profiles("Ed Sheeran", 31, "Halifax, West Yorkshire, England", "February 17, 1991", "5 Feet 8 Inches", R.drawable.edsheeran);
        Profiles Ani = new Profiles("Anirudh", 33, "Chennai, India", "16 October 1990", "5 Feet 9 Inches", R.drawable.anirudh);
        Profiles Ari = new Profiles("Ariana Grande", 29, "Boca Raton, Florida, United States", "June 26, 1993", "5 Feet 3 Inches", R.drawable.ariana_grande);
        Profiles Raja = new Profiles("Ilaiyaraaja", 78, "Chennai, India", "02 Jun 1943", "5 Feet 4 Inches", R.drawable.ilaiyaraaja);
        Profiles Harry = new Profiles("Harris Jayaraj", 47, "Chennai, India", "08 Jan 1975", "5 Feet 8 Inches", R.drawable.harris_jayaraj);
        Profiles JB = new Profiles("Justin Bieber", 28, "London, Ontario, Canada", "March 1, 1994", "5 Feet 9 Inches", R.drawable.justin_bieber);
        arr = new ArrayList<Profiles>(0);
        arr.add(swift);
        arr.add(Gom);
        arr.add(Dsp);
        arr.add(Ed);
        arr.add(Ani);
        arr.add(Ari);
        arr.add(Raja);
        arr.add(Harry);
        arr.add(JB);
    }
    @SuppressLint("ResourceType")
    public void buildUiByCode()
    {
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int w = size.x / 3;

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(SIDE);
        gridLayout.setRowCount(SIDE + 1);

        buttons = new ImageButton[SIDE][SIDE];
        ButtonHandler bh = new ButtonHandler();

        for (int row = 0; row < SIDE; row++)
        {
            for (int col = 0; col < SIDE; col++)
            {
                buttons[row][col] = new ImageButton(this);
                buttons[row][col].setOnClickListener(bh);
                gridLayout.addView(buttons[row][col], w, w);
            }

            }
        status = new TextView(this);
        GridLayout.Spec rowSpec = GridLayout.spec(SIDE, 1);
        GridLayout.Spec columnSpec = GridLayout.spec(0, SIDE);
        GridLayout.LayoutParams lpStatus = new GridLayout.LayoutParams(rowSpec, columnSpec);
        status.setLayoutParams(lpStatus);

        status.setWidth(SIDE * w);
        status.setHeight(w);
        status.setGravity(Gravity.CENTER);
        status.setBackgroundColor(Color.GREEN);
        status.setTextSize((int) (w * .1));
        status.setText("Select your favourite singer");
        gridLayout.addView(status);
        setContentView(gridLayout);

        buttons[0][0].setId(0);
        buttons[0][0].setImageResource(R.drawable.taylor_swift_picture);
        buttons[0][1].setId(1);
        buttons[0][1].setImageResource(R.drawable.salena_gomez);
        buttons[0][2].setId(2);
        buttons[0][2].setImageResource(R.drawable.dsp);
        buttons[1][0].setId(3);
        buttons[1][0].setImageResource(R.drawable.edsheeran);
        buttons[1][1].setId(4);
        buttons[1][1].setImageResource(R.drawable.anirudh);
        buttons[1][2].setId(5);
        buttons[1][2].setImageResource(R.drawable.ariana_grande);
        buttons[2][0].setId(6);
        buttons[2][0].setImageResource(R.drawable.ilaiyaraaja);
        buttons[2][1].setId(7);
        buttons[2][1].setImageResource(R.drawable.harris_jayaraj);
        buttons[2][2].setId(8);
        buttons[2][2].setImageResource(R.drawable.justin_bieber);

    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            for (int row = 0; row < SIDE; row++)
                for (int column = 0; column < SIDE; column++)
                    if (v == buttons[row][column]) {
                        id = buttons[row][column].getId();
                        String message = Integer.toString(id);
                        Intent i = new Intent(MainActivity.this, Profiles.class);
                        i.putExtra(EXTRA_MESSAGE, message);
                        startActivity(i);
                    }


        }
    }
}