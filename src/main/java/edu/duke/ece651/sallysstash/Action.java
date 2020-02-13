package edu.duke.ece651.sallysstash;
import java.util.Scanner;
public class Action {
  private Board board;
  public Action(Board myboard) {
    this.board = myboard;
  }

  public void putAllStack(String player_A, String player_B) {
    int id = 0;
    BoardDrawer.drawOne(this.board);
    myUtils.WELCOME(player_A, player_B);
    putStack(2, 'G', id, player_A, "Green");
    putStack(3, 'P', id, player_A, "Purple");
    putStack(3, 'R', id, player_A, "Red");
    putStack(2, 'B', id, player_A, "Blue");
  }

  private void putStack(int num, char color, int id, String player, String colorname) {
    int count = 0;
    while (count != num) {
      myUtils.ASK_PUT(player, colorname);
      Scanner input = new Scanner(System.in);
      String myString = input.next();

      InputHandler myhandler = new InputHandler(myString, color, this.board);
      if (myhandler.getValid() == 1) {
        Rectangle stack = new Rectangle(myhandler.getHeight(), myhandler.getWidth(), color, id);
        stack.putonBoard(myhandler.getCoordinateX(), myhandler.getCoordinateY(), this.board);

        BoardDrawer.drawOne(this.board);
        count++;
        id++;
      }
    }
  }

  public void getHitted() {}
}
