import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceCalculation {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String repeat;
		int option;
		double sum = 0;

		List<Product> basket = new ArrayList<Product>();

		do {
			System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
			System.out.println("Press 1 to add an item to the basket");
			System.out.println("Press 2 to display the list of items in the basket and their prices");
			System.out.println("Press 3 to display the total price including tax");
			option = input.nextInt();

			Product product = new Product();
			if (option == 1) {
				System.out.println(
						"ooooooooooooooooooooooooMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMoooooooooooooooooooooooooooooooo");
				System.out.println("What is the name of the product ?");
				String newProductDesc = input.nextLine();
				product.setProductDesc(newProductDesc);
				input.nextLine();
				System.out.println("What is the product's price ?");
				double newPrice = input.nextDouble();
				product.setPrice(newPrice);

				basket.add(product);

			} else if (option == 2) {
				System.out.println(
						"-------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^------------------------------");
				for (int i = 0; i < basket.size(); i++) {
					System.out.println(" product " + (i + 1) + " ----> " + basket.get(i).getPrice() +"$");
				}				
				
			} else if (option == 3) {
				System.out.println(
						"--------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^------------------------------");
				System.out.println("What is the tax rate to be applied to your basket ? ");
				double taxRate = input.nextDouble();
				for (int i = 0; i < basket.size(); i++) {
					sum = sum + basket.get(i).getPrice();
				}
				double rate = sum * (taxRate / 100);

				System.out.println("The total price is " + "_______"+(sum + rate)+"_______");
				System.out.println("_________________________________________________________________________________________");
			}

			System.out.println("Would you like to continue to add, check your list or output your total price, Press 'yes'?");
			repeat = input.next();
		} while (repeat.equalsIgnoreCase("yes"));

	}

}
