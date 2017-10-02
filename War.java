import java.util.Scanner;

public class War {

	public War() {
		Playerhand player1 = new Playerhand();
		Playerhand player2 = new Playerhand();
		Playerhand table = new Playerhand();
		CardDeck cd = new CardDeck();
		cd.shuffle();
		boolean ifWin = false;

		

		for (int i = 0; i < 52; i++) {
			if (i < 4)
				player1.addCardtoHand(cd.deck[i]);
			else
				player2.addCardtoHand(cd.deck[i]);
		}

		while (ifWin == false) {
			if (player1.isEmpty() == true || player2.isEmpty() == true) {
				System.out.println("You win!");
				ifWin = true;
				break;
			}
			playWar(player1,player2,table);
		}
		System.out.println("Congratulations!");
	}

	public void playWar(Playerhand player1, Playerhand player2, Playerhand table) {

		Card player1Card, player2Card;
		
		player1Card = player1.playCard().getCard();
		System.out.println(player1Card.printCard());

		player2Card = player2.playCard().getCard();
		System.out.println(player2Card.printCard());

		if (player1Card.compareCard(player2Card) == 3) {
			System.out.println("Winner of hand: Player A");
			while(table.isEmpty() == false) {
				player1.addCardtoHand(table.playCard().getCard());
			}
			player1.addCardtoHand(player1Card);
			player1.addCardtoHand(player2Card);
		} else if (player1Card.compareCard(player2Card) == 2) {
			System.out.println("Winner of hand: Player B");
			while(table.isEmpty() == false) {
				player2.addCardtoHand(table.playCard().getCard());
			}
			player2.addCardtoHand(player1Card);
			player2.addCardtoHand(player2Card);
		} else {
			System.out.println("War!");
			table.addCardtoHand(player1Card);
			table.addCardtoHand(player2Card);
			playWar(player1,player2,table);
		}
	}

}
