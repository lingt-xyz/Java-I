package A1;
import java.util.Scanner;

/**
 * A java calculator for a pizza shop.
 * 
 * @author Ling
 * @date May 16, 2016
 */
public class Q2 {

	public static final double PRICE_OF_CHEESE = 1.99;
	public static final double PRICE_OF_ALL_DRESSED = 2.99;
	public static final double PRICE_OF_VEGE = 2.49;
	public static final double TAX_OF_PIZZA = 0.435;

	public static void main(String[] args) {
		int numberOfCheese, numberOfAllDressed, numberOfVege, money;
		double totalOfCheese, totalOfAllDressed, totalOfVega, subTotal, tax, total, change;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many Cheese slices do you want?");
		numberOfCheese = keyboard.nextInt();
		System.out.println("How many All Dressed slices do you want?");
		numberOfAllDressed = keyboard.nextInt();
		System.out.println("How many Vege slices do you want?");
		numberOfVege = keyboard.nextInt();
		
		totalOfCheese = PRICE_OF_CHEESE * numberOfCheese;
		totalOfAllDressed = PRICE_OF_ALL_DRESSED * numberOfAllDressed;
		totalOfVega = PRICE_OF_VEGE * numberOfVege;
		subTotal = totalOfCheese + totalOfAllDressed + totalOfVega;
		tax = subTotal * TAX_OF_PIZZA;
		total = subTotal + tax;
		
		System.out.println();
		System.out.println();
		System.out.println("** Receipt **");
		System.out.println();
		System.out.println("Type of Slice\t\tQuantity\tPrice\t\tTotal");
		System.out.printf("Cheese\t\t\t" + numberOfCheese + "\t\t" + PRICE_OF_CHEESE + "\t\t%.2f\n", totalOfCheese);
		System.out.printf("All Dressed\t\t" + numberOfAllDressed + "\t\t" + PRICE_OF_ALL_DRESSED + "\t\t%.2f\n", totalOfAllDressed);
		System.out.printf("Vege\t\t\t" + numberOfVege + "\t\t" + PRICE_OF_VEGE + "\t\t%.2f\n", totalOfVega);
		System.out.println();
		System.out.printf("SubTotal\t\t\t\t\t\t%.2f\n", subTotal);
		System.out.printf("QPMA Tax\t\t\t\t\t\t%.2f\n", tax);
		System.out.printf("Total\t\t\t\t\t\t\t%.2f\n\n", total);
		System.out.println("Money given to you by customer?");
		
		money = keyboard.nextInt();
		change = money - total;
		
		System.out.println();
		System.out.println();
		System.out.println("** Change **");
		System.out.printf("Total: %.2f\n", total);
		System.out.println("Money from customer: " + money);
		System.out.printf("Change: %.2f\n", change);
		
		int left = (int)(change * 100);
		System.out.println(left / 100 + " x 1.00");
		left %= 100;
		System.out.println(left / 25 + " x .25");
		left %= 25;
		System.out.println(left / 10 + " x .10");
		left %= 10;
		System.out.println(left / 5 + " x .5");
		left %= 5;
		System.out.println(left + " x .1");
		
		keyboard.close();
	}
}
