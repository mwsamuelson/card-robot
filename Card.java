public class Card {
	public final int Spades = 0, Hearts = 1, Clubs = 2, Diamonds = 3;
	public final int Jack = 11, Queen = 12, King = 13, Ace = 14;

	public int suit;
	public int value;
	public int suitValue;

	public Card(int cardValue, int cardSuit, int cardSuitValue) {
		suit = cardSuit;
		value = cardValue;
		suitValue = cardSuitValue;
	}

	public int getSuit() {
		return suit;
	}

	public int getSuitValue() {
		return suitValue;
	}

	public int getValue() {
		return value;
	}

	public String getSuitAsString() {
		switch (suit) {
		case Spades:
			return "Spades";
		case Hearts:
			return "Hearts";
		case Clubs:
			return "Clubs";
		case Diamonds:
			return "Diamonds";
		default:
			return "??";
		}
	}

	public String getValueAsString() {
		//starts at 2 to keep the values between 2 and A
		switch (value) {
		case 2:
			return "2";
		case 3:
			return "3";
		case 4:
			return "4";
		case 5:
			return "5";
		case 6:
			return "6";
		case 7:
			return "7";
		case 8:
			return "8";
		case 9:
			return "9";
		case 10:
			return "10";
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13:
			return "K";
		case 14:
			return "A";
		default:
			return "??";
		}
	}

	public String toString() {
		//overrides toString method to print out card value and card suit
		return getValueAsString() + " " + getSuitAsString();
	}

}
