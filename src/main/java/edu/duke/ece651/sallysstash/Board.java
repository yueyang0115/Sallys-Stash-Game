package edu.duke.ece651.sallysstash;

public class Board {
  private Pixel[][] board;
  private int length;
  private int width;

  public Board() {
    length = 20;
    width = 10;
    board = new Pixel[length][width];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < width; j++) {
        board[i][j] = new Pixel();
      }
    }
  }

  public Pixel getPixel(int x, int y) {
    return board[x][y];
  }

  public int getLength() {
    return this.length;
  }
  public int getWidth() {
    return this.width;
  }

  public void moveStack(int i, int j) {}
}
