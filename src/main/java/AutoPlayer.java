public class AutoPlayer extends Player {
  @Override
  Card playCard(Trick trick) {
    return this.getHand().drawCard();
  }
}
