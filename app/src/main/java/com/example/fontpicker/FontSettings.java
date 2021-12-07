package com.example.fontpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FontSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_settings);
        initSettings();
        initRadioGroupfont();
    }

    private void initSettings(){
        SharedPreferences sp = getSharedPreferences("fontPref", Context.MODE_PRIVATE);
        String fontName = sp.getString("font", "serif");

    }

    private void initRadioGroupfont(){
        RadioGroup rg = findViewById(R.id.fontGroup);
        RadioButton rb1 = findViewById(R.id.radioButton1);
        RadioButton rb2 = findViewById(R.id.radioButton2);
        RadioButton rb3 = findViewById(R.id.radioButton3);
        RadioButton rb4 = findViewById(R.id.radioButton4);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rb1.isChecked()){
                    SharedPreferences sp = getSharedPreferences("fontPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("font", 0xffd12a2a);
                    editor.apply();
                }else if(rb2.isChecked()){
                    SharedPreferences sp = getSharedPreferences("fontPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("font", 0xff00ff00);
                    editor.apply();
                }else if(rb3.isChecked()){
                    SharedPreferences sp = getSharedPreferences("fontPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("font", 0xff2a4ed1);
                    editor.apply();
                }else{
                    SharedPreferences sp = getSharedPreferences("fontPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("font", 0xff0be3e3);
                    editor.apply();
                }
            }
        });
    }









}




