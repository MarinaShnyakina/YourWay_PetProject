package com.example.yourway_petproject.Adapters;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yourway_petproject.Menu.Courses.CoursePage;
import com.example.yourway_petproject.Models.Course;
import com.example.yourway_petproject.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(courseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.courseBack.setCardBackgroundColor(Color.parseColor(courses.get(position).getColor()));

        int imageId = context.getResources().getIdentifier(courses.get(position).getImg(), "drawable", context.getPackageName());
        holder.courseImage.setImageResource(imageId);

        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseDate.setText(courses.get(position).getDate());
        holder.courseFormat.setText(courses.get(position).getFormat());
        holder.coursePrice.setText(courses.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CoursePage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context, new Pair<View, String>(holder.courseImage, "courseImage"));

                intent.putExtra("courseBack", Color.parseColor(courses.get(position).getColor()));
                intent.putExtra("courseImage", imageId);
                intent.putExtra("courseTitle", courses.get(position).getTitle());
                intent.putExtra("dateCoursePage", courses.get(position).getDate());
                intent.putExtra("formatCoursePage", courses.get(position).getFormat());
                intent.putExtra("priceCoursePage", courses.get(position).getPrice());
                intent.putExtra("textCoursePage", courses.get(position).getTextPage());
                intent.putExtra("courseId", courses.get(position).getId());

                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder {

        CardView courseBack;
        ImageView courseImage;
        TextView courseTitle, courseDate, coursePrice, courseFormat;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBack = itemView.findViewById(R.id.courseBack);
            courseImage = itemView.findViewById(R.id.courseImage);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            coursePrice = itemView.findViewById(R.id.coursePrice);
            courseDate = itemView.findViewById(R.id.courseDate);
            courseFormat = itemView.findViewById(R.id.courseFormat);
        }
    }


}
