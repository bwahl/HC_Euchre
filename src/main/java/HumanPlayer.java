public class HumanPlayer extends Player {
  @Override
  Card playCard(Trick trick) {
    return this.getHand().drawCard();
  }
}
