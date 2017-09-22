import java.util.Scanner;

/**
 * @author mwsamuelson
 * Creates a card object and stores it in a deck object
 *
 */
public class p2 {

	public static void main(String[] args) {
		// Creates deck then prompts user
		CardDeck cd = new CardDeck();

		cd.printDeck();
		
		System.out.println();
		System.out.println();
		System.out.println("Would you like to (1)shuffle or (2)sort the deck?");
		

		boolean exit = false;
		while (exit == false) {
			Scanner userIn = new Scanner(System.in);
			int usrCommand = userIn.nextInt();

			switch (usrCommand) {
			case 1:
				cd.shuffle();
				cd.printDeck();
				System.out.println();
				System.out.println("Would you like to (1)shuffle or (2)sort the deck?");
				break;
			case 2:
				cd.cardSort();
				cd.printDeck();
				System.out.println();
				System.out.println("Would you like to (1)shuffle or (2)sort the deck?");
				break;
			default:
				exit = true;
				userIn.close();
				break;
			}
		}
	}
}
