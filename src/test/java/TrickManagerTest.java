import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrickManagerTest extends EuchreTest {

  private Player leader;
  private Player player2;
  private Player player3;
  private Player player4;
  private PlayerOrder playerOrder;
  private TrickManager trickman;
  private Card.Suit trump;

  @Before
  public void setUp() throws Exception {
    leader = makeTestPlayer();
    player2 = makeTestPlayer();
    player3 = makeTestPlayer();
    player4 = makeTestPlayer();
    playerOrder = new PlayerOrder(leader, player2, player3, player4);
    trump = Card.Suit.HEARTS;
    trickman = new TrickManager(playerOrder, leader, trump);
  }

  @Test
  public void testGetTrickCards() {
    assertTrue("Card list should start out empty",
            trickman.getTrickCards().isEmpty());
  }
}