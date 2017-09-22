
public class Node {

	public Card card;
	Node next;

	public Node() {
		next = null;
		card = null;
	}

	public Node(Node newNext) {
		next = newNext;
		card = null;
	}

	public Node(Card newCard) {
		next = null;
		card = newCard;
	}

	public Node(Node newNext, Card newCard) {
		next = newNext;
		card = newCard;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
