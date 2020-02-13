package edu.duke.ece651.sallysstash;

public class Game {
  public static void main(String[] args) {
    System.out.print("Welcome to mygame!\n");
    Board board_A = new Board();
    Board board_B = new Board();
    Action player_A = new Action(board_A);
    Action player_B = new Action(board_B);
    player_A.putAllStack('A', 'B');
    player_B.putAllStack('B', 'A');
    int count_A = 0;
    int count_B = 0;
    while ((count_A != 37) && (count_B != 37)) {
      count_A += player_A.hitBoard(board_B, 'A', 'B');
      if (count_A == 37) {
        myUtils.IS_WIN('A');
        break;
      }
      count_B += player_B.hitBoard(board_A, 'B', 'A');
      if (count_B == 37) {
        myUtils.IS_WIN('B');
      }
    }
  }
}
