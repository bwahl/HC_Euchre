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
    Card[] providedCards = makeTensCardArray();
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

  @Test
  public void testWinningPlayerDifferentSuitsAllTens() {
    Card.Suit trump = Card.Suit.HEARTS;
    Player leadPlayer = playerOrder.getPlayerAt(0);
    Card[] providedCards = makeTensCardArray();
    playerOrder.assignCardsToPlayers(providedCards);
    TrickManager trickman = new TrickManager(playerOrder, leadPlayer, trump);
    trickman.playTrick();
    assertEquals("Lead player wins because they played trump", leadPlayer, trickman.getWinningPlayer());
  }

  private Card[] makeTensCardArray() {
    Card[] cardArray = new Card[4];
    cardArray[0] = new Card(Card.Suit.HEARTS, Card.Value.TEN);
    cardArray[1] = new Card(Card.Suit.CLUBS, Card.Value.TEN);
    cardArray[2] = new Card(Card.Suit.DIAMONDS, Card.Value.TEN);
    cardArray[3] = new Card(Card.Suit.SPADES, Card.Value.TEN);
    return cardArray;
  }
}