import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardList {

  private List<Card> cards;

  public CardList() {
    cards = new ArrayList<>();
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
}
