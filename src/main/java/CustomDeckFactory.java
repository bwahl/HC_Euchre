public class CustomDeckFactory implements DeckFactory {

  private CardList deck;

  public CustomDeckFactory(CardList deck) {
    this.deck = deck;
  }

  @Override
  public CardList createDeck() {
    return deck.clone();
  }
}
