package com.example.reggie.scheduler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class ViewClassActivity extends AppCompatActivity {

    String ClassName, teacherName, Day1, Day2, Day3, startTime, viewClasses, location, lineSeparator;
    Intent startAddClass;
    private TextView viewClass;

    private static final String TAG = "MainActivity";


    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/aaScheduler";

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_class);
        startAddClass = getIntent();
        Bundle extras = startAddClass.getExtras();
        viewClass = (TextView) findViewById(R.id.textView);
        ArrayList<Item> arraylist = AddClassActivity.getList();
        ArrayList<String> className = AddClassActivity.getClassNames();

        if (arraylist.size() == 0) {
            viewClasses = "Please Create a class List";
        } else {
            for (i = 0; i < arraylist.size(); i++) {
                viewClasses = "Class Name: " + arraylist.get(i).getClassName() + "\n\n" +
                        "Teacher's Name: " + arraylist.get(i).getTeacherName() + "\n\n" +
                        "Location: " + arraylist.get(i).getLocation() + "\n\n" +
                        "Meeting Days: " + arraylist.get(i).getDay1() + ", " + arraylist.get(i).getDay2() + ", " + arraylist.get(i).getDay3() + "\n\n" +
                        "Start Time: " + arraylist.get(i).getStartTime() + "\n\n" +
                        "---------------------------------------------------------------------------------------------------" + "\n\n\n\n" + viewClasses;
            }
        }
        viewClasses = viewClasses.substring(0,viewClasses.length()-4);
        viewClass.setText(viewClasses);
    }


    public void exportClick(View view) throws IOException{
       /* String textToSaveString = viewClass.getText().toString();
        writeToFile(textToSaveString);*/
        /*File file = new File (path + "classSchedule.txt");
        String [] saveText = String.valueOf(viewClass.getText()).split(System.getProperty("line.separator"));

        Save (file, saveText);*/
        Intent startViewClass = new Intent(this, MainActivity.class);
        startActivity(startViewClass);
    }


    private void writeToFile(String data) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(FILENAME, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e(TAG, "File write failed: " + e.toString());
        }

    }
   /* public static void Save(File file, String[] data)
    {
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        try
        {
            try
            {
                for (int i = 0; i<data.length; i++)
                {
                    fos.write(data[i].getBytes());
                    if (i < data.length-1)
                    {
                        fos.write("\n".getBytes());
                    }
                }
            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }*/

}
