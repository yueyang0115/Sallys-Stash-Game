package edu.duke.ece651.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ShapeTest {
  @Test
  public void test_shapeprint() {
    System.out.println("This is my test case!\n");
    Rectangle green = new Rectangle(1, 2, 'g', 1);
    Board myboard1 = new Board();
    green.putonBoard(0, 0, myboard1);
    /*Rectangle green2 = new Rectangle(3, 5, 'p', 1);
    Board myboard2 = new Board();
    green2.putonBoard(2, 3, myboard2);
    myboard2.getPixel(4, 5).setMissed(1);
    myboard2.getPixel(3, 4).setHitted(1);*/
    // myboard1.getPixel(6, 6).setHitted(1);

    // BoardDrawer drawer = new BoardDrawer(myboard1, myboard2);
    // drawer.DrawtwoBoard();
    BoardDrawer drawer2 = new BoardDrawer(myboard1);
    drawer2.DrawoneBoard();

    Rectangle purple = new Rectangle(1, 3, 'p', 2);
    purple.putonBoard(1, 0, myboard1);
    drawer2.DrawoneBoard();
  }
}
