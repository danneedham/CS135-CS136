enum Rank { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
}

enum Suit { CLUBS, DIAMONS, HEARTS, SPADES;
}

public interface card {

    public Suit getSuit();
    public Rank getRank();
}
//this must be in a separate doc
//public boolean equals (object other) {
//  if (other instanceof Card) {
//	Card oc = (Card) other;
//	return this.getRank() == oc.getRank() &&
//	    this.getSuit() == oc.getSuit();
    }
