import java.util.ArrayList;
import java.util.List;

public class CardList {

  private List<Card> cards;

  public CardList() {
    cards = new ArrayList<>();
  }

  public boolean isEmpty() {
    return cards.isEmpty();
  }
}
