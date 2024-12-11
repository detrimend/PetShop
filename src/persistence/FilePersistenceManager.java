package persistence;

import model.*;
import java.io.IOException;
import parser.ParserException;
import parser.XmlJsonParser;

public class FilePersistenceManager {

  private XmlJsonParser parser;

  public FilePersistenceManager() {
    this.parser = new XmlJsonParser();
  }

  public void saveReservationList(ReservationList reservationList, String filePath) throws IOException,
      ParserException
  {
    parser.toXml(reservationList, filePath);
  }

  public ReservationList loadReservationList(String filePath) throws IOException, ParserException {
    return parser.fromXml(filePath, ReservationList.class);
  }

  public void saveCustomerList(CustomerList customerList, String filePath) throws IOException, ParserException {
    parser.toXml(customerList, filePath);
  }

  public CustomerList loadCustomerList(String filePath) throws IOException, ParserException {
    return parser.fromXml(filePath, CustomerList.class);
  }

  public void savePurchaseList(PurchaseList purchaseList, String filePath) throws IOException, ParserException {
    parser.toXml(purchaseList, filePath);
  }

  public PurchaseList loadPurchaseList(String filePath) throws IOException, ParserException {
    return parser.fromXml(filePath, PurchaseList.class);
  }

  public void saveAnimalsForSaleList(AnimalsForSaleList animalsForSaleList, String filePath) throws IOException, ParserException {
    parser.toXml(animalsForSaleList, filePath);
  }

  public AnimalsForSaleList loadAnimalsForSaleList(String filePath) throws IOException, ParserException {
    return parser.fromXml(filePath, AnimalsForSaleList.class);
  }

  public void saveOwnedAnimalsList(OwnedAnimalsList ownedAnimalsList, String filePath) throws IOException, ParserException {
    parser.toXml(ownedAnimalsList, filePath);
  }

  public OwnedAnimalsList loadOwnedAnimalsList(String filePath) throws IOException, ParserException {
    return parser.fromXml(filePath, OwnedAnimalsList.class);
  }
}