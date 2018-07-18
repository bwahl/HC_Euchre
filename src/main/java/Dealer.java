public class Dealer {
  CardList deck;
  private final DeckFactory deckFactory;

  public Dealer(DeckFactory deckFactory) {
    this.deckFactory = deckFactory;
    reset();
  }

  public CardList getDeck() {
    return deck.clone();
  }

  public void reset() {
    deck = deckFactory.createDeck();
  }

  public void deal(Iterable<Player> players, int numCards) {
    for (int i = 0; i < numCards; i++) {
      for (Player player : players) {
        Card card = deck.drawCard();
        CardList hand = player.getHand();
        hand.addCard(card);
      }
    }
    publishCardsDealt(players);
  }

  private void publishCardsDealt(Iterable<Player> players) {
    EuchreEvent event = EuchreEvent.makeCardsDealtEvent(players);
    PubSub.getInstance().publish(event);
  }
}
