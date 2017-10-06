import java.util.Scanner;

public class FuckTheDealer {
	int[] drinkCount;
	int dealer = 0;
	int player = 1;
	int dealerWinCount = 0;
	int guessCount = 0;

	public FuckTheDealer() {

		CardDeck cd = new CardDeck();
		cd.shuffle();
		Playerhand dealerDeck = new Playerhand();
		for (int i = 0; i < 52; i++) {
			dealerDeck.addCardtoHand(cd.deck[i]);
		}

		System.out.println("How many players?");
		Scanner input = new Scanner(System.in);
		int playerCount = input.nextInt();
		System.out.println("You have choosen " + playerCount + " players!");
		drinkCount = new int[playerCount];
		playFuckTheDealer(playerCount, dealerDeck);

	}

	public void playFuckTheDealer(int playerCount, Playerhand dealerDeck) {
		boolean passPlayer = false;

		for (int i = 0; i < drinkCount.length; i++) {
			Card topCard = dealerDeck.playCard().getCard();
			passPlayer = false;
			while (passPlayer == false) {
				System.out.println(
						"The Dealer is Player " + (dealer + 1) + ". It is Player " + (player + 1) + "'s turn.");
				System.out.println("Take a guess!");

				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				int guess = input.nextInt();

				passPlayer = playerTurn(topCard, guess);
			}
		}

	}

	public boolean playerTurn(Card topCard, int guess) {
		System.out.println("Looking at top card...");

		if (topCard.getValue() == guess) {
			System.out.print("Nice guess the card was " + topCard.printCard() + ". ");
			drinkCount[dealer] = drinkCount[dealer] + (topCard.getValue() * 2);
			drinkCheck();
			dealerWinCount = 0;
			guessCount = 0;
			player++;
			resetPlayer();
		} else if (topCard.getValue() > guess) {
			System.out.println("Higher");
			if (guessCount == 1) {
				System.out.println("Dealer wins!");
				System.out.print("The card was " + topCard.printCard() + ". ");
				dealerWinCount++;
				drinkCount[player] = drinkCount[player] + topCard.getValue();
				drinkCheck();
				player++;
				resetPlayer();
				guessCount = 0;
			} else {
				guessCount++;
			}
		} else {
			if (guessCount == 1) {
				System.out.println("Dealer wins!");
				System.out.print("The card was " + topCard.printCard() + ". ");
				dealerWinCount++;
				drinkCount[player] = drinkCount[player] + topCard.getValue();
				drinkCheck();
				player++;
				resetPlayer();
				guessCount = 0;
			} else {
				System.out.println("Lower");
				guessCount++;
			}
		}
		if (guessCount == 2) {
			System.out.println("Dealer wins!");
			dealerWinCount++;
			player++;
			resetPlayer();
			System.out.println("Player" + player + " turn!");
			return true;
		}

		if (dealerWinCount == 3) {
			dealer++;
			resetDealer();
			System.out.println("The Dealer won twice in a row!");
			System.out.println("The dealer is now Player " + (dealer + 1));
			return true;
		} else {
			return false;
		}
	}
	
	public void resetPlayer() {
		if (player == (drinkCount.length+1)) {
			player = 0;
		}
	}
	public void resetDealer() {
		if (dealer == (drinkCount.length+1)) {
			dealer = 0;
		}
	}

	public void drinkCheck() {
		for (int i = 0; i < drinkCount.length; i++) {
			if (drinkCount[i] >= 20) {
				System.out.println("Player " + (i + 1) + " take a shot!");
				drinkCount[i] = drinkCount[i] - 20;
			}
		}
	}

}
