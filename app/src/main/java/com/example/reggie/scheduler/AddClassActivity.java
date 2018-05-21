package com.example.reggie.scheduler;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddClassActivity extends AppCompatActivity {

    public EditText className;
    public EditText teacher;
    public EditText time;
    public EditText place;
    public EditText day1;
    public EditText day2;
    public EditText day3;

    public static ArrayList<Item> itemList = new ArrayList<Item>(); //= new ArrayList<Item>()
    public static ArrayList<String> classNames = new ArrayList<String>();

    String ClassName, teacherName, Day1, Day2, Day3, startTime, location;
    Intent editClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        className = (EditText) findViewById(R.id.class_Name);
        teacher = (EditText) findViewById(R.id.teacher_Name);
        time = (EditText) findViewById(R.id.meet_Time);
        place = (EditText) findViewById(R.id.location_Name);
        day1 = (EditText) findViewById(R.id.day_1);
        day2 = (EditText) findViewById(R.id.day_2);
        day3 = (EditText) findViewById(R.id.day_3);

        editClass = getIntent();
        Bundle extras = editClass.getExtras();

        if (extras == null) {
            ClassName = "Enter Class Name";
            teacherName = "Enter Teacher Name";
            location = "Enter the meeting place";
            Day1 = "Enter Day1";
            Day2 = "Enter Day2";
            Day3 = " ";
            startTime = "Enter a startTime";
        }
        else {
            className.setText(extras.getString("ClassName"));
            teacher.setText(extras.getString("teacherName"));
            place.setText(extras.getString("location"));
            day1.setText(extras.getString("Day1"));
            day2.setText(extras.getString("Day2"));
            day3.setText(extras.getString("Day3"));
            time.setText(extras.getString("startTime"));
        }
    }

    public static ArrayList<Item> getList() {
        return itemList;
    }

    public static ArrayList<String> getClassNames() {
        return classNames;
    }


    public void saveButtonOnClick(View v){
        ClassName = className.getText().toString();
        teacherName = teacher.getText().toString();
        location = place.getText().toString();
        Day1 = day1.getText().toString();
        Day2 = day2.getText().toString();
        Day3 = day3.getText().toString();
        startTime = time.getText().toString();

        Item newObject = new Item();
        newObject.setClassName(ClassName);
        newObject.setTeacherName(teacherName);
        newObject.setDay1(Day1);
        newObject.setDay2(Day2);
        newObject.setDay3(Day3);
        newObject.setLocation(location);
        newObject.setStartTime(startTime);

        AddClassActivity.itemList.add(newObject);
        AddClassActivity.classNames.add(newObject.getClassName());

        //Toast.makeText(getBaseContext(), "Class Saved to List!" , Toast.LENGTH_SHORT ).show();

        Intent startMainActivity = new Intent(this, MainActivity.class);
        startActivity(startMainActivity);
    }

    public void viewListOnClick(View v){

        Intent startMainActivity = new Intent(this, MainActivity.class);
        startActivity(startMainActivity);
    }
}
