package edu.duke.ece651.sallysstash;

import java.util.Random;
import java.util.Scanner;

public class Robot extends Player {
  public Robot(Board myboard) {
    super(myboard);
  }

  @Override
  public void putAllStack(char name, char oppo_name) {
    putStack(2, 'G', 0, name, "Green");
    putStack(3, 'P', 2, name, "Purple");
    putStack(3, 'R', 5, name, "Red");
    putStack(3, 'B', 8, name, "Blue");
  }

  @Override
  public void putStack(int num, char color, int id, char name, String colorname) {
    int count = 0;
    while (count != num) {
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
    }
  }

  @Override
  public void ActionSelect(Board oppo_board, char name, char oppo_name) {
    int action_valid = 0;
    while (action_valid == 0) {
      Scanner scanner = new Scanner(System.in);
      String myString = GenerateOne();
      if (myString.equals("D") || myString.equals("d")) {
        action_valid = hitBoard(scanner, oppo_board, name, oppo_name);
      } else if ((myString.equals("M") || myString.equals("m")) && this.move_remain != 0) {
        action_valid = MoveStack(scanner, oppo_board, name, oppo_name);
        this.move_remain -= action_valid;
      } else if ((myString.equals("S") || myString.equals("s")) && this.sonar_remain != 0) {
        myUtils.SPECIAL(name);
        action_valid = 1;
        this.sonar_remain--;
      }
    }
  }

  @Override
  public int hitBoard(Scanner scanner, Board oppo_board, char name, char oppo_name) {
    String myString = GenerateTwo();
    InputHandler myhandler = new InputHandler(myString, oppo_board);
    myhandler.CheckTwoBits();
    if (myhandler.getValid() == 0) {
      return 0;
    }
    Pixel mypixel = oppo_board.getPixel(myhandler.getCoordinateX(), myhandler.getCoordinateY());
    if (mypixel.getOccupied() == 1) {
      mypixel.setHitted(1);
      myUtils.FOUND(
          name, mypixel.getColor(), myhandler.getCoordinateX(), myhandler.getCoordinateY());
    } else {
      mypixel.setMissed(1);
    }
    return 1;
  }

  @Override
  public int MoveStack(Scanner scanner, Board oppo_board, char name, char oppo_name) {
    String mychoice = GenerateTwo();
    InputHandler choice = new InputHandler(mychoice, board);
    choice.CheckTwoBits();
    if (choice.getValid() == 0) {
      return 0;
    }
    Pixel mypixel = board.getPixel(choice.getCoordinateX(), choice.getCoordinateY());
    if (mypixel.getOccupied() == 0) {
      return 0;
    }

    char color = board.getPixel(choice.getCoordinateX(), choice.getCoordinateY()).getColor();
    int id = board.getPixel(choice.getCoordinateX(), choice.getCoordinateY()).getID();

    String mylocation = GenerateThree(color);
    InputHandler location = new InputHandler(mylocation, board);
    location.CheckThreeBits();
    if (location.getValid() == 0) {
      return 0;
    }

    ShapeAdapter myadapter = new ShapeAdapter(location.getCoordinateX(), location.getCoordinateY(),
        color, location.getDirection(), this.board, id);
    if (myadapter.getValid() == 0) {
      return 0;
    }

    Move mymove = new Move(this.board);
    mymove.Clear(choice.getCoordinateX(), choice.getCoordinateY());
    myadapter.Move(mymove.getHitset());
    myUtils.SPECIAL(name);
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
