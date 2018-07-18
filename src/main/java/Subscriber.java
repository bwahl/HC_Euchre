interface Subscriber {
  default void subscribeTo(EuchreEvent.Topic topic) {
    PubSub pubSub = PubSub.getInstance();
    pubSub.subscribe(topic, this);
  }

  default void subscribeToAll() {
    for (EuchreEvent.Topic topic : EuchreEvent.Topic.values()) {
      subscribeTo(topic);
    }
  }

  default void unsubscribeFrom(EuchreEvent.Topic topic) {
    PubSub pubSub = PubSub.getInstance();
    pubSub.unsubscribe(topic, this);
  }

  default void unsubscribeFromAll() {
    for (EuchreEvent.Topic topic : EuchreEvent.Topic.values()) {
      unsubscribeFrom(topic);
    }
  }

  default void respond(EuchreEvent event) {
    switch (event.getTopic()) {
      case CARD_PLAYED:
        respondToCardPlayed((EuchreEvent.CardPlayedEvent) event);
        break;
      case CARDS_DEALT:
        respondToCardsDealt((EuchreEvent.CardsDealtEvent) event);
        break;
      default:
        throw new RuntimeException("Invalid topic for event.");
    }
  }

  default void respondToCardsDealt(EuchreEvent.CardsDealtEvent event) {
  }

  default void respondToCardPlayed(EuchreEvent.CardPlayedEvent event) {
  }
}
