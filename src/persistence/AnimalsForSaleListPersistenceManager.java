package persistence;

import model.AnimalsForSaleList;
import parser.ParserException;
import parser.XmlJsonParser;

import java.io.IOException;

/**
 * Persistence manager for AnimalsForSaleList.
 * It handles saving and loading the list of animals for sale to and from XML files.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class AnimalsForSaleListPersistenceManager {

  private XmlJsonParser parser;

  /**
   * Constructs an AnimalsForSaleListPersistenceManager.
   * Initializes the XML/JSON parser.
   */
  public AnimalsForSaleListPersistenceManager() {
    this.parser = new XmlJsonParser();
  }

  /**
   * Saves the AnimalsForSaleList to an XML file.
   *
   * @param animalsForSaleList the list of animals for sale to be saved
   * @param filePath the file path where the list will be saved
   * @throws IOException if an I/O error occurs
   * @throws ParserException if a parsing error occurs
   */
  public void saveAnimalsForSaleList(AnimalsForSaleList animalsForSaleList, String filePath) throws IOException, ParserException {
    parser.toXml(animalsForSaleList, filePath);
    System.out.println("AnimalsForSaleList saved as XML to " + filePath);
  }

  /**
   * Loads the AnimalsForSaleList from an XML file.
   *
   * @param filePath the file path from where the list will be loaded
   * @return the loaded AnimalsForSaleList
   * @throws IOException if an I/O error occurs
   * @throws ParserException if a parsing error occurs
   */
  public AnimalsForSaleList loadAnimalsForSaleList(String filePath) throws IOException, ParserException {
    return parser.fromXml(filePath, AnimalsForSaleList.class);
  }
}