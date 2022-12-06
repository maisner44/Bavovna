package com.forgoodbavovna.airdrop3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.forgoodbavovna.airdrop3.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Spinner spinner;
    Spinner spinner2;
    Spinner spinner3;
    EditText edit1;
    EditText edit2;
    Button calc;
    EditText editText;
    Info refer;
    TextView lango;
    TextView choose_container;
    TextView input_height;
    TextView input_speed;
    TextView result;
    private Calculate calculator;
    TextView x;
    TextView t;
    String sec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        Window w = getWindow();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.seagreen));
        lango = findViewById(R.id.lango);
        calc = findViewById(R.id.calc);
        input_height = findViewById(R.id.input_height);
        input_speed = findViewById(R.id.input_speed);
        result = findViewById(R.id.result);
        choose_container = findViewById(R.id.choose_container);

//languages
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,R.array.languages,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] array = getResources().getStringArray(R.array.languages);
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                switch (position){
                    case 0:
                        lango.setText("Мова");
                        choose_container.setText("Оберіть контейнер");
                        input_height.setText("Висота у м.");
                        input_speed.setText("Швидкість вітру у м/с");
                        calc.setText("Порахувати");
                        result.setText("результат");
                        sec = "c.";
                        break;
                    case 1:
                        lango.setText("Language");
                        choose_container.setText("Choose container");
                        input_height.setText("Height in m.");
                        input_speed.setText("Speed of vind in m/sec.");
                        calc.setText("Calculate");
                        result.setText("result");
                        sec = "sec.";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//themes
//        spinner2 = (Spinner) findViewById(R.id.spinner2);
//        ArrayAdapter<?> adapter2 = ArrayAdapter.createFromResource(this,R.array.themes,android.R.layout.simple_spinner_item);
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//
//        spinner2.setAdapter(adapter2);
//        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String[] array = getResources().getStringArray(R.array.themes);
//                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
//                ((TextView) parent.getChildAt(0)).setTextSize(18);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//containers
        final double[] mas = {0};
        final double[] S = {0};
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<?> adapter3 = ArrayAdapter.createFromResource(this,R.array.containers,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] array = getResources().getStringArray(R.array.containers);
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);

                switch (position){
                    case 0:
                        S[0] = 0.15*0.03;
                        mas[0] = 0.29;
                    break;
                    case 1:
                        S[0] = 0.1*0.04;
                        mas[0] = 0.265;
                    break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.calculate);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.info:
                        startActivity(new Intent(getApplicationContext(),Info.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.calculate:
                        return true;
                    case R.id.contacts:
                        startActivity(new Intent(getApplicationContext(),Contacts.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
//calculate
        calculator = new Calculate();
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        t = findViewById(R.id.t);
        x = findViewById(R.id.x);

        calc.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int height = 0;
                double vindspeed = 0;
                String firstedit = calculator.check_on_dot(edit1.getText().toString());
                String secondedit = calculator.check_on_dot(edit2.getText().toString());
                edit1.setTextColor(Color.argb(255, 255, 255, 255));
                edit2.setTextColor(Color.argb(255, 255, 255, 255));
                if(!edit1.getText().toString().equals("") && !edit2.getText().toString().equals("")){
                    if(!calculator.check_on_letters(firstedit) || !calculator.double_dot(firstedit)){
                        edit1.setTextColor(Color.argb(255, 255, 14, 2));

                    }
                    if(!calculator.check_on_letters(secondedit) || !calculator.double_dot(secondedit)){
                        edit2.setTextColor(Color.argb(255, 255, 14, 2));
                    }
                    if(calculator.check_on_letters(secondedit) && calculator.double_dot(secondedit) && calculator.check_on_letters(firstedit) && calculator.double_dot(firstedit)){
                        height = Integer.parseInt(firstedit);
                        vindspeed = Double.parseDouble(secondedit);
                        double drift = calculator.calculate_drift(vindspeed,height, mas[0], S[0]);
                        double time = calculator.calculate_time(vindspeed,height,mas[0], S[0]);
                        String drift_str = String.format("%.2f", drift);
                        String time_str = String.format("%.2f", time);
                        x.setText("Зміщення: " + drift_str + "м.");
                        t.setText("Час падіння: "+ time_str + sec);
                    }
                }





            }
        });




    }
}