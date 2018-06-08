public class AutoPlayer extends Player {
  @Override
  Card playCard() {
    return this.getHand().drawCard();
  }
}
