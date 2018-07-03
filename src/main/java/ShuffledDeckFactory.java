import java.util.Collections;

public class ShuffledDeckFactory implements DeckFactory {
  private DeckFactory deckFactory;

  public ShuffledDeckFactory(DeckFactory deckFactory) {
    this.deckFactory = deckFactory;
  }

  @Override
  public CardList createDeck() {
    CardList deck = deckFactory.createDeck();
    Collections.shuffle(deck);
    return deck;
  }
}
