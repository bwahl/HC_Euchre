import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HandPlayManagerTest extends EuchreTest {
  @Before
  public void setUp() throws Exception {
    StubPlayerOrder playerOrder = makeStubPlayerOrder();
    Player leader = playerOrder.getPlayerAt(0);
    Card.Suit trump = Card.Suit.HEARTS;
    HandPlayManager handPlayManager = new HandPlayManager(playerOrder, leader, trump);
  }

}
