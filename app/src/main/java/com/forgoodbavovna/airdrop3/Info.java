package com.forgoodbavovna.airdrop3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.forgoodbavovna.airdrop3.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Info extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Button refer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        Window w = getWindow();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.seagreen));

        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.info);
        refer = (Button) findViewById(R.id.refer);
        refer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent refer = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1gl9s5j7B3k4ycyauTn5L_cNGQR9BlIq1?usp=sharing"));
                startActivity(refer);
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){
                    case R.id.info:
                        return true;
                    case R.id.calculate:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.contacts:
                        startActivity(new Intent(getApplicationContext(),Contacts.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}