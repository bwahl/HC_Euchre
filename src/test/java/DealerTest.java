import org.junit.Before;
import org.junit.Test;

import javax.rmi.CORBA.Stub;

import static org.junit.Assert.*;

public class DealerTest extends EuchreTest {

  private PlayerOrderWithLeader players;

  @Before
  public void setUp() throws Exception {
    players = makeStubPlayerOrderWithLeader();
  }

  @Test
  public void TestDealOneCardHand() {
    CardList deck = new CardList(EuchreTest.TENS_CARD_ARRAY);
    Dealer dealer = new Dealer(new CustomDeckFactory(deck));
    dealer.deal(players, 1);
  }
}
