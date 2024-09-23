/* Declaring public class for Customer, to ensure accessibility – by signalling
 * to the Java Virtual Machine (JVM) and other parts of the program that public
 * class Customer is accessible from any other class initiate the application */
public class Customer {
  /* Making methods & constructors only accessible within the declared class */
  private String name;
  private String contactNumber;
  private String address;
  private String location;
  private String email;

  public Customer(
      String name, String contactNumber, String address, String location, String email) {
    /*Using the 'this.keyword' in the constructor to refer to the current
    object's 'name' field */
    this.name = name;
    this.contactNumber = contactNumber;
    this.address = address;
    this.location = location;
    this.email = email;
  }

  /* Accessing private variables by providing public get method to return the
  variable value */
  public String getName() {
    return name;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public String getAddress() {
    return address;
  }

  public String getLocation() {
    return location;
  }

  public String getEmail() {
    return email;
  }
}