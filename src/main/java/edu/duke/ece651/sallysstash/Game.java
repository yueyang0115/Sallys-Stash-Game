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
    int total = 4;
    while ((player_A.CountHitted() != total) && (player_B.CountHitted() != total)) {
      player_A.ActionSelect(board_B, 'A', 'B');
      if (player_B.CountHitted() == total) {
        myUtils.IS_WIN('A');
        break;
      }
      player_B.ActionSelect(board_A, 'B', 'A');
      if (player_A.CountHitted() == total) {
        myUtils.IS_WIN('B');
      }
    }
  }
}
