import java.util.Scanner;

public class p3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Do you want to play War? (Y or N)");
		Scanner input = new Scanner(System.in);
		char usrCommand = input.next().charAt(0);
		if (usrCommand == 'Y' || usrCommand == 'y') {
			War War1 = new War();
		} else if (usrCommand == 'N' || usrCommand == 'n') {
			System.out.println("Goodbye!");
		} else {
			System.out.println("Please choose (Y/y) or (N/n)");
		}
		input.close();

	}

}
