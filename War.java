
public class War {

	int player1win = 0, player2win = 0;
	int roundCount = 0;

	public War() {
		Playerhand player1 = new Playerhand();
		Playerhand player2 = new Playerhand();
		Playerhand table = new Playerhand();
		CardDeck cd = new CardDeck();
		cd.shuffle();
		boolean ifWin = false;
		// creates the deck
		for (int i = 0; i < 52; i++) {
			if (i < 26)
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
			//Checks for 20 rounds
			if (roundCount == 20) {
				if (player1win > player2win) {
					System.out.println("Player A wins!");
					break;
				} else if (player1win < player2win) {
					System.out.println("Player B wins!");
					break;
				} else {
					System.out.println("It's a tie!");
					break;
				}
			}else {
				playWar(player1, player2, table);
			}
			
		}
		System.out.println("Congratulations!");
	}

	public void playWar(Playerhand player1, Playerhand player2, Playerhand table) {

		Card player1Card = null, player2Card = null;

		if (checkWin(player1) == false) {
			player1Card = player1.playCard().getCard();
			System.out.println(player1Card.printCard());
		} else {
			System.out.println("Player B wins! Player A has no cards");
		}
		if (checkWin(player2) == false) {
			player2Card = player2.playCard().getCard();
			System.out.println(player2Card.printCard());
		} else {
			System.out.println("Player A wins! Player B has no cards");
		}

		if (player1Card.compareCard(player2Card) == 3) {
			System.out.println("Winner of hand: Player A");
			while (table.isEmpty() == false) {
				player1.addCardtoHand(table.playCard().getCard());
			}
			player1.addCardtoHand(player1Card);
			player1.addCardtoHand(player2Card);
			player1win++;
			roundCount++;
		} else if (player1Card.compareCard(player2Card) == 2) {
			System.out.println("Winner of hand: Player B");
			while (table.isEmpty() == false) {
				player2.addCardtoHand(table.playCard().getCard());
			}
			player2.addCardtoHand(player1Card);
			player2.addCardtoHand(player2Card);
			player2win++;
			roundCount++;
		} else {
			System.out.println("War!");
			roundCount++;
			if (checkWin(player1) == false) {
				// pulls 2 cards from player1 and adds it to table's deck
				table.addCardtoHand(player1.playCard().getCard());
				table.addCardtoHand(player1.playCard().getCard());
			} else {
				System.out.println("Player B wins! Player A has no cards");
			}
			if (checkWin(player1) == false) {
				// pulls 2 cards from player2 and add it to table's deck
				table.addCardtoHand(player2.playCard().getCard());
				table.addCardtoHand(player2.playCard().getCard());
			} else {
				System.out.println("Player A wins! Player B has no cards");
			}
			// adds the original cards to table's deck
			table.addCardtoHand(player1Card);
			table.addCardtoHand(player2Card);
			playWar(player1, player2, table);
		}
	}

	public boolean checkWin(Playerhand player) {
		if (player.isEmpty() == false) {
			return false;
		} else
			return true;
	}

	public void checkRound(int player1, int player2, int round) {
		
	}

}
