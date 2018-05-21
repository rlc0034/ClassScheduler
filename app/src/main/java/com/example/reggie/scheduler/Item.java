package com.example.reggie.scheduler;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String ClassName, teacherName, Day1, Day2, Day3, startTime, location;

    public Item(){
        super();
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public void setTeacherName(String teacherName){
        this.teacherName = teacherName;
    }

    public void setDay1(String Day1) {
        this.Day1 = Day1;
    }

    public void setDay2(String Day2) {
        this.Day2 = Day2;
    }

    public void setDay3(String Day3) {
        this.Day3 = Day3;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClassName() {
        return ClassName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getDay1() {
        return Day1;
    }

    public String getDay2() {
        return Day2;
    }

    public String getDay3() {
        return Day3;
    }

    public String getLocation() {
        return location;
    }

    public String getStartTime() {
        return startTime;
    }

}
