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

  public static CardList buildFullDeck() {
    CardList fullDeck = getOrderedDeck();
    Collections.shuffle(fullDeck.cards);
    return fullDeck;
  }

  private static CardList getOrderedDeck() {
    CardList fullDeck = new CardList();
    for (Card.Suit suit : Card.getSuits()) {
      for (Card.Value value : Card.getValues()) {
        fullDeck.addCard(new Card(suit, value));
      }
    }
    return fullDeck;
  }

  private void addCard(Card card) {
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
}
