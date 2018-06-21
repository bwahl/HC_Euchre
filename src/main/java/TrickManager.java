public class TrickManager {

  private final Trick trick;
  private final PlayerOrderWithLeader players;
  private Player winningPlayer;

  public TrickManager(PlayerOrderWithLeader players, Card.Suit trump) {
    this.players = players;
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
    for (Player player : players) {
      makePlayerPlayCard(player);
    }
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
