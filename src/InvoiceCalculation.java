///////////////////////////////////////////////////////////////////////////////
// Author:           (Jaouad Sarouti )                                       //				     /
// Date :     		  (07/28/2017)					     //
// 									     //								 //	
///////////////////////////////////////////////////////////////////////////////


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceCalculation {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String repeat;
		int option;
		double sum = 0;
		String priceString = " ";
		List<Product> basket = new ArrayList<Product>();// the arrayList
		Product product; // contains the object
		// Product.

		do {// a do while which allow the user to run the program as long as his
			// input is repeat. it run at least once.
			System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
			System.out.println("Press 1 to add an item to the basket");
			System.out.println("Press 2 to display the list of items in the basket and their prices");
			System.out.println("Press 3 to display the total price including tax pl");
			option = input.nextInt();

			product = new Product();// call the construction..

			if (option == 1) { // option 1
				System.out.println(
						"ooooooooooooooooooooooooMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMoooooooooooooooooooooooooooooooo");
				System.out.println("What is the name of the product ?");
				String newProductDesc = input.nextLine();
				product.setProductDesc(newProductDesc); // set the productDesc
														// using the the set
														// method called
														// setProductDesc
				input.nextLine();
				System.out.println("What is the product's price ?");
				double newPrice = input.nextDouble();
				priceString = product.currentPrices(newPrice);
				System.out.println("The new price with its currency format is " + priceString);
				product.setPrice(newPrice);// set the price using the set method
											// in the Product class
				basket.add(product);

			} else if (option == 2) {// option two
				System.out.println(
						"-------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^------------------------------");
				for (int i = 0; i < basket.size(); i++) {
					System.out.println("|------------------------------|------------------------------------|");
					System.out.println("| product " + (i + 1) + " ---->| " + "$" + basket.get(i).getPrice());
					System.out.println("|------------------------------|-------------------------------------|");
				}

			} else if (option == 3) { // option 3
				System.out.println(
						"--------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^------------------------------");
				System.out.println("What is the tax rate to be applied to your basket ? ");
				double taxRate = input.nextDouble();
				double taxFormat = Double.parseDouble(String.format("%.2f", taxRate));
				System.out.println("The new tax Rate to be applied using two decimal places is " + taxFormat);
				for (int i = 0; i < basket.size(); i++) {
					sum = sum + basket.get(i).getPrice();
				}
				double rate = sum * (taxFormat / 100); // calculation of taxRate

				double finalAmount = sum + rate;
				System.out.println("The total price is " + "_______" + (finalAmount) + "_______");// applying
																									// the
																									// taxRate
																									//to the total amount
				
				System.out.println("The total price at two decimal places is "
						+ Double.parseDouble(String.format("%.2f", finalAmount)));
				System.out.println(
						"_________________________________________________________________________________________");
				for (int i = 0; i < basket.size(); i++) {
					System.out.println("|-------------------------|");
					System.out.println("| product " + (i + 1) + " ---->" + "$" + basket.get(i).getPrice());
					System.out.println("|-------------------------|");
				}
				System.out.println("|Final amount" + "---> " + Double.parseDouble(String.format("%.2f", finalAmount)));
				System.out.println("|-------------------------|");

			}

			System.out.println(
					"Would you like to continue to add, check your list or output your total price, Press 'yes'?");
			repeat = input.next(); // prompt the user to continue in order to
									// see or choose the other options
		} while (repeat.equalsIgnoreCase("yes"));

	}

}
