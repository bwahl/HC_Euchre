import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CardList implements Iterable<Card>{

  public static final int DECK_SIZE = 24;
  public static final int HAND_SIZE = 5;
  private List<Card> cards;

  public CardList() {
    cards = new ArrayList<>();
  }

  @Override
  public Iterator<Card> iterator() {
    return cards.iterator();
  }

  public static CardList createShuffledDeck() {
    CardList fullDeck = createOrderedDeck();
    Collections.shuffle(fullDeck.cards);
    return fullDeck;
  }

  private static CardList createOrderedDeck() {
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

  public int size() {
    return cards.size();
  }

  public boolean contains(Card card) {
    return cards.contains(card);
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
}
