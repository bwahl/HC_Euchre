import java.util.Iterator;

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
    playCards();
    computeTrickWinner();
  }

  private void playCards() {
    Player currentPlayer = leadPlayer;
    do {
      makePlayerPlayCard(currentPlayer);
      currentPlayer = playerOrder.nextPlayer(currentPlayer);
    } while (!currentPlayer.equals(leadPlayer));
  }

  private void computeTrickWinner() {
    Player currentPlayer = leadPlayer;
    Iterator<Card> iter = trick.playedCards.iterator();
    Card leadCard = iter.next();
    Card winningCard = leadCard;
    winningPlayer = leadPlayer;

    while (iter.hasNext()) {
      currentPlayer = playerOrder.nextPlayer(currentPlayer);
      Card currentCard = iter.next();
      if (challengerBeatsIncumbent(currentCard, winningCard, trick.trump)) {
        winningCard = currentCard;
        winningPlayer = currentPlayer;
      }
    }
  }

  private boolean challengerBeatsIncumbent(Card challenger, Card incumbent, Card.Suit trump) {
    if (challenger.hasSameSuit(incumbent)) {
      return challenger.hasHigherValue(incumbent);
    }

    return challenger.getSuit().equals(trump);
  }

  private void makePlayerPlayCard(Player currentPlayer) {
    Card card = currentPlayer.playCard(trick);
    trick.playedCards.addCard(card);
  }
}
