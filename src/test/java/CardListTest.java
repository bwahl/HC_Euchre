import org.junit.Test;
import static org.junit.Assert.*;

public class CardListTest {

  public static final int DECK_SIZE = 24;

  @Test
  public void testConstructor() {
    CardList cardList = new CardList();
    assertTrue("CardList should be empty", cardList.isEmpty());
  }

  @Test
  public void testBuildFullDeck() {
    CardList fullDeck = CardList.buildFullDeck();
    assertEquals("Full deck should have 24 cards", DECK_SIZE, fullDeck.size());
    for (Card.Suit suit : Card.getSuits()) {
      for (Card.Value value : Card.getValues()) {
        Card card = new Card(suit, value);
        assertTrue("The deck should contain " + card.toString(),
                fullDeck.contains(card));
      }
    }
  }
  
}