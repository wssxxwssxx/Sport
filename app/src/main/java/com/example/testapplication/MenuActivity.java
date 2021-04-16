package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.testapplication.activity.BasketballActivity;
import com.example.testapplication.activity.FootbolActivity;
import com.example.testapplication.activity.HandballActivity;
import com.example.testapplication.activity.TenisActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onFootbol(View view) {
        Intent intent = new Intent(MenuActivity.this, FootbolActivity.class);
        startActivity(intent);
    }

    public void onTennis(View view) {
        Intent intent = new Intent(getApplicationContext(), TenisActivity.class);
        startActivity(intent);
    }

    public void onBasketball(View view) {
        Intent intent = new Intent(MenuActivity.this, BasketballActivity.class);
        startActivity(intent);
    }

    public void onHandball(View view) {
        Intent intent = new Intent(MenuActivity.this, HandballActivity.class);
        startActivity(intent);
    }
}