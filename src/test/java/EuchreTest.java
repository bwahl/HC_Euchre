import java.util.Collections;

public class EuchreTest {

  public static final Card[] TENS_CARD_ARRAY = {
          new Card(Card.Suit.HEARTS, Card.Value.TEN),
          new Card(Card.Suit.CLUBS, Card.Value.TEN),
          new Card(Card.Suit.DIAMONDS, Card.Value.TEN),
          new Card(Card.Suit.SPADES, Card.Value.TEN)
  };

  public static final Card[] HEARTS_CARD_ARRAY = {
          new Card(Card.Suit.HEARTS, Card.Value.TEN),
          new Card(Card.Suit.HEARTS, Card.Value.NINE),
          new Card(Card.Suit.HEARTS, Card.Value.ACE),
          new Card(Card.Suit.HEARTS, Card.Value.QUEEN)
  };

  public static final Card[] BLACK_CARD_ARRAY = {
          new Card(Card.Suit.SPADES, Card.Value.NINE),
          new Card(Card.Suit.CLUBS, Card.Value.ACE),
          new Card(Card.Suit.CLUBS, Card.Value.KING),
          new Card(Card.Suit.CLUBS, Card.Value.TEN)
  };

  public static CardList createShuffledDeck() {
    return (new ShuffledDeckFactory(new StandardDeckFactory())).createDeck();
  }

  static CardList createOrderedDeck() {
    return (new StandardDeckFactory()).createDeck();
  }

  protected CardList getRandomHand() {
    CardList fullDeck = createShuffledDeck();
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
    CardList fullDeck = createShuffledDeck();
    Player currPlayer = leader;
    for (int i = 0; i < 4; i++) {
      currPlayer.setHand(fullDeck.dealHand());
      currPlayer = playerOrder.nextPlayer(currPlayer);
    }
  }

  protected Player makeStubPlayer() {
    return new StubPlayer();
  }

  protected PlayerOrderWithLeader getPlayersWithLeader(StubPlayerOrder playerOrder, int leaderIndex) {
    Player leadPlayer = playerOrder.getPlayerAt(leaderIndex);
    return new PlayerOrderWithLeader(playerOrder, leadPlayer);
  }

  public static class StubPlayer extends Player {
    public StubPlayer() {
      super();
      setHand(new CardList());
    }

    @Override
    Card playCard(Trick trick) {
      return this.getHand().drawCard();
    }
  }

  protected StubPlayerOrder makeStubPlayerOrder() {
    return new StubPlayerOrder(makeStubPlayer(), makeStubPlayer(), makeStubPlayer(), makeStubPlayer());
  }

  protected PlayerOrderWithLeader makeStubPlayerOrderWithLeader() {
    StubPlayerOrder playerOrder = makeStubPlayerOrder();
    return getPlayersWithLeader(playerOrder, 0);
  }

  public static class StubPlayerOrder extends PlayerOrder {

    public StubPlayerOrder(Player p0, Player p1, Player p2, Player p3) {
      super(p0, p1, p2, p3);
    }

    public Player getPlayerAt(int i) {
      return players[i];
    }

    public void assignCardsToPlayers(Card[] cardArray) {
      for (int i = 0; i < 4; i++) {
        players[i].getHand().addCard(cardArray[i]);
      }
    }
  }
}
