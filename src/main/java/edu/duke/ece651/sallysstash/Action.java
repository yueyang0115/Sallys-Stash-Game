package edu.duke.ece651.sallysstash;
import java.util.Scanner;
public class Action {
  private Board board;
  public Action(Board myboard) {
    this.board = myboard;
  }

  public void putAllStack() {
    int id = 0;
    BoardDrawer.drawOne(this.board);
    putStack(2, 'G', id);
    putStack(3, 'P', id);
    putStack(3, 'R', id);
    putStack(2, 'B', id);
  }

  private void putStack(int num, char color, int id) {
    int count = 0;
    while (count != num) {
      Scanner input = new Scanner(System.in);
      String myString = input.next();

      InputHandler myhandler = new InputHandler(myString, color, this.board);
      System.out.println("myhandler.getValid=" + myhandler.getValid());
      if (myhandler.getValid() == 1) {
        System.out.println("myhandler.getX=" + myhandler.getCoordinateX());
        System.out.println("myhandler.getY=" + myhandler.getCoordinateY());
        System.out.println("myhandler.getHeight=" + myhandler.getHeight());
        System.out.println("myhandler.getWidth=" + myhandler.getWidth());
        Rectangle stack = new Rectangle(myhandler.getHeight(), myhandler.getWidth(), color, id);
        stack.putonBoard(myhandler.getCoordinateX(), myhandler.getCoordinateY(), this.board);

        BoardDrawer.drawOne(this.board);
        count++;
        id++;
      }
    }
  }
}
