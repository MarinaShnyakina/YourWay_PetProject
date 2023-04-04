package com.example.yourway_petproject.AboutService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yourway_petproject.R;

public class AboutService extends AppCompatActivity {

    TextView btnTextPersonalArea;
    ImageView btnIconPersonalArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_service);

        btnTextPersonalArea = findViewById(R.id.textPersonalArea);
        btnIconPersonalArea = findViewById(R.id.iconPersonalArea);

        btnTextPersonalArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPersonalArea();
            }
        });
        }

    public void showPersonalArea() {
        startActivity(new Intent(AboutService.this, PersonalArea.class));
        finish();
    }
}