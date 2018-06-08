public class TrickManager {

  private final PlayerOrder playerOrder;
  private final Player leadPlayer;
  private final Card.Suit trump;
  private CardList trickCards;
  private Player winPlayer;

  public TrickManager(PlayerOrder playerOrder, Player leadPlayer, Card.Suit trump) {
    this.playerOrder = playerOrder;
    this.leadPlayer = leadPlayer;
    this.trump = trump;
    this.trickCards = new CardList();
    this.winPlayer = null;
  }

  public CardList getTrickCards() {
    return trickCards;
  }

  public Player getWinPlayer() {
    return winPlayer;
  }
}
