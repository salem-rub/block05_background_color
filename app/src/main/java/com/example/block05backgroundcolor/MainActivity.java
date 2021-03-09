package com.example.block05backgroundcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("my_color", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.mylayout);

        if (sharedPreferences.contains("colorId"))
            relativeLayout.setBackgroundColor(sharedPreferences.getInt("colorId",0));

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int color_code = 0;
                switch (checkedId) {
                    case R.id.radioButton_blue:
                        color_code = Color.BLUE;
                        break;
                    case R.id.radioButton_yellow:
                        color_code = Color.YELLOW;
                        break;
                    case R.id.radioButton_red:
                        color_code = Color.RED;
                        break;
                }
                relativeLayout.setBackgroundColor(color_code);
                editor.putInt("colorId", color_code);
                editor.commit();
            }

        });
    }
}