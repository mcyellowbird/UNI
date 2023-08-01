/**
 *
 * @author ln982
 */
public class TestProduct {
 public static void main(String[] args) {
 System.out.println("There are " + Product.getNumberInStock() + "items");

 Product pr1 = new Product("Computer", 1500.0);
 System.out.println("There are " + Product.getNumberInStock() + "items");
 Product pr2 = new Product("Printer", 600.0);
 Product pr3 = new Product("Monitor", 240.0);
 System.out.println("There are " + Product.getNumberInStock() + "items");
 pr2.changePrice( 550.0 );
 System.out.println(" -- Product info -- ");
 System.out.println( "Name: " + pr2.getName() );
 System.out.println("Scan code: " + pr2.getScanCode() );
 System.out.println("Price: " + pr2.getPrice() );
 }
}
