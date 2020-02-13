package edu.duke.ece651.sallysstash;

public class Board {
  private Pixel[][] board;
  private int heighth;
  private int width;

  public Board() {
    heighth = 20;
    width = 10;
    board = new Pixel[heighth][width];
    for (int i = 0; i < heighth; i++) {
      for (int j = 0; j < width; j++) {
        board[i][j] = new Pixel();
      }
    }
  }

  public Pixel getPixel(int x, int y) {
    return board[x][y];
  }

  public int getHeighth() {
    return this.heighth;
  }
  public int getWidth() {
    return this.width;
  }
}
