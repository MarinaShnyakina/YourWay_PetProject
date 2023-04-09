package com.example.yourway_petproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.yourway_petproject.Menu.AboutService;
import com.example.yourway_petproject.Menu.Articles;
import com.example.yourway_petproject.Menu.Books;
import com.example.yourway_petproject.Menu.Courses;
import com.example.yourway_petproject.Menu.Glider;
import com.example.yourway_petproject.Menu.Special;

public class MenuActivity extends AppCompatActivity {

    ImageView imageBooks, imageSpecial, imageCourses, imageArticles, imageGlider, imageService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imageBooks = findViewById(R.id.imageBooks);
        imageSpecial = findViewById(R.id.imageSpecial);
        imageCourses = findViewById(R.id.imageCourses);
        imageArticles = findViewById(R.id.imageArticles);
        imageGlider = findViewById(R.id.imageGlider);
        imageService = findViewById(R.id.imageService);

        imageBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBooks();
            }
        });

        imageSpecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSpecial();
            }
        });

        imageCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCourses();
            }
        });

        imageArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showArticles();
            }
        });

        imageGlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGlider();
            }
        });

        imageService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutService();
            }
        });
    }


    public void showBooks() {
        startActivity(new Intent(MenuActivity.this, Books.class));
    }

    public void showSpecial() {
        startActivity(new Intent(MenuActivity.this, Special.class));
    }

    public void showCourses() {
        startActivity(new Intent(MenuActivity.this, Courses.class));
    }

    public void showArticles() { startActivity(new Intent(MenuActivity.this, Articles.class));
    }

    public void showGlider() {
        startActivity(new Intent(MenuActivity.this, Glider.class));
    }

    public void showAboutService() { startActivity(new Intent(MenuActivity.this, AboutService.class));

    }
}