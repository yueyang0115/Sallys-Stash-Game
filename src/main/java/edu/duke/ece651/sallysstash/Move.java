package edu.duke.ece651.sallysstash;

import java.util.HashMap;
import java.util.HashSet;

public class Move {
  public static HashMap<Character, Integer> NumMap = new HashMap<Character, Integer>();
  static {
    NumMap.put('G', 2);
    NumMap.put('P', 3);
    NumMap.put('R', 4);
    NumMap.put('B', 6);
  }
  private Board board;
  private HashSet<Integer> hit_set;

  public Move(Board myboard) {
    this.board = myboard;
    this.hit_set = new HashSet<Integer>();
  }

  public void Clear(int x, int y) {
    int id = board.getPixel(x, y).getID();
    char color = board.getPixel(x, y).getColor();
    int num = NumMap.get(color);
    int count = 0;

    for (int i = 0; i < board.getHeighth(); i++) {
      for (int j = 0; j < board.getWidth(); j++) {
        Pixel mypixel = board.getPixel(i, j);
        if (mypixel.getOccupied() == 1 && mypixel.getID() == id) {
          mypixel.setOccupied(0);
          count++;
          if (mypixel.getHitted() == 1) {
            hit_set.add(mypixel.getOrder());
          }
        }
        if (count == num) {
          return;
        }
      }
    }
  }

  public HashSet<Integer> getHitset() {
    return this.hit_set;
  }
}
