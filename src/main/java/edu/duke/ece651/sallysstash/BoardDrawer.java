package edu.duke.ece651.sallysstash;

public class BoardDrawer {
  private Board board_one;
  private Board board_two;
  private LineDrawer drawer_one;
  private LineDrawer drawer_two;

  public BoardDrawer(Board myboard_one, Board myboard_two) {
    this.board_one = myboard_one;
    this.board_two = myboard_two;
    drawer_one = new LineDrawer(myboard_one);
    drawer_two = new LineDrawer(myboard_two);
  }

  public BoardDrawer(Board myboard_one) {
    this.board_one = myboard_one;
    drawer_one = new LineDrawer(myboard_one);
  }

  public void DrawtwoBoard() {
    System.out.print("      Your tree"
        + "\t\t\t"
        + "    Player B's tree");
    System.out.print("\n");
    for (int i = 0; i < board_one.getLength(); i++) {
      char temp = (char) ('A' + i);
      System.out.print(temp + "|");
      drawer_one.toSelf(i);
      System.out.print(temp + "\t\t" + temp + "|");
      drawer_two.toOther(i);
      System.out.print(temp + "\n");
    }
  }

  public void DrawoneBoard() {
    System.out.print("      Your tree\n");
    for (int i = 0; i < board_one.getLength(); i++) {
      char temp = (char) ('A' + i);
      System.out.print(temp + "|");
      drawer_one.toSelf(i);
      System.out.print(temp + "\n");
    }
  }
}
