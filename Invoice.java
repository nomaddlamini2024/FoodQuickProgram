public class Invoice {
  /**
   * Generating the invoice for the order.
   *
   * @param customer The customer who placed the order.
   * @param driver The driver delivering the order.
   * @param restaurant The restaurant preparing the order.
   * @return A string representing the formatted invoice.
   */
  // Making the string accessible without creating an object of a class
  public static String generateInvoice(Customer customer, Driver driver, Restaurant restaurant) {
    StringBuilder invoice = new StringBuilder();
    /*  Using the append() method of StringBuilder class to append some value
    to a current sequence.*/
    invoice.append("Order number 1234\n");
    invoice.append("Customer: ").append(customer.getName()).append("\n");
    invoice.append("Email: ").append(customer.getEmail()).append("\n");
    invoice.append("Phone number: ").append(customer.getContactNumber()).append("\n");
    invoice.append("Location: ").append(customer.getLocation()).append("\n\n");

    invoice
        .append("You have ordered the following from ")
        .append(restaurant.getName())
        .append(" in ")
        .append(restaurant.getLocation())
        .append(":\n\n");

    for (int i = 0; i < restaurant.getMealNames().size(); i++) {
      invoice
          .append(restaurant.getMealQuantities().get(i))
          .append(" x ")
          .append(restaurant.getMealNames().get(i))
          .append(" (R")
          .append(String.format("%.2f", restaurant.getMealPrices().get(i)))
          .append(")\n");
    }

    invoice
        .append("\nSpecial instructions: ")
        .append(restaurant.getSpecialInstructions())
        .append("\n");
    invoice
        .append("\nTotal: R")
        .append(String.format("%.2f", calculateTotal(restaurant)))
        .append("\n\n");

    invoice
        .append(driver.getName())
        .append(" is nearest to the restaurant and so he will be delivering " + "your\n");
    invoice.append("order to you at:\n\n");

    invoice.append(customer.getAddress()).append("\n\n");

    invoice
        .append("If you need to contact the restaurant, their number is ")
        .append(restaurant.getContactNumber())
        .append(".\n");

    return invoice.toString();
  }

  /**
   * Calculating the total cost of the order.
   *
   * @param restaurant The restaurant where the order is placed.
   * @return The total cost of the order.
   */
  private static double calculateTotal(Restaurant restaurant) {
    double total = 0;
    for (int i = 0; i < restaurant.getMealNames().size(); i++) {
      total += restaurant.getMealPrices().get(i) * restaurant.getMealQuantities().get(i);
    }
    return total;
  }
}
