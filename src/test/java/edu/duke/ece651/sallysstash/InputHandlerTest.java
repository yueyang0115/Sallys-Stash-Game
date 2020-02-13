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
    handler.CheckThreeBits('G');
    int valid = handler.getValid();
    int x = handler.getCoordinateX();
    int y = handler.getCoordinateY();
    char direc = handler.getDirection();
    System.out.println("x=" + x);
    System.out.println("y=" + y);
    System.out.println("direc=" + direc);
    System.out.println("valid=" + valid);

    String myString2 = "2pj";
    InputHandler handler_2 = new InputHandler(myString2, myboard);
    handler_2.CheckThreeBits('G');
    int valid_2 = handler_2.getValid();
    System.out.println("valid2=" + valid_2);

    String myString3 = "m4hh";
    InputHandler handler_3 = new InputHandler(myString3, myboard);
    handler_3.CheckThreeBits('G');
    int valid_3 = handler_3.getValid();
    System.out.println("valid3=" + valid_3);

    String myString4 = "M00";
    InputHandler handler_4 = new InputHandler(myString4, myboard);
    handler_4.CheckThreeBits('G');
    int valid_4 = handler_4.getValid();
    System.out.println("valid4=" + valid_4);
  }
}
