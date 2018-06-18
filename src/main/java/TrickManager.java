public class TrickManager {

  private final PlayerOrder playerOrder;
  private final Player leadPlayer;
  private final Card.Suit trump;
  private CardList playedCards;
  private Player winningPlayer;

  public TrickManager(PlayerOrder playerOrder, Player leadPlayer, Card.Suit trump) {
    this.playerOrder = playerOrder;
    this.leadPlayer = leadPlayer;
    this.trump = trump;
    this.playedCards = new CardList();
    this.winningPlayer = null;
  }

  public CardList getPlayedCards() {
    return playedCards;
  }

  public Player getWinningPlayer() {
    return winningPlayer;
  }
}
