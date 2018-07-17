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

  public void playHand(int numCards) {
    dealer.reset();
    dealer.deal(players, numCards);
    Player currLeader = players.getLeader();
    Player winningPlayer = null;
    for (int i = 0; i < numCards; i++) {
      winningPlayer = playTrickAndGetWinner(currLeader);
      incrementTricksWonForPlayer(winningPlayer);
      currLeader = winningPlayer;
    }
  }

  private Player playTrickAndGetWinner(Player currLeader) {
    Player winningPlayer;
    PlayerOrderWithLeader playerOrder = players.cloneWithNewLeader(currLeader);
    TrickManager trickManager = new TrickManager(playerOrder, trump);
    trickManager.playTrick();
    winningPlayer = trickManager.getWinningPlayer();
    return winningPlayer;
  }

  private void incrementTricksWonForPlayer(Player winningPlayer) {
    tricksWon.replace(winningPlayer, tricksWon.get(winningPlayer) + 1);
  }

  public int getTricksWonBy(Player player) {
    return (int)tricksWon.get(player);
  }
}

