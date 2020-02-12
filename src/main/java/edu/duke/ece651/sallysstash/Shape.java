package edu.duke.ece651.sallysstash;

interface Shape {
  void putonBoard(int x, int y, Board board);
}

class Rectangle implements Shape {
  int width;
  int height;
  char color;
  int id;

  public Rectangle(int mywidth, int myheight, char mycolor, int myid) {
    this.width = mywidth;
    this.height = myheight;
    this.color = mycolor;
    this.id = myid;
  }

  @Override
  public void putonBoard(int x, int y, Board board) {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        board.getPixel(x + i, y + j).setOccupied(1);
        board.getPixel(x + i, y + j).setColor(color);
      }
    }
  }
}
