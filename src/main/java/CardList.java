import java.util.*;

public class CardList extends AbstractList<Card> {

  public static final int DECK_SIZE = 24;
  public static final int HAND_SIZE = 5;
  private List<Card> cards;

  public CardList() {
    cards = new ArrayList<>();
  }

  @ Override
  public int size() {
    return cards.size();
  }

  @Override
  public Card set(int index, Card element) {
    return cards.set(index, element);
  }

  @Override
  public void add(int index, Card element) {
    cards.add(index, element);
  }

  @Override
  public Card remove(int index) {
    return cards.remove(index);
  }

  @Override
  public Card get(int index) {
    return cards.get(index);
  }

  public CardList(Card[] cardArray) {
    this();  // Calls default constructor
    for (int i = 0; i < cardArray.length; i++) {
      addCard(cardArray[i]);
    }
  }

  public CardList(Iterable<Card> listOfCards) {
    this();  // Calls default constructor
    for (Card card : listOfCards) {
      addCard(card);
    }
  }

  @Override
  public Iterator<Card> iterator() {
    return cards.iterator();
  }

  @Override
  public String toString() {
    if (this.isEmpty()){
      return "<empty>\n";
    }

    StringBuilder sb = new StringBuilder();
    for (Card card : cards) {
      sb.append(card.toString());
      sb.append("\n");
    }
    return sb.toString();
  }

  public boolean contains(Card card) {
    return cards.contains(card);
  }

  public static CardList createShuffledDeck() {
    CardList fullDeck = createOrderedDeck();
    Collections.shuffle(fullDeck.cards);
    return fullDeck;
  }

  protected CardList clone() {
    return new CardList(this.cards);
  }

  static CardList createOrderedDeck() {
    CardList fullDeck = new CardList();
    for (Card.Suit suit : Card.getSuits()) {
      for (Card.Value value : Card.getValues()) {
        fullDeck.addCard(new Card(suit, value));
      }
    }
    return fullDeck;
  }

  void addCard(Card card) {
    cards.add(card);
  }

  public boolean isEmpty() {
    return cards.isEmpty();
  }

  // Throws IndexOutOfBoundsException if this CardList is empty.
  Card drawCard() {
    return cards.remove(0);
  }

  CardList dealHand() {
    CardList hand = new CardList();
    for (int i = 0; i < HAND_SIZE; i++) {
      hand.addCard(this.drawCard());
    }
    return hand;
  }
}
