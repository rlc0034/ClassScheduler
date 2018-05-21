package com.example.reggie.scheduler;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Message;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.Button;
//import android.widget.ScrollView;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List list = new ArrayList();
    ArrayAdapter adapter;
    ListView listView;

    int i;

    ArrayList<Item> arraylist = AddClassActivity.getList();

    String ClassName, teacherName, Day1, Day2, Day3, startTime, location;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

       if (arraylist.size() == 0) {
           adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list);
           listView.setAdapter(adapter);
           list.add("Please Create a Class");
       }
        else {
           adapter = new ArrayAdapter<Item>(MainActivity.this, android.R.layout.simple_list_item_1, list);
           listView.setAdapter(adapter);
           for (i = 0; i < arraylist.size(); i++) {
               list.add(arraylist.get(i).getClassName());
           }
       }
           listView.setOnItemClickListener(new ItemList());
    }

    class ItemList implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            ClassName = arraylist.get(position).getClassName();
            teacherName = arraylist.get(position).getTeacherName();
            Day1 = arraylist.get(position).getDay1();
            Day2 = arraylist.get(position).getDay2();
            Day3 = arraylist.get(position).getDay3();
            startTime = arraylist.get(position).getStartTime();
            location = arraylist.get(position).getLocation();
            Intent startNewClass = new Intent(MainActivity.this, AddClassActivity.class);
            startNewClass.putExtra("ClassName", ClassName);
            startNewClass.putExtra("teacherName", teacherName);
            startNewClass.putExtra("Day1", Day1);
            startNewClass.putExtra("Day2", Day2);
            startNewClass.putExtra("Day3", Day3);
            startNewClass.putExtra("startTime", startTime);
            startNewClass.putExtra("location", location);
            adapter.remove(adapter.getItem(position));
            arraylist.remove(arraylist.get(position));
            startActivity(startNewClass);
        }
    }


    public void buttonOnClick(View view){
        Intent startNewClass = new Intent(this, AddClassActivity.class);
        startActivity(startNewClass);
    }

    public void detailsOnClick(View view){
        Intent ViewClass = new Intent(this, ViewClassActivity.class);
        startActivity(ViewClass);
    }

}
