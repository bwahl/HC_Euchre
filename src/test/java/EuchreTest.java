public class EuchreTest {
  protected CardList getRandomHand() {
    CardList fullDeck = CardList.createShuffledDeck();
    CardList hand = fullDeck.dealHand();
    return hand;
  }

  protected CardList cloneHand(CardList hand) {
    CardList copy = new CardList();
    for (Card card : hand) {
      copy.addCard(card);
    }
    return copy;
  }

  protected Player makeStubPlayer() {
    return new StubPlayer();
  }

  protected Trick getRandomTrick() {
    return new Trick(Card.Suit.HEARTS);
  }

  protected void dealHands(PlayerOrder playerOrder, Player leader) {
    CardList fullDeck = CardList.createShuffledDeck();
    Player currPlayer = leader;
    for (int i = 0; i < 4; i++) {
      currPlayer.setHand(fullDeck.dealHand());
      currPlayer = playerOrder.nextPlayer(currPlayer);
    }
  }

  public static class StubPlayer extends Player {
    @Override
    Card playCard(Trick trick) {
      return null;
    }
  }
}
