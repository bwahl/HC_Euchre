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
    return trick.getPlayedCardsAsCardList();
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
    PlayedCard winningCard = computeWinningCard();
    this.winningPlayer = winningCard.player;
  }

  private PlayedCard computeWinningCard() {
    PlayedCard winningPlayedCard = null;
    for (PlayedCard card : trick.playedCards) {
      if (challengerBeatsIncumbent(card, winningPlayedCard, trick.trump)) {
        winningPlayedCard = card;
      }
    }
    return winningPlayedCard;
  }

  private boolean challengerBeatsIncumbent(PlayedCard challenger,
                 PlayedCard incumbent, Card.Suit trump) {
    if (incumbent == null) {
      return true;
    }

    if (challenger.hasSameSuit(incumbent)) {
      return challenger.hasHigherValue(incumbent);
    }

    return challenger.hasSuit(trump);
  }

  private void makePlayerPlayCard(Player currentPlayer) {
    Card card = currentPlayer.playCard(trick);
    trick.addPlayedCard(card, currentPlayer);
  }

}
