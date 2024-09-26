/* Import the FileWriter class to write some text to the file */
import java.io.FileWriter;
/* Importing java IOException to use when performing input and
 * output operations in Java - like reading and writing to files
 */
import java.io.IOException;
/* Importing java NIO package for utility API, Files - used for manipulating
 * files and directories using its static methods
 */
import java.nio.file.Files;
/* Importing the Paths class, the main entry point to all operations involving
 * file system paths - to use it to create and manipulate paths to files and
 * directories
 */
import java.nio.file.Paths;
/* Importing java ArrayList a class of java.util package – to use it to
 * dynamically modify and store a collection of objects
 */
import java.util.ArrayList;
/*Importing java Utility list to provide interfaces and classes for
 * transferring data between and within applications
 */
import java.util.List;
/*Importing java Scanner to use it to receive user inputs and parse them into
 *  data types such as int, double
 */
import java.util.Scanner;
/* Using an access modifier, a public class - to make it accessible by any
 * other class
 */
public class FoodQuickProgram {
  /* Making use of Java's main() method, the starting point from where
   * the Java virtual machine (JVM) starts the execution of the program
   */
  public static void main(String[] args) {
    /* Making use of the Scanner class - to allow for user input
     * to be read and processed within the program.
     */
    Scanner scanner = new Scanner(System.in);
    /* Using the try keyword to create a try...catch statement – where the try
     * statement enables the definition of a block of code to be tested for
     * errors while it is being executed
     */
    try {
      // Prompting user for customer details
      System.out.print("Enter Customer Name: ");
      String customerName = scanner.nextLine();
      System.out.print("Enter Customer Contact Number: ");
      String contactNumber = scanner.nextLine();
      System.out.print("Enter Customer Address: ");
      String address = scanner.nextLine();
      System.out.print("Enter Customer Location: ");
      String location = scanner.nextLine();
      System.out.print("Enter Customer Email: ");
      String email = scanner.nextLine();

      Customer customer =
          new Customer(customerName, contactNumber, address, location, email);

      // Prompting user for restaurant details
      System.out.print("Enter Restaurant Name: ");
      String restaurantName = scanner.nextLine();
      System.out.print("Enter Restaurant Contact Number: ");
      String restaurantContact = scanner.nextLine();
      System.out.print("Enter Restaurant Location: ");
      String restaurantLocation = scanner.nextLine();

      // Prompting for meals
      System.out.print("How many meals are being ordered? ");
      int numMeals = scanner.nextInt();
      /* Making use of the nextLine() method get the input string that was
       * skipped of the Scanner object.
       */
      scanner.nextLine();

      List<String> mealNames = new ArrayList<>();
      List<Double> mealPrices = new ArrayList<>();
      List<Integer> mealQuantities = new ArrayList<>();

      for (int i = 0; i < numMeals; i++) {
        System.out.print("Enter meal name: ");
        mealNames.add(scanner.nextLine());

        /* Making use of the try method for exception handling for price and
         * quantity input
         */
        try {
          System.out.print("Enter meal price: ");
          mealPrices.add(scanner.nextDouble());
          System.out.print("Enter meal quantity: ");
          mealQuantities.add(scanner.nextInt());
          /* Using the catch statement to define a block of code to be executed
           * , if an error occurs in the try block.
           */
        } catch (NumberFormatException e) {
          System.out.println("Invalid input for price or quantity. Please "
              + "enter numeric values.");
          // Clearing buffer
          scanner.nextLine();
          // Repeating the current meal entry
          i--;
          continue;
        }
        // Consuming newline
        scanner.nextLine();
      }

      System.out.print("Any special preparation instructions? ");
      String specialInstructions = scanner.nextLine();

      Restaurant restaurant =
          new Restaurant(restaurantName, restaurantContact, restaurantLocation,
              mealNames, mealPrices, mealQuantities, specialInstructions);

      // Reading drivers.txt file and finding the driver with the smallest load
      // in the same area
      Driver availableDriver = findavailableDriver(customer, restaurant);
      
      if (availableDriver != null) {
        // Generating invoice and writing it to invoice.txt
        String invoiceDetails =
            Invoice.generateInvoice(customer, availableDriver, restaurant);
        writeInvoiceToFile("invoice.txt", invoiceDetails);
        System.out.println(
            "Invoice has been generated and saved to invoice.txt");
      } else {
        System.out.println(
            "Sorry! Our drivers are too far away from you to deliver.");
      }
    } catch (Exception e) {
      System.out.println("An unexpected error occurred: " + e.getMessage());
    } finally {
      scanner.close();
    }
  }


  // Making utility methods private to maintain encapsulation
  private static Driver findavailableDriver(    
    Customer customer, Restaurant restaurant) {
    List<Driver> drivers = new ArrayList<>();
    try {
      List<String> lines = Files.readAllLines(Paths.get("drivers.txt"));
      for (String line : lines) {
        String[] parts = line.split(", ");
        if (parts.length == 3) {
          String name = parts[0];
          String location = parts[1];
          int load = Integer.parseInt(parts[2]);
          drivers.add(new Driver(name, location, load));
        }
      }
    } catch (IOException e) {
      System.out.println("Error reading drivers file: " + e.getMessage());
      return null;
    }

    /* 
       Making use of the getMethod() method - using get to get the specified method of  
       the class with the specified parameter type
    */ 
    Driver availableDriver = null;
    for (Driver driver : drivers) {
      if (driver.getLocation().equalsIgnoreCase(restaurant.getLocation())) {
        if (availableDriver == null
            || driver.getLoad() < availableDriver.getLoad()) {
          availableDriver = driver;
        }
      }
    }

    return availableDriver;
  }

  // Writing invoice to a file with exception handling
  private static void writeInvoiceToFile(
    String fileName, String invoiceDetails) {
      try {
        FileWriter writer = new FileWriter(fileName);
          writer.write(invoiceDetails);
          writer.close();
      } 
      catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
  }
}
