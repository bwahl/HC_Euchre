import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrickWinningLogicTest extends EuchreTest {
  private StubPlayerOrder playerOrder;

  @Before
  public void setUp() throws Exception {
    playerOrder = makeStubPlayerOrder();
  }

  @Test
  public void testWinningPlayerDifferentSuitsAllTens() {
    for (int i = 0; i < 4; i++) {
      playTrickAndTestWinner(
              "Trump beats any other suit",
              TENS_CARD_ARRAY[i].getSuit(),
              playerOrder.getPlayerAt(0),
              playerOrder.getPlayerAt(i),
              TENS_CARD_ARRAY
      );
    }
  }

  @Test
  public void testWinningPlayerAllSameSuit() {
    for (int i = 0; i < 4; i++) {
      playTrickAndTestWinner(
              "All same suit (trump), highest value wins.",
              Card.Suit.HEARTS,
              playerOrder.getPlayerAt(i),
              playerOrder.getPlayerAt(2),
              HEARTS_CARD_ARRAY
      );
    }

    for (int i = 0; i < 4; i++) {
      playTrickAndTestWinner(
              "All same suit (not trump), highest value wins.",
              Card.Suit.CLUBS,
              playerOrder.getPlayerAt(i),
              playerOrder.getPlayerAt(2),
              HEARTS_CARD_ARRAY
      );
    }
  }

  @Test
  public void testWinningPlayerTwoSuitsNeitherTrump() {
    playTrickAndTestWinner(
            "No trump played; only leader plays spades; leader wins.",
            Card.Suit.DIAMONDS,
            playerOrder.getPlayerAt(0),
            playerOrder.getPlayerAt(0),
            BLACK_CARD_ARRAY
    );

    for (int i = 1; i < 4; i++) {
      playTrickAndTestWinner(
              "No trump played; clubs lead; player[1] wins.",
              Card.Suit.CLUBS,
              playerOrder.getPlayerAt(i),
              playerOrder.getPlayerAt(1),
              BLACK_CARD_ARRAY
      );
    }
  }

  private void playTrickAndTestWinner(String message,
                                      Card.Suit trump,
                                      Player leadPlayer,
                                      Player winningPlayer,
                                      Card[] providedCards) {
    playerOrder.assignCardsToPlayers(providedCards);
    TrickManager trickman = new TrickManager(new PlayerOrderWithLeader(playerOrder, leadPlayer), trump);
    trickman.playTrick();
    assertEquals(message,
            winningPlayer, trickman.getWinningPlayer());
  }
}
