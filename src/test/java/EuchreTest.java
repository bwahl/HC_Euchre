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

  protected Player makeStubPlayer() {
    return new StubPlayer();
  }

  public static class StubPlayer extends Player {
    @Override
    Card playCard(Trick trick) {
      return null;
    }
  }

  protected StubPlayerOrder makeStubPlayerOrder() {
    return new StubPlayerOrder(makeStubPlayer(), makeStubPlayer(), makeStubPlayer(), makeStubPlayer());
  }

  public static class StubPlayerOrder extends PlayerOrder {

    public StubPlayerOrder(Player p0, Player p1, Player p2, Player p3) {
      super(p0, p1, p2, p3);
    }

    public Player getPlayerAt(int i) {
      return players[i];
    }

  }
}
