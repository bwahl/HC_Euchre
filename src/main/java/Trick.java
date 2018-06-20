import java.util.ArrayList;
import java.util.List;

public class Trick {
  public Card.Suit trump;
  public List<PlayedCard> playedCards;

  public Trick(Card.Suit trump) {
    this.trump = trump;
    this.playedCards = new ArrayList<>();
  }

  public CardList getPlayedCardsAsCardList() {
    CardList cards = new CardList();
    for (PlayedCard playedCard : playedCards) {
      cards.addCard(playedCard.card);
    }
    return cards;
  }

  void addPlayedCard(Card card, Player player) {
    playedCards.add(new PlayedCard(card, player));
  }

}