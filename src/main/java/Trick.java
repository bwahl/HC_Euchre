public class Trick {
  public Card.Suit trump;
  public CardList playedCards;

  public Trick(Card.Suit trump) {
    this.trump = trump;
    playedCards = new CardList();
  }
}