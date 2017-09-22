
public class Playerhand {

	public Node top;

	public Playerhand() {
		top = null;
	}

	public void addCardtoHand(Card card) {
		top = new Node(top, card);
	}

	public boolean isEmpty() {
		return top == null;
	}

	public Card peek() {
		if (isEmpty() == true) {
			return top.getCard();
		} else {
			return null;
		}
	}

}
