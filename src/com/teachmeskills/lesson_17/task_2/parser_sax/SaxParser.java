package com.teachmeskills.lesson_17.task_2.parser_sax;

import com.teachmeskills.lesson_17.task_2.model.Sonnet;
import com.teachmeskills.lesson_17.task_2.iparser.IParser;
import com.teachmeskills.lesson_17.task_2.writexml.WriteXML;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser implements IParser {

    private List<Sonnet> sonnetList = new ArrayList<>();

    @Override
    public void process(String file) {
        try{
            File inputFile = new File(file);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SonnetHandler sonnetHandler = new SonnetHandler();

            saxParser.parse(inputFile, sonnetHandler);

            sonnetList = sonnetHandler.getSonnet();
            WriteXML.addLinesSonnetInDoc(sonnetList);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.err.println(e.getMessage());
        }
    }

}

