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
        int font = sp.getInt("font", 0);

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
                    editor.putInt("font", 0);
                    editor.apply();
                }else if(rb2.isChecked()){
                    SharedPreferences sp = getSharedPreferences("fontPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("font", 1);
                    editor.apply();
                }else if(rb3.isChecked()){
                    SharedPreferences sp = getSharedPreferences("fontPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("font", 2);
                    editor.apply();
                }else{
                    SharedPreferences sp = getSharedPreferences("fontPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("font", 3);
                    editor.apply();
                }
            }
        });
    }









}




