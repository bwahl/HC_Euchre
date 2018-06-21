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
    handPlayManager = new HandPlayManager(players, trump);
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
}
