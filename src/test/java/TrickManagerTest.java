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
    PlayerOrderWithLeader players = getPlayersWithLeader(playerOrder, 0);
    TrickManager trickman = new TrickManager(players, trump);
    assertTrue("Card list should start out empty",
            trickman.getPlayedCards().isEmpty());
  }

  @Test
  public void testPlayedCardsAfterOneCardHand() {
    Card.Suit trump = Card.Suit.HEARTS;
    Card[] providedCards = TENS_CARD_ARRAY;
    playerOrder.assignCardsToPlayers(providedCards);
    PlayerOrderWithLeader players = getPlayersWithLeader(playerOrder, 0);
    TrickManager trickman = new TrickManager(players, trump);
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