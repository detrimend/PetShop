package persistence;

import model.*;

import java.io.File;
import java.io.IOException;
import parser.ParserException;
import parser.XmlJsonParser;

public class FilePersistenceManager {

  // Klasse skal måske renames til noget som "XMLPersistenceManager"
  private XmlJsonParser parser;
  private File file;

  public FilePersistenceManager() {
    this.parser = new XmlJsonParser();

  }

  public void saveAnimalsForSaleList(AnimalsForSaleList animalsForSaleList, String filePath) throws IOException, ParserException {
    parser.toXml(animalsForSaleList, filePath);
  }

  // Ikke nødvendigvis noget vi skal bruge
  public AnimalsForSaleList loadAnimalsForSaleList(String filePath) throws IOException, ParserException {
    return parser.fromXml(filePath, AnimalsForSaleList.class);
  }



}