package edu.duke.ece651.sallysstash;

import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    myUtils.HELLO();
    Board board_A = new Board();
    Board board_B = new Board();
    Scanner scanner = new Scanner(System.in);
    Action player_A = init(scanner, board_A, 'A');
    Action player_B = init(scanner, board_B, 'B');

    player_A.putAllStack('A', 'B');
    player_B.putAllStack('B', 'A');
    int total = 43;
    while ((player_A.CountHitted() != total) && (player_B.CountHitted() != total)) {
      player_A.ActionSelect(board_B, 'A', 'B');
      if (player_B.CountHitted() == total) {
        myUtils.IS_WIN('A');
        BoardDrawer.drawTwo(board_B, board_A, 'A');
        break;
      }
      player_B.ActionSelect(board_A, 'B', 'A');
      if (player_A.CountHitted() == total) {
        BoardDrawer.drawTwo(board_A, board_B, 'B');
        myUtils.IS_WIN('B');
      }
    }
  }

  public static Action init(Scanner scanner, Board board, char name) {
    Action player;
    while (true) {
      myUtils.ROLE_CHOOSE(name);
      String input_A = scanner.next();
      if (input_A.equals("1")) {
        player = new Action(board);
        break;
      } else if (input_A.equals("0")) {
        player = new RobotAction(board);
        break;
      }
      myUtils.IS_INVALID();
    }
    return player;
  }
}
