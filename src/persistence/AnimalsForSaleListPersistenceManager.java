package persistence;

import model.AnimalsForSaleList;
import parser.ParserException;
import parser.XmlJsonParser;

import java.io.IOException;

public class AnimalsForSaleListPersistenceManager {

  private XmlJsonParser parser;

  public AnimalsForSaleListPersistenceManager() {
    this.parser = new XmlJsonParser();
  }

  public void saveAnimalsForSaleList(AnimalsForSaleList animalsForSaleList, String filePath) throws IOException, ParserException {
    parser.toXml(animalsForSaleList, filePath);
    System.out.println("AnimalsForSaleList saved as XML to " + filePath);
  }

  public AnimalsForSaleList loadAnimalsForSaleList(String filePath) throws IOException, ParserException {
    return parser.fromXml(filePath, AnimalsForSaleList.class);
  }
}
