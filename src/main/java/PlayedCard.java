public class PlayedCard {

  public Card card;
  public Player player;

  public PlayedCard(Card card, Player player) {
    this.card = card;
    this.player = player;
  }

  public Card.Suit getSuit() {
    return card.getSuit();
  }

  public boolean hasSameSuit(PlayedCard other) {
    return card.hasSameSuit(other.card);
  }

  boolean hasSuit(Card.Suit suit) {
    return getSuit().equals(suit);
  }

  public Card.Value getValue() {
    return card.getValue();
  }

  public boolean hasSameValue(PlayedCard other) {
    return card.hasSameValue(other.card);
  }

  public boolean hasHigherValue(PlayedCard other) {
    return card.hasHigherValue(other.card);
  }

}
