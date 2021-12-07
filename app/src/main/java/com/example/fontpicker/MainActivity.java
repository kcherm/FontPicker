package com.example.fontpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;
    TextView fontBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=findViewById(R.id.layout);
        initChangeButton();

        fontBox = findViewById(R.id.fontBox);

        Typeface cascadia = Typeface.createFromAsset(getAssets(),"Fonts/cascadia.ttf");
        Typeface SeriesEM = Typeface.createFromAsset(getAssets(),"Fonts/fhwa.ttf");
        Typeface MediaCenter = Typeface.createFromAsset(getAssets(),"Fonts/segoemcl.ttf");



    }

    public void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("fontPref", Context.MODE_PRIVATE);

        int font = sp.getInt("font", 0);

        if (font==0){
            Typeface cascadia = Typeface.createFromAsset(getAssets(),"Fonts/cascadia.ttf");
            fontBox.setTypeface(cascadia);
            fontBox.setText("The Quick Brown Fox Jumps Over The Lazy Dog - This is Microsoft's Cascadia Code Font");
        }
        else if (font==1){
            Typeface SeriesEM = Typeface.createFromAsset(getAssets(),"Fonts/fhwa.ttf");
            fontBox.setTypeface(SeriesEM);
            fontBox.setText("The Quick Brown Fox Jumps Over The Lazy Dog - This is The FHWA's Font used for Highway Signs");
        }
        else if(font==2){
            Typeface MediaCenter = Typeface.createFromAsset(getAssets(),"Fonts/segoemcl.ttf");
            fontBox.setTypeface(MediaCenter);
            fontBox.setText("The Quick Brown Fox Jumps Over The Lazy Dog - This is the font used in Windows Media Center");
        }
        else {
            Typeface Clearview = Typeface.createFromAsset(getAssets(), "Fonts/clear.ttf");
            fontBox.setTypeface(Clearview);
            fontBox.setText("The Quick Brown Fox Jumps Over The Lazy Dog - This is the Clearview font, also for Highway Signs");

        }

    }

    private void initChangeButton(){
        Button changeButton = findViewById(R.id.buttonChange);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FontSettings.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}