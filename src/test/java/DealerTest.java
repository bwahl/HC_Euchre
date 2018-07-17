import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DealerTest extends EuchreTest {

  private PlayerOrderWithLeader players;
  private int numCards;
  private Dealer dealer;
  private CardList origDeck;

  @Before
  public void setUp() throws Exception {
    players = makeStubPlayerOrderWithLeader();
  }

  @Test
  public void TestDealOneCardHand() {
    initializeDealerAndDeck(1);
    dealer.deal(players, numCards);
    verifyAllPlayersHands();
  }

  @Test
  public void testDealFiveCardHand() {
    initializeDealerAndDeck(5);
    dealer.deal(players, numCards);
    verifyAllPlayersHands();
  }

  private void initializeDealerAndDeck(int numCards) {
    this.numCards = numCards;
    this.dealer = createDealer();
    origDeck = this.dealer.getDeck();
  }

  private void verifyAllPlayersHands() {
    int playerNum = 0;
    for (Player player : players) {
      verifyPlayerHand(playerNum, player.getHand());
      playerNum += 1;
    }
  }

  private void verifyPlayerHand(int playerNum, CardList playerHand) {
    assertEquals("Hand size should be 5.", numCards, playerHand.size());
    for (int i = 0; i < numCards; i++) {
      // The cards should be dealt one at a time, starting from leader
      assertContains("Player should have correct cards.",
              playerHand,
              origDeck.get(playerNum + i * 4));
    }
  }

  private void assertContains(String msg, Iterable iterable, Object item) {
    for (Object o : iterable) {
      if (o.equals(item)) { return; }
    }
    msg = msg + "\n" + "Item: " + item + " not contained in the collection.";
    fail(msg);
  }
}
