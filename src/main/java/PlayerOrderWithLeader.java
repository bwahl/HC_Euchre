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
    return new PlayerOrderIterator(playerOrder, leader);
  }

  private class PlayerOrderIterator implements Iterator<Player> {

    private final PlayerOrder order;
    private final Player start;
    private Player current;

    public PlayerOrderIterator(PlayerOrder order, Player start) {
      this.order = order;
      this.start = start;
      this.current = null;
    }

    @Override
    public boolean hasNext() {
      if (current == null) {
        current = start;
        return true;
      }
      current = order.nextPlayer(current);
      return (current != start);
    }

    @Override
    public Player next() {
      return current;
    }
  }
}
