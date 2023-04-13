package com.example.yourway_petproject.Courses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yourway_petproject.R;

public class CoursePage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_page);

        ConstraintLayout courseBack = findViewById(R.id.backCoursePage);
        ImageView courseImage = findViewById(R.id.imageCoursePage);
        TextView courseTitle = findViewById(R.id.titleCoursePage);
        TextView dateCoursePage = findViewById(R.id.dateCoursePage);
        TextView formatCoursePage = findViewById(R.id.formatCoursePage);
        TextView priceCoursePage = findViewById(R.id.priceCoursePage);
        TextView textCoursePage = findViewById(R.id.textCoursePage);

        courseBack.setBackgroundColor(getIntent().getIntExtra("courseBack", 0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage", 0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        dateCoursePage.setText(getIntent().getStringExtra("dateCoursePage"));
        formatCoursePage.setText(getIntent().getStringExtra("formatCoursePage"));
        priceCoursePage.setText(getIntent().getStringExtra("priceCoursePage"));
        textCoursePage.setText(getIntent().getStringExtra("textCoursePage"));


    }
}