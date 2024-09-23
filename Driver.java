/* Declaring public class for Driver, to ensure accessibility – by signalling
 * to the Java Virtual Machine (JVM) and other parts of the program that public
 * class Driver is accessible from any other class to initiate the application
 */
public class Driver {
  private String name;
  private String location;
  private int load;

  /* Using the 'this.keyword' in the constructor to refer to the current
  object's 'name' field */
  public Driver(String name, String location, int load) {
    this.name = name;
    this.location = location;
    this.load = load;
  }

  /* Accessing private variables by providing public get method to return the
  variable value */
  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public int getLoad() {
    return load;
  }
}