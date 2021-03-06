import java.util.Iterator;

public class PlayerOrder {
  Player[] players;

  public PlayerOrder(Player p0, Player p1, Player p2, Player p3) {
    players = new Player[4];
    players[0] = p0;
    players[1] = p1;
    players[2] = p2;
    players[3] = p3;
  }

  public PlayerOrderIterator createIterator(Player start) {
    return new PlayerOrderIterator(start);
  }

  public Player nextPlayer(Player p) {
    int i = this.indexOf(p);
    return players[nextIndex(i)];
  }

  private int indexOf(Player p) {
    for (int i = 0; i < 4; i++) {
      if (players[i] == p) { return i; }
    }
    return -1;
  }

  private int nextIndex(int i) {
    return (i + 1) % 4;
  }

  class PlayerOrderIterator implements Iterator<Player> {

    private final Player start;
    private Player current;

    private PlayerOrderIterator(Player start) {
      this.start = start;
      this.current = null;
    }

    @Override
    public boolean hasNext() {
      if (current == null) {
        current = start;
        return true;
      }
      current = nextPlayer(current);
      return (current != start);
    }

    @Override
    public Player next() {
      return current;
    }
  }
}
