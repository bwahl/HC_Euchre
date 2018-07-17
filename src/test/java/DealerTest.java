import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DealerTest extends EuchreTest {

  private PlayerOrderWithLeader players;

  @Before
  public void setUp() throws Exception {
    players = makeStubPlayerOrderWithLeader();
  }

  @Test
  public void TestDealOneCardHand() {
    int cardNum;
    CardList deck = new CardList(EuchreTest.TENS_CARD_ARRAY);
    Dealer dealer = new Dealer(new CustomDeckFactory(deck));
    dealer.deal(players, 1);
    // The cards are dealt one at a time, starting from leader
    cardNum = 0;
    for (Player player : players) {
      assertEquals("Each player has the correct card.",
                   EuchreTest.TENS_CARD_ARRAY[cardNum],
                   player.getHand().get(0)
      );
      cardNum += 1;
    }
    assertEquals("Dealer's deck should now be empty.",
                 0,
                  dealer.getDeck().size()
    );
  }

  @Test
  public void testDealFiveCardHand() {
    int numCards = 5;
    DeckFactory shuffledDeckFactory = new ShuffledDeckFactory(new StandardDeckFactory());
    Dealer dealer = new Dealer(shuffledDeckFactory);
    CardList deck = dealer.getDeck();
    dealer.deal(players, numCards);
    assertEquals("Deck is still size 24", 24, deck.size());
    verifyAllPlayersHands(numCards, deck);
  }

  private void verifyAllPlayersHands(int numCards, CardList deck) {
    int playerNum = 0;
    for (Player player : players) {
      verifyPlayerHand(playerNum, numCards, deck, player.getHand());
      playerNum += 1;
    }
  }

  private void verifyPlayerHand(int playerNum, int numCards, CardList deck, CardList hand) {
    assertEquals("Hand size should be 5.", numCards, hand.size());
    for (int i = 0; i < numCards; i++) {
      // The cards should be dealt one at a time, starting from leader
      assertContains("Player should have correct cards.",
              hand,
              deck.get(playerNum + i * 4));
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
