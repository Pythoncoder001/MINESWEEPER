package com.example.mine;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    public static final String KEY_NUM_MINES = "KEY_NUM_MINES";
    public static final String KEY_GRID_SIZE = "KEY_GRID_SIZE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_menu);

        Button easyBtn = (Button) findViewById(R.id.easyBtn);
        easyBtn.setBackgroundColor(Color.LTGRAY);
        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentEasyGameActivity = new Intent(MenuActivity.this, MainActivity.class);
                intentEasyGameActivity.putExtra(KEY_NUM_MINES, 3);
                intentEasyGameActivity.putExtra(KEY_GRID_SIZE, 4);

                startActivity(intentEasyGameActivity);



            }
        });

        Button mediumBtn = (Button) findViewById(R.id.mediumBtn);
        mediumBtn.setBackgroundColor(Color.LTGRAY);
        mediumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentMediumGameActivity = new Intent(MenuActivity.this, MainActivity.class);
                intentMediumGameActivity.putExtra(KEY_NUM_MINES, 6);
                intentMediumGameActivity.putExtra(KEY_GRID_SIZE, 6);

                startActivity(intentMediumGameActivity);
            }
        });

        Button hardBtn = (Button) findViewById(R.id.hardBtn);
        hardBtn.setBackgroundColor(Color.LTGRAY);
        hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHardGameActivity = new Intent(MenuActivity.this, MainActivity.class);
                intentHardGameActivity.putExtra(KEY_NUM_MINES, 10);
                intentHardGameActivity.putExtra(KEY_GRID_SIZE, 8);

                startActivity(intentHardGameActivity);
            }
        });

    }
}
