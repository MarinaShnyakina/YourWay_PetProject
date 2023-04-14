package com.example.yourway_petproject.Menu.Courses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yourway_petproject.Adapters.CategoryAdapter;
import com.example.yourway_petproject.Adapters.CourseAdapter;
import com.example.yourway_petproject.Models.Category;
import com.example.yourway_petproject.Models.Course;
import com.example.yourway_petproject.R;

import java.util.ArrayList;
import java.util.List;

public class Courses extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    public static List<Course> fullCoursesList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Онлайн"));
        categoryList.add(new Category(2, "Коучинг"));
        categoryList.add(new Category(3, "Психология"));
        categoryList.add(new Category(4, "Прочее"));

        setCategoryRecycler(categoryList);

        courseList.add(new Course(1, 1, "coursegoalsetting", "Целеполагание", "24 апреля", "Онлайн", "1499 рублей", "#D7D9FD",
                "Каждый человек, который стремится к самосовершенствованию, духовному и физическому росту, не может обойтись без цели. Цель – это то, что движет личностью, " +
                        "побуждает на действие. Умение правильно определить и поставить задачу, это довольно непростое дело. " +
                        "Как наиболее эффективно справиться с этим вы и узнаете из авторского курса Екатерины Селиной." +
                        "Вы узнаете, что такое мечта и может ли она быть целью, какие существуют внутренние блоки и ограничения, мешающие постановке целей и как можно мотивировать себя на достижение. " +
                        "Эти механизмы не раз тестировались в научной среде и имеют положительные результаты. Вам останется лишь внедрить их в свою жизнь и начать прогрессировать. "));

        courseList.add(new Course(2, 3, "courseacceptanceofemotions", "Принятие эмоций", "1 мая", "Нижний Новгород", "2999 рублей", "#D1F6FD",
                "Тут будет красивое описание курса, чтобы люди могли понять о чем идет речь и захотели на него записаться"));

        courseList.add(new Course(3, 1, "courseselflove", "Любовь к себе", "11 мая", "Онлайн", "Бесплатно", "#FADEC6",
                "Главная задача курса Любви к себе — это не просто «стать счастливой и ускакать в закат на розовом пони». " +
                        "Прежде всего, вы научитесь защищать свое право быть у себя в приоритете.\n" +
                        "Большинство людей живут по чужим правилам не потому что не осознают своих желаний, а потому что боятся устанавливать свои правила.\n" +
                        "*Научиться решать свои задачи, отстаивать границы, развиваться, не бояться терять и ошибаться — задача «со звездочкой», и на курсе Любовь к себе вы сможете ее решить."));

        courseList.add(new Course(4, 1, "courseimpostorsyndrome", "Синдром самозванца", "1 июня", "Онлайн", "999 рублей", "#C4C7FC",
                "Есть заблуждение, которое подтачивает больше других. И звучит оно так: я недостаточно хорош. Я не на своем месте. Мне просто везет. Меня разоблачат." +
                        "Мы — самопровозглашенные самозванцы. И нас миллионы. Мы слышим голос, который твердит, что мы плохие руководители/ художники/ родители (подчеркните нужное)." +
                        "А хочется, чтобы каждый из нас, «самозванцев», наконец-то осознал: с нами все в порядке. Мы хорошо справляемся. То, что мы говорим, имеет вес. " +
                        "От нас есть польза. Мы достойны любви. Мы не подделка."));

        courseList.add(new Course(5, 2, "coursesresourses", "Я в ресурсе", "13 июня", "Москва", "4999 рублей", "#FBE8D6", "Тебе нужен этот вебинар, если: \n" +
                "\n" +
                "Ты чувствуешь усталость сразу, как только просыпаешься\n" +
                "Тебя всё раздражает\n" +
                "Безразличие ко всему, что раньше тебя зажигало\n" +
                "Опускаются руки от огромного кома дел, которые надо выполнить\n" +
                "Вебинар научит быстро возвращаться в ресурс:\n" +
                "\n" +
                "Разберём, куда сливается твоя энергия и как это остановить\n" +
                "Выясним, что придаёт сил и наполняет именно тебя\n" +
                "Освоим доступные приёмы, как быстро привести себя в ресурсное состояние"));

        fullCoursesList.addAll(courseList);

        setCourseRecycler(courseList);
    }

    public void openCart(View view) {
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);

    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }

    public static void showCoursesByCategory(int category) {

        courseList.clear();
        courseList.addAll(fullCoursesList);

        List<Course> filterCourses = new ArrayList<>();

        for (Course c : courseList) {
            if (c.getCategory() == category)
                filterCourses.add(c);
        }

        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();
    }
    
    
}