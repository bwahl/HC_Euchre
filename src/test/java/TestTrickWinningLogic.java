import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTrickWinningLogic extends EuchreTest {
  private StubPlayerOrder playerOrder;

  @Before
  public void setUp() throws Exception {
    playerOrder = makeStubPlayerOrder();
  }

  @Test
  public void testWinningPlayerDifferentSuitsAllTens() {
    playTrickAndTestWinner(
            "Lead player wins because they played trump",
            Card.Suit.HEARTS,
            playerOrder.getPlayerAt(0),
            playerOrder.getPlayerAt(0),
            TENS_CARD_ARRAY
    );
  }

  private void playTrickAndTestWinner(String message, Card.Suit trump, Player leadPlayer, Player winningPlayer, Card[] providedCards) {
    playerOrder.assignCardsToPlayers(providedCards);
    TrickManager trickman = new TrickManager(playerOrder, leadPlayer, trump);
    trickman.playTrick();
    assertEquals(message,
            leadPlayer, trickman.getWinningPlayer());
  }

  @Test
  public void testWinningPlayerAllSameSuit() {

  }
}
