package com.academy.assigment;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CarsDAO {
    
    private final String FILE = "src\\main\\java\\file\\cars.xml";
    
    private String exp = "";
    
    private Document document;
    
    private DocumentBuilderFactory dbf;
    
    private DocumentBuilder builder;
    
    private XPath xPath;
    
    private NodeList nodeList;
    
    private Node node;
    
    public CarsDAO() {}
    
    public void getCarsByManufacturer(String model) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        
        dbf = DocumentBuilderFactory.newInstance();
        
        builder = dbf.newDocumentBuilder();
        
        document = builder.parse(FILE);
        
        xPath = XPathFactory.newInstance().newXPath();
        
        exp = "//car[manufacturer[contains(., '" + model +"')]]";
        
        nodeList = (NodeList) xPath.compile(exp).evaluate(document, XPathConstants.NODESET);
        
        for(int i = 0; i < nodeList.getLength(); i++) {
            
            node = nodeList.item(i);
            
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                
                System.out.println("Manufacturer: " + e.getElementsByTagName("manufacturer").item(0).getTextContent());
                System.out.println("Model: " + e.getElementsByTagName("model").item(0).getTextContent());
                System.out.println("Production Year: " + e.getElementsByTagName("production-year").item(0).getTextContent());
                System.out.println("HP: " + e.getElementsByTagName("horsepower").item(0).getTextContent());
                System.out.println("Consumption: " + e.getElementsByTagName("consumption").item(0).getTextContent());
                System.out.println("Price: " + e.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("-------------------------------------------");
            }
        }
    }
    
    public void getCarsByAge(int fromYear, int toYear) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        dbf = DocumentBuilderFactory.newInstance();
        
        builder = dbf.newDocumentBuilder();
        
        document = builder.parse(FILE);
        
        xPath = XPathFactory.newInstance().newXPath();
        
        exp = "//car[production-year >= " + fromYear + " and production-year <= " + toYear + "]";
        
        nodeList = (NodeList) xPath.compile(exp).evaluate(document, XPathConstants.NODESET);
        
        for(int i = 0; i < nodeList.getLength(); i++) {
            
            node = nodeList.item(i);
            
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                
                System.out.println("Manufacturer: " + e.getElementsByTagName("manufacturer").item(0).getTextContent());
                System.out.println("Model: " + e.getElementsByTagName("model").item(0).getTextContent());
                System.out.println("Production Year: " + e.getElementsByTagName("production-year").item(0).getTextContent());
                System.out.println("HP: " + e.getElementsByTagName("horsepower").item(0).getTextContent());
                System.out.println("Consumption: " + e.getElementsByTagName("consumption").item(0).getTextContent());
                System.out.println("Price: " + e.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("-------------------------------------------");
            }
        }
    }
    
    public void getElectricCars() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
         dbf = DocumentBuilderFactory.newInstance();
        
        builder = dbf.newDocumentBuilder();
        
        document = builder.parse(FILE);
        
        xPath = XPathFactory.newInstance().newXPath();
        
        exp = "//car[consumption/@type='electric']";
        
        nodeList = (NodeList) xPath.compile(exp).evaluate(document, XPathConstants.NODESET);
        
        for(int i = 0; i < nodeList.getLength(); i++) {
            
            node = nodeList.item(i);
            
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                
                System.out.println("Manufacturer: " + e.getElementsByTagName("manufacturer").item(0).getTextContent());
                System.out.println("Model: " + e.getElementsByTagName("model").item(0).getTextContent());
                System.out.println("Production Year: " + e.getElementsByTagName("production-year").item(0).getTextContent());
                System.out.println("HP: " + e.getElementsByTagName("horsepower").item(0).getTextContent());
                System.out.println("Consumption: " + e.getElementsByTagName("consumption").item(0).getTextContent());
                System.out.println("Price: " + e.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("-------------------------------------------");
            }
        }
    }
    
    public void getCarsByFuelType(String type, double d) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        dbf = DocumentBuilderFactory.newInstance();
        
        builder = dbf.newDocumentBuilder();
        
        document = builder.parse(FILE);
        
        xPath = XPathFactory.newInstance().newXPath();
        
        exp = "//car[consumption/@type='" + type + "' and consumption < '" + d +"']";
        
        nodeList = (NodeList) xPath.compile(exp).evaluate(document, XPathConstants.NODESET);
        
        for(int i = 0; i < nodeList.getLength(); i++) {
            
            node = nodeList.item(i);
            
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                
                System.out.println("Manufacturer: " + e.getElementsByTagName("manufacturer").item(0).getTextContent());
                System.out.println("Model: " + e.getElementsByTagName("model").item(0).getTextContent());
                System.out.println("Production Year: " + e.getElementsByTagName("production-year").item(0).getTextContent());
                System.out.println("HP: " + e.getElementsByTagName("horsepower").item(0).getTextContent());
                System.out.println("Consumption: " + e.getElementsByTagName("consumption").item(0).getTextContent());
                System.out.println("Price: " + e.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("-------------------------------------------");
            }
        }
    }
    
    
}
