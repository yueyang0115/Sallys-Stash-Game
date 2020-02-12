package edu.duke.ece651.sallysstash;

import java.util.ArrayList;
import java.util.HashMap;

public class ShapeAdapter {
  public static HashMap<String, int[]> RectangleMap;
  static {
    RectangleMap = new HashMap<String, int[]>();
    int[] gHpair = {1, 2};
    RectangleMap.put("gH", gHpair);
    int[] gVpair = {2, 1};
    RectangleMap.put("gV", gVpair);
    int[] pHpair = {1, 3};
    RectangleMap.put("pH", pHpair);
    int[] pVpair = {3, 1};
    RectangleMap.put("pV", pVpair);
    int[] rHpair = {1, 4};
    RectangleMap.put("rH", rHpair);
    int[] rVpair = {4, 1};
    RectangleMap.put("rV", rVpair);
    int[] bHpair = {1, 6};
    RectangleMap.put("bH", bHpair);
    int[] bVpair = {6, 1};
    RectangleMap.put("bV", bVpair);
  }

  public static int getHeight(String shape) {
    int height = RectangleMap.get(shape)[0];
    return height;
  }
  public static int getWidth(String shape) {
    int width = RectangleMap.get(shape)[1];
    return width;
  }

  public static int LocationCheck(int coordinate_x, int coordinate_y, String shape, Board board) {
    int is_valid = 0;
    if (RectangleMap.get(shape) != null) {
      int height = getHeight(shape);
      int width = getWidth(shape);
      is_valid = CheckRectangle(coordinate_x, coordinate_y, height, width, board);
    }
    return is_valid;
  }

  public static int CheckRectangle(int x, int y, int height, int width, Board board) {
    int is_valid = 0;

    if ((x >= 0 && x < board.getHeighth())
        && ((x + height) >= 0 && (x + height) < board.getHeighth())
        && (y >= 0 && y < board.getWidth())
        && ((y + width) >= 0 && (y + width) < board.getWidth())) {
      is_valid = 1;
    }
    System.out.println("location_valid in shapeadapter after bound check=" + is_valid);
    if (is_valid == 1) {
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          if (board.getPixel(x + i, y + j).getOccupied() == 1) {
            is_valid = 0;
            System.out.println("there is already a block!");
          }
        }
      }
    }
    System.out.println("location_valid in shapeadapter=" + is_valid);
    return is_valid;
  }
}
