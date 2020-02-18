package edu.duke.ece651.sallysstash;

import java.util.HashMap;
import java.util.HashSet;

interface Shape {
  // void putonBoard(int x, int y, Board board);
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

  // @Override
  public void putonBoard(int x, int y, Board board, int order_begin, int order_flip) {
    int count = 0;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        board.getPixel(x + i, y + j).setOccupied(1);
        board.getPixel(x + i, y + j).setColor(color);
        board.getPixel(x + i, y + j).setID(id);
        board.getPixel(x + i, y + j).setOrder(order_begin + count * order_flip);
        count++;
      }
    }
  }

  public void movetoBoard(
      int x, int y, Board board, int order_begin, int order_flip, HashSet<Integer> hit_set) {
    int count = 0;
    int order;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        board.getPixel(x + i, y + j).setOccupied(1);
        board.getPixel(x + i, y + j).setColor(color);
        board.getPixel(x + i, y + j).setID(id);
        order = order_begin + count * order_flip;
        board.getPixel(x + i, y + j).setOrder(order);
        if (hit_set.contains(order)) {
          board.getPixel(x + i, y + j).setMoveHitted(1);
        }
        count++;
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

  //@Override
  public void putonBoard(int x, int y, Board board) {
    for (HashMap.Entry<int[], int[]> entry : map.entrySet()) {
      int x_offset = entry.getKey()[0];
      int y_offset = entry.getKey()[1];
      int height = entry.getValue()[0];
      int width = entry.getValue()[1];
      int order_begin = entry.getValue()[2];
      int order_flip = entry.getValue()[3];
      Rectangle rectangle = new Rectangle(height, width, this.color, this.id);
      rectangle.putonBoard(x + x_offset, y + y_offset, board, order_begin, order_flip);
    }
  }

  public void movetoBoard(int x, int y, Board board, HashSet<Integer> hit_set) {
    for (HashMap.Entry<int[], int[]> entry : map.entrySet()) {
      int x_offset = entry.getKey()[0];
      int y_offset = entry.getKey()[1];
      int height = entry.getValue()[0];
      int width = entry.getValue()[1];
      int order_begin = entry.getValue()[2];
      int order_flip = entry.getValue()[3];
      Rectangle rectangle = new Rectangle(height, width, this.color, this.id);
      rectangle.movetoBoard(x + x_offset, y + y_offset, board, order_begin, order_flip, hit_set);
    }
  }
}
