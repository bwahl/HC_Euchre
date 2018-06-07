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

  @Override
  public String toString() {
    return value.getName() + " of " + suit.getName();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    Card other = (Card)obj;
    return hasSameSuit(other) && hasSameValue(other);
  }

  private boolean hasSameValue(Card other) {
    return this.value.equals(other.value);
  }

  private boolean hasSameSuit(Card other) {
    return this.suit.equals(other.suit);
  }

  static Value[] getValues() {
    return Value.values();
  }

  enum Suit {
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    SPADES("Spades");

    private final String name;

    Suit(String suit) {
      this.name = suit;
    }

    public String getName() {
      return name;
    }
  }

  enum Value {
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private final String name;

    Value(String value) {
      this.name = value;
    }

    public String getName() {
      return name;
    }
  }
}
