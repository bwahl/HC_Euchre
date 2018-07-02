public class Dealer {
  CardList deck;
  private final DeckFactory deckFactory;

  public Dealer(DeckFactory deckFactory) {
    this.deckFactory = deckFactory;
    reset();
  }

  private void reset() {
    deck = deckFactory.createDeck();
  }

  public void deal(Iterable<Player> players, int numCards) {
  }
}
