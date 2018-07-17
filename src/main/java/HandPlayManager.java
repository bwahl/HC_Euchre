import java.util.HashMap;
import java.util.Map;

public class HandPlayManager {

  private final Dealer dealer;
  private final PlayerOrderWithLeader players;
  private final Card.Suit trump;
  private final Map<Player, Integer> tricksWon;

  public HandPlayManager(Dealer dealer, PlayerOrderWithLeader players, Card.Suit trump) {
    this.dealer = dealer;
    this.trump = trump;
    this.players = players;
    tricksWon = new HashMap<>();
    initializeTricksWon();
  }

  private void initializeTricksWon() {
    for (Player player : players) {
      tricksWon.put(player, 0);
    }
  }

  public Map<Player, Integer> getTricksWon() {
    return tricksWon;
  }

}

