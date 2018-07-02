public abstract class Player {
  private CardList hand;

  public CardList getHand() {
    return hand;
  }

  public void setHand(CardList hand) {
    this.hand = hand;
  }

  abstract Card playCard(Trick trick);

  PlayedCard getPlayedCard(Trick trick) {
    return new PlayedCard(playCard(trick), this);
  }
}
