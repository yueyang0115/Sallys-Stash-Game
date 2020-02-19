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
}
