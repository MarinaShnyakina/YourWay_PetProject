package com.example.yourway_petproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.yourway_petproject.AboutService.AboutService;

public class MenuActivity extends AppCompatActivity {

    ImageView btnBooks, btnSpecial, btnCourses, btnArticles, btnGlider, btnService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnBooks = findViewById(R.id.imageBooks);
        btnSpecial = findViewById(R.id.imageSpecial);
        btnCourses = findViewById(R.id.imageCourses);
        btnArticles = findViewById(R.id.imageArticles);
        btnGlider = findViewById(R.id.imageGlider);
        btnService = findViewById(R.id.imageService);

        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutService();
            }
        });
    }

    public void showAboutService() {
            startActivity(new Intent(MenuActivity.this, AboutService.class));
            finish();

    }
}