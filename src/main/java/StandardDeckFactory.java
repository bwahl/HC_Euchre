public class StandardDeckFactory implements DeckFactory {
  @Override
  public CardList createDeck() {
    return CardList.createOrderedDeck();
  }
}
