package com.teachmeskills.lesson_17.task_2.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {

    private String pathXML;
    private int value;

    public Property() { }

    public Property(String XMLPath, int value) {
        this.pathXML = XMLPath;
        this.value = value;
    }

    public String getPathXML() {
        return pathXML;
    }

    public int getValue() {
        return value;
    }

    public void getProperties() {
        Properties appProps = new Properties();

        try(FileInputStream fis = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\TeachMeSkills_HW_Lesson_17\\src" +
                "\\com\\teachmeskills\\lesson_17\\task_2\\resources\\app.properties")) {
            appProps.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.pathXML = appProps.getProperty("urlXML");
        this.value = Integer.parseInt(appProps.getProperty("value"));
    }

}
