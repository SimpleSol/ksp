package com.example.tikhon.ksp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnRed;
    private Button btnBlue;
    private Button btnOrange;
    private Button btnGreen;
    private LinearLayout indicators;
    private String result = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setOnClicks();
    }

    private void findViews() {
        btnRed = findViewById(R.id.btnRed);
        btnBlue = findViewById(R.id.btnBlue);
        btnOrange = findViewById(R.id.btnOrange);
        btnGreen = findViewById(R.id.btnGreen);
        indicators = findViewById(R.id.indicators);
    }

    private void setOnClicks() {
        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResult("R");
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResult("B");
            }
        });

        btnOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResult("O");
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResult("G");
            }
        });
    }

    private void updateResult(String value) {
        result = result + value;
        updateIndicators();
        checkResult();
    }

    private void checkResult() {
        if (result.length() == 4) {
            if (result.equals("GROB")) {
                showEasternEgg();
            } else {
                showFail();
            }
            resetResult();
            resetIndicators();
        }
    }

    private void updateIndicators() {
        for (int i = 0; i < result.length(); i++) {
            indicators.getChildAt(i).setActivated(true);
        }
    }

    private void showEasternEgg() {
        final Intent intent = new Intent(this, EasternEggActivity.class);
        startActivity(intent);
    }

    private void showFail() {
        Toast.makeText(this, R.string.wrong_guess, Toast.LENGTH_SHORT).show();
    }

    private void resetIndicators() {
        for (int i = 0; i < indicators.getChildCount(); i++) {
            indicators.getChildAt(i).setActivated(false);
        }
    }

    private void resetResult() {
        result = "";
    }
}
