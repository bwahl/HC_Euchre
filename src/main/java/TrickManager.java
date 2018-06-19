public class TrickManager {

  private final PlayerOrder playerOrder;
  private final Player leadPlayer;
  private final Trick trick;
  private Player winningPlayer;

  public TrickManager(PlayerOrder playerOrder, Player leadPlayer, Card.Suit trump) {
    this.playerOrder = playerOrder;
    this.leadPlayer = leadPlayer;
    trick = new Trick(trump);
    this.winningPlayer = null;
  }

  public CardList getPlayedCards() {
    return trick.playedCards;
  }

  public Player getWinningPlayer() {
    return winningPlayer;
  }


  public void playTrick() {
  }
}
