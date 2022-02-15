package com.teachmeskills.lesson_17.task_1.runner;

import com.teachmeskills.lesson_17.task_1.validator.XMLFileValidator;
import java.util.Scanner;

/**
 *  Задание 1. (Основное задание)
 *    Написать программу для парсинга xml документа.
 *
 *    Программа на вход получает строку к папке, где находится документ.
 *    Распарсить нужно только один документ - соответственно, предусмотреть различные проверки, например на то,
 *     что в папке нет файлов, или в папке несколько документов формата xml и другие возможные проверки.
 *
 *    Необходимо распарсить xml документ и содержимое тегов line записать в другой документ.
 *    Название файла для записи должно состоять из значений тегов и имеет вид: <firstName>_<lastName>_<title>.txt
 */

public class MainTask_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Укажите путь к папке: ");
        String path = scanner.next();          // src/com/teachmeskills/lesson_17/task_1/folder
        XMLFileValidator.validate(path);

        scanner.close();
    }

}
