package edu.duke.ece651.sallysstash;
import java.util.Scanner;

public class Action {
  private Board board;
  public Action(Board myboard) {
    this.board = myboard;
  }

  public void putAllStack(char name, char oppo_name) {
    int id = 0;
    myUtils.WELCOME(name, oppo_name);
    BoardDrawer.drawOne(this.board);
    putStack(2, 'G', id, name, "Green");
    putStack(3, 'P', id, name, "Purple");
    // putStack(3, 'R', id, name, "Red");
    // putStack(3, 'B', id, name, "Blue");
  }

  private void putStack(int num, char color, int id, char name, String colorname) {
    int count = 0;
    while (count != num) {
      myUtils.ASK_PUT(name, colorname);
      Scanner input = new Scanner(System.in);
      String myString = input.next();
      InputHandler myhandler = new InputHandler(myString, this.board);
      myhandler.CheckThreeBits();
      if (myhandler.getValid() == 0) {
        continue;
      }

      ShapeAdapter myadapter = new ShapeAdapter(myhandler.getCoordinateX(),
          myhandler.getCoordinateY(), color, myhandler.getDirection(), this.board, id);
      if (myadapter.getValid() == 0) {
        continue;
      }
      myadapter.Create();
      count++;
      id++;
      BoardDrawer.drawOne(this.board);
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
      if (myhandler.getValid() == 0) {
        continue;
      }

      Pixel mypixel = oppo_board.getPixel(myhandler.getCoordinateX(), myhandler.getCoordinateY());
      if (mypixel.getOccupied() == 1) {
        if (mypixel.getHitted() != 1) {
          hit_flag = 1;
        }
        mypixel.setHitted(1);
        myUtils.IS_HIT();
      } else {
        mypixel.setMissed(1);
        myUtils.IS_MISS();
      }
      num++;
    }
    return hit_flag;
  }

  public void MoveStack() {
    Scanner input = new Scanner(System.in);
    String choice = input.next();
    InputHandler choice_handler = new InputHandler(choice, board);
    choice_handler.CheckTwoBits();
    if (choice_handler.getValid() == 0) {
      return;
    }
    int x = choice_handler.getCoordinateX();
    int y = choice_handler.getCoordinateY();
    char color = board.getPixel(x, y).getColor();
    int id = board.getPixel(x, y).getID();

    Scanner input2 = new Scanner(System.in);
    String location = input2.next();
    InputHandler location_handler = new InputHandler(location, board);
    location_handler.CheckThreeBits();
    if (location_handler.getValid() == 0) {
      return;
    }
    int new_x = location_handler.getCoordinateX();
    int new_y = location_handler.getCoordinateY();
    char direction = location_handler.getDirection();
    ShapeAdapter myadapter = new ShapeAdapter(new_x, new_y, color, direction, this.board, id);
    if (myadapter.getValid() == 0) {
      return;
    }
    Move mymove = new Move(this.board);
    mymove.Clear(x, y);
    myadapter.Move(mymove.getHitset());
  }
}
