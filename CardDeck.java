/**
 * @author mwsam
 * Creates 52 cards and stores them in a deck
 *
 */
public class CardDeck {
	private Card[] deck;
	private int cardsUsed;

	public CardDeck() {
		deck = new Card[52];
		int cardCount = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 2; value <= 14; value++) {
				deck[cardCount] = new Card(value, suit, cardCount);
				cardCount++;
			}
		}
		cardsUsed = 0;
	}

	public void shuffle() {
		//shuffles the deck by putting a card in a random spot in the deck
		for (int i = 51; i > 0; i--) {
			int random = (int) (Math.random() * (i + 1));
			Card temp = deck[i];
			deck[i] = deck[random];
			deck[random] = temp;
		}
	}

	public void cardSort() {
		//sorts the deck by card value the sorts by suit
		for (int i = 0; i < deck.length; i++) {
			for (int j = i + 1; j < deck.length; j++) {
				Card temp = deck[i];
				if (deck[i].value > deck[j].value) {
					temp = deck[i];
					deck[i] = deck[j];
					deck[j] = temp;
				}
			}
		}
		// loops through 4 cards at a time and sorts them by suit
		int suitCount = 4;
		while (suitCount != 56) {
			for (int i = (suitCount - 4); i < suitCount; i++) {
				for (int j = (suitCount - 4); j < suitCount; j++) {
					Card temp = deck[i];
					if (deck[i].suit < deck[j].suit) {
						temp = deck[i];
						deck[i] = deck[j];
						deck[j] = temp;
					}
				}
			}
			suitCount = suitCount + 4;// Next card value
		}
	}

	public Card dealCards() {
		// will be helpful for the war game.
		cardsUsed++;
		return deck[cardsUsed - 1];
	}
	
	public void countValuesUsed() {
		
	}
	

	public void printDeck() {
		// prints 4 cards at a time
		int rowCount = 0;
		for (int i = 0; i < deck.length; i++) {
			if (rowCount < 3) {
				System.out.print(this.deck[i].toString() + ", ");
				rowCount++;
			} else {
				System.out.print(this.deck[i].toString());
				System.out.println();
				rowCount = 0;
			}

		}
	}
}
