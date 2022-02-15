package com.teachmeskills.lesson_17.task_1.validator;

import com.teachmeskills.lesson_17.task_1.document.MyDocument;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLFileValidator {

    public static void validate(String path) {

        try{
            File folder = new File(path);

            if(folder.isDirectory()) {

                // проверяем, пустая ли папка
                if(folder.length() == 0) {
                    System.out.println("Эта папка пуста.");
                    return ;
                }

                // получаем только "xml" файл согласно условию
                List<File> doc = Arrays.stream(folder.listFiles( (dir, name) -> name.endsWith("xml") ))
                        .limit(1)
                        .collect(Collectors.toList());

                // проверка на то, что после фильтрации есть файлы, подходящие под наше условие
                if(doc.size() == 0){
                    System.out.println("Нет подходящих файлов формата xml.");
                    return ;
                }

                DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
                domFactory.setValidating(true);
                DocumentBuilder builder = domFactory.newDocumentBuilder();

                builder.setErrorHandler(new ErrorHandler() {
                    @Override
                    public void error(SAXParseException exception) throws SAXException {
                        System.err.println(exception.getMessage());
                    }

                    @Override
                    public void fatalError(SAXParseException exception) throws SAXException {
                        System.err.println(exception.getMessage());
                    }

                    @Override
                    public void warning(SAXParseException exception) throws SAXException {
                        System.err.println(exception.getMessage());
                    }
                });

                for(File file: doc){
                    Document doc1 = builder.parse(file);
                    readFile(file,path);
                    System.out.println("Document is valid.");
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e){
            System.out.println(e.getMessage());
        }
    }


    private static MyDocument readFile(File file,String path) throws IOException {

        Pattern pattern1 = Pattern.compile("<line>(.+?)</line>", Pattern.CASE_INSENSITIVE);
        String pathWithDoc = path +"\\William_Shakespeare_Sonnet 130.txt";

        MyDocument myDocument = new MyDocument();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathWithDoc)))) {
            String oneLine;

            // читаем документ посстрочно и анализируем
            while((oneLine = reader.readLine()) != null) {
                Matcher matcher1 = pattern1.matcher(oneLine);

                while(matcher1.find()) {
                    int n = oneLine.indexOf("</line>");
                    String betweenTags = oneLine.substring(10, n); // с "десятого элем." до "седьмого с конца" (отнять семь с конца)
                    myDocument.addList(betweenTags);               // получаем текст внутри тегов(т.е. не учитывая отступы и теги)
                }
            }

            for (String str : myDocument.getList()) { // перебираем весь список и записываем в ФАЙЛ (William_Shakespeare_Sonnet 130)
                writer.write(str);
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return myDocument;
    }

}
