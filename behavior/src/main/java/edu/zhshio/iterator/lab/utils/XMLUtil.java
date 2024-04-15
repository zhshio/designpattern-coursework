package edu.zhshio.iterator.lab.utils;



import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: zs
 * @time: 2024/3/7 11:15
 */

public class XMLUtil {

    public static Object getBean() {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("src/main/java/edu/zhshio/iterator/lab/resource/beanconfig.xml"));

            NodeList mealBuilderNames = document.getElementsByTagName("beanName");
            Node mealBuilderName = mealBuilderNames.item(0).getFirstChild();
            String mealBuilerNameVal = mealBuilderName.getNodeValue().trim();

            Class<?> aClass = Class.forName(mealBuilerNameVal);
            return aClass.newInstance();

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (org.xml.sax.SAXException e) {
            throw new RuntimeException(e);
        }
    }
}