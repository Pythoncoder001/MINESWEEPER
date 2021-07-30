package com.example.mine;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    static public int totalNumMines;
    static public int gridDim;
    private ScrollView layoutContent;
    public static TextView score;
    public static TextView highscore;
    Button b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutContent = (ScrollView) findViewById(R.id.layoutContent);
        score  = findViewById(R.id.score);
        highscore = findViewById(R.id.highscore);
        b = findViewById(R.id.button_back);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });


        if (getIntent().hasExtra(MenuActivity.KEY_GRID_SIZE)) {
            gridDim = getIntent().getIntExtra(MenuActivity.KEY_GRID_SIZE,4);
        }
        if (getIntent().hasExtra(MenuActivity.KEY_NUM_MINES)) {
            totalNumMines = getIntent().getIntExtra(MenuActivity.KEY_NUM_MINES,3);
        }

        final MinesweeperBoard gameField = (MinesweeperBoard) findViewById(R.id.gameField);

        final ToggleButton toggleBtn = (ToggleButton) findViewById(R.id.toggleBtn);
        toggleBtn.setOnClickListener(v -> gameField.toggleFlagSquare = !gameField.toggleFlagSquare);

        final Button restartBtn = (Button) findViewById(R.id.restartButton);
        restartBtn.setOnClickListener(v -> {
            gameField.clearGameField();
            toggleBtn.setChecked(false);
            score.setText("SCORE:" + 0);

        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void showGameOverMessage(String msg) {
        Snackbar.make(layoutContent, msg, Snackbar.LENGTH_LONG).setAction(
                R.string.cancelAction, v -> {


                }
        ).show();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(400);
    }
    }
