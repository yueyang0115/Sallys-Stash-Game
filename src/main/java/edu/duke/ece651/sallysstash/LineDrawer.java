package edu.duke.ece651.sallysstash;

public class LineDrawer {
  private Board board;

  public LineDrawer(Board myboard) {
    this.board = myboard;
  }

  public void toSelf(int line) {
    for (int i = 0; i < board.getWidth(); i++) {
      Pixel mypixel = board.getPixel(line, i);
      System.out.print(mypixel.getToself());
      System.out.print('|');
    }
  }

  public void toOther(int line) {
    for (int i = 0; i < board.getWidth(); i++) {
      Pixel mypixel = board.getPixel(line, i);
      System.out.print(mypixel.getToother());
      System.out.print('|');
    }
  }
}
