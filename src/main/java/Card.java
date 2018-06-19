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

  public Suit getSuit() {
    return suit;
  }

  public Value getValue() {
    return value;
  }

  public boolean hasSameValue(Card other) {
    return this.value.equals(other.value);
  }

  public boolean hasSameSuit(Card other) {
    return this.suit.equals(other.suit);
  }

  public boolean hasHigherValue(Card other) {
    return (this.value.compareTo(other.value) > 0);
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
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    ACE("Ace");

    private final String name;

    Value(String value) {
      this.name = value;
    }

    public String getName() {
      return name;
    }
  }
}
