package edu.duke.ece651.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoveTest {
  @Test
  public void test_move() {
    Board board = new Board();
    Rectangle green = new Rectangle(1, 2, 'G', 1);
    green.putonBoard(3, 3, board, 1, 1);

    ShapeAdapter myadapter_10 = new ShapeAdapter(18, 3, 'R', 'U', board, 2);
    myadapter_10.Create();
    ShapeAdapter myadapter_11 = new ShapeAdapter(4, 8, 'R', 'R', board, 3);
    myadapter_11.Create();
    ShapeAdapter myadapter_12 = new ShapeAdapter(9, 2, 'R', 'D', board, 4);
    myadapter_12.Create();
    ShapeAdapter myadapter_13 = new ShapeAdapter(9, 7, 'R', 'L', board, 5);
    myadapter_13.Create();
    board.getPixel(9, 7).setHitted(1);

    BoardDrawer.drawOne(board);
    assertEquals(board.getPixel(3, 3).getOccupied(), 1);
    assertEquals(board.getPixel(3, 4).getOccupied(), 1);

    Move mymove = new Move(board);
    mymove.Clear(3, 3);
    assertEquals(board.getPixel(3, 3).getOccupied(), 0);
    assertEquals(board.getPixel(3, 4).getOccupied(), 0);
    Move mymove2 = new Move(board);
    mymove2.Clear(19, 3);
    Move mymove3 = new Move(board);
    mymove3.Clear(5, 9);
    Move mymove4 = new Move(board);
    mymove4.Clear(10, 3);
    Move mymove5 = new Move(board);
    mymove5.Clear(9, 7);
    ShapeAdapter myadapter = new ShapeAdapter(0, 8, 'R', 'U', board, 5);
    myadapter.Move(mymove5.getHitset());

    ShapeAdapter myadapter2 = new ShapeAdapter(0, 0, 'R', 'R', board, 5);
    myadapter2.Move(mymove5.getHitset());

    ShapeAdapter myadapter3 = new ShapeAdapter(4, 0, 'R', 'D', board, 5);
    myadapter3.Move(mymove5.getHitset());

    ShapeAdapter myadapter4 = new ShapeAdapter(4, 9, 'R', 'L', board, 5);
    myadapter4.Move(mymove5.getHitset());

    BoardDrawer.drawOne(board);
  }

  @Test
  public void test_crazymove() {
    Board board = new Board();

    ShapeAdapter myadapter_10 = new ShapeAdapter(0, 0, 'B', 'U', board, 2);
    myadapter_10.Create();
    ShapeAdapter myadapter_11 = new ShapeAdapter(2, 3, 'B', 'R', board, 3);
    myadapter_11.Create();
    ShapeAdapter myadapter_12 = new ShapeAdapter(6, 1, 'B', 'D', board, 4);
    myadapter_12.Create();
    ShapeAdapter myadapter_13 = new ShapeAdapter(7, 3, 'B', 'L', board, 5);
    myadapter_13.Create();
    board.getPixel(8, 5).setHitted(1);

    BoardDrawer.drawOne(board);
    Move mymove = new Move(board);
    mymove.Clear(2, 1);
    assertEquals(board.getPixel(3, 1).getOccupied(), 0);
    assertEquals(board.getPixel(4, 1).getOccupied(), 0);
    Move mymove2 = new Move(board);
    mymove2.Clear(1, 5);
    Move mymove3 = new Move(board);
    mymove3.Clear(8, 0);
    Move mymove4 = new Move(board);
    mymove4.Clear(8, 5);
    BoardDrawer.drawOne(board);

    ShapeAdapter myadapter = new ShapeAdapter(9, 1, 'B', 'U', board, 5);
    myadapter.Move(mymove4.getHitset());

    ShapeAdapter myadapter2 = new ShapeAdapter(11, 4, 'B', 'R', board, 5);
    myadapter2.Move(mymove4.getHitset());

    ShapeAdapter myadapter3 = new ShapeAdapter(15, 2, 'B', 'D', board, 5);
    myadapter3.Move(mymove4.getHitset());

    ShapeAdapter myadapter4 = new ShapeAdapter(16, 4, 'B', 'L', board, 5);
    myadapter4.Move(mymove4.getHitset());

    BoardDrawer.drawOne(board);
  }
}
