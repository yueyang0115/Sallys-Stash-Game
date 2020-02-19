package edu.duke.ece651.sallysstash;
import java.util.Scanner;

public class Action {
  private Board board;
  private int move_remain;
  private int sonar_remain;
  public Action(Board myboard) {
    this.board = myboard;
    this.move_remain = 3;
    this.sonar_remain = 3;
  }

  public void putAllStack(char name, char oppo_name) {
    int id = 0;
    myUtils.WELCOME(name, oppo_name);
    BoardDrawer.drawOne(this.board);
    putStack(2, 'G', id, name, "Green");
    // putStack(3, 'P', id, name, "Purple");
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

  public void ActionSelect(Board oppo_board, char name, char oppo_name) {
    int action_valid = 0;
    while (true) {
      myUtils.ASK_ACTION(name, move_remain, sonar_remain);
      BoardDrawer.drawTwo(this.board, oppo_board, oppo_name);
      Scanner scanner = new Scanner(System.in);
      String myString = scanner.next();
      if (myString.equals("D") || myString.equals("d")) {
        action_valid = hitBoard(scanner, oppo_board, name, oppo_name);
      } else if ((myString.equals("M") || myString.equals("m")) && this.move_remain != 0) {
        action_valid = MoveStack(scanner, oppo_board, name, oppo_name);
        if (action_valid == 1) {
          this.move_remain--;
        }
      } else if ((myString.equals("S") || myString.equals("s")) && this.sonar_remain != 0) {
      } else {
        System.out.print("\nInvalid input.");
        myUtils.GOBACK();
      }
      if (action_valid == 1) {
        break;
      }
    }
  }

  private int hitBoard(Scanner scanner, Board oppo_board, char name, char oppo_name) {
    myUtils.HIT_WELCOME(name, oppo_name);
    BoardDrawer.drawTwo(this.board, oppo_board, oppo_name);
    myUtils.ASK_HIT(name, oppo_name);
    String myString = scanner.next();
    InputHandler myhandler = new InputHandler(myString, oppo_board);
    myhandler.CheckTwoBits();
    if (myhandler.getValid() == 0) {
      myUtils.GOBACK();
      return 0;
    }

    Pixel mypixel = oppo_board.getPixel(myhandler.getCoordinateX(), myhandler.getCoordinateY());
    if (mypixel.getOccupied() == 1) {
      mypixel.setHitted(1);
      myUtils.IS_HIT();
    } else {
      mypixel.setMissed(1);
      myUtils.IS_MISS();
    }
    return 1;
  }

  private int MoveStack(Scanner scanner, Board oppo_board, char name, char oppo_name) {
    myUtils.ASK_MOVE(name, oppo_name);
    BoardDrawer.drawTwo(this.board, oppo_board, oppo_name);
    String choice = scanner.next();
    InputHandler choice_handler = new InputHandler(choice, board);
    choice_handler.CheckTwoBits();
    if (choice_handler.getValid() == 0) {
      myUtils.GOBACK();
      return 0;
    }
    int x = choice_handler.getCoordinateX();
    int y = choice_handler.getCoordinateY();
    char color = board.getPixel(x, y).getColor();
    int id = board.getPixel(x, y).getID();

    myUtils.ASK_MOVE_TO(name);
    String location = scanner.next();
    InputHandler location_handler = new InputHandler(location, board);
    location_handler.CheckThreeBits();
    if (location_handler.getValid() == 0) {
      myUtils.GOBACK();
      return 0;
    }
    int new_x = location_handler.getCoordinateX();
    int new_y = location_handler.getCoordinateY();
    char direction = location_handler.getDirection();
    ShapeAdapter myadapter = new ShapeAdapter(new_x, new_y, color, direction, this.board, id);
    if (myadapter.getValid() == 0) {
      myUtils.GOBACK();
      return 0;
    }

    Move mymove = new Move(this.board);
    mymove.Clear(x, y);
    myadapter.Move(mymove.getHitset());
    return 1;
  }

  public int CountHitted() {
    int hit_count = 0;
    for (int i = 0; i < board.getHeighth(); i++) {
      for (int j = 0; j < board.getWidth(); j++) {
        if (board.getPixel(i, j).getHitted() == 1) {
          hit_count++;
        }
      }
    }
    return hit_count;
  }
}
