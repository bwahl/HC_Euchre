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
  public void testGetTrickCards() {
    Card.Suit trump = Card.Suit.HEARTS;
    Player leadPlayer = playerOrder.getPlayerAt(0);
    TrickManager trickman = new TrickManager(playerOrder, leadPlayer, trump);
    assertTrue("Card list should start out empty",
            trickman.getPlayedCards().isEmpty());
  }
}