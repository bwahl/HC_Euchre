import org.junit.Test;
import static org.junit.Assert.*;

public class CardListTest {

  @Test
  public void testConstructor() {
    CardList cardList = new CardList();
    assertTrue("CardList should be empty", cardList.isEmpty());
  }

  @Test
  public void testBuildFullDeck() {
    CardList fullDeck = CardList.buildFullDeck();
    assertEquals("Full deck should have 24 cards", CardList.DECK_SIZE, fullDeck.size());
    for (Card.Suit suit : Card.getSuits()) {
      for (Card.Value value : Card.getValues()) {
        Card card = new Card(suit, value);
        assertTrue("The deck should contain " + card.toString(),
                fullDeck.contains(card));
      }
    }
  }

  @Test
  public void testDrawCard() {
    CardList fullDeck = CardList.buildFullDeck();
    int origSize = fullDeck.size();
    Card card = fullDeck.drawCard();
    assertNotNull("Drawn card should not be null", card);
    assertEquals("Deck size should decrease by 1", origSize-1, fullDeck.size());
    assertFalse("Drawn card is not in deck", fullDeck.contains(card));
  }

  @Test
  public void testDealHand() {
    CardList fullDeck = CardList.buildFullDeck();
    int origSize = fullDeck.size();
    CardList hand = fullDeck.dealHand();
    assertNotNull("Dealt hand should not be null", hand);
    assertEquals("Dealt hand should have five cards", CardList.HAND_SIZE, hand.size());
    assertEquals("Deck size is reduced by five",
            origSize-CardList.HAND_SIZE, fullDeck.size());
    checkHasNoRepeats(hand);
  }

  private void checkHasNoRepeats(CardList hand) {
    Card card;
    for (int i = 0; i < CardList.HAND_SIZE; i++) {
      card = hand.drawCard();
      assertFalse("Hand should contain no duplicates", hand.contains(card));
    }
  }
}