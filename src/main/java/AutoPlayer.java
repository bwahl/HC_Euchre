public class AutoPlayer extends Player {
  public AutoPlayer() {
    super();
    setHand(new CardList());
  }

  @Override
  Card playCard(Trick trick) {
    return this.getHand().drawCard();
  }
}
