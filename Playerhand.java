
public class Playerhand {

	public Node firstCard, lastCard;

	public Playerhand() {
		this.firstCard = this.lastCard = null;
	}

	public void addCardtoHand(Card card) { // enqueue
		Node tempCard = new Node(card); // temp node

		if (this.lastCard == null) { //if playerHand is empty, the first card is the last card
			this.firstCard = this.lastCard = tempCard;
			return;
		}
		//adds the new card at the end of the deck and changes the last card
		this.lastCard.next = tempCard;
		this.lastCard = tempCard;
	}

	public Node playCard() { // dequeue
		//if hand is empty, return null
		if (this.firstCard == null)
			return null;
		
		// stores previous firstCard and moves firstCard one node ahead
		Node tempCard = this.firstCard;
		this.firstCard = this.firstCard.next;
		
		// if the first card is null, the last card is set to null
		if (this.firstCard == null)
			this.lastCard = null;
		return tempCard;
	}

	public void dropHand() {
		lastCard = null;
	}

	public boolean isEmpty() {
		return lastCard == null;
	}

	public Card peek() {
		if (isEmpty() == true) {
			return lastCard.getCard();
		} else {
			return null;
		}
	}

}
