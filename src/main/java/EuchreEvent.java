public abstract class EuchreEvent {

  public enum Topic {
    ALL, NEW_GAME, NEW_HAND, CARDS_DEALT, CARD_PLAYED, TRICK_WON
  }

  abstract Topic getTopic();

  abstract String print();

  static CardPlayedEvent makeCardPlayedEvent(PlayedCard card) {
    return new CardPlayedEvent(card);
  }

  static CardsDealtEvent makeCardDealtEvent(PlayerOrderWithLeader playerOrder) {
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

    private final PlayerOrderWithLeader playerOrder;

    CardsDealtEvent(PlayerOrderWithLeader playerOrder) {
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
