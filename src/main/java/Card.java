public class Card {

    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    static Suit[] getSuits() {
      return Suit.values();
    }

    static Value[] getValues() {
      return Value.values();
    }

    enum Suit {
        HEARTS("Hearts"),
        DIAMONDS("Diamonds"),
        CLUBS("Clubs"),
        SPADES("Spades");

        private final String suit;

        Suit(String suit) {
            this.suit = suit;
        }

        public String getSuit() {
            return suit;
        }
    }

    enum Value {
        NINE("9"),
        TEN("10"),
        JACK("J"),
        QUEEN("Q"),
        KING("K"),
        ACE("A");

        private final String value;

        Value(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
