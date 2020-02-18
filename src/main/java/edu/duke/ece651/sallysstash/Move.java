package edu.duke.ece651.sallysstash;

public class Move {
  Board board;
  public Move(Board myboard) {
    this.board = myboard;
  }

  public void clear(int x, int y) {
    int id = board.getPixel(x, y).getID();
  }
}
