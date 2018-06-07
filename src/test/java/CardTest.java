import org.junit.Assert;
import org.junit.Test;

public class CardTest {

  @Test
  public void testConstructor() {
    Card card;
    card = new Card(Card.Suit.HEARTS, Card.Value.TEN);
    Assert.assertNotNull(card);
  }

}