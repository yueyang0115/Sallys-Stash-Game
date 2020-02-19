package edu.duke.ece651.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ShapeAdapterTest {
  @Test
  public void test_shapeadapter() {
    Board myboard = new Board();
    ShapeAdapter myadapter = new ShapeAdapter(2, 1, 'G', 'H', myboard, 3);
    assertEquals(myadapter.getValid(), 1);
    assertEquals(myboard.getPixel(2, 2).getOccupied(), 0);
    myadapter.Create();
    assertEquals(myboard.getPixel(2, 2).getOccupied(), 1);

    ShapeAdapter myadapter_2 = new ShapeAdapter(2, 9, 'G', 'H', myboard, 4);
    assertEquals(myadapter_2.getValid(), 0);
    assertEquals(myboard.getPixel(2, 9).getOccupied(), 0);

    ShapeAdapter myadapter_3 = new ShapeAdapter(2, 2, 'G', 'H', myboard, 5);
    assertEquals(myadapter_3.getValid(), 0);

    ShapeAdapter myadapter_4 = new ShapeAdapter(2, 2, 'G', 'R', myboard, 6);
    assertEquals(myadapter_4.getValid(), 0);

    BoardDrawer.drawOne(myboard);
    ShapeAdapter myadapter_5 = new ShapeAdapter(2, 4, 'G', 'V', myboard, 7);
    assertEquals(myadapter_5.getValid(), 1);

    ShapeAdapter myadapter_6 = new ShapeAdapter(5, 0, 'R', 'U', myboard, 8);
    assertEquals(myadapter_6.getValid(), 0);
    ShapeAdapter myadapter_7 = new ShapeAdapter(0, 9, 'R', 'R', myboard, 9);
    assertEquals(myadapter_7.getValid(), 0);
    ShapeAdapter myadapter_8 = new ShapeAdapter(19, 0, 'R', 'D', myboard, 10);
    assertEquals(myadapter_8.getValid(), 0);
    ShapeAdapter myadapter_9 = new ShapeAdapter(18, 9, 'R', 'L', myboard, 11);
    assertEquals(myadapter_9.getValid(), 0);

    ShapeAdapter myadapter_10 = new ShapeAdapter(4, 3, 'R', 'U', myboard, 12);
    myadapter_10.Create();
    ShapeAdapter myadapter_11 = new ShapeAdapter(4, 6, 'R', 'R', myboard, 13);
    myadapter_11.Create();
    ShapeAdapter myadapter_12 = new ShapeAdapter(9, 2, 'R', 'D', myboard, 14);
    myadapter_12.Create();
    ShapeAdapter myadapter_13 = new ShapeAdapter(9, 7, 'R', 'L', myboard, 15);
    myadapter_13.Create();

    BoardDrawer.drawOne(myboard);
  }
}
