import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardListTest {

  public static final int DECK_SIZE = 24;

  @Test
  public void testConstructor() {
    CardList cardList = new CardList();
    Assert.assertTrue("CardList should be empty", cardList.isEmpty());
  }

  @Test
  public void testBuildFullDeck() {
    CardList fullDeck = CardList.buildFullDeck();
    Assert.assertEquals("Full deck should have 24 cards", DECK_SIZE, fullDeck.size());
  }
}