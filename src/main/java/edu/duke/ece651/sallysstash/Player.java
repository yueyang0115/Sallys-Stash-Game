package edu.duke.ece651.sallysstash;
import java.util.HashMap;
import java.util.Scanner;

public class Player {
  public Board board;
  public Scanner scanner;
  public int move_remain;
  public int sonar_remain;
  public Player(Scanner myscanner, Board myboard) {
    this.board = myboard;
    this.scanner = myscanner;
    this.move_remain = 3;
    this.sonar_remain = 3;
  }

  public void putAllStack(char name, char oppo_name) {
    myUtils.WELCOME(name, oppo_name);
    BoardDrawer.drawOne(this.board);
    putStack(2, 'G', 0, name, "Green");
    putStack(3, 'P', 2, name, "Purple");
    putStack(3, 'R', 5, name, "Red");
    putStack(3, 'B', 8, name, "Blue");
  }

  public void putStack(int num, char color, int id, char name, String colorname) {
    int count = 0;
    while (count != num) {
      myUtils.ASK_PUT(name, colorname);
      String myString = this.scanner.next();
      InputHandler myhandler = new InputHandler(myString, this.board);
      myhandler.CheckThreeBits();
      if (myhandler.getValid() == 0) {
        myUtils.IS_INVALID();
        continue;
      }

      ShapeAdapter myadapter = new ShapeAdapter(myhandler.getCoordinateX(),
          myhandler.getCoordinateY(), color, myhandler.getDirection(), this.board, id);
      if (myadapter.getValid() == 0) {
        myUtils.IS_INVALID();
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
    while (action_valid == 0) {
      myUtils.ASK_ACTION(name, move_remain, sonar_remain);
      BoardDrawer.drawTwo(this.board, oppo_board, oppo_name);
      String myString = this.scanner.next();
      if (myString.equals("D") || myString.equals("d")) {
        action_valid = hitBoard(this.scanner, oppo_board, name, oppo_name);
      } else if ((myString.equals("M") || myString.equals("m")) && this.move_remain != 0) {
        action_valid = MoveStack(this.scanner, oppo_board, name, oppo_name);
        this.move_remain -= action_valid;
      } else if ((myString.equals("S") || myString.equals("s")) && this.sonar_remain != 0) {
        action_valid = SonarStack(this.scanner, oppo_board, name, oppo_name);
        this.sonar_remain -= action_valid;
      } else {
        myUtils.GOBACK();
      }
    }
  }

  public int hitBoard(Scanner scanner, Board oppo_board, char name, char oppo_name) {
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

  public int MoveStack(Scanner scanner, Board oppo_board, char name, char oppo_name) {
    myUtils.ASK_MOVE(name, oppo_name);
    BoardDrawer.drawTwo(this.board, oppo_board, oppo_name);
    String mychoice = scanner.next();
    InputHandler choice = new InputHandler(mychoice, board);
    choice.CheckTwoBits();
    if (choice.getValid() == 0) {
      myUtils.GOBACK();
      return 0;
    }
    Pixel mypixel = board.getPixel(choice.getCoordinateX(), choice.getCoordinateY());
    if (mypixel.getOccupied() == 0) {
      myUtils.NOSTACK();
      return 0;
    }

    char color = board.getPixel(choice.getCoordinateX(), choice.getCoordinateY()).getColor();
    int id = board.getPixel(choice.getCoordinateX(), choice.getCoordinateY()).getID();

    myUtils.ASK_MOVE_TO(name);
    String mylocation = scanner.next();
    InputHandler location = new InputHandler(mylocation, board);
    location.CheckThreeBits();
    if (location.getValid() == 0) {
      myUtils.GOBACK();
      return 0;
    }

    ShapeAdapter myadapter = new ShapeAdapter(location.getCoordinateX(), location.getCoordinateY(),
        color, location.getDirection(), this.board, id);
    if (myadapter.getValid() == 0) {
      myUtils.GOBACK();
      return 0;
    }

    Move mymove = new Move(this.board);
    mymove.Clear(choice.getCoordinateX(), choice.getCoordinateY());
    myadapter.Move(mymove.getHitset());
    return 1;
  }

  public int SonarStack(Scanner scanner, Board oppo_board, char name, char oppo_name) {
    HashMap<Character, Integer> numMap = new HashMap<Character, Integer>();
    myUtils.ASK_SONAR(name, oppo_name);
    String input = scanner.next();
    InputHandler handler = new InputHandler(input, board);
    handler.CheckTwoBits();
    if (handler.getValid() == 0) {
      myUtils.GOBACK();
      return 0;
    }

    int x = handler.getCoordinateX();
    int y = handler.getCoordinateY();
    numMap = InsideDiamond(x, y, oppo_board);
    myUtils.SONAR_RESULT(numMap.get('G'), numMap.get('P'), numMap.get('R'), numMap.get('B'));
    return 1;
  }

  public static HashMap<Character, Integer> InsideDiamond(int x, int y, Board oppo_board) {
    HashMap<Character, Integer> numMap = new HashMap<Character, Integer>();
    numMap.put('G', 0);
    numMap.put('P', 0);
    numMap.put('R', 0);
    numMap.put('B', 0);
    for (int i = 0; i < oppo_board.getHeighth(); i++) {
      for (int j = 0; j < oppo_board.getWidth(); j++) {
        Pixel mypixel = oppo_board.getPixel(i, j);
        if ((Math.abs(i - x) * 6 + Math.abs(j - y) * 6 <= 18) && (mypixel.getOccupied() == 1)) {
          char color = mypixel.getColor();
          int temp_num = numMap.get(color);
          numMap.replace(color, temp_num + 1);
        }
      }
    }
    return numMap;
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
