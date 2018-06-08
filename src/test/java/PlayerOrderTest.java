import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerOrderTest extends EuchreTest {

  private Player player1;
  private Player player2;
  private Player player3;
  private Player player4;
  private PlayerOrder playerOrder;

  @Before
  public void setUp() throws Exception {
    player1 = makeTestPlayer();
    player2 = makeTestPlayer();
    player3 = makeTestPlayer();
    player4 = makeTestPlayer();
    playerOrder = new PlayerOrder(player1, player2, player3, player4);
  }

  @Test
  public void testNextPlayer() {
    assertEquals("player1 should follow player4", player1, playerOrder.nextPlayer(player4));
    assertEquals("player2 should follow player1", player2, playerOrder.nextPlayer(player1));
    assertEquals("player3 should follow player2", player3, playerOrder.nextPlayer(player2));
    assertEquals("player4 should follow player3", player4, playerOrder.nextPlayer(player3));
  }
}