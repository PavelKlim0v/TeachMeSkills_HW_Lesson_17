package com.teachmeskills.lesson_17.task_1.document;

import java.util.ArrayList;
import java.util.List;

public class MyDocument {

    private List<String> list = new ArrayList<>();

    public MyDocument() { }

    public MyDocument(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void addList(String str) {
        this.list.add(str);
    }

    @Override
    public String toString() {
        return "MyDocument {list=" + list + '}';
    }
}
