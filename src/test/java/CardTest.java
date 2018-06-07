import static org.junit.Assert.*;
import org.junit.Test;

public class CardTest {

  @Test
  public void testConstructor() {
    Card card;
    card = new Card(Card.Suit.HEARTS, Card.Value.TEN);
    assertNotNull(card);
  }

  @Test
  public void testToString() {
    Card card = new Card(Card.Suit.HEARTS, Card.Value.ACE);
    assertEquals("Ace of Hearts should print as 'Ace of Hearts'",
            "Ace of Hearts", card.toString());
    card = new Card(Card.Suit.CLUBS, Card.Value.TEN);
    assertEquals("10 of Clubs should print as '10 of Clubs'",
            "10 of Clubs", card.toString());
  }
}