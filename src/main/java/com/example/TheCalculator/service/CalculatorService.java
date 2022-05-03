package com.example.TheCalculator.service;

import com.example.TheCalculator.Algoritm;
import com.example.TheCalculator.entity.CalculatorEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class CalculatorService {


    private String input;

    public Double getCalculatorSolution(String input) {
        CalculatorEntity calculator = new CalculatorEntity(input);
        calculator.setSolution(Algoritm.generateSolution(input));
        return calculator.getSolution();
    }

    public Double getCalculatorSolutionWithoutStep(String input) {
        CalculatorEntity calculator = new CalculatorEntity(input);
        calculator.setSolution(Algoritm.generateSolutionWithoutSteps(input));
        return calculator.getSolution();
    }

    public double writeInXml(File file){
        try {
            ObjectMapper mapper = new XmlMapper();
            InputStream inputStream = new FileInputStream(file);
            TypeReference<List<CalculatorEntity>> typeReference = new TypeReference<>() {};

            List<CalculatorEntity> calculators= mapper.readValue(inputStream, typeReference);
            for(CalculatorEntity c :calculators) {
                System.out.println("The input is "+c.getInput());
                this.input=c.getInput();
            }
            return(Algoritm.generateSolutionWithoutSteps(input));

//            CalculatorEntity calculator = new CalculatorEntity();
//            mapper.writeValue(new File(String.valueOf(file)), calculator);
//            inputStream.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}

/*
ry {
            File fXmlFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("staff");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Staff id : "
                            + eElement.getAttribute("id"));
                    System.out.println("First Name : "
                            + eElement.getElementsByTagName("firstname")
                            .item(0).getTextContent());
                    System.out.println("Last Name : "
                            + eElement.getElementsByTagName("lastname")
                            .item(0).getTextContent());
                    System.out.println("Nick Name : "
                            + eElement.getElementsByTagName("nickname")
                            .item(0).getTextContent());
                    System.out.println("Salary : "
                            + eElement.getElementsByTagName("salary")
                            .item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 */

