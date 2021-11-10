package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ColorSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_settings);
        initSettings();
        initRadioGroupColor();
    }

    private void initSettings(){
        SharedPreferences sp = getSharedPreferences("colorPref", Context.MODE_PRIVATE);
        int color = sp.getInt("color", -1);

    }

    private void initRadioGroupColor(){
        RadioGroup rg = findViewById(R.id.colorGroup);
        RadioButton rb1 = findViewById(R.id.radioButton1);
        RadioButton rb2 = findViewById(R.id.radioButton2);
        RadioButton rb3 = findViewById(R.id.radioButton3);
        RadioButton rb4 = findViewById(R.id.radioButton4);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rb1.isChecked()){
                    SharedPreferences sp = getSharedPreferences("colorPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("color", 0xffd12a2a);
                    editor.apply();
                }else if(rb2.isChecked()){
                    SharedPreferences sp = getSharedPreferences("colorPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("color", 0xff00ff00);
                    editor.apply();
                }else if(rb3.isChecked()){
                    SharedPreferences sp = getSharedPreferences("colorPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("color", 0xff2a4ed1);
                    editor.apply();
                }else{
                    SharedPreferences sp = getSharedPreferences("colorPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("color", 0xff0be3e3);
                    editor.apply();
                }
            }
        });
    }









}




