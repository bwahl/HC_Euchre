import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Map;

public class HandPlayManagerTest extends EuchreTest {
  private HandPlayManager handPlayManager;
  private PlayerOrderWithLeader players;

  @Before
  public void setUp() throws Exception {
    StubPlayerOrder playerOrder = makeStubPlayerOrder();
    players = getPlayersWithLeader(playerOrder, 0);
    Card.Suit trump = Card.Suit.HEARTS;
    handPlayManager = new HandPlayManager(createDealer(), players, trump);
  }

  @Test
  public void testHandPlayStartsWithTricksWonAllZero() {
    Map<Player, Integer> tricksWon = handPlayManager.getTricksWon();
    for (Player player : players) {
      assertTrue("Each player is in the tricksWon map.", tricksWon.containsKey(player));
      assertEquals("Each player has won zero tricks at start.",
              tricksWon.get(player), new Integer(0));
    }
  }

  @Test
  public void testPlayHand() {
    handPlayManager.playHand(5);
    assertEquals("Total of five tricks won.", 5, countTricksWon());
    verifyNoNegativeTricksWon();
  }

  private void verifyNoNegativeTricksWon() {
    for (Player player : players) {
      assertTrue("No players have won less than zero tricks.",
              handPlayManager.getTricksWonBy(player) >= 0);
    }
  }

  private int countTricksWon() {
    int numWon = 0;
    for (Player player : players) {
      numWon += handPlayManager.getTricksWonBy(player);
    }
    return numWon;
  }
}
