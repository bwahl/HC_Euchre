public class HumanPlayer extends Player {
  @Override
  Card playCard() {
    return this.getHand().drawCard();
  }
}
