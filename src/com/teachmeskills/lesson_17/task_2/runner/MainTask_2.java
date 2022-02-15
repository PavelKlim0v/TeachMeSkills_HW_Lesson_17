package com.teachmeskills.lesson_17.task_2.runner;

import com.teachmeskills.lesson_17.task_2.properties.Property;
import com.teachmeskills.lesson_17.task_2.parser_dom.DomParser;
import com.teachmeskills.lesson_17.task_2.parser_sax.SaxParser;

/**
 *  Задание 2. (Дополнительное задание)
 *    Написать прграмму для парсинга xml документа.
 *
 *    Задание со *
 *    Дополнительно реализовать следующий функционал:
 *    -если в файле properties введено значение 1 - распарсить документ с помощью SAX
 *    -если в файле properties введено значение 2 - распарсить документ с помощью DOM
 *
 *    Программа на вход получает строку к папке, где находится документ.
 *    Распарсить нужно только один документ - соотвественно, предуспотреть различные проверки, например на то,
 *     что в папке нет файлов, или в папке несколько документов формата xml и другие возможные проверки.
 *
 *    Необходимо распарсить xml документ и содержимое тегов line записать в другой документ.
 *    Название файла для записи должно состоять из значений тегов и имеет вид: <firstName>_<lastName>_<title>.txt
 */

public class MainTask_2 {

    public static void main(String[] args) {
        Property property = new Property();
        property.getProperties();

        String pathXML = property.getPathXML();

        if (property.getValue() == 1) {
            SaxParser parser = new SaxParser();
            parser.process(pathXML);

        } else
            if (property.getValue() == 2) {
            DomParser parser = new DomParser();
            parser.process(pathXML);
        }
    }

}
