package com.teachmeskills.lesson_17.task_2.parser_sax;

import com.teachmeskills.lesson_17.task_2.model.Sonnet;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SonnetHandler extends DefaultHandler {

    private List<Sonnet> sonnetList = new ArrayList<>();
    private String currentTagName;

    private String firstName;
    private String lastName;
    private String title;
    private List<String> line = new ArrayList<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало обработки документа.");
    }

    @Override
    public void startElement(String uri,String localName,String qName,Attributes attributes) {
        currentTagName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ((lastName != null && !lastName.isEmpty()) && (firstName != null && !firstName.isEmpty())
                && (title != null && !title.isEmpty()) && "lines".equals(qName)) {

            sonnetList.add(new Sonnet(firstName,lastName,title,line));
            lastName = null;
            firstName = null;
            title = null;
            line = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch,start,length);
        str = str.replace("\n", "");

        if (currentTagName.equals("firstName")) {
            firstName = str;

        } else if (currentTagName.equals("lastName")) {
            lastName = str;

        } else if (currentTagName.equals("title")) {
            title = str;

        } else if (currentTagName.equals("line")) {
            line.add(str);
        }

        currentTagName = null;
    }

    @Override
    public void endDocument() {
        System.out.println("Обработка документа завершена!");
    }

    public List<Sonnet> getSonnet() {
        return sonnetList;
    }

}
