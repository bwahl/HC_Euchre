import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrickManagerTest extends EuchreTest {
  private StubPlayerOrder playerOrder;

  @Before
  public void setUp() throws Exception {
    playerOrder = makeStubPlayerOrder();
  }

  @Test
  public void testPlayedCardsEmptyAtStart() {
    Card.Suit trump = Card.Suit.HEARTS;
    Player leadPlayer = playerOrder.getPlayerAt(0);
    TrickManager trickman = new TrickManager(playerOrder, leadPlayer, trump);
    assertTrue("Card list should start out empty",
            trickman.getPlayedCards().isEmpty());
  }

  @Test
  public void testPlayedCardsAfterOneCardHand() {
    Card.Suit trump = Card.Suit.HEARTS;
    Player leadPlayer = playerOrder.getPlayerAt(0);
    Card[] providedCards = TENS_CARD_ARRAY;
    playerOrder.assignCardsToPlayers(providedCards);
    TrickManager trickman = new TrickManager(playerOrder, leadPlayer, trump);
    trickman.playTrick();
    assertPlayedCardsMatchesProvidedCards(trickman.getPlayedCards(), providedCards);

  }

  private void assertPlayedCardsMatchesProvidedCards(CardList playedCards, Card[] providedCards) {
    assertEquals("Four cards should have been played",
            4, playedCards.size());
    int i = 0;
    for (Card card : playedCards) {
      assertEquals("Cards at index " + i + " should match",
              providedCards[i], card);
      i++;
    }
  }

}