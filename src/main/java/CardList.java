import java.util.ArrayList;
import java.util.List;

public class CardList {

  private List<Card> cards;

  public CardList() {
    cards = new ArrayList<>();
  }

  public static CardList buildFullDeck() {
    CardList fullDeck = new CardList();
    for (Card.Suit suit : Card.getSuits()) {
      for (Card.Value value : Card.getValues()) {
        Card card = new Card(suit, value);
        fullDeck.addCard(card);
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
