package persistence;

import model.PetShopModelManager;

import java.io.*;

public class PetShopPersistenceManager {

  private static final String FILE_PATH = "PetShopModelManager.bin";

  // Save the state of PetShopModelManager to a binary file
  public void saveState(PetShopModelManager manager) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
      out.writeObject(manager);
      System.out.println("State saved successfully.");
    } catch (IOException e) {
      System.err.println("Failed to save state: " + e.getMessage());
      e.printStackTrace();
    }
  }

  // Load the state of PetShopModelManager from a binary file
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