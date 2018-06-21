import java.util.HashMap;
import java.util.Map;

public class HandPlayManager {

  private final Card.Suit trump;
  private final Map<Player, Integer> tricksWon;
  private final PlayerOrderWithLeader players;

  public HandPlayManager(PlayerOrderWithLeader players, Card.Suit trump) {
    this.trump = trump;
    this.players = players;
    tricksWon = new HashMap<>();
    setTricksWonToAllZeroes();
  }

  private void setTricksWonToAllZeroes() {
    for (Player player : players) {
      tricksWon.put(player, 0);
    }
  }

  public Map<Player, Integer> getTricksWon() {
    return tricksWon;
  }

}

