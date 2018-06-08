public class EuchreTest {
  protected CardList getRandomHand() {
    CardList fullDeck = CardList.createShuffledDeck();
    CardList hand = fullDeck.dealHand();
    return hand;
  }

  protected CardList cloneHand(CardList hand) {
    CardList copy = new CardList();
    for (Card card : hand) {
      copy.addCard(card);
    }
    return copy;
  }

  protected Player makeTestPlayer() {
    return new AutoPlayer();
  }
}
