package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=findViewById(R.id.layout);
        initChangeButton();

    }

    public void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("colorPref", Context.MODE_PRIVATE);
        int color = sp.getInt("color",0);
        layout.setBackgroundColor(color);
    }

    private void initChangeButton(){
        Button changeButton = findViewById(R.id.buttonChange);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorSettings.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}