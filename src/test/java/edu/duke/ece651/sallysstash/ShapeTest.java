package edu.duke.ece651.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ShapeTest {
  @Test
  public void test_shapeprint() {
    System.out.println("This is my test case!\n");

    Rectangle green = new Rectangle(1, 2, 'g', 1);
    Board myboard1 = new Board();
    green.putonBoard(0, 0, myboard1, 1, 1);
    BoardDrawer.drawOne(myboard1);
    assertEquals(myboard1.getPixel(0, 1).getID(), 1);
    assertEquals(myboard1.getPixel(0, 1).getColor(), 'g');

    Rectangle purple = new Rectangle(1, 3, 'p', 2);
    purple.putonBoard(1, 0, myboard1, 1, 1);
    BoardDrawer.drawOne(myboard1);

    Rectangle green2 = new Rectangle(3, 5, 'p', 1);
    Board myboard2 = new Board();
    green2.putonBoard(2, 3, myboard2, 1, 1);
    myboard1.getPixel(6, 6).setHitted(1);
    myboard2.getPixel(4, 5).setMissed(1);
    assertEquals(myboard2.getPixel(4, 5).getMissed(), 1);
    myboard2.getPixel(3, 4).setHitted(1);
    assertEquals(myboard2.getPixel(3, 4).getHitted(), 1);

    BoardDrawer.drawTwo(myboard1, myboard2, 'B');
    BoardDrawer.drawTwo(myboard2, myboard1, 'A');
  }
}
