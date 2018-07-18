public class Game implements Subscriber {

  @Override
  public void respond(EuchreEvent event) {
    System.out.println(event.print());
  }

  private void runGame() {
    // create players
    Player player0 = makePlayer();
    Player player1 = makePlayer();
    Player player2 = makePlayer();
    Player player3 = makePlayer();
    PlayerOrder players = new PlayerOrder(player0, player1, player2, player3);
    PlayerOrderWithLeader playersWithLeader =
            new PlayerOrderWithLeader(players, player0);

    // create deck factory and dealer
    DeckFactory shuffledDeckFactory = new ShuffledDeckFactory(new StandardDeckFactory());
    Dealer dealer = new Dealer(shuffledDeckFactory);

    // create HandPlayManager
    HandPlayManager manager =
            new HandPlayManager(dealer, playersWithLeader, Card.Suit.HEARTS);

    subscribeToAll();
    manager.playHand(5);  // Play 5 card hand!
  }

  private Player makePlayer() {
    return new AutoPlayer();
  }

  public static void main(String[] args) {

    // create Game instance and call runGame
    Game game = new Game();
    game.runGame();
  }

}
