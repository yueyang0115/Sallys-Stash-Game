package edu.duke.ece651.sallysstash;

import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    System.out.println("This is my main method!\n");
    int count = 0;
    int id = 0;
    Board myboard = new Board();
    BoardDrawer drawer = new BoardDrawer(myboard);
    drawer.DrawoneBoard();
    while (count != 6) {
      Scanner input = new Scanner(System.in);
      String myString = input.next();

      InputHandler myhandler = new InputHandler(myString, 'g', myboard);
      System.out.println("myhandler.getValid=" + myhandler.getValid());
      if (myhandler.getValid() == 1) {
        System.out.println("myhandler.getX=" + myhandler.getCoordinateX());
        System.out.println("myhandler.getY=" + myhandler.getCoordinateY());
        System.out.println("myhandler.getHeight=" + myhandler.getHeight());
        System.out.println("myhandler.getWidth=" + myhandler.getWidth());
        Rectangle green = new Rectangle(myhandler.getHeight(), myhandler.getWidth(), 'g', id);
        green.putonBoard(myhandler.getCoordinateX(), myhandler.getCoordinateY(), myboard);
        drawer.DrawoneBoard();
        count++;
        id++;
      }
    }
  }

  /*
  Scanner input = new Scanner(System.in);
  String myString = input.next();
  int x = InputHandler.getCoordinateX(myString);
  int y = InputHandler.getCoordinateY(myString);
  char direc = InputHandler.getDirection(myString);
  System.out.println(x);
  System.out.println(y);
  System.out.println(direc);
  */
}
