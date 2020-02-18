package edu.duke.ece651.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OrderTest {
  @Test
  public void test_order() {
    Board board = new Board();
    ShapeAdapter gh = new ShapeAdapter(0, 0, 'G', 'H', board, 1);
    gh.Create();
    assertEquals(board.getPixel(0, 0).getOrder(), 1);
    assertEquals(board.getPixel(0, 1).getOrder(), 2);

    ShapeAdapter pv = new ShapeAdapter(2, 0, 'P', 'V', board, 2);
    pv.Create();
    assertEquals(board.getPixel(2, 0).getOrder(), 1);
    assertEquals(board.getPixel(3, 0).getOrder(), 2);
    assertEquals(board.getPixel(4, 0).getOrder(), 3);

    ShapeAdapter ru = new ShapeAdapter(6, 1, 'R', 'U', board, 3);
    ru.Create();
    assertEquals(board.getPixel(6, 1).getOrder(), 1);
    assertEquals(board.getPixel(7, 0).getOrder(), 2);
    assertEquals(board.getPixel(7, 1).getOrder(), 3);
    assertEquals(board.getPixel(7, 2).getOrder(), 4);

    ShapeAdapter rr = new ShapeAdapter(6, 4, 'R', 'R', board, 4);
    rr.Create();
    assertEquals(board.getPixel(7, 5).getOrder(), 1);
    assertEquals(board.getPixel(6, 4).getOrder(), 2);
    assertEquals(board.getPixel(7, 4).getOrder(), 3);
    assertEquals(board.getPixel(8, 4).getOrder(), 4);

    ShapeAdapter rd = new ShapeAdapter(9, 0, 'R', 'D', board, 5);
    rd.Create();
    assertEquals(board.getPixel(10, 1).getOrder(), 1);
    assertEquals(board.getPixel(9, 2).getOrder(), 2);
    assertEquals(board.getPixel(9, 1).getOrder(), 3);
    assertEquals(board.getPixel(9, 0).getOrder(), 4);

    ShapeAdapter rl = new ShapeAdapter(9, 5, 'R', 'L', board, 6);
    rl.Create();
    assertEquals(board.getPixel(10, 4).getOrder(), 1);
    assertEquals(board.getPixel(11, 5).getOrder(), 2);
    assertEquals(board.getPixel(10, 5).getOrder(), 3);
    assertEquals(board.getPixel(9, 5).getOrder(), 4);
  }
}
