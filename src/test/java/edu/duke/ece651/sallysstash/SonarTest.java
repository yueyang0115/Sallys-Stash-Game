package edu.duke.ece651.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class SonarTest {
  @Test
  public void test_sonar() {
    HashMap<Character, Integer> numMap = new HashMap<Character, Integer>();
    HashMap<Character, Integer> numMap2 = new HashMap<Character, Integer>();
    HashMap<Character, Integer> numMap3 = new HashMap<Character, Integer>();
    Board board = new Board();
    ShapeAdapter adapter = new ShapeAdapter(3, 3, 'G', 'H', board, 1);
    adapter.Create();
    BoardDrawer.drawOne(board);
    numMap = Player.InsideDiamond(3, 8, board);
    assertEquals(numMap.get('G'), 0);

    numMap2 = Player.InsideDiamond(3, 6, board);
    assertEquals(numMap2.get('G'), 2);

    numMap3 = Player.InsideDiamond(6, 4, board);
    assertEquals(numMap3.get('G'), 1);
  }

  @Test
  public void test_sonar2() {
    Board board = new Board();
    for (int i = 4; i < 7; i++) {
      for (int j = 3; j < 8; j++) {
        board.getPixel(i, j).setOccupied(1);
        board.getPixel(i, j).setColor('G');
      }
    }
    for (int i = 3; i < 8; i++) {
      for (int j = 4; j < 7; j++) {
        board.getPixel(i, j).setOccupied(1);
        board.getPixel(i, j).setColor('G');
      }
    }
    board.getPixel(2, 5).setOccupied(1);
    board.getPixel(2, 5).setColor('R');
    board.getPixel(5, 2).setOccupied(1);
    board.getPixel(5, 2).setColor('B');
    board.getPixel(5, 8).setOccupied(1);
    board.getPixel(5, 8).setColor('R');
    board.getPixel(8, 5).setOccupied(1);
    board.getPixel(8, 5).setColor('P');

    BoardDrawer.drawOne(board);
    HashMap<Character, Integer> numMap = new HashMap<Character, Integer>();
    numMap = Player.InsideDiamond(5, 5, board);
    assertEquals(numMap.get('G'), 21);
    assertEquals(numMap.get('P'), 1);
    assertEquals(numMap.get('R'), 2);
    assertEquals(numMap.get('B'), 1);
  }

  @Test
  public void test_sonar3() {
    Board board = new Board();

    board.getPixel(1, 5).setOccupied(1);
    board.getPixel(1, 5).setColor('G');
    board.getPixel(9, 5).setOccupied(1);
    board.getPixel(9, 5).setColor('G');
    board.getPixel(5, 1).setOccupied(1);
    board.getPixel(5, 1).setColor('G');
    board.getPixel(5, 9).setOccupied(1);
    board.getPixel(5, 9).setColor('G');

    board.getPixel(2, 4).setOccupied(1);
    board.getPixel(2, 4).setColor('G');
    board.getPixel(3, 3).setOccupied(1);
    board.getPixel(3, 3).setColor('G');
    board.getPixel(4, 2).setOccupied(1);
    board.getPixel(4, 2).setColor('G');

    board.getPixel(6, 2).setOccupied(1);
    board.getPixel(6, 2).setColor('G');
    board.getPixel(7, 3).setOccupied(1);
    board.getPixel(7, 3).setColor('G');
    board.getPixel(8, 4).setOccupied(1);
    board.getPixel(8, 4).setColor('G');

    board.getPixel(8, 6).setOccupied(1);
    board.getPixel(8, 6).setColor('G');
    board.getPixel(7, 7).setOccupied(1);
    board.getPixel(7, 7).setColor('G');
    board.getPixel(6, 8).setOccupied(1);
    board.getPixel(6, 8).setColor('G');

    board.getPixel(4, 8).setOccupied(1);
    board.getPixel(4, 8).setColor('G');
    board.getPixel(3, 7).setOccupied(1);
    board.getPixel(3, 7).setColor('G');
    board.getPixel(2, 6).setOccupied(1);
    board.getPixel(2, 6).setColor('G');

    BoardDrawer.drawOne(board);
    HashMap<Character, Integer> numMap = new HashMap<Character, Integer>();
    numMap = Player.InsideDiamond(5, 5, board);
    assertEquals(numMap.get('G'), 0);
  }
}
