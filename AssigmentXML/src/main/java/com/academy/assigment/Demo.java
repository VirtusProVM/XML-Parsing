package com.academy.assigment;

import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

public class Demo {
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        CarsDAO dao = new CarsDAO();
        Scanner in = new Scanner(System.in);
        
        System.out.println("Java XML Assigment");
        System.out.println("------------------------------");
        System.out.println("1) Filtriraj automobile po proizvodjacu");
        System.out.println("2) Filter automobile po godini proizvodnje");
        System.out.println("3) Filter auta po tipu goriva");
        System.out.println("0) IZLAZ");
        
        System.out.println("------------------------------\n");
        
        System.out.println("Izaberite opciju iz menija da bi nastavili dalje sa pretragom: ");
        int option = in.nextInt();
        
        switch (option) {
            case 1 -> {
                System.out.println("Unesite naziv automobila: ");
                String model = in.next();
                
                System.out.println("Rezultati pretrazivanja za " + model + "\n");
                dao.getCarsByManufacturer(model);
            }
            
            case 2 -> {
                System.out.println("Unesite datum proizvodnje automobila: \n");
                
                System.out.println("Od: ");
                int fromYear = in.nextInt();
                
                System.out.println("Do: ");
                int toYear = in.nextInt();
                
                System.out.println("Rezultati pretrazivanja od " + fromYear + " godine do " + toYear + "\n");
                dao.getCarsByAge(fromYear, toYear);
            }
            
            case 3 -> {
                System.out.println("Unesite tip goriva: ");
                String fuelType = in.next();
                
            switch (fuelType) {
                case "electric" -> {
                    System.out.println("Rezultati pretrazivanja za " + fuelType + "\n");
                    dao.getElectricCars();
                    
                }
                    
                case "fuel" -> {
                        System.out.println("Unesite opseg potrosnje: ");
                        double d = in.nextDouble();
                        
                        System.out.println("Rezultati pretrazivanja za " + fuelType + "\n");
                        dao.getCarsByFuelType(fuelType, d);
                    }
                
                case "hybrid" -> {
                        System.out.println("Unesite opseg potrosnje: ");
                        double d = in.nextDouble();
                        
                        System.out.println("Rezultati pretrazivanja za " + fuelType + "\n");
                        dao.getCarsByFuelType(fuelType, d);
                    }
                
                default -> {
                        System.out.println("Nepoznati tip goriva " + fuelType);
                        System.exit(0);
                    }
                }
            }
            
            case 0 -> System.exit(0);
            
            default -> System.out.println("Somthing went wrong");
        }
        
        
        
    }
    
    
}
