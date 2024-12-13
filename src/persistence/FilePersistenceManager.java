package persistence;

import model.*;

import java.io.*;

import parser.ParserException;
import parser.XmlJsonParser;

public class FilePersistenceManager {

  // Klasse skal måske renames til noget som "XMLPersistenceManager"
  private XmlJsonParser parser;

  public FilePersistenceManager() {
    this.parser = new XmlJsonParser();


  }

  public void saveAnimalsForSaleList(AnimalsForSaleList animalsForSaleList, String filePath) throws IOException, ParserException {
    parser.toXml(animalsForSaleList,"AnimalsForSaleList.xml" );

  }

  public void saveCustomerList(CustomerList customerList, String filePath) throws IOException {
    try (FileOutputStream fileOutputStream = new FileOutputStream("Customerlist.bin");
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
       objectOutputStream.writeObject(customerList);
      System.out.println("Customer list saved in binary format to " + filePath);
    }
  }

  // Ikke nødvendigvis noget vi skal bruge
  public AnimalsForSaleList loadAnimalsForSaleList(String filePath) throws IOException, ParserException {
    return parser.fromXml(filePath, AnimalsForSaleList.class);
  }

  public static void loadCustomerList(String filePath) {
    try (FileInputStream fileInputStream = new FileInputStream("Customerlist.bin");
         ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {


      CustomerList customerList = (CustomerList) objectInputStream.readObject();


      System.out.println("Loaded customer list:");
      System.out.println(customerList);

    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Failed to load customer list: " + e.getMessage());
      e.printStackTrace();
    }
  }

}