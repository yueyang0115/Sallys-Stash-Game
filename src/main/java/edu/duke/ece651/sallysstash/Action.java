package edu.duke.ece651.sallysstash;
import java.util.Scanner;
import jdk.nashorn.api.tree.WhileLoopTree;
public class Action {
  private Board board;
  public Action(Board myboard) {
    this.board = myboard;
  }

  public void putAllStack(char name, char oppo_name) {
    int id = 0;
    myUtils.WELCOME(name, oppo_name);
    putStack(2, 'G', id, name, "Green");
    putStack(3, 'P', id, name, "Purple");
    putStack(3, 'R', id, name, "Red");
    putStack(2, 'B', id, name, "Blue");
  }

  private void putStack(int num, char color, int id, char name, String colorname) {
    int count = 0;
    while (count != num) {
      BoardDrawer.drawOne(this.board);
      myUtils.ASK_PUT(name, colorname);
      Scanner input = new Scanner(System.in);
      String myString = input.next();

      InputHandler myhandler = new InputHandler(myString, this.board);
      myhandler.CheckThreeBits(color);
      if (myhandler.getValid() == 1) {
        Rectangle stack = new Rectangle(myhandler.getHeight(), myhandler.getWidth(), color, id);
        stack.putonBoard(myhandler.getCoordinateX(), myhandler.getCoordinateY(), this.board);
        count++;
        id++;
      }
    }
  }

  public int hitBoard(Board oppo_board, char name, char oppo_name) {
    int num = 0;
    int hit_flag = 0;
    myUtils.HIT_WELCOME(name, oppo_name);

    while (num != 1) {
      BoardDrawer.drawTwo(this.board, oppo_board, oppo_name);
      myUtils.ASK_HIT(name, oppo_name);
      Scanner input = new Scanner(System.in);
      String myString = input.next();
      InputHandler myhandler = new InputHandler(myString, oppo_board);
      myhandler.CheckTwoBits();
      if (myhandler.getValid() == 1) {
        Pixel mypixel = oppo_board.getPixel(myhandler.getCoordinateX(), myhandler.getCoordinateY());
        if (mypixel.getOccupied() == 1) {
          mypixel.setHitted(1);
          hit_flag = 1;
          myUtils.IS_HIT();
        } else {
          mypixel.setMissed(1);
          myUtils.IS_MISS();
        }
        num++;
      }
    }
    return hit_flag;
  }
}
