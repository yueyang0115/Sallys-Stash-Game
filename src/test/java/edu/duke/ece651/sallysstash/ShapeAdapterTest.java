package edu.duke.ece651.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ShapeAdapterTest {
  @Test
  public void test_shapeadapter() {
    Board myboard = new Board();
    ShapeAdapter myadapter = new ShapeAdapter(2, 1, 'G', 'H', myboard, 3);
    assertEquals(myadapter.getValid(), 1);
    assertEquals(myboard.getPixel(2, 2).getOccupied(), 1);

    ShapeAdapter myadapter_2 = new ShapeAdapter(2, 9, 'G', 'H', myboard, 3);
    assertEquals(myadapter_2.getValid(), 0);
    assertEquals(myboard.getPixel(2, 9).getOccupied(), 0);

    ShapeAdapter myadapter_3 = new ShapeAdapter(2, 2, 'G', 'H', myboard, 3);
    assertEquals(myadapter_3.getValid(), 0);
    BoardDrawer.drawOne(myboard);
  }
}
