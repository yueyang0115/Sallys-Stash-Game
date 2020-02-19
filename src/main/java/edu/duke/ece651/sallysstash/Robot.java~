package edu.duke.ece651.sallysstash;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Robot extends Player {
  public Robot(Board myboard) {
    super(myboard);
  }

  @Override
  public void putStack(int num, char color, int id, char name, String colorname) {
    int count = 0;
    while (count != num) {
      myUtils.ASK_PUT(name, colorname);
      String myString = GenerateThree(color);
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

  @Override
  public void ActionSelect(Board oppo_board, char name, char oppo_name) {
    int action_valid = 0;
    while (action_valid == 0) {
      myUtils.ASK_ACTION(name, move_remain, sonar_remain);
      BoardDrawer.drawTwo(this.board, oppo_board, oppo_name);
      Scanner scanner = new Scanner(System.in);
      String myString = GenerateOne();
      if (myString.equals("D") || myString.equals("d")) {
        action_valid = hitBoard(scanner, oppo_board, name, oppo_name);
      } else if ((myString.equals("M") || myString.equals("m")) && this.move_remain != 0) {
        action_valid = MoveStack(scanner, oppo_board, name, oppo_name);
        this.move_remain -= action_valid;
      } else if ((myString.equals("S") || myString.equals("s")) && this.sonar_remain != 0) {
        action_valid = SonarStack(scanner, oppo_board, name, oppo_name);
        this.sonar_remain -= action_valid;
      } else {
        System.out.print("\nInvalid input.");
        myUtils.GOBACK();
      }
    }
  }

  @Override
  public int hitBoard(Scanner scanner, Board oppo_board, char name, char oppo_name) {
    myUtils.HIT_WELCOME(name, oppo_name);
    BoardDrawer.drawTwo(this.board, oppo_board, oppo_name);
    myUtils.ASK_HIT(name, oppo_name);
    String myString = GenerateTwo();
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

  @Override
  public int MoveStack(Scanner scanner, Board oppo_board, char name, char oppo_name) {
    myUtils.ASK_MOVE(name, oppo_name);
    BoardDrawer.drawTwo(this.board, oppo_board, oppo_name);
    String mychoice = GenerateTwo();
    InputHandler choice = new InputHandler(mychoice, board);
    choice.CheckTwoBits();
    if (choice.getValid() == 0) {
      myUtils.GOBACK();
      return 0;
    }
    Pixel mypixel = board.getPixel(choice.getCoordinateX(), choice.getCoordinateY());
    if (mypixel.getOccupied() == 0) {
      System.out.print("No stack here. ");
      myUtils.GOBACK();
      return 0;
    }

    char color = board.getPixel(choice.getCoordinateX(), choice.getCoordinateY()).getColor();
    int id = board.getPixel(choice.getCoordinateX(), choice.getCoordinateY()).getID();

    myUtils.ASK_MOVE_TO(name);
    String mylocation = GenerateThree(color);
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

  @Override
  public int SonarStack(Scanner scanner, Board oppo_board, char name, char oppo_name) {
    HashMap<Character, Integer> numMap = new HashMap<Character, Integer>();
    myUtils.ASK_SONAR(name, oppo_name);
    String input = GenerateTwo();
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

  public static String GenerateOne() {
    Random rand = new Random();
    String action_array[] = {"D", "M", "S"};
    int num = rand.nextInt(3) + 0;
    String ans = action_array[num];
    return ans;
  }
  public static String GenerateTwo() {
    Random rand = new Random();
    int num_0 = rand.nextInt(20) + 0;
    char x = (char) ('A' + num_0);
    int y = rand.nextInt(10) + 0;
    StringBuilder ans = new StringBuilder();
    ans.append(x).append(y);
    return ans.toString();
  }

  public static String GenerateThree(char color) {
    String ans = GenerateTwo();
    Random rand = new Random();
    char direc_array[] = {'H', 'V', 'U', 'D', 'R', 'L'};
    if (color == 'G' || color == 'P') {
      int num = rand.nextInt(2) + 0;
      char z = (char) (direc_array[num]);
      ans = ans + z;
    } else {
      int num = rand.nextInt(4) + 2;
      char z = (char) (direc_array[num]);
      ans = ans + z;
    }
    return ans;
  }
}
