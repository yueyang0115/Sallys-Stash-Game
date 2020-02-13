package edu.duke.ece651.sallysstash;

public class BoardDrawer {
  public static void drawTwo(Board board_A, Board board_B, char c) {
    LineDrawer drawer_A = new LineDrawer(board_A);
    LineDrawer drawer_B = new LineDrawer(board_B);

    System.out.print("\n      Your tree"
        + "\t\t\t"
        + "    Player " + c + "'s tree");
    System.out.print("\n");
    System.out.print("  0|1|2|3|4|5|6|7|8|9  \t\t  0|1|2|3|4|5|6|7|8|9\n");
    for (int i = 0; i < board_A.getHeighth(); i++) {
      char temp = (char) ('A' + i);
      System.out.print(temp + "|");
      drawer_A.toSelf(i);
      System.out.print(temp + "\t\t" + temp + "|");
      drawer_B.toOther(i);
      System.out.print(temp + "\n");
    }
    System.out.print("  0|1|2|3|4|5|6|7|8|9  \t\t  0|1|2|3|4|5|6|7|8|9\n");
  }

  public static void drawOne(Board board) {
    LineDrawer drawer = new LineDrawer(board);
    System.out.print("      Your tree\n");
    System.out.print("  0|1|2|3|4|5|6|7|8|9 \n");
    for (int i = 0; i < board.getHeighth(); i++) {
      char temp = (char) ('A' + i);
      System.out.print(temp + "|");
      drawer.toSelf(i);
      System.out.print(temp + "\n");
    }
    System.out.print("  0|1|2|3|4|5|6|7|8|9 \n");
  }
}
