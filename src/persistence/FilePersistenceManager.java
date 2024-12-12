package persistence;

import model.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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



}