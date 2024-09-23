// Importing utility classes
import java.util.List;

/* Declaring public class for Restaurant, to ensure accessibility – by signalling
 * to the Java Virtual Machine (JVM) and other parts of the program that public
 * class Restaurant is accessible from any other class to initiate the application */
public class Restaurant {

  /* Making methods & constructors only accessible within the declared class */
  private String name;
  private String contactNumber;
  private String location;
  private List<String> mealNames;
  private List<Double> mealPrices;
  private List<Integer> mealQuantities;
  private String specialInstructions;

  public Restaurant(
      String name,
      String contactNumber,
      String location,
      List<String> mealNames,
      List<Double> mealPrices,
      List<Integer> mealQuantities,
      String specialInstructions) {
    /* Using the 'this.keyword' in the constructor to refer to the current
    object's 'name' field */

    this.name = name;
    this.contactNumber = contactNumber;
    this.location = location;
    this.mealNames = mealNames;
    this.mealPrices = mealPrices;
    this.mealQuantities = mealQuantities;
    this.specialInstructions = specialInstructions;
  }

  /* Accessing private variables by providing public get method to return the
  variable value */
  public String getName() {
    return name;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public String getLocation() {
    return location;
  }

  public List<String> getMealNames() {
    return mealNames;
  }

  public List<Double> getMealPrices() {
    return mealPrices;
  }

  public List<Integer> getMealQuantities() {
    return mealQuantities;
  }

  public String getSpecialInstructions() {
    return specialInstructions;
  }
}