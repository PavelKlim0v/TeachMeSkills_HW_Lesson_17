package com.teachmeskills.lesson_17.task_2.writexml;

import com.teachmeskills.lesson_17.task_2.model.Sonnet;
import java.io.*;
import java.util.List;

public class WriteXML {

    public static void addLinesSonnetInDoc(List<Sonnet> list) {
        String fileName = list.get(0).getAuthorLastName() +"_"+ list.get(0).getAuthorFirstName() +"_"+ list.get(0).getTitle();

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName +".txt")))) {

            for (Sonnet sonnet : list) {
                for (String str : sonnet.getLine()) {
                    writer.write(str);
                    writer.write(System.lineSeparator());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Обработка документа завершена!");
    }

}
