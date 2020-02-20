package edu.duke.ece651.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class GameTest {
  /* @Test
  public void test_Player() {
    System.out.println("test for player");
    String filename = "./src/test/resources/player.txt";
    try {
      // String input[] = " ";
      System.setIn(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      System.out.println("File not exist");
    }
    Board board_A = new Board();
    Board board_B = new Board();
    Scanner scanner = new Scanner(System.in);
    Player player_A = new Player(scanner, board_A);
    Player player_B = new Player(scanner, board_B);
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
    }*/

  @Test
  public void test_robot() throws FileNotFoundException {
    String filename = "./src/test/resources/robot.txt";
    System.setIn(new FileInputStream(filename));
    Game mygame = new Game();
    mygame.main(null);
  }

  @Test
  public void test_player() throws FileNotFoundException {
    String filename = "./src/test/resources/pp.txt";
    System.setIn(new FileInputStream(filename));
    Game mygame = new Game();
    mygame.main(null);
  }
}
