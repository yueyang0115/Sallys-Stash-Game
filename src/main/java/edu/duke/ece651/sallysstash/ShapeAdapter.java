package edu.duke.ece651.sallysstash;

import java.util.HashMap;

public class ShapeAdapter {
  public static HashMap<String, int[]> RectangleMap;
  static {
    RectangleMap = new HashMap<String, int[]>();
    int[] gHpair = {1, 2};
    RectangleMap.put("GH", gHpair);
    int[] gVpair = {2, 1};
    RectangleMap.put("GV", gVpair);
    int[] pHpair = {1, 3};
    RectangleMap.put("PH", pHpair);
    int[] pVpair = {3, 1};
    RectangleMap.put("PV", pVpair);
    int[] rHpair = {1, 4};
    RectangleMap.put("RH", rHpair);
    int[] rVpair = {4, 1};
    RectangleMap.put("RV", rVpair);
    int[] bHpair = {1, 6};
    RectangleMap.put("BH", bHpair);
    int[] bVpair = {6, 1};
    RectangleMap.put("BV", bVpair);
  }

  private int x;
  private int y;
  private char color;
  private char direction;
  private String shape;
  private Board board;
  private int id;
  private int is_valid;

  public ShapeAdapter(int my_x, int my_y, char mycolor, char mydirection, Board myboard, int myid) {
    this.x = my_x;
    this.y = my_y;
    this.color = mycolor;
    this.direction = mydirection;
    this.board = myboard;
    this.shape = Character.toString(this.color) + Character.toString(this.direction);
    this.id = myid;
    init();
  }

  private void init() {
    if (RectangleMap.get(shape) != null) {
      int height = RectangleMap.get(shape)[0];
      int width = RectangleMap.get(shape)[1];

      this.is_valid = CheckRectangle(height, width);
      if (this.is_valid == 1) {
        Rectangle stack = new Rectangle(height, width, this.color, this.id);
        stack.putonBoard(this.x, this.y, this.board);
      }
    }
  }

  private int CheckRectangle(int height, int width) {
    int is_valid = 0;

    if ((x >= 0 && x < board.getHeighth())
        && ((x + height - 1) >= 0 && (x + height - 1) < board.getHeighth())
        && (y >= 0 && y < board.getWidth())
        && ((y + width - 1) >= 0 && (y + width - 1) < board.getWidth())) {
      is_valid = 1;
    }
    if (is_valid == 0) {
      System.out.println("\nInvalid location, stack goes off the grid. Please retype!");
      return is_valid;
    }

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (board.getPixel(x + i, y + j).getOccupied() == 1) {
          is_valid = 0;
        }
      }
    }
    if (is_valid == 0) {
      System.out.println(
          "\nInvalid location, stack collides with other stacks on board. Please retype!");
    }
    return is_valid;
  }

  public int getValid() {
    return this.is_valid;
  }
}
