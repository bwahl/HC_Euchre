public abstract class EuchreEvent {

  public enum Topic {
    NEW_GAME, NEW_HAND, CARDS_DEALT, CARD_PLAYED, TRICK_WON
  }

  abstract Topic getTopic();

  abstract String print();

  static CardPlayedEvent makeCardPlayedEvent(PlayedCard card) {
    return new CardPlayedEvent(card);
  }

  static CardsDealtEvent makeCardsDealtEvent(Iterable<Player> playerOrder) {
    return new CardsDealtEvent(playerOrder);
  }

  static class CardPlayedEvent extends EuchreEvent {

    private final PlayedCard playedCard;

    public CardPlayedEvent(PlayedCard playedCard) {
      this.playedCard = playedCard;
    }

    @Override
    Topic getTopic() {
      return Topic.CARD_PLAYED;
    }

    @Override
    String print() {
      return playedCard.toString();
    }
  }

  static class CardsDealtEvent extends EuchreEvent {

    private final Iterable<Player> playerOrder;

    CardsDealtEvent(Iterable<Player> playerOrder) {
      this.playerOrder = playerOrder;
    }

    @Override
    Topic getTopic() {
      return Topic.CARDS_DEALT;
    }

    @Override
    String print() {
      return "Cards dealt";
    }
  }
}
