import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest extends EuchreTest {

  @Test
  public void testDefaultConstructor() {
    HumanPlayer human = new HumanPlayer();
    AutoPlayer auto = new AutoPlayer();
  }

  @Test
  public void testHumanPlayCard() {
    testPlayerCard(new HumanPlayer());
  }

  @Test
  public void testAutoPlayCard() {
    testPlayerCard(new AutoPlayer());
  }

  private void testPlayerCard(Player player) {
    CardList hand = getRandomHand();
    CardList handcopy = cloneHand(hand);
    player.setHand(hand);
    Card playedcard = player.playCard(getRandomTrick());
    assertTrue("Played card was in original hand", handcopy.contains(playedcard));
    assertFalse("Played card is no longer in hand", hand.contains(playedcard));
  }

}
