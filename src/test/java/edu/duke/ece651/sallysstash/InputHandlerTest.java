package edu.duke.ece651.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class InputHandlerTest {
  @Test
  public void test_handler() {
    System.out.println("This is my testcase!\n");
    Board myboard = new Board();
    String myString = "a0h";
    InputHandler handler = new InputHandler(myString, myboard);
    handler.CheckThreeBits();
    assertEquals(handler.getValid(), 1);
    assertEquals(handler.getCoordinateX(), 0);
    assertEquals(handler.getCoordinateY(), 0);
    assertEquals(handler.getDirection(), 'H');

    String myString2 = "2pj";
    InputHandler handler_2 = new InputHandler(myString2, myboard);
    handler_2.CheckThreeBits();
    assertEquals(handler_2.getValid(), 0);

    String myString3 = "m4hh";
    InputHandler handler_3 = new InputHandler(myString3, myboard);
    handler_3.CheckThreeBits();
    assertEquals(handler_3.getValid(), 0);

    String myString4 = "M00";
    InputHandler handler_4 = new InputHandler(myString4, myboard);
    handler_4.CheckThreeBits();
    assertEquals(handler_4.getValid(), 0);

    String myString5 = "m4V";
    InputHandler handler_5 = new InputHandler(myString5, myboard);
    handler_5.CheckThreeBits();
    assertEquals(handler_5.getValid(), 1);
    assertEquals(handler_5.getCoordinateX(), 12);
    assertEquals(handler_5.getCoordinateY(), 4);
    assertEquals(handler_5.getDirection(), 'V');

    String myString6 = "s9";
    InputHandler handler_6 = new InputHandler(myString6, myboard);
    handler_6.CheckTwoBits();
    assertEquals(handler_6.getValid(), 1);
    assertEquals(handler_6.getCoordinateX(), 18);
    assertEquals(handler_6.getCoordinateY(), 9);

    String myString7 = "zz";
    InputHandler handler_7 = new InputHandler(myString7, myboard);
    handler_7.CheckTwoBits();
    assertEquals(handler_7.getValid(), 0);
  }
}
