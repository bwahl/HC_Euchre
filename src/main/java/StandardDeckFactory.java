public class StandardDeckFactory implements DeckFactory {
  @Override
  public CardList createDeck() {
    CardList fullDeck = new CardList();
    for (Card.Suit suit : Card.getSuits()) {
      for (Card.Value value : Card.getValues()) {
        fullDeck.addCard(new Card(suit, value));
      }
    }
    return fullDeck;
  }
}
