import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardListTest {

  @Test
  public void testConstructor() {
    CardList cardList = new CardList();
    Assert.assertTrue("CardList should be empty", cardList.isEmpty());
  }
}