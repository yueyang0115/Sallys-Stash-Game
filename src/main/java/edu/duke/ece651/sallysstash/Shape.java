package edu.duke.ece651.sallysstash;

import java.util.HashMap;

interface Shape {
  void putonBoard(int x, int y, Board board);
}

class Rectangle implements Shape {
  int width;
  int height;
  char color;
  int id;

  public Rectangle(int myheight, int mywidth, char mycolor, int myid) {
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
        board.getPixel(x + i, y + j).setID(id);
      }
    }
  }
}

class SuperStack implements Shape {
  private HashMap<int[], int[]> map;
  char color;
  int id;

  public SuperStack(HashMap<int[], int[]> mymap, char mycolor, int myid) {
    this.map = mymap;
    this.color = mycolor;
    this.id = myid;
  }

  @Override
  public void putonBoard(int x, int y, Board board) {
    for (HashMap.Entry<int[], int[]> entry : map.entrySet()) {
      int x_offset = entry.getKey()[0];
      int y_offset = entry.getKey()[1];
      int height = entry.getValue()[0];
      int width = entry.getValue()[1];
      Rectangle rectangle = new Rectangle(height, width, this.color, this.id);
      rectangle.putonBoard(x + x_offset, y + y_offset, board);
    }
  }
}
