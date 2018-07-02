public class StandardOrderedDeckFactory implements DeckFactory {
  @Override
  public CardList createDeck() {
    return CardList.createOrderedDeck();
  }
}
