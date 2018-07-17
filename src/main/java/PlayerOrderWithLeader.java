import java.util.Iterator;

class PlayerOrderWithLeader implements Iterable<Player> {
  private final PlayerOrder playerOrder;
  private final Player leader;

  PlayerOrderWithLeader(PlayerOrder playerOrder, Player leader) {
    this.playerOrder = playerOrder;
    this.leader = leader;
  }

  public PlayerOrder getPlayerOrder() {
    return playerOrder;
  }

  public Player getLeader() {
    return leader;
  }

  @Override
  public Iterator<Player> iterator() {
    return playerOrder.createIterator(leader);
  }

  public PlayerOrderWithLeader cloneWithNewLeader(Player newLeader) {
    return new PlayerOrderWithLeader(playerOrder, newLeader);
  }

}
