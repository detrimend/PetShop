package persistence;

import model.PetShopModelManager;

import java.io.*;

/**
 * Persistence manager for PetShopModelManager.
 * It handles saving and loading the pet shop data to and from a binary file.
 *
 * @author Martin Skovby Andersen
 * @author Rasmus Duus Kristensen
 * @author Victor Grud Oksen
 * @author Victor Sander Marx Hoelgaard
 * @version 1.0 - December 2024
 */
public class PetShopPersistenceManager {

  private static final String FILE_PATH = "PetShopModelManager.bin";

  /**
   * Saves the state of PetShopModelManager to a binary file.
   *
   * @param manager the PetShopModelManager to be saved
   */
  public void saveState(PetShopModelManager manager) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
      out.writeObject(manager);
      System.out.println("State saved successfully.");
    } catch (IOException e) {
      System.err.println("Failed to save state: " + e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * Loads the state of PetShopModelManager from a binary file.
   *
   * @return the loaded PetShopModelManager, or null if an error occurs
   */
  public PetShopModelManager loadState() {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
      return (PetShopModelManager) in.readObject();
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Failed to load state: " + e.getMessage());
      e.printStackTrace();
      return null;
    }
  }
}