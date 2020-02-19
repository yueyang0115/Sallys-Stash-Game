package edu.duke.ece651.sallysstash;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RobotAction extends Action {
  private int move_remain;
  private int sonar_remain;

  public RobotAction(Board myboard) {
    super(myboard);
    this.move_remain = 3;
    this.sonar_remain = 3;
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
      char z = (char) (direc_array[0 + num]);
      ans = ans + z;
    } else {
      int num = rand.nextInt(4) + 2;
      char z = (char) (direc_array[0 + num]);
      ans = ans + z;
    }
    return ans;
  }
}
